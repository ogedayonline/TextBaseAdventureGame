import java.util.Random;

public class Monster {
    Random r = new Random();
    private int id;
    private int damage;
    private int health;
    private String name;
    private int award;
    private String itemAward;
    private int defaultHealth;
    private int randomDmg;

    public Monster(int id, int damage, int health, String name, int award, String itemAward) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.defaultHealth = health;
        this.name = name;
        this.award = award;
        this.itemAward = itemAward;
        this.randomDmg = getRandomDmg();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public String getItemAward() {
        return itemAward;
    }

    public void setItemAward(String itemAward) {
        this.itemAward = itemAward;
    }

    public int getRandomDmg() {
        return r.nextInt(4) + 3;
    }

    public void setRandomDmg(int randomDmg) {
        this.randomDmg = randomDmg;
    }
}
