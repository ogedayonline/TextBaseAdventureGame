import java.util.Random;

public class Snake extends Monster {
    Random r = new Random();

    public Snake() {
        super(4, 3, 12, "Snake", 0, "item");
        setDamage(getRandomDmg());
    }
}
