import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisitPlannerPanel extends JPanel {
    private JCheckBox museumCheck, cityCenterCheck, mallCheck, parkCheck;
    private JTextArea resultArea;
    private String selectedCityName = "";

    public VisitPlannerPanel() {
        setLayout(new BorderLayout());

        // CheckBox paneli
        JPanel checkPanel = new JPanel(new GridLayout(4, 1));
        museumCheck = new JCheckBox("Visit Museum");
        cityCenterCheck = new JCheckBox("Visit City Center");
        mallCheck = new JCheckBox("Visit Shopping Mall");
        parkCheck = new JCheckBox("Walk in the Park");

        checkPanel.add(museumCheck);
        checkPanel.add(cityCenterCheck);
        checkPanel.add(mallCheck);
        checkPanel.add(parkCheck);

        add(checkPanel, BorderLayout.NORTH);

        // Sonuç alanı
        resultArea = new JTextArea(6, 30);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // Event listener
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePlan();
            }
        };

        museumCheck.addActionListener(action);
        cityCenterCheck.addActionListener(action);
        mallCheck.addActionListener(action);
        parkCheck.addActionListener(action);
    }

    public void setSelectedCity(String cityName) {
        this.selectedCityName = cityName;
        updatePlan();
    }

    private void updatePlan() {
        CityActivity plan = new BaseCity(selectedCityName);

        if (museumCheck.isSelected()) plan = new VisitMuseum(plan);
        if (cityCenterCheck.isSelected()) plan = new VisitCityCenter(plan);
        if (mallCheck.isSelected()) plan = new VisitShoppingMall(plan);
        if (parkCheck.isSelected()) plan = new WalkInThePark(plan);

        String result = plan.getDescription()
                + "\n\nTotal Time: " + plan.getTime() + " hours"
                + "\nTotal Cost: $" + plan.getCost();

        resultArea.setText(result);
    }
}
