import java.util.Random;
import java.util.Scanner;

public class Player {
    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    private int damage;
    private int health;
    private int defaultHealth;
    private int money;
    private int armor;
    private String name;
    private String charName;
    private Inventory inventory;
    private int hitLuck;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void start() {
        selectChar();
        chooseLocation();
    }

    public void selectChar() {
        System.out.println("Welcome To the Battle Royale!!");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.print("Please Insert Your Name!: ");
        name = sc.nextLine();
        System.out.println("----------------------------------------------------------------------------------------------");
        showCharInfo();
        System.out.println("----------------------------------------------------------------------------------------------");
        chooseChar();
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void initPlayer(GameCharacter gameCharacter) {
        this.setHealth(gameCharacter.getHealth());
        this.setDamage(gameCharacter.getDamage());
        this.setMoney(gameCharacter.getMoney());
        this.setCharName(gameCharacter.getName());
        this.setDefaultHealth(gameCharacter.getHealth());

    }

    public void showCharInfo() {
        GameCharacter[] characters = {new Samurai(), new Archer(), new Knight(), new Mage()};
        for (GameCharacter gameCharacter : characters) {
            System.out.println("Character :" + gameCharacter.getName() +
                    "\t ID:" + gameCharacter.getId() +
                    "\t Health : " + gameCharacter.getHealth() +
                    "\t Damage :" + gameCharacter.getDamage() +
                    "\t Money :" + gameCharacter.getMoney());
        }
    }

    public void chooseChar() {
        System.out.println("Please choose a character! :");
        int selectCharacter = sc.nextInt();
        switch (selectCharacter) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            case 4:
                initPlayer(new Mage());
                break;
            default:
                initPlayer(new Samurai());
        }

        System.out.println("You choose \t" + this.getCharName() + " Health:" + this.getHealth() + "\tDamage:" + this.getDamage() + "\tMoney:" + this.getMoney());

    }

    public void showLocation() {
        Location[] locations = {new SafeHouse(this), new Storage(this), new Cave(this), new Forest(this), new River(this), new Mine(this)};
        for (Location location : locations) {
            System.out.println("ID: " + location.getId() + "\t" + location.getName() + "\t||" + location.getExplanation() + "\t");

        }
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("For quit write 0 on console!");
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void chooseLocation() {
        while (true) {
            showPlayerInfo();
            System.out.println("Please choose location to go! :");
            System.out.println("----------------------------------------------------------------------------------------------");
            showLocation();
            Location location = null;
            int selectLocation = sc.nextInt();
            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(this);
                    break;
                case 2:
                    location = new Storage(this);
                    break;
                case 3:
                    if (getInventory().isFood() == true) {
                        System.out.println("You already defeat the cave monster.!You can't go in again.");
                        location = new SafeHouse(this);
                        break;
                    }
                    location = new Cave(this);
                    break;
                case 4:
                    if (getInventory().isWood() == true) {
                        System.out.println("You already defeat the forest monster.!You can't go in again.");
                        location = new SafeHouse(this);
                        break;
                    }
                    location = new Forest(this);
                    break;
                case 5:
                    if (getInventory().isWater() == true) {
                        System.out.println("You already defeat the river monster.!You can't go in again.");
                        location = new SafeHouse(this);
                        break;
                    }
                    location = new River(this);
                    break;
                case 6:
                    location = new Mine(this);
                    break;
                default:
                    location = new SafeHouse(this);
            }
            if (location == null) {
                System.out.println("You quit the game see u soon :)");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Game Over !!!");
                break;
            }
            if (location.getName().equals("Safe House") && this.getInventory().isWater() && this.getInventory().isWood() && this.getInventory().isFood()) {
                System.out.println("Congratulations!!!\n ------YOU WIN-----");
            }
        }
    }

    public void showPlayerInfo() {
        System.out.println("Your items: " + this.getInventory().getWeapon().getName() + " , " + this.getInventory().getArmor().getName() + "\n" +
                "Health: " + this.getHealth() + "\n" +
                "Damage: " + this.getTotalDamage() + "\n" +
                "Armor: " + this.getTotalArmor() + "\n" +
                "Money: " + this.getMoney());
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public void hitLuck() {
        this.setHitLuck(r.nextInt(2) + 1);
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
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
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getTotalArmor() {
        return armor + this.getInventory().getArmor().getDefence();
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public int getHitLuck() {
        return hitLuck;
    }

    public void setHitLuck(int hitLuck) {
        this.hitLuck = hitLuck;
    }
}