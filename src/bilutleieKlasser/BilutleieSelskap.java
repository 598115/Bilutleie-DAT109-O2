package bilutleieKlasser;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

public class BilutleieSelskap {

private String navn;
private String tlf;
private String adresse;
private Map<String, Integer>  prisliste;
private Map<Integer, Kunde> kundeliste;
private List<Kontor> kontorer;

public BilutleieSelskap(String navn, String tlf, String adresse) {
    this.navn = navn;
    this.tlf = tlf;
    this.adresse = adresse;
    this.kundeliste = new TreeMap<>();
    this.prisliste = new TreeMap<>();
    this.kontorer = new LinkedList<>();
                                                     //Hardkodet biler og kontorer
    //Legger til priser for ulike biltyper
    prisliste.put("2door", 800);
    prisliste.put("4door", 1200);
    prisliste.put("utility", 1600);
    prisliste.put("sport", 2700);
    //legger til andre faste priser
    prisliste.put("rentfee", 500);
    prisliste.put("locationChange", 700);
    //opretter bilutvalg
    List<Bil> k1 = new LinkedList<>();
    List<Bil> k2 = new LinkedList<>();
    List<Bil> k3 = new LinkedList<>();
    k1.add(new Bil("BD32399", "Toyota", "GR Yaris", 36943, "sport"));
    k1.add(new Bil("ST12345", "Suzuki", "4x4", 95321, "4door"));
    k1.add(new Bil("SX54321", "VW", "Beetle", 43456, "2door"));
    k1.add(new Bil("TV12345", "Kia", "ioniq", 65432, "4door"));
    k1.add(new Bil("UX23456", "Ford", "Transit", 120000, "utility"));

    k2.add(new Bil("BR56799", "Toyota", "GR Yaris", 86943, "sport"));
    k2.add(new Bil("XT17655", "Suzuki", "4x4", 25321, "4door"));
    k2.add(new Bil("CX23456", "VW", "Beetle", 123456, "2door"));
    k2.add(new Bil("XS67890", "Kia", "ioniq", 155432, "4door"));
    k2.add(new Bil("UT40321", "Ford", "Transit", 20000, "utility"));

    k3.add(new Bil("VW44399", "Toyota", "GR Yaris", 67839, "sport"));
    k3.add(new Bil("RD22345", "Suzuki", "4x4", 11234, "4door"));
    k3.add(new Bil("RZ24321", "VW", "Beetle", 2567, "2door"));
    k3.add(new Bil("TA33345", "Kia", "ioniq", 5566, "4door"));
    k3.add(new Bil("ED23673", "Ford", "Transit", 123, "utility"));
    //Oppretter kontorer
    kontorer.add(new Kontor(1, "Flesland, Bergen", "12345678", k1));
    kontorer.add(new Kontor(2, "Oslo S, Oslo", "87654321", k2));
    kontorer.add(new Kontor(2, "Oslo S, Oslo", "12344321", k3));
}

//TODO javadoc
public void reserver() {
//Finner tiden kunden vill reservere
Calendar resd = null;
Calendar reslev = null;
int dager = -1;
while(dager < 0) {
    String sr = JOptionPane.showInputDialog(null, "Oppgi tid for reservasjon (YYYY-MM-DD HH:MM): ");
    resd = datoValidering(sr);
    String sl = JOptionPane.showInputDialog(null, "Oppgi tid for tilbakelevering (YYYY-MM-DD HH:MM): ");
    reslev = datoValidering(sl);
    dager = dagerKalk(resd, reslev);
}
//Finner stedet kunden vill reservere fra
Kontor valgtKontor = velgKontor2();

//Finner alle tilgjengelige biler i perioden fra valgt kontor
List<Bil> bilerTilgjengelig = valgtKontor.getTilgjeng(resd, reslev);

//Henter liste over tilgjengelige bilklasser
List<String> klasser = valgtKontor.getTilgjengKlasser(bilerTilgjengelig, prisliste);
String valg = velgKlasse(klasser, valgtKontor);

//Henter liste over aktuelle biler
String klasse = valg.replaceAll(" \\(\\d+\\)$", "");
List<Bil> valgteBiler = valgtKontor.bilklasseFilter(bilerTilgjengelig, klasse);

//Velger bil
Bil valgtBil = velgBil(valgteBiler);

//Finner/Oppretter kunde


//Reserverer
valgtKontor.reserverBil(valgtBil, resd, reslev, null);

    
}


//TODO 
public String velgKlasse(List<String> alternativ, Kontor k) {

    if (alternativ.isEmpty()) {
        return null;
    }

String header = "Tilgjengelige bilklasser for " + k.getAdresse() +
 ". Standard leiegebyr " + prisliste.get("rentfee") + "Kr. velg en klasse:";

int valg = JOptionPane.showOptionDialog(null, header, "Klassevalg",
 0, JOptionPane.QUESTION_MESSAGE, null, alternativ.toArray(), alternativ.toArray()[0]);

  if (valg >= 0 && valg < alternativ.size()) {
    return alternativ.get(valg);
 } else {
    return velgKlasse(alternativ, k); // Rekursivt kall for ikke-valid valg
 }
}

//TODO
public Bil velgBil(List<Bil> liste) {

    int valg = JOptionPane.showOptionDialog(null, "Velg bil", "Bilvalg",
 0, JOptionPane.QUESTION_MESSAGE, null, liste.toArray(), liste.toArray()[0]);

  if (valg >= 0 && valg < liste.size()) {
    return liste.get(valg);
 } else {
    return velgBil(liste); // Rekursivt kall for ikke-valid valg
 }

}

//TODO Ikke ferdig
public Kunde kundebehandling() {

    String[] liste = {"Ja","Nei"};

    int valg = JOptionPane.showOptionDialog(null, "Er du ny kunde?", "Bilvalg",
    0, JOptionPane.QUESTION_MESSAGE, null, liste, liste[0]);
   
     if (valg == 0) {

        int nykundevalg = JOptionPane.showOptionDialog(null, "Er du ny kunde?", "Bilvalg",
    0, JOptionPane.QUESTION_MESSAGE, null, liste, liste[0]);
      
    } else if(valg == 1) {
       
    }
    else {
        return kundebehandling(); // Rekursivt kall for ikke-valid valg
    }
   return null;
}

public String getNavn() {
    return navn;
}

public void setNavn(String navn) {
    this.navn = navn;
}

public String getTlf() {
    return tlf;
}

public void setTlf(String tlf) {
    this.tlf = tlf;
}

public String getAdresse() {
    return adresse;
}

public void setAdresse(String adresse) {
    this.adresse = adresse;
}

public Map<String, Integer> getPrisliste() {
    return prisliste;
}

//TODO javadoc
private Calendar datoValidering(String s) {
    
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
   try {
    Date date =  dateFormat.parse(s);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar;
   } catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showConfirmDialog(null, "Invalid tids-format");
    return null;
   }
}

//TODO javadoc
public int dagerKalk(Calendar f, Calendar e) {

    LocalDate f2 = f.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate e2 = e.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    int result = (int)ChronoUnit.DAYS.between(f2, e2);

    if(result < 0) {
        JOptionPane.showConfirmDialog(null, "Leveringsdato ugyldig. Er etter reservasjonsdato");
        return result;
    }
    return result == 0 ? 1 : result; 
    }
    
//TODO
public Kontor velgKontor() {
    Optional<Kontor> kontoret = null;
while(kontoret.isEmpty()) {
    kontorer.stream().forEach(System.out::println);
    String kontorNr = JOptionPane.showInputDialog(null, "Oppgi nummeret til kontoret du vill leie fra");
    int nummer = Integer.parseInt(kontorNr);
    kontoret = kontorer.stream().filter(x -> x.getNummer() == nummer).findFirst();
    if(kontoret.isEmpty()) {
        JOptionPane.showConfirmDialog(null, "Ugyldig kontor nummer");
    }
  }
  return kontoret.get();
 } 

 //Alter
 public Kontor velgKontor2() {

int valg = JOptionPane.showOptionDialog(null, "Velg ulteiested", "Ulteiested",
 0, JOptionPane.QUESTION_MESSAGE, null, kontorer.toArray(), kontorer.toArray()[0]);

  if (valg >= 0 && valg < kontorer.size()) {
    return kontorer.get(valg);
 } else {
    return velgKontor2(); // Rekursivt kall for ikke-valid valg
 }

 }
}
