package bilutleieKlasser;

import java.util.Calendar;

public class Reservasjon {
    
private Calendar reservDato;
private Calendar leverDato;
private Calendar levertDato;
private int kmUt;
private int kmInn;
private Kunde kunden;
private Bil bilen;


public Reservasjon(Calendar reservDato, Calendar leverDato, int kmUt, Kunde kunden, Bil bilen) {
    this.reservDato = reservDato;
    this.leverDato = leverDato;
    this.kmUt = kmUt;
    this.kunden = kunden;
    this.bilen = bilen;
}

//TODO
public boolean erLedigIperiode(Calendar t, Calendar f) {
    return !f.after(reservDato) && !t.before(leverDato);
}

//TODO
public void avslutt() {
}


public Calendar getReservDato() {
    return reservDato;
}

public void setReservDato(Calendar reservDato) {
    this.reservDato = reservDato;
}

public Calendar getLeverDato() {
    return leverDato;
}

public void setLeverDato(Calendar leverDato) {
    this.leverDato = leverDato;
}

public Calendar getLevertDato() {
    return levertDato;
}

public void setLevertDato(Calendar levertDato) {
    this.levertDato = levertDato;
}

public int getKmUt() {
    return kmUt;
}

public void setKmUt(int kmUt) {
    this.kmUt = kmUt;
}

public int getKmInn() {
    return kmInn;
}

public void setKmInn(int kmInn) {
    this.kmInn = kmInn;
}

public Kunde getKunden() {
    return kunden;
}

public void setKunden(Kunde kunden) {
    this.kunden = kunden;
}

public Bil getBilen() {
    return bilen;
}

public void setBilen(Bil bilen) {
    this.bilen = bilen;
}

@Override
public String toString() {
    return 

    "Bekreftet reservasjon: \n"
    + "Fra: " + reservDato.getTime().toString() + "\n"
    + "Til: " + leverDato.getTime().toString() + "\n"
    + "For kunde: " + this.kunden.toString() + "\n"
    + "Bil: " + this.bilen.toString();
}

}
