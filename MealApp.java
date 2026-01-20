
interface Meal {

    double calculatePrice();

    void displayInfo();
}

class StandardMeal implements Meal {

    private final String name;
    private final double basePrice;

    public StandardMeal(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    @Override
    public double calculatePrice() {
        return basePrice * 1.2;
    }

    @Override
    public void displayInfo() {
        System.out.println("----- Standard Meal -----");
        System.out.println("Meal Name: " + name);
        System.out.println("Meal Price: " + calculatePrice());
        System.out.println();
    }

}

class ComboMeal implements Meal {

    private final String name;
    private final double basePrice;

    public ComboMeal(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    @Override
    public double calculatePrice() {
        return basePrice * 2.5;
    }

    @Override
    public void displayInfo() {
        System.out.println("----- Combo Meal -----");
        System.out.println("Meal Name: " + name);
        System.out.println("Meal Price: " + calculatePrice());
        System.out.println();
    }

}

class DiscountMeal implements Meal {

    private final String name;
    private final double basePrice;
    private final double discountPercent;

    public DiscountMeal(String name, double basePrice, double discountPercent) {
        this.name = name;
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculatePrice() {
        return basePrice - (basePrice * 2.5);
    }

    @Override
    public void displayInfo() {
        System.out.println("----- Discount Meal -----");
        System.out.println("Meal Name: " + name);
        System.out.println("Meal Price: " + calculatePrice());
        System.out.println();
    }

}

public class MealApp {

    public static void main(String[] args) {
        Meal m1 = new StandardMeal("Burger", 300);
        Meal m2 = new ComboMeal("Pizza Combo", 1400);
        Meal m3 = new DiscountMeal("Pasta", 500, 0.30);

        m1.calculatePrice();
        m1.displayInfo();

        m2.calculatePrice();
        m2.displayInfo();

        m3.calculatePrice();
        m3.displayInfo();
    }
}
