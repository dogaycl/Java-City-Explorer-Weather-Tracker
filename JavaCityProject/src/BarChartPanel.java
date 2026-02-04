/**
 * This class is responsible for rendering a custom bar chart
 * showing the temperatures of cities. Implements WeatherObserver
 * to stay updated.
 * Developed by NisaDoğa.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.List;

public class BarChartPanel extends JPanel implements WeatherObserver {

    private List<City> cities;

    public BarChartPanel() {
        this.cities = CityRepository.getInstance().getCities();
    }

    // Hava durumu güncellenince grafiği yeniden çizdiriyoruz (observer pattern)

    @Override
    public void updateWeather() {
        this.cities = CityRepository.getInstance().getCities();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (cities == null || cities.isEmpty()) return;

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int padding = 50;
        int availableWidth = width - 2 * padding;
        int barWidth = Math.max(20, availableWidth / cities.size());

        int maxTemp = cities.stream().mapToInt(c -> c.currentTemperature).max().orElse(1);

        // Başlık
        g2.setFont(new Font("SansSerif", Font.BOLD, 14));
        g2.setColor(Color.BLACK);
        g2.drawString("City Temperatures", padding, 20);
// Bar grafiğin üst başlığı - sabit yazı
        for (int i = 0; i < cities.size(); i++) {
            City city = cities.get(i);
            int temp = city.currentTemperature;

            int barHeight = (int) ((double) temp / maxTemp * (height - 100));
            int x = padding + i * barWidth;
            int y = height - barHeight - padding;

            // Bar şekili
            g2.setColor(new Color(255, 102, 102)); // pembe/kırmızımsı bar rengi
            g2.fillRect(x, y, barWidth - 10, barHeight);

            // Sıcaklık etiketi
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("SansSerif", Font.BOLD, 12));
            g2.drawString(temp + "°C", x + 2, y - 5);

            // Şehir ismini dikey yaz
            AffineTransform oldTransform = g2.getTransform();
            g2.rotate(-Math.PI / 2, x + (barWidth / 2.0), height - 10);
            g2.drawString(city.name, x + (barWidth / 2) - 10, height - 10);
            g2.setTransform(oldTransform);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 300);
    }
}
