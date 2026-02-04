//WeatherProvider, 3 saniyede bir tüm observer’lara haber verir (updateWeather() çağrılır).
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherProvider extends Thread {
    private static WeatherProvider instance;
    private final List<WeatherObserver> observers = new ArrayList<>();
    private final String[] weatherStates = {"SUNNY", "RAINY", "CLOUDY", "SNOWY"};
    private final Random random = new Random();
    private boolean running = true;

    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(3000); // 3 saniye bekle

                // Şehirlerin hava durumu ve sıcaklığını rastgele değiştir
                List<City> cities = CityRepository.getInstance().getCities();
                for (City city : cities) {
                    city.currentWeatherState = weatherStates[random.nextInt(weatherStates.length)];
                    city.currentTemperature = 10 + random.nextInt(26); // 10–35 derece
                }

                notifyObservers(); // Grafik bileşenlerine haber ver

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopProvider() {
        running = false;
    }

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.updateWeather();
        }
    }
}
