
import java.util.Comparator;

/**
 *
 * @author Tarmoboy
 */
 
public class SamatMaatVierekkainArvojarjestykseen implements Comparator<Kortti> {
    public int compare(Kortti k1, Kortti k2) {
        if(k1.getMaa() == k2.getMaa()) {
            return k1.getArvo() - k2.getArvo();
        } else {
            return k1.getMaa().ordinal() - k2.getMaa().ordinal();
        }
    }
}
