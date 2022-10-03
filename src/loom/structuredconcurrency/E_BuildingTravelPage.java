package loom.structuredconcurrency;

import loom.structuredconcurrency.model.TravelPage;

public class E_BuildingTravelPage {

    public static void main(String[] args) {

        TravelPage travelPage = TravelPage.readTravelPage();
        System.out.println("Final travel page = " + travelPage);
    }
}