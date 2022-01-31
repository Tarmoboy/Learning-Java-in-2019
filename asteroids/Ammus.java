package asteroids;

/**
 *
 * @author Tarmoboy
 */

import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Polygon;

public class Ammus extends Hahmo {
    public Ammus(int x, int y) {
        super(new Polygon(2, -2, 2, 2, -2, 2, -2, -2), x, y);
        List<Ammus> ammukset = new ArrayList<>();
    }
}
