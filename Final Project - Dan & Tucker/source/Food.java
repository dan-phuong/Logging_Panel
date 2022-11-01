public class Food {
    private String name;
    private double value; // monetary value of ingredient per pound
    private double weight;

    public Food(String name, double value, double weight){
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String part1 = name+": $";
        String part2 = String.format("%.2f", value*weight);
        return String.format(part1+part2);
    }

}
