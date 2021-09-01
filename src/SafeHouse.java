public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player) {
        super(player, "Safe House", 1, "You are in safehouse right now.Your health restored.");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in safehouse right now.");
        System.out.println("Your health restored.");
        this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
        return true;
    }
}
