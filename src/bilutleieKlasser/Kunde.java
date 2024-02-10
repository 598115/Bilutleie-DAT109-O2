package bilutleieKlasser;

public class Kunde {

private String fornavn;
private String etternavn;
private String adresse;
private String kredittkort;


public Kunde(String fornavn, String etternavn, String adresse) {
    this.fornavn = fornavn;
    this.etternavn = etternavn;
    this.adresse = adresse;
}

//TODO
public void betalingsRegistrering() {

}

public String getFornavn() {
    return fornavn;
}

public void setFornavn(String fornavn) {
    this.fornavn = fornavn;
}

public String getEtternavn() {
    return etternavn;
}

public void setEtternavn(String etternavn) {
    this.etternavn = etternavn;
}

public String getAdresse() {
    return adresse;
}

public void setAdresse(String adresse) {
    this.adresse = adresse;
}

public String getKredittkort() {
    return kredittkort;
}

public void setKredittkort(String kredittkort) {
    this.kredittkort = kredittkort;
}

}
