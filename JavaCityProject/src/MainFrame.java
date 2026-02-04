/**
 * Main GUI window for the City Explorer application.
 * Combines multiple panels including sorting, filtering, visual charts and planner logic.
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private JComboBox<String> sortComboBox;
    private JComboBox<String> weatherComboBox;

    private DefaultListModel<String> allCitiesModel;
    private DefaultListModel<String> filteredCitiesModel;

    private JList<String> allCityList;
    private JList<String> filteredCityList;

    private CitySorter sorter;
    private BarChartPanel barChartPanel;
    private PieChartPanel pieChartPanel;
    private VisitPlannerPanel visitPlannerPanel;

    public MainFrame() {
        setTitle("City Explorer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLayout(new BorderLayout());

        // Top Panel: Sort + Weather
        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        topPanel.add(new JLabel("Sort Cities"));
        topPanel.add(new JLabel("Filter by Weather"));

        sortComboBox = new JComboBox<>(new String[]{"Name", "Population", "Area"});
        weatherComboBox = new JComboBox<>(new String[]{"ALL", "SUNNY", "RAINY", "CLOUDY", "SNOWY"});

        topPanel.add(sortComboBox);
        topPanel.add(weatherComboBox);
        add(topPanel, BorderLayout.NORTH);

        // Center Panel: Lists + Planner
        allCitiesModel = new DefaultListModel<>();
        filteredCitiesModel = new DefaultListModel<>();

        allCityList = new JList<>(allCitiesModel);
        filteredCityList = new JList<>(filteredCitiesModel);

        JScrollPane allCityScroll = new JScrollPane(allCityList);
        JScrollPane filteredCityScroll = new JScrollPane(filteredCityList);

        JPanel listPanel = new JPanel(new GridLayout(1, 2));
        listPanel.add(allCityScroll);
        listPanel.add(filteredCityScroll);

        // VisitPlanner
        visitPlannerPanel = new VisitPlannerPanel();

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(listPanel, BorderLayout.CENTER);
        centerPanel.add(visitPlannerPanel, BorderLayout.EAST);

        add(centerPanel, BorderLayout.CENTER);

        // Charts
        barChartPanel = new BarChartPanel();
        pieChartPanel = new PieChartPanel();
        barChartPanel.setPreferredSize(new Dimension(400, 300));
        pieChartPanel.setPreferredSize(new Dimension(400, 400));

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(barChartPanel, BorderLayout.WEST);
        bottomPanel.add(pieChartPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Listeners
        sorter = new CitySorter();

        sortComboBox.addActionListener(e -> updateLists());
        weatherComboBox.addActionListener(e -> updateLists());

        filteredCityList.addListSelectionListener(e -> {
            String selected = filteredCityList.getSelectedValue();
            if (selected != null && selected.contains("|")) {
                String cityName = selected.split("\\|")[0].trim();
                visitPlannerPanel.setSelectedCity(cityName);
            }
        });

        // Observer start
        WeatherProvider.getInstance().addObserver(barChartPanel);
        WeatherProvider.getInstance().addObserver(pieChartPanel);
        WeatherProvider.getInstance().start();

        updateLists(); // initial
    }

    private void updateLists() {
        CityRepository repo = CityRepository.getInstance();

        String selectedSort = (String) sortComboBox.getSelectedItem();
        String selectedWeather = (String) weatherComboBox.getSelectedItem();

        // Set strategy
        switch (selectedSort) {
            case "Name" -> sorter.setStrategy(new SortByName());
            case "Population" -> sorter.setStrategy(new SortByPopulation());
            case "Area" -> sorter.setStrategy(new SortByArea());
        }

        List<City> allCities = sorter.sort(repo.getCities());

        // Fill left list (All cities)
        allCitiesModel.clear();
        for (City city : allCities) {
            allCitiesModel.addElement(city.toString());
        }

        // Filter for middle list
        List<City> filteredCities;
        if (!selectedWeather.equals("ALL")) {
            filteredCities = WeatherFilter.filter(allCities, selectedWeather);
        } else {
            filteredCities = allCities;
        }

        // Fill right list (Filtered cities)
        filteredCitiesModel.clear();
        for (City city : filteredCities) {
            filteredCitiesModel.addElement(city.toString());
        }
    }
}
