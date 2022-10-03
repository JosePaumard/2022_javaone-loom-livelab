package loom.structuredconcurrency.model;

import java.util.Random;

public record Weather(String agency, String weather) {

    private static final Random random = new Random();

    private static final Weather ADD_YOUR_CODE_HERE = null;

    public static final Weather UNKNOWN_WEATHER = new Weather("Unknown", "Mostly sunny");

    public static Weather readWeather() {

        // These instructions follow the ones from the B_FirstScope class.
        // Be sure to follow them before continuing here.
        // First, create an instance of the StructuredTaskScope class.
        // This class implements AutoCloseable, so you should create it in a
        // try-with-resources pattern. Because this scope will produce a Weather object,
        // you should create an instance of StructuredTaskScope<Weather>.
        // There is no trick here: this class has an empty constructor that you can call.
        // Second, create and submit a task to this scope. This task is an instance of
        // Callable<Weather>, because your scope is parameterized by Weather.
        // You can create this Callable by simply calling readWeatherFromA(). It will produce a
        // (not so) random Weather instance, after a little (random) delay.
        // Submitting a task to a scope is done by calling its fork() method. It
        // gives you a future object that you can put in a variable.
        // Third, once you have submitted tasks to your scope, you should call its join()
        // method. This call is blocking: join() will return when all your tasks have complete.
        // Not calling join() will make your code fail with an exception when you call
        // get() on your future objects.
        // Fourth and last point: you can get the result of your future by calling its classical
        // get() method, or even better, its new resultNow() method. This last method should be called
        // only if you know that your future is complete, which is the case after you called scope.join().
        // Once you have completed these steps, you can go back to the instructions in
        // the B_FirstScope class.

        return ADD_YOUR_CODE_HERE; // or UNKNOWN_WEATHER
    }

    public static Weather readWeatherFromA() {
        try {
            Thread.sleep(random.nextInt(20, 80));
            return new Weather("Agency A", "Sunny");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Weather readWeatherFromB() {
        try {
            Thread.sleep(random.nextInt(40, 100));
            return new Weather("Agency B", "Sunny");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Weather readWeatherFromC() {
        try {
            Thread.sleep(random.nextInt(30, 120));
            return new Weather("Agency C", "Sunny");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Weather readWeatherFromD() {
        try {
            Thread.sleep(random.nextInt(10, 100));
            return new Weather("Agency D", "Sunny");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Weather readWeatherFromE() {
        try {
            Thread.sleep(random.nextInt(50, 60));
            return new Weather("Agency E", "Sunny");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}