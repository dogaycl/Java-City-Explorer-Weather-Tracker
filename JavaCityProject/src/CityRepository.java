/**
 * Manages all city data loaded from a JSON file.
 * Implements Singleton Pattern to ensure only one instance exists.
 * Provides global access to city list.
 * decorator pattern
 * get instance burada.
 */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class CityRepository {
    private static CityRepository instance;
    private List<City> cities;

    private CityRepository() {
        cities = new ArrayList<>();
    }

    public static CityRepository getInstance() {
        if (instance == null) {
            instance = new CityRepository();
        }
        return instance;
    }

    public void loadCities(String filePath) {
    try {
        // Dosyanın tam yolunu kontrol etmek için bir File objesi oluşturalım
        java.io.File file = new java.io.File(filePath);
        
        // Eğer dosya bulunamazsa, kullanıcıya tam olarak nerede aradığını gösterelim
        if (!file.exists()) {
            System.out.println("Dosya bulunamadı! Aranan konum: " + file.getAbsolutePath());
            return;
        }

        FileReader reader = new FileReader(file);
        JSONArray cityArray = new JSONArray(new JSONTokener(reader));
        
        // ... geri kalan döngü işlemlerin aynı kalabilir ...
        for (int i = 0; i < cityArray.length(); i++) {
            JSONObject obj = cityArray.getJSONObject(i);
            City city = new City(
                    obj.getString("name"),
                    obj.getInt("population"),
                    obj.getDouble("area"),
                    obj.getInt("currentTemperature"),
                    obj.getString("currentWeatherState")
            );
            cities.add(city);
        }
        reader.close();
        System.out.println("Şehirler başarıyla yüklendi: " + cities.size() + " adet.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public List<City> getCities() {
        return cities;
    }
}
//singleton patterni burda kullanacağım
//getınstance() ile şehirlere erişim