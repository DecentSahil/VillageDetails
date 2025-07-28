package Village.Details;

public class Village {
    private String name;
    private String district;
    private String population;

    public Village(String name, String district, String population) {
        this.name = name;
        this.district = district;
        this.population = population;
    }

    public String toString() {
        return name + ", " + district + " (" + population + ")";
    }
}
