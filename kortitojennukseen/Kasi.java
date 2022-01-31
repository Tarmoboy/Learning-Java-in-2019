
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Tarmoboy
 */
 
public class Kasi implements Comparable<Kasi> {
    private ArrayList<Kortti> kasi;
    public Kasi() {
        this.kasi = new ArrayList<>();
    }
    public void lisaa(Kortti kortti) {
        this.kasi.add(kortti);
    }
    public void tulosta() {
        for(Kortti kortti : kasi) {
            System.out.println(kortti);
        }    
    }
    public void jarjesta() {
        Collections.sort(kasi);
    }
    @Override
    public int compareTo(Kasi vertailtava) {
        int summa = 0;
        for(Kortti kortti : this.kasi) {
            summa += kortti.getArvo();
        }
        int vertailtavaSumma = 0;
        for(Kortti toinenKasi : vertailtava.kasi) {
            vertailtavaSumma += toinenKasi.getArvo();
        }
        if(summa == vertailtavaSumma) {
            return 0;
        } else if(summa > vertailtavaSumma) {
            return 1;
        } else {
            return -1;
        } 
    }
    public void jarjestaMaittain() {
        Collections.sort(kasi, new SamatMaatVierekkainArvojarjestykseen());
    }
}
