package ex4;

public class Metallak extends EkstraUdstyr {

    public Metallak(Bil bil) {
        super(bil);
    }

    @Override
    public String getBeskrivelse() {
        return super.getBeskrivelse() +
                """
                    Metallak: 5.000 kr
                
                """;
    }

    @Override
    public int pris() {
        return bil.pris() + 5000;
    }
}
