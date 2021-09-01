import java.util.Random;

public abstract class BattleLocation extends Location {
    Random r = new Random();
    private Monster monster;
    private String award;
    private int maxMonsterCount;


    public BattleLocation(Player player, String name, int id, String explanation, Monster monster, String award, int maxMonsterCount) {
        super(player, name, id, explanation);
        this.monster = monster;
        this.award = award;
        this.maxMonsterCount = maxMonsterCount;

    }

    @Override
    public boolean onLocation() {
        int monsterCount = this.randomMonsterCountGenerator();
        System.out.println("You are in " + this.getName());
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Be careful there are " + monsterCount + " " + this.monster.getName() + " 's here");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("<F>ight or <R>un Away!!!");
        String behavior = sc.nextLine().toUpperCase();
        System.out.println("You choose to Fight!");
        if (behavior.equals("F") ) {
            if (fight(monsterCount)) {
                System.out.println("You killed all monsters!");
                if (this.award.equals("Food") && this.getPlayer().getInventory().isFood() == false) {
                    System.out.println("You dropped " + this.monster.getItemAward());
                    this.getPlayer().getInventory().setFood(true);
                } else if (this.award.equals("Wood") && this.getPlayer().getInventory().isWood() == false) {
                    System.out.println("You dropped " + this.monster.getItemAward());
                    this.getPlayer().getInventory().setWood(true);
                } else if (this.award.equals("Water") && this.getPlayer().getInventory().isWater() == false) {
                    System.out.println("You dropped " + this.monster.getItemAward());
                    this.getPlayer().getInventory().setWater(true);
                }
            }
            if (this.getPlayer().getHealth() <= 0) {
                System.out.println("You died in a combat!");
                return false;
            }
        }
        return true;
    }


    public int randomMonsterCountGenerator() {
        Random r = new Random();
        return r.nextInt(this.getMaxMonsterCount()) + 1;
    }

    public boolean fight(int monsterCount) {
        this.getPlayer().hitLuck();
        for (int i = 1; i <= monsterCount; i++) {
            this.getMonster().setHealth(this.monster.getDefaultHealth());
            getPlayer().showPlayerInfo();
            showMonsterInfo();
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("<H>it or <R>un Away!");
                String selectBehavior = sc.nextLine().toUpperCase();
                if (selectBehavior.equals("H")) {
                    if (this.getPlayer().getHitLuck() == 1) {
                        System.out.println("You're lucky.You are gonna hit first.");
                        if (this.getPlayer().getHealth() > 0 ) {
                            System.out.println("You hit the! " + monster.getName());
                            monster.setHealth(this.monster.getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                            System.out.println("----------------------------------------------------------------------------------------------");
                            if (this.getMonster().getHealth() > 0) {
                                System.out.println("Monster hits you!");
                                int monsterDamage = this.monster.getDamage() - this.getPlayer().getTotalArmor();
                                if (monsterDamage < 0) {
                                    monsterDamage = 0;
                                }
                                this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                                afterHit();
                                System.out.println("----------------------------------------------------------------------------------------------");
                            }
                        }
                    }
                    if (this.getPlayer().getHitLuck() == 2) {
                        System.out.println("You're out of luck.Be ready monster gonna hit you.");
                        if (this.getMonster().getHealth() > 0 ) {
                            System.out.println("Monster hits you!");
                            int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getTotalArmor();
                            if (monsterDamage < 0) {
                                monsterDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                            afterHit();
                            if(this.getPlayer().getHealth()>0){
                            System.out.println("----------------------------------------------------------------------------------------------");
                            System.out.println("You hit the! " + monster.getName());
                            this.monster.setHealth(this.monster.getHealth() - this.getPlayer().getTotalDamage());
                            System.out.println("----------------------------------------------------------------------------------------------");
                            afterHit();
                            }
                            else{
                                return false;
                            }
                        }
                    }
                }
                else {
                    return false;
                }
            }
            if (this.monster.getHealth() < this.getPlayer().getHealth()) {
                afterMonsterDie();
                if (this.getMonster().getName().equals("Snake")) {
                    itemDrop();
                }
            }

        }
        return true;
    }

    public void showMonsterInfo() {
        System.out.println("Monster's Name: " + monster.getName() + "\n" +
                "Monster's Damage: " + monster.getDamage() + "\n" +
                "Monster's Health: " + monster.getHealth() + "\n" +
                "Monster's Award: " + monster.getAward());
        System.out.println("----------------------------------------------------------------------------------------------");
    }


    public void afterHit() {
        System.out.println("Your health is " + this.getPlayer().getHealth());
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Monster's health is " + this.getMonster().getHealth());
    }
    public void itemDrop() {
        int dropRate;
        int dropPosibility;
        dropPosibility = r.nextInt(100);
        dropRate = r.nextInt(100);
        if (dropPosibility <= 15) {
            if (dropRate < 50) {
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
                System.out.println("You dropped " + getPlayer().getInventory().getWeapon().getName());
            }
            if (dropRate >= 50 && dropRate < 80) {
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
                System.out.println("You dropped " + getPlayer().getInventory().getWeapon().getName());
            }
            if (dropRate >= 80 && dropRate < 90) {
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
                System.out.println("You dropped " + getPlayer().getInventory().getWeapon().getName());
            }
            if (dropRate >= 90) {
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(4));
                System.out.println("You dropped " + getPlayer().getInventory().getWeapon().getName());
            }
        }
        if (dropPosibility > 16 && dropPosibility <= 30) {
            if (dropRate < 50) {
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(1));
                System.out.println("You dropped " + getPlayer().getInventory().getArmor().getName());
            }
            if (dropRate >= 50 && dropRate < 80) {
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(2));
                System.out.println("You dropped " + getPlayer().getInventory().getArmor().getName());
            }
            if (dropRate >= 80) {
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(3));
                System.out.println("You dropped " + getPlayer().getInventory().getArmor().getName());
            }
        }
        if (dropPosibility > 31 && dropPosibility < 56) {
            if (dropRate < 20) {
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                System.out.println("You dropped 10 gold.");
            }
            if (dropRate >= 20 && dropRate < 50) {
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                System.out.println("You dropped 5 gold.");
            }
            if (dropRate >= 50) {
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                System.out.println("You dropped 1 gold.");
            }
        }
        if (dropPosibility >= 56) {
            System.out.println("There is no item on this monster.");
        }

    }

    public void afterMonsterDie() {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("You beat the: " + this.monster.getName());
        System.out.println("You earn: " + this.getMonster().getAward() + " gold.");
        this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
        System.out.println("You have " + this.getPlayer().getMoney() + " gold.");
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonsterCount() {
        return maxMonsterCount;
    }

    public void setMaxMonsterCount(int maxMonsterCount) {
        this.maxMonsterCount = maxMonsterCount;
    }

}

