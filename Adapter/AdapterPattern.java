interface OldInterface {
    void oldRequest();
}

class OldImplementation implements OldInterface {
    @Override
    public void oldRequest() {
        System.out.println("Called oldRequest() from OldImplementation");
    }
}
interface NewInterface {
    void newRequest();
}
class Adapter implements NewInterface {
    private OldInterface oldInterface;
    public Adapter(OldInterface oldInterface) {
        this.oldInterface = oldInterface;
    }
    @Override
    public void newRequest() {
        System.out.println("Adapter translates newRequest() to oldRequest()");
        oldInterface.oldRequest();
    }
}
public class AdapterPattern {
    public static void main(String[] args) {
        OldInterface oldObject = new OldImplementation();

        NewInterface adapter = new Adapter(oldObject);

        // Client uses new interface
        adapter.newRequest();
    }
}
