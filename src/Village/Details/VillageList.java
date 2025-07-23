package Village.Details;

import javax.swing.*;
import java.awt.event.*;


public class VillageList {
    Village village;
    private DefaultListModel<String> villageList = new DefaultListModel<>();
    VillageList(){
        JFrame frame = new JFrame();
        frame.setBounds(0,0,1000,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JList<String> list = new JList<>(villageList);
        JScrollPane details = new JScrollPane(list);
        details.setBounds(100,100,500,500);
        frame.add(details);
        frame.setVisible(true);

        JButton addButton = new JButton("Add New Village");
        addButton.setBounds(100, 600, 130, 30);
        frame.add(addButton);

        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String selectedVillage = list.getSelectedValue();
                    if (selectedVillage != null) {
                        frame.setVisible(false);
                        new HouseList(frame); // Open new window with details
                    }
                }
            }
        });


        addButton.addActionListener( e ->{
            frame.setVisible(false);
            new VillageForm(villageList,frame);
        });

    }

    public static void main(String[] args) {
        new VillageList();
    }
}
