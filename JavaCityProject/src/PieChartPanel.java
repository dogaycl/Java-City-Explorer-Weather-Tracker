//BarChartPanel, PieChartPanel gibi sınıflar WeatherObserver interface'ini implement eder.

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PieChartPanel extends JPanel implements WeatherObserver {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        List<City> cities = CityRepository.getInstance().getCities();

        int sunny = 0, rainy = 0, cloudy = 0, snowy = 0;
        for (City city : cities) {
            switch (city.currentWeatherState) {
                case "SUNNY" -> sunny++;
                case "RAINY" -> rainy++;
                case "CLOUDY" -> cloudy++;
                case "SNOWY" -> snowy++;
            }
        }

        int total = sunny + rainy + cloudy + snowy;
        if (total == 0) return;

        Graphics2D g2 = (Graphics2D) g;
        int startAngle = 0;

        int diameter = Math.min(getWidth(), getHeight()) - 120;
        int x = (getWidth() - diameter) / 2;
        int y = 40;

        // Pie dilimleri
        int sunnyAngle = (int) ((sunny / (double) total) * 360);
        int rainyAngle = (int) ((rainy / (double) total) * 360);
        int cloudyAngle = (int) ((cloudy / (double) total) * 360);
        int snowyAngle = 360 - sunnyAngle - rainyAngle - cloudyAngle;

        g2.setColor(Color.YELLOW); g2.fillArc(x, y, diameter, diameter, startAngle, sunnyAngle); startAngle += sunnyAngle;
        g2.setColor(Color.GREEN);  g2.fillArc(x, y, diameter, diameter, startAngle, rainyAngle); startAngle += rainyAngle;
        g2.setColor(Color.BLUE);   g2.fillArc(x, y, diameter, diameter, startAngle, cloudyAngle); startAngle += cloudyAngle;
        g2.setColor(Color.WHITE);  g2.fillArc(x, y, diameter, diameter, startAngle, snowyAngle);

        // Başlık
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 14));
        g2.drawString("Weather Conditions", x + diameter/2 - 60, 20);

        // Legend (renk kutuları)
        int legendX = getWidth() - 160;
        int legendY = 60;
        int boxSize = 15;

        drawLegend(g2, legendX, legendY, boxSize, Color.YELLOW, "SUNNY");
        drawLegend(g2, legendX, legendY + 25, boxSize, Color.GREEN, "RAINY");
        drawLegend(g2, legendX, legendY + 50, boxSize, Color.BLUE, "CLOUDY");
        drawLegend(g2, legendX, legendY + 75, boxSize, Color.WHITE, "SNOWY");
    }

    private void drawLegend(Graphics2D g2, int x, int y, int size, Color color, String label) {
        g2.setColor(color);
        g2.fillRect(x, y, size, size);
        g2.setColor(Color.BLACK);
        g2.drawRect(x, y, size, size);
        g2.drawString(label, x + size + 10, y + 12);
    }

    @Override
    public void updateWeather() {
        repaint();
    }
}
