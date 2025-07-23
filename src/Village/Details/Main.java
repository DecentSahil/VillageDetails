package Village.Details;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
       JFrame frame = new JFrame();
       frame.setSize(1500,750);
       frame.setLayout(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JLabel heading = new JLabel("Enter personal Details");
       heading.setBounds(200,20,350,50);
       frame.add(heading);
       heading.setFont(new Font("Arial",Font.BOLD,30));

       JLabel name = new JLabel("Name : ");
       name.setBounds(200,100,100,25);
       frame.add(name);
       JTextField nameTF = new JTextField();
       nameTF.setBounds(320,100,180,25);
       frame.add(nameTF);
       JLabel nameError = new JLabel();
       nameError.setBounds(320,125,180,25);
       nameError.setForeground(Color.red);
       frame.add(nameError);

        JLabel age = new JLabel("Age : ");
        age.setBounds(200,150,100,25);
        frame.add(age);
        JTextField ageTF = new JTextField();
        ageTF.setBounds(320,150,180,25);
        frame.add(ageTF);
        JLabel ageError = new JLabel();
        ageError.setBounds(320,175,200,20);
        ageError.setForeground(Color.red);
        frame.add(ageError);

        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(200,200,100,25);
        frame.add(gender);
        String[] genders = {"Select Gender","Male","Female","TransGender","LGBTQ","others"};
        JComboBox<String> genderCB = new JComboBox<>(genders);
        genderCB.setBounds(320,200,180,25);
        frame.add(genderCB);
        JLabel genderError = new JLabel();
        genderError.setBounds(320, 225, 200, 25);
        genderError.setForeground(Color.red);
        frame.add(genderError);

        JLabel education = new JLabel("Education Level:");
        education.setBounds(200, 250, 100, 25);
        frame.add(education);
        String[] educationLevels = {"Select Education", "High School", "Bachelor's", "Master's", "PhD"};
        JComboBox<String> educationCB = new JComboBox<>(educationLevels);
        educationCB.setBounds(320, 250, 180, 25);
        frame.add(educationCB);
        JLabel educationError = new JLabel();
        educationError.setBounds(320, 275, 200, 25);
        educationError.setForeground(Color.red);
        frame.add(educationError);


        // Marital Status
        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(200, 300, 100, 25);
        frame.add(marital);
        String[] maritalStatuses = {"Select Status", "Single", "Married", "Divorced", "Widowed"};
        JComboBox<String> maritalCB = new JComboBox<>(maritalStatuses);
        maritalCB.setBounds(320, 300, 180, 25);
        frame.add(maritalCB);
        JLabel maritalError = new JLabel();
        maritalError.setBounds(320, 325, 200, 25);
        maritalError.setForeground(Color.red);
        frame.add(maritalError);

        // Religion
        JLabel religion = new JLabel("Religion:");
        religion.setBounds(200, 350, 100, 25);
        frame.add(religion);
        String[] religions = {"Select Religion", "Hindu", "Muslim", "Christian", "Sikh", "Other"};
        JComboBox<String> religionCB = new JComboBox<>(religions);
        religionCB.setBounds(320, 350, 180, 25);
        frame.add(religionCB);
        JLabel religionError = new JLabel();
        religionError.setBounds(320, 375, 200, 25);
        religionError.setForeground(Color.red);
        frame.add(religionError);


        JButton submit = new JButton("Submit");
        submit.setBounds(280,450,100,25);
        frame.add(submit);


        submit.addActionListener(e ->{
            String userAge = ageTF.getText();
            String userName = nameTF.getText();
            String userGender = (String) genderCB.getSelectedItem();
            String userEducation = (String) educationCB.getSelectedItem();
            String userMaritalstatus = (String) maritalCB.getSelectedItem();
            String userReligion = (String) religionCB.getSelectedItem();
            Boolean valid = true;

            if (!userName.isEmpty()){
                nameError.setText("");
            }else{
                nameError.setText("Enter your name");
                valid = false;
            }
            if (userAge.isEmpty()) {
                ageError.setText("Please input age");
                valid = false;
            } else if(userAge.matches("^[0-9]+$")){
                ageError.setText("");
            }else{
                ageError.setText("Invalid input");
                valid = false;
            }
            if (!userGender.equals("Select Gender")) {
                genderError.setText("");
            } else {
                genderError.setText("Please select a gender");
                valid = false;
            }

            // Education validation
            if (!userEducation.equals("Select Education")) {
                educationError.setText("");
            } else {
                educationError.setText("Please select education level");
                valid = false;
            }

            // Marital status validation
            if (!userMaritalstatus.equals("Select Status")) {
                maritalError.setText("");
            } else {
                maritalError.setText("Please select marital status");
                valid = false;
            }

            // Religion validation
            if (!userReligion.equals("Select Religion")) {
                religionError.setText("");
            } else {
                religionError.setText("Please select religion");
                valid = false;
            }

        });








        frame.setVisible(true);


    }
}