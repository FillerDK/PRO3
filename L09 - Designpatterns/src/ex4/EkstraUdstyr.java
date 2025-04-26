package ex4;

public abstract class EkstraUdstyr implements Bil {
    protected Bil bil;

    public EkstraUdstyr(Bil bil) {
        this.bil = bil;
    }

    public String getBeskrivelse() {
        return bil.getBeskrivelse() +
                """
                Med ekstraudstyr:
                """;
    }
}
