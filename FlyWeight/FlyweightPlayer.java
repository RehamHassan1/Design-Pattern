import java.util.*;

interface PlayerType {
    void render(int x, int y, int health, int score, String weapon);
}

// Concrete Flyweight
class ConcretePlayerType implements PlayerType {
    private String shape;
    private String skin;

    public ConcretePlayerType(String shape, String skin) {
        this.shape = shape;
        this.skin = skin;
    }

    @Override
    public void render(int x, int y, int health, int score, String weapon) {
        System.out.println("Rendering player at (" + x + ", " + y + ") "
                + "with health=" + health + ", score=" + score
                + " | Shape=" + shape + ", Skin=" + skin + ", Weapon=" + weapon);
    }
}

// Flyweight Factory
class PlayerFactory {
    private static Map<String, PlayerType> playerTypes = new HashMap<>();

    public static PlayerType getPlayerType(String model, String skin) {
        String key = model + "-" + skin;
        if (!playerTypes.containsKey(key)) {
            playerTypes.put(key, new ConcretePlayerType(model, skin));
            System.out.println("Created new PlayerType: " + key);
        }
        return playerTypes.get(key);
    }
}

class Player {
    private int x;
    private int y;
    private int health;
    private int score;
    private String weapon;
    private PlayerType type;

    public Player(int x, int y, int health, int score, String weapon, PlayerType type) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.score = score;
        this.weapon = weapon;
        this.type = type;
    }

    public void render() {
        type.render(x, y, health, score, weapon);
    }
}

// Client
public class FlyweightPlayer {
    public static void main(String[] args) {
        PlayerType soldierType = PlayerFactory.getPlayerType("3DModel_A", "DesertSkin");
        PlayerType sniperType = PlayerFactory.getPlayerType("3DModel_B", "ForestSkin");

        Player[] players = {
                new Player(10, 20, 100, 50, "Rifle", soldierType),
                new Player(15, 30, 80, 120, "Pistol", soldierType),
                new Player(25, 40, 90, 200, "Sniper", sniperType),
                new Player(30, 50, 70, 300, "Shotgun", soldierType),
        };

        for (Player p : players) {
            p.render();
        }
    }
}
