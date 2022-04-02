package lab5;

public class Auto {

    private int nr_silnika;
    private String marka;
    private String typ;
    private int data_produkcji;
    private double cena;
    private String kolor;
    private int skladowanie;
    private double przecena;

    public Auto() {}

    public Auto(int nr_silnika, String marka, String typ, int data_produkcji,
                double cena, String kolor, int skladowanie) {
        this.nr_silnika = nr_silnika;
        this.marka = marka;
        this.typ = typ;
        this.data_produkcji = data_produkcji;
        this.cena = cena;
        this.kolor = kolor;
        this.skladowanie = skladowanie;
        if  (skladowanie >= 6 && skladowanie < 15) {
            this.przecena = (0.06)*cena;
            this.cena = cena - przecena;
        } else if (skladowanie >= 15) {
            this.przecena = (0.15)*cena;
            this.cena = cena - przecena;
        } else {
            this.przecena = 0;
        }
    }

    public int getNr_silnika() {
        return nr_silnika;
    }

    public void setNr_silnika(int nr_silnika) {
        this.nr_silnika = nr_silnika;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getData_produkcji() {
        return data_produkcji;
    }

    public void setData_produkcji(int data_produkcji) {
        this.data_produkcji = data_produkcji;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public int getSkladowanie() {
        return skladowanie;
    }

    public void setSkladowanie(int skladowanie) {
        this.skladowanie = skladowanie;
    }

    public double getPrzecena() {
        return przecena;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "nr_silnika=" + nr_silnika +
                ", marka='" + marka + '\'' +
                ", typ='" + typ + '\'' +
                ", data_produkcji=" + data_produkcji +
                ", cena=" + cena +
                ", kolor='" + kolor + '\'' +
                ", skladowanie=" + skladowanie +
                ", przecena=" + przecena +
                '}';
    }
}
