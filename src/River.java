public class River extends BattleLocation {
    public River(Player player) {
        super(player, "River", 5, "Be careful don't fall into the water!", new Bear(), "Water", 2);
    }

    @Override
    public boolean onLocation() {
        return super.onLocation();
    }
}
