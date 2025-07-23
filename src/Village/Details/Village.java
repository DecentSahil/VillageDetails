package Village.Details;

public class Village {
    private String name;
    private String district;
    private int population;

    public Village(String name, String district, int population) {
        this.name = name;
        this.district = district;
        this.population = population;
    }

    public String toString() {
        return name + ", " + district + " (" + population + ")";
    }
}
