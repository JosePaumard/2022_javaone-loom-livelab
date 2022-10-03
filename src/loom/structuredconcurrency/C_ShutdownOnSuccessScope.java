package loom.structuredconcurrency;

import loom.structuredconcurrency.model.Weather;

public class C_ShutdownOnSuccessScope {

    public static void main(String[] args) {

        Weather weather = Weather.readWeather();
        System.out.println("Same weather, but faster = " + weather);
    }
}