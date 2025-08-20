// Complex APIs
class AuthService {
    public void register(String username, String password) {
        System.out.println("User " + username + " registered.");
    }
    public void login(String username, String password) {
        System.out.println("User " + username + " logged in.");
    }
}
class ProductService {
    public void getProducts() {
        System.out.println("Fetched product list from server.");
    }
}
class PaymentService {
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " processed.");
    }
}
class AppFacade {
    private AuthService authService;
    private ProductService productService;
    private PaymentService paymentService;
    public AppFacade() {
        this.authService = new AuthService();
        this.productService = new ProductService();
        this.paymentService = new PaymentService();
    }
    public void registerAndLogin(String username, String password) {
        authService.register(username, password);
        authService.login(username, password);
    }
    public void showProducts() {
        productService.getProducts();
    }
    public void buyProduct(double amount) {
        paymentService.makePayment(amount);
    }
}
// Client
public class FacadePattern {
    public static void main(String[] args) {
        AppFacade app = new AppFacade();
        // Client only talks to Facade
        app.registerAndLogin("Reham", "12345");
        app.showProducts();
        app.buyProduct(99.99);
    }
}
