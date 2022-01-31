
/**
 *
 * @author Tarmoboy
 */

public class Kortti implements Comparable<Kortti> {

    private int arvo;
    private Maa maa;

    public Kortti(int arvo, Maa maa) {
        if (arvo < 2 || arvo > 14) {
            throw new IllegalArgumentException("Kortin arvon tulee olla väliltä 2...14.");
        }

        this.arvo = arvo;
        this.maa = maa;
    }

    @Override
    public String toString() {
        String kortinArvo = "" + arvo;
        if(arvo == 11) {
            kortinArvo = "J";
        } else if (arvo == 12) {
            kortinArvo = "Q";
        } else if (arvo == 13) {
            kortinArvo = "K";
        } else if (arvo == 14) {
            kortinArvo = "A";
        }
        
        return maa + " " + kortinArvo;
    }

    public int getArvo() {
        return arvo;
    }

    public Maa getMaa() {
        return maa;
    }

    @Override
    public int compareTo(Kortti verrattava) {
        if (this.arvo == verrattava.getArvo()) {
            if (this.maa.ordinal() > verrattava.getMaa().ordinal()) {
                return 1;
            }else if (this.maa == verrattava.getMaa()) {
                return 0;
            }else {
                return -1;
            }
        } else if (this.arvo > verrattava.getArvo()) {
            return 1;
        } else {
            return -1;
        }    
    }
}
