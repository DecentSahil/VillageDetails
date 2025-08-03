package Village.Details;
public class Resource {
    String name;
    int quantity;
    public Resource(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    public double calculateValue() {
        return quantity * 1.0;
    }
    public double calculateValue(double pricePerUnit) {
        return quantity * pricePerUnit;
    }
    public double calculateValue(double pricePerUnit, double seasonalFactor) {
        return quantity * pricePerUnit * seasonalFactor;
    }
}
class Water extends Resource {
    public Water(String name, int quantity) {
        super(name, quantity);
    }
    @Override
    public double calculateValue() {
        return quantity * 0.5;
    }
    @Override
    public double calculateValue(double pricePerUnit) {
        return quantity * pricePerUnit * 0.9;
    }
    @Override
    public double calculateValue(double pricePerUnit, double seasonalFactor) {
        return quantity * pricePerUnit * seasonalFactor * 0.85;
    }
}
class Food extends Resource {
    public Food(String name, int quantity) {
        super(name, quantity);
    }
    @Override
    public double calculateValue() {
        return quantity * 2.0;
    }
    @Override
    public double calculateValue(double pricePerUnit) {
        return quantity * pricePerUnit ;
    }
    @Override
    public double calculateValue(double pricePerUnit, double seasonalFactor) {
        return quantity * pricePerUnit * seasonalFactor;
    }
}
class Wood extends Resource {
    public Wood(String name, int quantity) {
        super(name, quantity);
    }
    @Override
    public double calculateValue() {
        return quantity * 1.5;
    }
    @Override
    public double calculateValue(double pricePerUnit) {
        return quantity * pricePerUnit ;
    }
    @Override
    public double calculateValue(double pricePerUnit, double seasonalFactor) {
        return quantity * pricePerUnit * seasonalFactor;
    }
}
class ResourceTest {
    public static void main(String[] args) {
        Resource water = new Water("River Water", 100);
        Resource food = new Food("Wheat", 50);
        Resource wood = new Wood("Timber", 30);
//        Resource r1 = new Resource(river,100);
        System.out.println("Water Value: " + water.calculateValue());
        System.out.println("Food Value: " + food.calculateValue(20));
        System.out.println("Wood Value: " + wood.calculateValue(10, 1.5));
    }
}
