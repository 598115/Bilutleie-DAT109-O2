package main;

import bilutleieKlasser.BilutleieSelskap;

public class App {
    public static void main(String[] args) throws Exception {
        
        BilutleieSelskap selskap = new BilutleieSelskap("Hyperion", "12345678", "Aker brygge 12");
        selskap.reserver();
    
    }
}
