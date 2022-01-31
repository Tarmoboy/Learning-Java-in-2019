
import java.util.ArrayList;


/**
 *
 * @author Tarmoboy
 */
 
class Arvosanat {
    private ArrayList<Integer> pisteet;
    private ArrayList<Integer> arvosanat;
    private ArrayList<Integer> hyvaksytyt;
    public Arvosanat() {
        this.pisteet = new ArrayList<>();
        this.arvosanat = new ArrayList<>();
        this.hyvaksytyt = new ArrayList<>();
    }
    public void lisaaTulos(int pisteet) {
        if (pisteet >= 50 && pisteet <= 100) {
            this.hyvaksytyt.add(pisteet);
            this.pisteet.add(pisteet);
        } else if (pisteet >= 0 && pisteet <= 100) {
            this.pisteet.add(pisteet);
        }
        
    }
    public String kaikkienKeskiarvo() {
        double yhteensa = 0;
        for (int indeksi = 0; indeksi < this.pisteet.size(); indeksi++) {
            yhteensa = yhteensa + this.pisteet.get(indeksi);
        }
        return "Pisteiden keskiarvo (kaikki): " + 1.0 * yhteensa / this.pisteet.size();
    }
    public String hyvaksyttyjenKeskiarvo() {
        if (this.hyvaksytyt.isEmpty()) {
            return "Pisteiden keskiarvo (hyväksytyt): -";
        }
        double yhteensa = 0;
        for (int indeksi = 0; indeksi < this.hyvaksytyt.size(); indeksi++) {
            yhteensa = yhteensa + this.hyvaksytyt.get(indeksi);
        }
        return "Pisteiden keskiarvo (hyväksytyt): " + 1.0 * yhteensa / this.hyvaksytyt.size();
    }
    public String hyvaksymisprosentti() {
        if (this.hyvaksytyt.isEmpty()) {
            return "Hyväksymisprosentti: 0.0";
        }
        return "Hyväksymisprosentti: " + 100.0 * this.hyvaksytyt.size() / this.pisteet.size();
    }
    public ArrayList<Integer> muutaPisteetArvosanoiksi(int pisteet) {
        int arvosana = 0;
        if (pisteet >= 0 && pisteet <= 100) {
            if (pisteet < 50) {
                arvosana = 0;
            } else if (pisteet < 60) {
                arvosana = 1;
            } else if (pisteet < 70) {
                arvosana = 2;
            } else if (pisteet < 80) {
                arvosana = 3;
            } else if (pisteet < 90) {
                arvosana = 4;
            } else if (pisteet >= 90) {
                arvosana = 5;
            }
            arvosanat.add(arvosana);
        }
        return arvosanat;
    }
    private String tulostaTahdet(int tahdet) {
        String merkkijono = "";
        for (int arvosana : this.arvosanat) {
            if (arvosana == tahdet) {
                merkkijono += "*";
            }
        }
        return merkkijono;   
    }
    public void tulostaArvosanat() {
        System.out.println("Arvosanajakauma: ");
        for (int indeksi = 5; indeksi >= 0; indeksi--) {
            System.out.println(indeksi + ": " + tulostaTahdet(indeksi));
        }
    }    
}
