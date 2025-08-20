abstract class Handler {
    protected Handler next;
    public void setNext(Handler next) {
        this.next = next;
    }
    public abstract void handleRequest(String request);
}
class BotHandler extends Handler {
    public void handleRequest(String request) {
        if (request.equals("faq")) {
            System.out.println("Bot: Answering FAQs.");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}
class ModeratorHandler extends Handler {
    public void handleRequest(String request) {
        if (request.equals("chat issue")) {
            System.out.println("Moderator: Handling chat issue.");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}
class AdminHandler extends Handler {
    public void handleRequest(String request) {
        if (request.equals("ban")) {
            System.out.println("Admin: Handling ban request.");
        } else if (next != null) {
            next.handleRequest(request);
        } else {
            System.out.println("Request not handled!");
        }
    }
}

// player
public class GameSupport {  
    public static void main(String[] args) {
        Handler bot = new BotHandler();
        Handler moderator = new ModeratorHandler();
        Handler admin = new AdminHandler();

        // Chain: bot => moderator => admin
        bot.setNext(moderator);
        moderator.setNext(admin);

        bot.handleRequest("faq");
        bot.handleRequest("chat issue");
        bot.handleRequest("ban");
        bot.handleRequest("unknown");
    }
}
