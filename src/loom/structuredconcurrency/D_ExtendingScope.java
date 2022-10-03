package loom.structuredconcurrency;

import loom.structuredconcurrency.model.Quotation;

public class D_ExtendingScope {

    public static void main(String[] args) {

        Quotation quotation = Quotation.readQuotation();
        System.out.println("The best quotation = " + quotation);
    }
}