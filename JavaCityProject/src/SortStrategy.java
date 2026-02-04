//Strategy Pattern’i, sıralama algoritmalarını değiştirilebilir
// hale getirmek için kullandım. Kullanıcı ComboBox’tan
// seçince, CitySorter dinamik olarak ilgili stratejiyi uygular.
import java.util.List;

public interface SortStrategy {
    List<City> sort(List<City> cities);
}
