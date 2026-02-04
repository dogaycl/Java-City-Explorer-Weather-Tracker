import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByArea implements SortStrategy {
    @Override
    public List<City> sort(List<City> cities) {
        Collections.sort(cities, Comparator.comparingDouble(city -> city.area));
        return cities;
    }
}
