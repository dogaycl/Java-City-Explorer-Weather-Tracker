//WeatherIterator sadece seçilen hava
// durumuna sahip şehirleri döndürür. WeatherFilter bu iterator’u kullanarak filtreleme yapar.
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class WeatherIterator implements Iterator<City> {
    private List<City> cities;
    private String weather;
    private int index = 0;

    public WeatherIterator(List<City> cities, String weather) {
        this.cities = cities;
        this.weather = weather;
        moveToNextValid();
    }

    private void moveToNextValid() {
        while (index < cities.size() && !cities.get(index).currentWeatherState.equalsIgnoreCase(weather)) {
            index++;
        }
    }

    @Override
    public boolean hasNext() {
        return index < cities.size();
    }

    @Override
    public City next() {
        if (!hasNext()) throw new NoSuchElementException();
        City current = cities.get(index++);
        moveToNextValid(); // sonraki geçerliye geç
        return current;
    }
}
