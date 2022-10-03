package loom.structuredconcurrency.model;

import java.util.Random;

public record Quotation(String agency, int amount) {

    private static final Quotation ADD_YOUR_CODE_HERE = null;
    private static Random random = new Random();

    public static Quotation readQuotation() {
        return ADD_YOUR_CODE_HERE;
    }

    public static Quotation readQuotationFromA() {
        try {
            Thread.sleep(random.nextInt(20, 80));
            return new Quotation("Agency A", random.nextInt(80, 120));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Quotation readQuotationFromB() {
        try {
            Thread.sleep(random.nextInt(40, 100));
            return new Quotation("Agency B", random.nextInt(90, 130));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Quotation readQuotationFromC() {
        try {
            Thread.sleep(random.nextInt(30, 120));
            return new Quotation("Agency C", random.nextInt(70, 130));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Quotation readQuotationFromD() {
        try {
            Thread.sleep(random.nextInt(20, 110));
            return new Quotation("Agency D", random.nextInt(60, 120));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Quotation readQuotationFromE() {
        try {
            Thread.sleep(random.nextInt(50, 90));
            return new Quotation("Agency E", random.nextInt(70, 110));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}