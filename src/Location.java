import java.util.Scanner;

public abstract class Location {
    public static Scanner sc = new Scanner(System.in);
    private Player player;
    private String name;
    private int id;
    private String explanation;

    public Location(Player player, String name, int id, String explanation) {
        this.player = player;
        this.name = name;
        this.id = id;
        this.explanation = explanation;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
