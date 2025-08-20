interface Server {
    void request();
}
class RealServer implements Server {
    @Override
    public void request() {
        System.out.println("Fetching data from the REAL Server...");
    }
}
class ProxyServer implements Server {
    private RealServer realServer;
    private boolean hasAccess;
    public ProxyServer(boolean hasAccess) {
        this.hasAccess = hasAccess;
    }
    @Override
    public void request() {
        if (hasAccess) {
            if (realServer == null) {
                realServer = new RealServer(); // Lazy initialization
            }
            System.out.println("Proxy: Access granted.");
            realServer.request();
        } else {
            System.out.println("Proxy: Access denied!");
        }
    }
}
// Client
public class ProxyPattern {
    public static void main(String[] args) {
        Server proxy1 = new ProxyServer(true);  // access
        proxy1.request();

        Server proxy2 = new ProxyServer(false); // no access
        proxy2.request();
    }
}
