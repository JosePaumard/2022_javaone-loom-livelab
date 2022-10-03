package loom.solution.structuredconcurrency;

import loom.solution.structuredconcurrency.E_model.TravelPage;

public class E_BuildingTravelPage {

    public static void main(String[] args) {

        // --enable-preview --add-modules jdk.incubator.concurrent

        TravelPage travelPage = TravelPage.readTravelPage();
        System.out.println("Final travel page = " + travelPage);
    }
}