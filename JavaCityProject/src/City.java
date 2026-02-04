/**
 * Represents a city with basic statistical and environmental data.
 * Used throughout the project for sorting, filtering, and visualization.
 */

public class City {
    public String name;
    public int population;
    public double area;
    public int currentTemperature;
    public String currentWeatherState;

    public City(String name, int population, double area, int currentTemperature, String currentWeatherState) {
        this.name = name;
        this.population = population;
        this.area = area;
        this.currentTemperature = currentTemperature;
        this.currentWeatherState = currentWeatherState;
    }
    // Şehir objesini listede okunabilir şekilde göstermek için;
    @Override
    public String toString() {
        return name + " | Pop: " + population + " | Area: " + area + " km² | Temp: " + currentTemperature + "°C | Weather: " + currentWeatherState;
    }
}
