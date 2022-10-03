package loom.solution.virtualthreads;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class E_HowManyPlatformThreads {

    public static Pattern pool = Pattern.compile("ForkJoinPool-[\\d?]");
    public static Pattern worker = Pattern.compile("worker-[\\d?]");

    private static final Thread REPLACE_WITH_YOUR_CODE = null;

    public static void main(String[] args) throws InterruptedException {

        Set<String> poolNames = ConcurrentHashMap.newKeySet();
        Set<String> platformThreadNames = ConcurrentHashMap.newKeySet();

        var threads =
                IntStream.range(0, 100)
                        .mapToObj(index ->
                                Thread.ofVirtual()
                                        .unstarted(() -> {
                                            if (index == 0) {
                                                System.out.println(Thread.currentThread());
                                            }
                                            poolNames.add(readThreadPoolName());
                                            platformThreadNames.add(readPlatformThreadName());
                                            try {
                                                Thread.sleep(20);
                                            } catch (InterruptedException e) {
                                                throw new RuntimeException(e);
                                            }
                                            if (index == 0) {
                                                System.out.println(Thread.currentThread());
                                            }
                                            try {
                                                Thread.sleep(20);
                                            } catch (InterruptedException e) {
                                                throw new RuntimeException(e);
                                            }
                                            poolNames.add(readThreadPoolName());
                                            platformThreadNames.add(readPlatformThreadName());
                                            if (index == 0) {
                                                System.out.println(Thread.currentThread());
                                            }
                                            try {
                                                Thread.sleep(20);
                                            } catch (InterruptedException e) {
                                                throw new RuntimeException(e);
                                            }
                                            poolNames.add(readThreadPoolName());
                                            platformThreadNames.add(readPlatformThreadName());
                                            if (index == 0) {
                                                System.out.println(Thread.currentThread());
                                            }
                                        })
                        )
                        .toList();

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Pool names used: ");
        poolNames.forEach(System.out::println);

        System.out.println("\nPlatform threads used: ");
        new TreeSet<>(platformThreadNames).forEach(System.out::println);
    }

    public static String readThreadPoolName() {
        String name = Thread.currentThread().toString();
        Matcher poolMatcher = pool.matcher(name);
        if (poolMatcher.find()) {
            return poolMatcher.group();
        } else {
            return "pool not found";
        }
    }

    public static String readPlatformThreadName() {
        String name = Thread.currentThread().toString();
        Matcher workerMatcher = worker.matcher(name);
        if (workerMatcher.find()) {
            return workerMatcher.group();
        } else {
            return "platform thread not found";
        }
    }
}