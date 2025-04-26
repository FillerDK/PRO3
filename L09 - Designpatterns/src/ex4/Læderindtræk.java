package ex4;

public class Læderindtræk extends EkstraUdstyr {

    public Læderindtræk(Bil bil) {
        super(bil);
    }

    @Override
    public String getBeskrivelse() {
        return super.getBeskrivelse() +
                """
                    Læderindtræk: 45.000 kr
                
                """;
    }

    @Override
    public int pris() {
        return bil.pris() + 45000;
    }
}
