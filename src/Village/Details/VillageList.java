package Village.Details;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VillageList {

    private JTable table;
    private DefaultTableModel tableModel;
    private DefaultListModel<String> villageList = new DefaultListModel<>();
    VillageList(){
        JFrame frame = new JFrame();
        frame.setBounds(0,0,1000,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        String[] columns = {"ID","Name","District","State"};
        tableModel = new DefaultTableModel(columns,0);
        table = new JTable(tableModel){
            public boolean isCellEditable(int row, int column) {
                return false; // disable editing
            }
        };
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100,100,800,500);
        frame.add(scrollPane);
        frame.setVisible(true);

        JButton addButton = new JButton("Add New Village");
        addButton.setBounds(100, 600, 130, 30);
        frame.add(addButton);

        loadVillageFromDatabase();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Double-click
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        int villageId = (int) table.getValueAt(selectedRow, 0); // Get village ID from column 0
                        frame.setVisible(false);
                        new HouseList(frame, villageId); // Pass villageId to HouseList
                    }
                }
            }
        });




        addButton.addActionListener( e ->{
            frame.setVisible(false);
            new VillageForm(tableModel,frame);
        });

    }
    public void loadVillageFromDatabase(){
        tableModel.setRowCount(0);
        try{
        Conn c = new Conn();
        String query = "select * from village";
        PreparedStatement pst = c.conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Object[] row = {
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("District"),
                        rs.getString("State")
                };
                tableModel.addRow(row);
            }
            rs.close();
            pst.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    public static void main(String[] args) {
        new VillageList();
    }
}
