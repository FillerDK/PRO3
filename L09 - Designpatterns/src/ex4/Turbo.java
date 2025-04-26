package ex4;

public class Turbo extends EkstraUdstyr {

    public Turbo(Bil bil) {
        super(bil);
    }

    @Override
    public String getBeskrivelse() {
        return super.getBeskrivelse() +
                """
                    Turbo: 15.000 kr
                
                """;
    }

    @Override
    public int pris() {
        return bil.pris() + 15000;
    }
}
