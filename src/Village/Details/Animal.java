package Village.Details;

public class Animal {
    String name;
    int age;
    double weight;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    public void feed() {
        System.out.println(name+" is fed his basic food");
    }
    public void feed(String food) {
        System.out.println(name+" is fed with " + food);
    }
    public void feed(String food, int amount) {
        System.out.println(name+" is fed with " + amount + " units of " + food);
    }
}
class Cow extends Animal {
    public Cow(String name, int age, double weight) {
        super(name, age, weight);
    }
    @Override
    public void feed() {
        System.out.println(name+" the cow is fed with hay");
    }
    @Override
    public void feed(String food) {
        System.out.println(name+" the cow is fed with " + food);
    }
    @Override
    public void feed(String food, int amount) {
        System.out.println(name+ " the cow is fed with " + amount + "kg of " + food);
    }
}
class Goat extends Animal {
    public Goat(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void feed() {
        System.out.println(name + " the goat is fed with dry leaves");
    }

    @Override
    public void feed(String food) {
        System.out.println(name + " the goat is fed with " + food);
    }

    @Override
    public void feed(String food, int amount) {
        System.out.println(name + " the goat is fed with " + amount + " handfuls of " + food);
    }
}
class Hen extends Animal {
    public Hen(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void feed() {
        System.out.println(name + " the hen is fed with corn");
    }

    @Override
    public void feed(String food) {
        System.out.println(name + " the hen is pecking at " + food);
    }

    @Override
    public void feed(String food, int amount) {
        System.out.println(name + " the hen is fed with " + amount + " grams of " + food );
    }
}
class Farm {
    public static void main(String[] args) {
        Animal cow = new Cow("Bessie", 5, 450.0);
        Animal goat = new Goat("Mimi", 3, 60.0);
        Animal hen = new Hen("Clucky", 1, 2.5);

        cow.feed();
        goat.feed("grass");
        hen.feed("seeds", 100);
    }
}
