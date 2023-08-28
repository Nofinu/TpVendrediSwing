package org.example.layout;

import com.toedter.calendar.JDateChooser;
import lombok.Data;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Locale;
import javax.swing.filechooser.FileSystemView;

@Data
public class FormPanel {
    private JPanel formPanel;
    private JTextField IdTextField;
    private JTextField nameTextField;
    private JTextField ageTextField;
    private JTextField bloodGroupTextField;
    private JTextField contactNoTextField;
    private JTextField imagePathTextField;

    private JDateChooser chooser;
    private JTextArea adressTextArea;
    private JComboBox<String> qualificationComboBox;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;

    private    String[] qualificationList = {"DOCT","DESS","MAST","LICE","BTS","DEUG","DUT","BAC"};

    public FormPanel() {
        formPanel = new JPanel(new BorderLayout());
        formPanel.setPreferredSize(new Dimension(500,250));
        formPanel.setBackground(Color.white);
        formPanel.setBorder(new LineBorder(Color.black));

        Container c = new Container();

        JLabel idLabel = new JLabel("Id : ");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        idLabel.setSize(100, 20);
        idLabel.setLocation(50, 25);
        c.add(idLabel);

        IdTextField = new JTextField();
        IdTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        IdTextField.setSize(150, 20);
        IdTextField.setLocation(150, 25);
        c.add(IdTextField);

        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Arial", Font.PLAIN, 16));
        name.setSize(100, 20);
        name.setLocation(50, 50);
        c.add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        nameTextField.setSize(150, 20);
        nameTextField.setLocation(150, 50);
        c.add(nameTextField);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        genderLabel.setSize(100, 20);
        genderLabel.setLocation(50, 75);
        c.add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBackground(Color.white);
        maleRadioButton.setFont(new Font("Arial", Font.PLAIN, 15));
        maleRadioButton.setSelected(true);
        maleRadioButton.setSize(75, 20);
        maleRadioButton.setLocation(150, 75);
        c.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBackground(Color.white);
        femaleRadioButton.setFont(new Font("Arial", Font.PLAIN, 15));
        femaleRadioButton.setSelected(false);
        femaleRadioButton.setSize(80, 20);
        femaleRadioButton.setLocation(225, 75);
        c.add(femaleRadioButton);

        ButtonGroup gengp = new ButtonGroup();
        gengp.add(maleRadioButton);
        gengp.add(femaleRadioButton);

        JLabel ageLabel = new JLabel("Age : ");
        ageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        ageLabel.setSize(100, 20);
        ageLabel.setLocation(50, 100);
        c.add(ageLabel);

        ageTextField = new JTextField();
        ageTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        ageTextField.setSize(150, 20);
        ageTextField.setLocation(150, 100);
        c.add(ageTextField);

        JLabel bloodGroupLabel = new JLabel("BloodGroup : ");
        bloodGroupLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        bloodGroupLabel.setSize(100, 20);
        bloodGroupLabel.setLocation(50, 125);
        c.add(bloodGroupLabel);

        bloodGroupTextField = new JTextField();
        bloodGroupTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        bloodGroupTextField.setSize(150, 20);
        bloodGroupTextField.setLocation(150, 125);
        c.add(bloodGroupTextField);

        JLabel contactNoLabel = new JLabel("ContactNo : ");
        contactNoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        contactNoLabel.setSize(100, 20);
        contactNoLabel.setLocation(100, 150);
        c.add(contactNoLabel);

        contactNoTextField = new JTextField();
        contactNoTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        contactNoTextField.setSize(150, 20);
        contactNoTextField.setLocation(200, 150);
        c.add(contactNoTextField);

        JLabel qualificationLabel = new JLabel("Qualification : ");
        qualificationLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        qualificationLabel.setSize(100, 20);
        qualificationLabel.setLocation(100, 175);
        c.add(qualificationLabel);


        qualificationComboBox= new JComboBox<>(qualificationList);
        qualificationComboBox.setBackground(Color.white);
        qualificationComboBox.setSize(150,20);
        qualificationComboBox.setLocation(200,175);
        c.add(qualificationComboBox);

        JLabel startDateLabel = new JLabel("StartDate : ");
        startDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        startDateLabel.setSize(100, 20);
        startDateLabel.setLocation(100, 200);
        c.add(startDateLabel);

        chooser = new JDateChooser();
        chooser.setLocation(200,200);
        chooser.setSize(150,20);
        chooser.setLocale(Locale.FRANCE);
        c.add(chooser);

        JLabel AdressLabel = new JLabel("Adress : ");
        AdressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        AdressLabel.setSize(100, 20);
        AdressLabel.setLocation(375, 25);
        c.add(AdressLabel);

        adressTextArea = new JTextArea();
        adressTextArea.setBackground(Color.white);
        adressTextArea.setBorder(new LineBorder(Color.gray));
        adressTextArea.setFont(new Font("Arial", Font.PLAIN, 15));
        adressTextArea.setSize(200, 125);
        adressTextArea.setLocation(460, 25);
        c.add(adressTextArea);

        JLabel imageLable = new JLabel("ImagePath : ");
        imageLable.setFont(new Font("Arial", Font.PLAIN, 16));
        imageLable.setSize(100, 20);
        imageLable.setLocation(375, 200);
        c.add(imageLable);

        imagePathTextField = new JTextField();
        imagePathTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        imagePathTextField.setSize(200, 25);
        imagePathTextField.setLocation(460, 200);
        c.add(imagePathTextField);

        JFileChooser fileChooser = new JFileChooser(
                FileSystemView
                        .getFileSystemView()
                        .getHomeDirectory());

        JButton addFileButton = new JButton("Upload Image");
        addFileButton.setBackground(Color.white);
        addFileButton.setSize(200,25);
        addFileButton.setLocation(460,170);
        addFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = fileChooser.showOpenDialog(null);
                if (res == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    imagePathTextField.setText(file.getAbsolutePath());
                }
            }
        });
        c.add(addFileButton);




        formPanel.add(c,BorderLayout.CENTER);
    }
}
