package Village.Details;

import javax.swing.*;

public class HouseList {
    DefaultListModel<String> houseList = new DefaultListModel<>();
    HouseList(JFrame villageFrame){
        JFrame frame = new JFrame("House List");
        frame.setBounds(0,0,1500,750);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JList<String> list = new JList<>(houseList);
        JScrollPane houseDetails = new JScrollPane(list);
        houseDetails.setBounds(100,100,1000,500);
        frame.add(houseDetails);

        JButton backButton = new JButton("Back");
        backButton.setBounds(40,20,200,25);
        frame.add(backButton);

        JButton newHouse = new JButton("Add New House");
        newHouse.setBounds(300,600,200,25);
        frame.add(newHouse);

        backButton.addActionListener(e->{
            frame.setVisible(false);
            villageFrame.setVisible(true);
        });

        newHouse.addActionListener(e->{
            frame.setVisible(false);
            new HouseForm(houseList,frame);
        });




        frame.setVisible(true);
    }

}
