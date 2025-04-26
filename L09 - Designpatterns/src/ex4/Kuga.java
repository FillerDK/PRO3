package ex4;

public class Kuga implements Bil {

    @Override
    public String getBeskrivelse() {
        return """
               Model: Kuga
               Basispris: 350.000 kr
               """;
    }

    @Override
    public int pris() {
        return 350000;
    }
}
