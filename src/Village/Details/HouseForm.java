package Village.Details;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Random;

public class HouseForm {
    private HashSet<Integer> usedIds = new HashSet<>();
    private Random random = new Random();

    public HouseForm(DefaultTableModel tableModel, JFrame parentFrame, int villageId) {
        JFrame frame = new JFrame("Add New House");
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels & Fields
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

        // Add Button
        JButton addButton = new JButton("Add House");
        addButton.setBounds(150, 200, 150, 30);
        frame.add(addButton);

        addButton.addActionListener(e -> {
            String houseNo = houseNoField.getText().trim();
            String type = (String) typeBox.getSelectedItem();
            String size = sizeField.getText().trim();
            String address = addressField.getText().trim();

            if (houseNo.isEmpty() || size.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int houseId = generateUniqueId();
            try {
                Conn c = new Conn();
                String query = "INSERT INTO house (id, houseNo, type, size, address, village_id) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = c.conn.prepareStatement(query);
                pst.setInt(1, houseId);
                pst.setString(2, houseNo);
                pst.setString(3, type);
                pst.setString(4, size);
                pst.setString(5, address);
                pst.setInt(6, villageId);
                pst.executeUpdate();
                pst.close();

                // Add to table
                tableModel.addRow(new Object[]{houseId, houseNo, type, size, address});

                JOptionPane.showMessageDialog(frame, "House added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                parentFrame.setVisible(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error saving to database", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    private int generateUniqueId() {
        int id;
        do {
            id = 100000 + random.nextInt(900000); // 6-digit number
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;
    }
}
