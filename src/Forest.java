public class Forest extends BattleLocation {
    public Forest(Player player) {
        super(player, "Forest", 4, "It's silent and dangerous forest!Be careful you can see some Vampire's here.", new Vampire(), "Wood", 3);
    }

    @Override
    public boolean onLocation() {
        return super.onLocation();
    }

}

