interface Command {
    void execute();
    void undo();
}
// Receiver
class Player {
    public void move() { System.out.println("Player moves forward"); }
    public void attack() { System.out.println("Player attacks"); }
    public void defend() { System.out.println("Player defends"); }
}
class MoveCommand implements Command {
    private Player player;
    public MoveCommand(Player player) { this.player = player; }

    public void execute() { player.move(); }
    public void undo() { System.out.println("Undo move"); }
}

class AttackCommand implements Command {
    private Player player;
    public AttackCommand(Player player) { this.player = player; }

    public void execute() { player.attack(); }
    public void undo() { System.out.println("Undo attack"); }
}

// Invoker
class RemoteControl {
    private Command command;
    public void setCommand(Command command) { this.command = command; }

    public void pressButton() { command.execute(); }
    public void pressUndo() { command.undo(); }
}

// Client
public class Game {
    public static void main(String[] args) {
        Player player = new Player();
        Command move = new MoveCommand(player);
        Command attack = new AttackCommand(player);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(move);
        remote.pressButton();
        remote.pressUndo();

        remote.setCommand(attack);
        remote.pressButton();
        remote.pressUndo();
    }
}
