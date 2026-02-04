import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeatherFilter {
    public static List<City> filter(List<City> cities, String weather) {
        List<City> result = new ArrayList<>();
        Iterator<City> iterator = new WeatherIterator(cities, weather);
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }
}
