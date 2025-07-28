package Village.Details;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.util.*;

public class VillageForm {
    private JFrame frame;
    private JTextField nameField, districtField, stateField;
    private Set<Integer> usedIds = new HashSet<>();
    private Random random = new Random();
    private DefaultTableModel tableModel; // 🔧 add this at class level


    public VillageForm(DefaultTableModel tableModel, JFrame parentFrame) {
        this.tableModel=tableModel;
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

        JLabel stateLabel = new JLabel("State:");
        stateLabel.setBounds(30, 110, 100, 25);
        frame.add(stateLabel);

        stateField = new JTextField();
        stateField.setBounds(140, 110, 150, 25);
        frame.add(stateField);

        JButton addButton = new JButton("Add Village");
        addButton.setBounds(100, 160, 130, 30);
        frame.add(addButton);



        addButton.addActionListener(e -> {
                    String name = nameField.getText().trim();
                    String district = districtField.getText().trim();
                    String state = stateField.getText().trim();
                    int id =generateUniqueId();

                    if (name.isEmpty() || district.isEmpty() || state.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try {
                    Conn c = new Conn();
                    String query = "insert into Village(Id,Name,District,State) Values (?,?,?,?)";
                    PreparedStatement pst = c.conn.prepareStatement(query);
                    pst.setInt(1, id);
                    pst.setString(2, name);
                    pst.setString(3, district);
                    pst.setString(4, state);
                    pst.executeUpdate();
                    tableModel.addRow(new Object[]{id, name, district, state});
                    pst.close();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }




//            listModel.addElement("ID: " + villageId + " | " + new Village(name, district, state));

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
