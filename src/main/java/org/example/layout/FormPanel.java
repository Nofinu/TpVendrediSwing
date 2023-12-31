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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileSystemView;

@Data
public class FormPanel {
    private JPanel formPanel;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField ageTextField;
    private JTextField bloodGroupTextField;
    private JTextField contactNoTextField;
    private JTextField imagePathTextField;

    private JDateChooser chooser;
    private JTextArea addressTextArea;
    private JComboBox<String> qualificationComboBox;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ImageIcon imageIcon;
    private JLabel imageLabel;

    private    String[] qualificationList = {"DOCT","DESS","MAST","LICE","BTS","DEUG","DUT","BAC"};

    public FormPanel() {
        formPanel = new JPanel(new BorderLayout());
        formPanel.setPreferredSize(new Dimension(800,250));
        formPanel.setBackground(Color.white);
        formPanel.setBorder(new LineBorder(Color.black));

        Container c = new Container();

        JLabel idLabel = new JLabel("Id : ");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        idLabel.setSize(100, 20);
        idLabel.setLocation(50, 25);
        c.add(idLabel);

        idTextField = new JTextField();
        idTextField.setEnabled(false);
        idTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        idTextField.setSize(150, 20);
        idTextField.setLocation(150, 25);
        c.add(idTextField);

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

        JLabel AddressLabel = new JLabel("Address : ");
        AddressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        AddressLabel.setSize(100, 20);
        AddressLabel.setLocation(375, 25);
        c.add(AddressLabel);

        addressTextArea = new JTextArea();
        addressTextArea.setBackground(Color.white);
        addressTextArea.setBorder(new LineBorder(Color.gray));
        addressTextArea.setFont(new Font("Arial", Font.PLAIN, 15));
        addressTextArea.setSize(200, 125);
        addressTextArea.setLocation(460, 25);
        c.add(addressTextArea);

        JLabel imagePathLabel = new JLabel("ImagePath : ");
        imagePathLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        imagePathLabel.setSize(100, 20);
        imagePathLabel.setLocation(375, 200);
        c.add(imagePathLabel);

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

        imageLabel = new JLabel( imageIcon);
        imageLabel.setBackground(Color.GRAY);
        imageLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        imageLabel.setSize(200, 250);
        imageLabel.setLocation(700,50);
        c.add(imageLabel);

        imagePathTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateImage();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateImage();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateImage();
            }
        });

        imagePathTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(imagePathTextField.getText());
                imageIcon = new ImageIcon(imagePathTextField.getText());
                Image image = imageIcon.getImage();
                Image newImg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(newImg);


                imageLabel.setIcon(imageIcon);

            }
        });

        formPanel.add(c,BorderLayout.CENTER);
    }
    private void updateImage (){
        imageIcon = new ImageIcon(imagePathTextField.getText());
        Image image = imageIcon.getImage();
        Image newImg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImg);
        imageLabel.setIcon(imageIcon);
    }

    public void setIdTextFieldStatus (boolean status){
        idTextField.setEnabled(status);
    }
}
