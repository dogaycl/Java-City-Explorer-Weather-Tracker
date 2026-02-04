
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByPopulation implements SortStrategy {
    @Override
    public List<City> sort(List<City> cities) {
        Collections.sort(cities, Comparator.comparingInt(city -> city.population));
        return cities;
    }
}
