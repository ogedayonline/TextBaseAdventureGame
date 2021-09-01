public class Armor {
    private String name;
    private int id;
    private int defence;
    private int price;
    private int dropPosibility;

    public Armor(String name, int id, int defence, int price, int dropPosibility) {
        this.name = name;
        this.id = id;
        this.defence = defence;
        this.price = price;
        this.dropPosibility = dropPosibility;
    }

    public static Armor[] armors() {
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor("Light Armor", 1, 1, 15, 50);
        armorList[1] = new Armor("Medium Armor", 2, 3, 25, 30);
        armorList[2] = new Armor("Heavy Armor", 3, 5, 40, 20);
        return armorList;
    }

    public static Armor getArmorObjByID(int id) {
        for (Armor a : armors()) {
            if (a.getId() == id) {
                return a;
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

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
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
