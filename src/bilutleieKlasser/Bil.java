package bilutleieKlasser;

import java.util.Random;

class Bil {

    private String regnr;
    private String  merke;
    private String modell;
    private int km;
    private String klasse;
    private String baseKontor;

    public Bil(String regnr, String merke, String modell, int km, String klasse, String baseKontor) {
        this.regnr = regnr;
        this.merke = merke;
        this.modell = modell;
        this.km = km;
        this.klasse = klasse;
        this.baseKontor = baseKontor;
    }
    
    /**
     * Simulates the car driving a random distance from 0-500km to add to its km count
     */
    public void drive() {
        Random random = new Random();
        this.km += random.nextInt(500);
    }

    public String getRegnr() {
        return regnr;
    }

    public void setRegnr(String regnr) {
        this.regnr = regnr;
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public String toString() {
    return

    "["+this.merke.toUpperCase() + " " + this.modell.toUpperCase()
    + "\nKM STAND: " + this.km +
    "\nBIL KLASSE: " +this.klasse +
    "\nSTED: " +this.baseKontor+
    "\nREGNR: "+this.regnr+"]";
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public String getBaseKontor() {
        return baseKontor;
    }

    public void setBaseKontor(String baseKontor) {
        this.baseKontor = baseKontor;
    }

}