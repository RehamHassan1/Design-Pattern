interface UI {
    void render();
}
// Switch Mode
class DarkUI implements UI {
    @Override
    public void render() {
        System.out.println("Rendering Dark UI");
    }
}
class LightUI implements UI {
    @Override
    public void render() {
        System.out.println("Rendering Light UI");
    }
}

// Abstraction OS
abstract class OperatingSystem {
    protected UI ui;
    public OperatingSystem(UI ui) {
        this.ui = ui;
    }
    abstract void run();
}
class WindowsOS extends OperatingSystem {
    public WindowsOS(UI ui) {
        super(ui);
    }
    @Override
    void run() {
        System.out.print("Windows running with ");
        ui.render();
    }
}
class LinuxOS extends OperatingSystem {
    public LinuxOS(UI ui) {
        super(ui);
    }
    @Override
    void run() {
        System.out.print("Linux running with ");
        ui.render();
    }
}
// Client
public class BridgePattern {
    public static void main(String[] args) {
        OperatingSystem windowsDark = new WindowsOS(new DarkUI());
        windowsDark.run();
        OperatingSystem windowsLight = new WindowsOS(new LightUI());
        windowsLight.run();

        OperatingSystem linuxDark = new LinuxOS(new DarkUI());
        linuxDark.run();
        OperatingSystem linuxLight = new LinuxOS(new LightUI());
        linuxLight.run();
    }
}
