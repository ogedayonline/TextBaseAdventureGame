public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean isFood;
    private boolean isWood;
    private boolean isWater;

    public Inventory() {
        this.armor = new Armor("Clothes: ", -98, 0, 0, 0);
        this.weapon = new Weapon("Fist: ", -99, 0, 0, 0);
        this.isWater = false;
        this.isFood = false;
        this.isWood = false;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isFood() {
        return isFood;
    }

    public void setFood(boolean food) {
        isFood = food;
    }

    public boolean isWood() {
        return isWood;
    }

    public void setWood(boolean wood) {
        isWood = wood;
    }

    public boolean isWater() {
        return isWater;
    }

    public void setWater(boolean water) {
        isWater = water;
    }
}
