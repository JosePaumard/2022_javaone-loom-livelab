package loom.solution.structuredconcurrency;

import loom.solution.structuredconcurrency.B_model.Weather;

public class B_FirstScope {

    public static void main(String[] args) {

        // --enable-preview --add-modules jdk.incubator.concurrent

        Weather weather = Weather.readWeather();
        System.out.println("weather = " + weather);
    }
}