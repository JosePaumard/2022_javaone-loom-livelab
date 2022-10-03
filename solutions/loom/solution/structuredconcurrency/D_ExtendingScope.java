package loom.solution.structuredconcurrency;

import loom.solution.structuredconcurrency.D_model.Quotation;

public class D_ExtendingScope {

    public static void main(String[] args) {

        // --enable-preview --add-modules jdk.incubator.concurrent

        Quotation quotation = Quotation.readQuotation();
        System.out.println("The best quotation = " + quotation);
    }
}