package Village.Details;

import javax.swing.*;
import java.util.*;

public class VillageForm {
    private JFrame frame;
    private JTextField nameField, districtField, populationField;
    private Set<Integer> usedIds = new HashSet<>();
    private Random random = new Random();

    public VillageForm(DefaultListModel<String> listModel,JFrame parentFrame) {
        frame = new JFrame("Village Management");
        frame.setSize(600, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Village Name:");
        nameLabel.setBounds(30, 30, 100, 25);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(140, 30, 150, 25);
        frame.add(nameField);

        JLabel districtLabel = new JLabel("District:");
        districtLabel.setBounds(30, 70, 100, 25);
        frame.add(districtLabel);

        districtField = new JTextField();
        districtField.setBounds(140, 70, 150, 25);
        frame.add(districtField);

        JLabel populationLabel = new JLabel("Population:");
        populationLabel.setBounds(30, 110, 100, 25);
        frame.add(populationLabel);

        populationField = new JTextField();
        populationField.setBounds(140, 110, 150, 25);
        frame.add(populationField);

        JButton addButton = new JButton("Add Village");
        addButton.setBounds(100, 160, 130, 30);
        frame.add(addButton);



        addButton.addActionListener(e -> {
                    String name = nameField.getText().trim();
                    String district = districtField.getText().trim();
                    String popText = populationField.getText().trim();

                    if (name.isEmpty() || district.isEmpty() || popText.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!popText.matches("\\d+")) {
                        JOptionPane.showMessageDialog(frame, "Population must be numeric.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int population = Integer.parseInt(popText);
                    int villageId = generateUniqueId();
                    listModel.addElement("ID: " + villageId + " | " + new Village(name, district, population));

                    JOptionPane.showMessageDialog(frame, "Village added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
                    parentFrame.setVisible(true);
                });
        frame.setVisible(true);


    }


    private int generateUniqueId() {
        int id;
        do {
            id = random.nextInt(9000) + 1000; // 1000 to 9999
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;
    }


}
