public class Weapon {
    private String name;
    private int id;
    private int damage;
    private int price;
    private int dropPosibility;

    public Weapon(String name, int id, int damage, int price, int dropPosibility) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
        this.dropPosibility = dropPosibility;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[4];
        weaponList[0] = new Weapon("Gun", 1, 2, 25, 50);
        weaponList[1] = new Weapon("Sword", 2, 3, 35, 30);
        weaponList[2] = new Weapon("Staff", 3, 5, 30, 10);
        weaponList[3] = new Weapon("Rifle", 4, 7, 45, 10);
        return weaponList;
    }

    public static Weapon getWeaponObjByID(int id) {
        for (Weapon w : weapons()) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDropPosibility() {
        return dropPosibility;
    }

    public void setDropPosibility(int dropPosibility) {
        this.dropPosibility = dropPosibility;
    }
}
