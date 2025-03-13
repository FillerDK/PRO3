package opg1;

import java.util.Objects;

public class Bil {

    private String registregingsnummer;
    private String mærke;
    private String model;
    private String farve;

    public Bil(String registregingsnummer, String mærke, String model, String farve) {
        this.registregingsnummer = registregingsnummer;
        this.mærke = mærke;
        this.model = model;
        this.farve = farve;
    }

    @Override
    public String toString() {
        return "Bil{" +
                "registregingsnummer=" + registregingsnummer +
                ", mærke='" + mærke + '\'' +
                ", model='" + model + '\'' +
                ", farve='" + farve + '\'' +
                '}';
    }

    public String getRegistregingsnummer() {
        return registregingsnummer;
    }

    public void setRegistregingsnummer(String registregingsnummer) {
        this.registregingsnummer = registregingsnummer;
    }

    public String getMærke() {
        return mærke;
    }

    public void setMærke(String mærke) {
        this.mærke = mærke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFarve() {
        return farve;
    }

    public void setFarve(String farve) {
        this.farve = farve;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bil bil = (Bil) o;
        return Objects.equals(
                registregingsnummer, bil.registregingsnummer) && Objects.equals(mærke, bil.mærke);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registregingsnummer, mærke);
    }
}
