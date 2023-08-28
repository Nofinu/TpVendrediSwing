package org.example.layout;

import lombok.Data;
import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

@Data
public class ButtonPanel {
    private JPanel buttonPanel;
    private FormPanel formPanel;
    private EmployeeDao employeeDao;
    private TablePanel tablePanel;

    private JButton newButton;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JButton printButton;

    public ButtonPanel(FormPanel formPanel) {
        this.formPanel = formPanel;
        employeeDao = new EmployeeDao();
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(new LineBorder(Color.black));
        buttonPanel.setPreferredSize(new Dimension(200, 50));
        buttonPanel.setMaximumSize(new Dimension(500, 50));

        JLabel searchLabel = new JLabel("Search :");
        buttonPanel.add(searchLabel);

        JTextField searchTeaxtField = new JTextField(15);
        buttonPanel.add(searchLabel);

        newButton = new JButton("New");
        addButton = new JButton("Save");
        addButton.setEnabled(false);
        updateButton = new JButton("Update");
        updateButton.setEnabled(false);
        deleteButton = new JButton("Delete");
        deleteButton.setEnabled(false);
        clearButton = new JButton("Clear");
        printButton = new JButton("Print");

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newButton.setEnabled(false);
                addButton.setEnabled(true);
                updateButton.setEnabled(false);
                deleteButton.setEnabled(false);
                clearButton.setEnabled(true);
                formPanel.setIdTextFieldStatus(false);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gender;
                if(formPanel.getMaleRadioButton().isSelected()){
                    gender = "MALE";
                }else{
                    gender = "FEMALE";
                }
                Employee employee = new Employee(
                formPanel.getNameTextField().getText(),
                gender,
                Integer.parseInt(formPanel.getAgeTextField().getText()) ,
                formPanel.getBloodGroupTextField().getText(),
                formPanel.getContactNoTextField().getText(),
                formPanel.getQualificationComboBox().getSelectedItem().toString(),
                formPanel.getChooser().getDate(),
                formPanel.getAddressTextArea().getText(),
                formPanel.getImagePathTextField().getText());

                employeeDao.add(employee);
                clear();
                tablePanel.tableRefresh();
                JOptionPane.showMessageDialog(buttonPanel,"Employee Add");
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gender;
                if(formPanel.getMaleRadioButton().isSelected()){
                    gender = "MALE";
                }else{
                    gender = "FEMALE";
                }
                Employee employee = new Employee(
                        Integer.parseInt(formPanel.getIdTextField().getText()),
                        formPanel.getNameTextField().getText(),
                        gender,
                        Integer.parseInt(formPanel.getAgeTextField().getText()) ,
                        formPanel.getBloodGroupTextField().getText(),
                        formPanel.getContactNoTextField().getText(),
                        formPanel.getQualificationComboBox().getSelectedItem().toString(),
                        formPanel.getChooser().getDate(),
                        formPanel.getAddressTextArea().getText(),
                        formPanel.getImagePathTextField().getText());

                employeeDao.update(employee);
                clear();
                tablePanel.tableRefresh();
                JOptionPane.showMessageDialog(buttonPanel,"Employee Update");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablePanel.getTable().getSelectedRow();
                int id = (Integer) tablePanel.getTable().getValueAt(selectedRow,0);
                int input = JOptionPane.showConfirmDialog(buttonPanel,"Delete Employee");
                System.out.println(input);
                if(input == 0){
                    employeeDao.delete(id);
                    tablePanel.tableRefresh();
                    JOptionPane.showMessageDialog(buttonPanel,"Employee Delete");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tablePanel.getTable().print();
                } catch (PrinterException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        buttonPanel.add(newButton);
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(printButton);
    }

    private void clear() {
        formPanel.getIdTextField().setText("");
        formPanel.getNameTextField().setText("");
        formPanel.getAgeTextField().setText("");
        formPanel.getBloodGroupTextField().setText("");
        formPanel.getContactNoTextField().setText("");
        formPanel.getImagePathTextField().setText("");
        formPanel.getChooser().setDate(null);
        formPanel.getAddressTextArea().setText("");
        formPanel.getQualificationComboBox().setSelectedIndex(0);
        formPanel.setIdTextFieldStatus(false);
    }
}
