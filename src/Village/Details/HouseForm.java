package Village.Details;

import javax.swing.*;
import java.util.HashSet;
import java.util.Random;


public class HouseForm {

    private HashSet<Integer> usedIds = new HashSet<>();
    private Random random = new Random();

    public HouseForm(DefaultListModel<String> houseList,JFrame parentFrame) {
        JFrame frame = new JFrame("House Management");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel houseNoLabel = new JLabel("House No:");
        houseNoLabel.setBounds(30, 30, 100, 25);
        frame.add(houseNoLabel);

        JTextField houseNoField = new JTextField();
        houseNoField.setBounds(150, 30, 150, 25);
        frame.add(houseNoField);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(30, 70, 100, 25);
        frame.add(typeLabel);

        String[] types = {"Apartment", "Village", "Bungalow", "Flat"};
        JComboBox<String> typeBox = new JComboBox<>(types);
        typeBox.setBounds(150, 70, 150, 25);
        frame.add(typeBox);

        JLabel sizeLabel = new JLabel("Size (sq ft):");
        sizeLabel.setBounds(30, 110, 100, 25);
        frame.add(sizeLabel);

        JTextField sizeField = new JTextField();
        sizeField.setBounds(150, 110, 150, 25);
        frame.add(sizeField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 150, 100, 25);
        frame.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(150, 150, 150, 25);
        frame.add(addressField);

        JButton addButton = new JButton("Add House");
        addButton.setBounds(150, 190, 150, 30);
        frame.add(addButton);


        addButton.addActionListener( e -> {
            String houseNo = houseNoField.getText();
            String type = (String) typeBox.getSelectedItem();
            String size = sizeField.getText();
            String address = addressField.getText();

            if (!houseNo.isEmpty() && !size.isEmpty() && !address.isEmpty()) {
                int uniqueId = generateUniqueId();
                String entry = uniqueId + " | House No: " + houseNo + ", " + type + ", " + size + " sq.ft, " + address;
                houseList.addElement(entry);
                JOptionPane.showMessageDialog(frame, "House added with ID: " + uniqueId);
                frame.dispose();
                parentFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    private int generateUniqueId() {
        int id;
        do {
            id = 100000 + random.nextInt(900000); // 6-digit number between 100000–999999
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;
    }


}
