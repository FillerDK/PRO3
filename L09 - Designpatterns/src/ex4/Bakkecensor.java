package ex4;

public class Bakkecensor extends EkstraUdstyr {

    public Bakkecensor(Bil bil) {
        super(bil);
    }

    @Override
    public String getBeskrivelse() {
        return super.getBeskrivelse() +
                """
                    Bakkecensor: 20.000 kr
                
                """;
    }

    @Override
    public int pris() {
        return bil.pris() + 20000;
    }
}
