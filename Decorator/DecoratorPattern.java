// Component
interface Beverage {
    String getDescription();

    double getCost();
}

// Concrete Component
class Espresso implements Beverage {
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double getCost() {
        return 8.0;
    }
}

class HouseBlend implements Beverage {
    @Override
    public String getDescription() {
        return "House Blend Coffee";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

// Decorator (Abstract)
abstract class BeverageDecorator implements Beverage {
    // Composition
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public double getCost() {
        return beverage.getCost();
    }
}

// Concrete Decorators
class Mocha extends BeverageDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Mocha";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}
class Whip extends BeverageDecorator {
    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whip Cream";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;
    }
}

class Milk extends BeverageDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + " => $" + espresso.getCost());

        Beverage mochaEspresso = new Mocha(new Espresso());
        System.out.println(mochaEspresso.getDescription() + " => $" + mochaEspresso.getCost());

        Beverage latte = new Milk(new Mocha(new Espresso()));
        System.out.println(latte.getDescription() + " => $" + latte.getCost());

        Beverage fancyCoffee = new Milk(new Whip(new Mocha(new HouseBlend())));
        System.out.println(fancyCoffee.getDescription() + " => $" + fancyCoffee.getCost());
    }
}
