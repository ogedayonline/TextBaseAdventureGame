public class Cave extends BattleLocation {

    public Cave(Player player) {
        super(player, "Cave", 3, "It's a dark cave!Be careful you can see some Zombie's here.", new Zombie(), "Food", 3);

    }

    @Override
    public boolean onLocation() {
        return super.onLocation();
    }
}
