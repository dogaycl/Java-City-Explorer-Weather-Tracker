//bu bir abstract callasıdır.
//Decorator Pattern sayesinde kullanıcı seçtiği şehre aktiviteler ekleyebiliyor.
// Her bir aktivite bir sınıf, ve plan toplam süresi ve maliyeti canlı hesaplanıyor.
public abstract class CityActivity {

    // Kullanıcıya gösterilecek plan açıklaması
    public abstract String getDescription();

    // Aktivitenin maliyeti (USD bazında hesaplanır)
    public abstract double getCost();

    // Tahmini süre (saat cinsinden)
    public abstract double getTime();
    }