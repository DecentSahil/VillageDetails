package Village.Details;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;

public class PersonForm {
    public PersonForm(JFrame parentFrame, int houseId, DefaultTableModel tableModel) {
        JFrame frame = new JFrame("Add Person");
        frame.setSize(500, 1000);
        frame.setLayout(null);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(30, 30, 100, 25);
        frame.add(firstNameLabel);

        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(140, 30, 200, 25);
        frame.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(30, 70, 100, 25);
        frame.add(lastNameLabel);

        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(140, 70, 200, 25);
        frame.add(lastNameField);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(30, 110, 100, 25);
        frame.add(dobLabel);

        JTextField dobField = new JTextField("yyyy-mm-dd");
        dobField.setBounds(140, 110, 200, 25);
        frame.add(dobField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 150, 100, 25);
        frame.add(genderLabel);

        JComboBox<String> genderBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        genderBox.setBounds(140, 150, 200, 25);
        frame.add(genderBox);

        JLabel occupationLabel = new JLabel("Occupation:");
        occupationLabel.setBounds(30, 190, 100, 25);
        frame.add(occupationLabel);

        JTextField occupationField = new JTextField();
        occupationField.setBounds(140, 190, 200, 25);
        frame.add(occupationField);

        JCheckBox voterCard = new JCheckBox("Do u have voter id card??");
        voterCard.setBounds(140,230,400,25);
        frame.add(voterCard);

        JLabel voterIdLabel = new JLabel("voterId:");
        voterIdLabel.setBounds(30, 270, 100, 25);
        frame.add(voterIdLabel);

        JTextField voteridField = new JTextField();
        voteridField.setBounds(140, 270, 200, 25);
        frame.add(voteridField);

        JLabel issueDatelabel = new JLabel("Issue date:");
        issueDatelabel.setBounds(30, 310, 100, 25);
        frame.add(issueDatelabel);

        JTextField issueDateField = new JTextField();
        issueDateField.setBounds(140, 310, 200, 25);
        frame.add(issueDateField);

        JLabel constituencyLabel = new JLabel("Constituency:");
        constituencyLabel.setBounds(30, 350, 100, 25);
        frame.add(constituencyLabel);

        JTextField constituencyField = new JTextField();
        constituencyField.setBounds(140, 350, 200, 25);
        frame.add(constituencyField);

        JLabel linkedPersonLabel = new JLabel("linked person:");
        linkedPersonLabel.setBounds(30, 390, 100, 25);
        frame.add(linkedPersonLabel);

        JTextField linkedPersonField = new JTextField();
        linkedPersonField.setBounds(140, 390, 200, 25);
        frame.add(linkedPersonField);

        voteridField.setEnabled(false);
        issueDateField.setEnabled(false);
        constituencyField.setEnabled(false);
        linkedPersonField.setEnabled(false);

        voterCard.addActionListener(e->{
            boolean isSelected = voterCard.isSelected();
            voteridField.setEnabled(isSelected);
            issueDateField.setEnabled(isSelected);
            constituencyField.setEnabled(isSelected);
            linkedPersonField.setEnabled(isSelected);
        });
        while (voterCard.isSelected()){
        boolean isSelected = voterCard.isSelected();
            voteridField.setEnabled(isSelected);
            issueDateField.setEnabled(true);
            constituencyField.setEnabled(true);
            linkedPersonField.setEnabled(true);

        }
//        if(isSelected){
//        }

        JButton submit = new JButton("Add Person");
        submit.setBounds(140, 450, 120, 30);
        frame.add(submit);


        submit.addActionListener((ActionEvent e) -> {
            try {
                Conn c = new Conn();
                String query = "INSERT INTO person (house_id, first_name, last_name, dob, gender, occupation) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = c.conn.prepareStatement(query);
                pst.setInt(1, houseId);
                pst.setString(2, firstNameField.getText());
                pst.setString(3, lastNameField.getText());
                pst.setString(4, dobField.getText());
                pst.setString(5, genderBox.getSelectedItem().toString());
                pst.setString(6, occupationField.getText());
//                pst.setInt(7,houseId);
                pst.executeUpdate();
                pst.close();

                JOptionPane.showMessageDialog(frame, "Person Added Successfully");

                tableModel.addRow(new Object[]{
                        firstNameField.getText(), lastNameField.getText(),
                        dobField.getText(), genderBox.getSelectedItem(), occupationField.getText()
                });

                frame.dispose();
                parentFrame.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
