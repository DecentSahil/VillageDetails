package Village.Details;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonList {
    DefaultTableModel tableModel;

    public PersonList(JFrame houseFrame, int houseId) {
        JFrame frame = new JFrame("Person List");
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columns = {"First Name", "Last Name", "DOB", "Gender", "Occupation"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 80, 700, 400);
        frame.add(scrollPane);

        JButton back = new JButton("Back");
        back.setBounds(30, 20, 100, 30);
        frame.add(back);

        JButton addPerson = new JButton("Add New Person");
        addPerson.setBounds(150, 20, 180, 30);
        frame.add(addPerson);

        back.addActionListener(e -> {
            frame.setVisible(false);
            houseFrame.setVisible(true);
        });

        addPerson.addActionListener(e -> {
            frame.setVisible(false);
            new PersonForm(frame, houseId, tableModel);
        });

        loadPersonsFromDB(houseId);

        frame.setVisible(true);
    }

    private void loadPersonsFromDB(int houseId) {
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM person WHERE house_id = ?";
            PreparedStatement pst = c.conn.prepareStatement(query);
            pst.setInt(1, houseId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("dob"),
                        rs.getString("gender"),
                        rs.getString("occupation")
                });
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
