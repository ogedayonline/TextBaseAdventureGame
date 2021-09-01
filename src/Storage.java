public class Storage extends NormalLocation {

    public Storage(Player player) {
        super(player, "Storage", 2, "You can buy items in here.");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        System.out.println("Welcome to Storage!");
        while (showMenu) {
            System.out.println("Choose the item category :\n" +
                    "1-Swords,Guns and Staffs\n" +
                    "----------------------------\n" +
                    "2-Armors(Heavy,Medium,Light)\n" +
                    "----------------------------\n" +
                    "3-For Turn Back to Location Menu!");
            int categoryId = sc.nextInt();
            while (categoryId < 1 || categoryId > 3) {
                System.out.println("You choose the wrong category please choose again.");
                categoryId = sc.nextInt();
            }
            switch (categoryId) {
                case 1:
                    listWeapons();
                    break;
                case 2:
                    listArmors();
                    break;
                case 3:
                    System.out.println("Come Again!");
                    System.out.println("----------------------------");
                    showMenu = false;

            }
        }
        return true;
    }

    public void listWeapons() {
        System.out.println("Here my guns for sale!");
        for (Weapon w : Weapon.weapons()) {
            System.out.println("ID: " + w.getId() +
                    " Name: " + w.getName() +
                    " Price: " + w.getPrice() +
                    " Damage: " + w.getDamage());
        }
        System.out.println("For Quit Write 0 on Console.");
        buyWeapon();

    }

    public void buyWeapon() {
        System.out.println("Choose the item you want to buy!");
        int selectWeaponID = sc.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("You choose the wrong id please choose again.");
            selectWeaponID = sc.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money!");
                }
                if(selectWeaponID==3&&!getPlayer().getCharName().equals("Mage")){
                    System.out.println("Only mage can buy staff!");
                }
                else {
                    System.out.println("You buy the " + selectedWeapon.getName());
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your balance is: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    public void listArmors() {
        System.out.println("Here my armors for sale!");
        for (Armor a : Armor.armors()) {
            System.out.println("ID: " + a.getId() +
                    " Name: " + a.getName() +
                    " Price: " + a.getPrice() +
                    " Defence: " + a.getDefence());
        }
        System.out.println("For Quit Write 0 on Console.");
        buyArmor();
    }

    public void buyArmor() {
        System.out.println("Choose the item you want to buy!");
        int selectArmorID = sc.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("You choose the wrong id please choose again.");
            selectArmorID = sc.nextInt();
        }
        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money!");
                } else {
                    System.out.println("You buy the " + selectedArmor.getName());
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your balance is: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }
}
