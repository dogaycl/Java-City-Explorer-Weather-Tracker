//Observer Pattern’i, grafiklerin canlı şekilde güncellenmesi için kullandım.
// WeatherProvider arka planda çalışıyor, her 3 saniyede observer’ları bilgilendiriyor.
public interface WeatherObserver {
    void updateWeather();
}
