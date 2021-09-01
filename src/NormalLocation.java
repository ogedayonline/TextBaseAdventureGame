public abstract class NormalLocation extends Location {
    public NormalLocation(Player player, String name, int id, String explanation) {
        super(player, name, id, explanation);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
