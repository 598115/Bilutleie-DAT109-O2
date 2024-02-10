package bilutleieKlasser;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Kontor {

private int nummer;
private String adresse;
private String tlf;
private List<Reservasjon> reservasjoner;
private List<Bil> biler;

public Kontor(int nummer, String adresse, String tlf, List<Bil> biler) {
    this.nummer = nummer;
    this.adresse = adresse;
    this.tlf = tlf;
    this.reservasjoner = new LinkedList<>();
    this.biler = biler;
}

//TODO

/**First fins a list of all the cars that are occupied in the given period,
 * and then removes the cars in that list from the list of available cars
 * @param f
 * @param t
 * @return
 */
public List<Bil> getTilgjeng(Calendar f, Calendar t) {

  List<Bil> bilerTilgjengelig = new LinkedList<>(biler);
  reservasjoner.stream()
  .filter(x -> tidKolliderer(f, t, x)).map(x -> x.getBilen()).forEach(x -> bilerTilgjengelig.remove(x));
  return bilerTilgjengelig;
}

//TODO
public List<String> getTilgjengKlasser(List<Bil> bilene, Map<String, Integer> priser) {

  Map<String, Long> countMap = bilene.stream().map(Bil::getKlasse).collect(Collectors.groupingBy(klasse -> klasse, Collectors.counting()));

  List<String> list = countMap.entrySet().stream().map(e -> e.getKey()
   + " (" + e.getValue() + ")" +" Dagpris: " + priser.get(e.getKey()) + "\n").toList();
  return list;

}

//TODO
public List<Bil> bilklasseFilter(List<Bil> listen, String klassen) {

return listen.stream().filter(b -> b.getKlasse().equals(klassen)).toList();

}

//TODO
public String reserverBil(Bil b, Calendar f, Calendar t, Kunde k) {
 
  Reservasjon nyReservasjon = new Reservasjon(f, t, b.getKm(), k, b);
  reservasjoner.add(nyReservasjon);
  return nyReservasjon.toString();

}

//TODO
public String leverBil(String regnr) {
    return null;
}
//TODO
public void setBilLevert(String regnr) {
   
}

//TODO
public boolean tidKolliderer(Calendar f, Calendar t, Reservasjon r) {
   
  return !f.after(r.getLeverDato()) && !t.before(r.getReservDato());
}

@Override
public String toString() {
  return 

  "["+"KONTOR NUMMER: " + this.nummer 
   +"\nSTED: " + this.adresse +
   "\nTLF: " + this.tlf +"]";

}

public int getNummer() {
  return nummer;
}

public void setNummer(int nummer) {
  this.nummer = nummer;
}

public String getAdresse() {
  return adresse;
}

public void setAdresse(String adresse) {
  this.adresse = adresse;
}

public String getTlf() {
  return tlf;
}

public void setTlf(String tlf) {
  this.tlf = tlf;
}

public List<Reservasjon> getReservasjoner() {
  return reservasjoner;
}

public void setReservasjoner(List<Reservasjon> reservasjoner) {
  this.reservasjoner = reservasjoner;
}

public List<Bil> getBiler() {
  return biler;
}

public void setBiler(List<Bil> biler) {
  this.biler = biler;
}

}
