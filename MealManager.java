
import java.util.ArrayList;

class MealList {

    private final ArrayList<Meal> _mealList = new ArrayList<>();

    public void addTicket(Meal meal) {
        _mealList.add(meal);
        System.out.println("Meal added successfully!\n");
    }

    public void removeMeal(int index) {
        if (index >= 0 && index < _mealList.size()) {
            _mealList.remove(index);
            System.out.println("Meal deleted successfully!\n");

        } else {
            System.out.println("Meal not found\n");
        }
    }

    public void displayAllTickets() {
        if (_mealList.isEmpty()) {
            System.out.println("No meal available.\n");
            return;
        }

        System.out.println("===== All Meals =====");
        for (Meal m : _mealList) {
            m.displayInfo();
        }
    }

    public double totalMealRevenue() {
        double sum = 0;
        for (Meal m : _mealList) {
            sum += m.calculatePrice();
        }
        return sum;
    }
}

public class MealManager {

    public static void main(String[] args) {
        MealList ml = new MealList();

        Meal m1 = new StandardMeal("Burger", 200);
        Meal m2 = new ComboMeal("Family Combo", 500);
        Meal m3 = new DiscountMeal("Pizza", 400, 0.15);
        Meal m4 = new StandardMeal("Sandwich", 150);

        ml.addTicket(m1);
        ml.addTicket(m2);
        ml.addTicket(m3);
        ml.addTicket(m4);

        ml.displayAllTickets();
        ml.removeMeal(3);
        System.out.println("Total Meal Cost = " + ml.totalMealRevenue());
    }
}
