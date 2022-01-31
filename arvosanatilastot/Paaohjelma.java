
import java.util.Scanner;

/**
 *
 * @author Tarmoboy
 */

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Arvosanat arvosanat = new Arvosanat();
        // Tee sovelluksesi tänne -- kannattaa harkita sovelluksen pilkkomista
        // useampaan luokkaan.
        System.out.println("Syötä yhteispisteet, -1 lopettaa: ");
        while (true) {
            int pisteet = Integer.valueOf(lukija.nextLine());
            if (pisteet == -1) {
                break;
            }
            arvosanat.lisaaTulos(pisteet);
            arvosanat.muutaPisteetArvosanoiksi(pisteet);
        }
        System.out.println(arvosanat.kaikkienKeskiarvo());
        System.out.println(arvosanat.hyvaksyttyjenKeskiarvo());
        System.out.println(arvosanat.hyvaksymisprosentti());
        arvosanat.tulostaArvosanat();
    }
}
