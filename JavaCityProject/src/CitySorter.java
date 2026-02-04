//Bu sınıf Strategy Pattern'in "context" sınıfı
import java.util.List;

public class CitySorter {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public List<City> sort(List<City> cities) {
        if (strategy == null) {
            throw new IllegalStateException("Sort strategy is not set.");
        }
        return strategy.sort(cities);
    }
}
