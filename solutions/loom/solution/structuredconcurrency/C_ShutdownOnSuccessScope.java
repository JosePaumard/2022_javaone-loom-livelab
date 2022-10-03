package loom.solution.structuredconcurrency;

import loom.solution.structuredconcurrency.C_model.Weather;

public class C_ShutdownOnSuccessScope {

    public static void main(String[] args) {

        // --enable-preview --add-modules jdk.incubator.concurrent

        Weather weather = Weather.readWeather();
        System.out.println("Same weather, but faster = " + weather);
    }
}