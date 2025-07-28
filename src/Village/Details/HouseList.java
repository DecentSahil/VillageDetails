package Village.Details;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class HouseList {
    private DefaultTableModel houseTableModel;
    private JTable houseTable;

    HouseList(JFrame villageFrame, int villageId) {
        JFrame frame = new JFrame("House List - Village ID: " + villageId);
        frame.setBounds(0, 0, 1200, 750);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ✅ Table Columns
        String[] columns = {"ID", "House No", "Type", "Size (sq ft)", "Address"};
        houseTableModel = new DefaultTableModel(columns, 0);
        houseTable = new JTable(houseTableModel){
            public boolean isCellEditable(int row, int column) {
                return false; // disable editing
            }
        };
        JScrollPane scrollPane = new JScrollPane(houseTable);
        scrollPane.setBounds(100, 100, 1000, 500);
        frame.add(scrollPane);

        // ✅ Buttons
        JButton backButton = new JButton("Back");
        backButton.setBounds(40, 20, 200, 25);
        frame.add(backButton);

        JButton newHouse = new JButton("Add New House");
        newHouse.setBounds(300, 620, 200, 30);
        frame.add(newHouse);

        // ✅ Load houses for selected village
        loadHousesFromDatabase(villageId);

        // ✅ Back button
        backButton.addActionListener(e -> {
            frame.setVisible(false);
            villageFrame.setVisible(true);
        });

        // ✅ Add house
        newHouse.addActionListener(e -> {
            frame.setVisible(false);
            new HouseForm(houseTableModel, frame, villageId);  // 👈 Pass tableModel
        });
        houseTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Double-click
                    int selectedRow = houseTable.getSelectedRow();
                    if (selectedRow != -1) {
                        int houseID = (int) houseTable.getValueAt(selectedRow, 0); // Get village ID from column 0
                        frame.setVisible(false);
                        new PersonList(frame, houseID); // Pass villageId to HouseList
                    }
                }
            }
        });
        frame.setVisible(true);
    }

    // ✅ Method to load houses from DB
    private void loadHousesFromDatabase(int villageId) {
        houseTableModel.setRowCount(0); // Clear table
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM house WHERE village_id = ?";
            PreparedStatement pst = c.conn.prepareStatement(query);
            pst.setInt(1, villageId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] row = {
                        rs.getInt("id"),
                        rs.getString("houseNo"),
                        rs.getString("type"),
                        rs.getString("size"),
                        rs.getString("address")
                };
                houseTableModel.addRow(row);
            }

            rs.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
