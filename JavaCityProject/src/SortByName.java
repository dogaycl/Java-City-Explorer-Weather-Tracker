import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByName implements SortStrategy {
    @Override
    public List<City> sort(List<City> cities) {
        Collections.sort(cities, Comparator.comparing(city -> city.name));
        return cities;
    }
}
