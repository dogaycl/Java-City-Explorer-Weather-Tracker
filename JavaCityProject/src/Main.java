//entry point
//şehir verisini yükler ve arayüzü çalıştırır.
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // JSON dosyasını yükle
        CityRepository.getInstance().loadCities("cities.json");

        // GUI ekranını başlat: MainFrame ekranı üzerinden
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
