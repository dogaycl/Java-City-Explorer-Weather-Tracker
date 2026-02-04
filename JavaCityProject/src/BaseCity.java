/**
 * Represents a basic city without any additional visits.
 * Used as the root in the Decorator Pattern.
 */

public class BaseCity extends CityActivity {
    private final String cityName;

    public BaseCity(String cityName) {
        this.cityName = cityName;
    }
    // Şehrin temel ziyaret planını döndürür (decorator root)

    @Override
    public String getDescription() {
        return "Base plan for visiting " + cityName;
    }

    @Override
    public double getCost() {
        return 0;
        // Temel şehir planı için ekstra maliyet yok
    }

    @Override
    public double getTime() {
        return 0;
        // Zaman gerektirmeyen boş plan.
    }
}
