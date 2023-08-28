package org.example.layout;

import lombok.Data;
import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

@Data
public class TablePanel {
    private JPanel tablePanel;
    private EmployeeDao employeeDao;
    private FormPanel formPanel;
    private ButtonPanel buttonPanel;
    private JTable table;
    private List<String> listQualification;
    private static String[] columnNames = {"EmployeeId","Name","Gender","Age","BloodGroup","ContactNo","Qualification","DOJ","Address","EmplImage"};
    private DefaultTableModel dtm = new DefaultTableModel(null, columnNames) {
        @Override
        public Class<?> getColumnClass(int col) {
            return getValueAt(0, col).getClass();
        }
    };


    public TablePanel(FormPanel formPanel,ButtonPanel buttonPanel) {
        employeeDao = new EmployeeDao();
        this.formPanel = formPanel;
        this.buttonPanel = buttonPanel;
        listQualification = Arrays.stream(formPanel.getQualificationList()).toList();
        tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(new LineBorder(Color.black));
        tablePanel.setPreferredSize(new Dimension(300, 300));
        table = new JTable(dtm);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRow = table.getSelectedRow();
                int id = (Integer) table.getValueAt(selectedRow,0) ;
                Employee employeeFind = employeeDao.findById(id);
                if(employeeFind != null){
                    buttonPanel.getNewButton().setEnabled(true);
                    buttonPanel.getAddButton().setEnabled(false);
                    buttonPanel.getUpdateButton().setEnabled(true);
                    buttonPanel.getDeleteButton().setEnabled(true);
                    buttonPanel.getClearButton().setEnabled(true);
                    buttonPanel.getPrintButton().setEnabled(true);

                    formPanel.getIdTextField().setText(employeeFind.getId().toString());
                    formPanel.getNameTextField().setText(employeeFind.getName());
                    formPanel.getAgeTextField().setText(employeeFind.getAge().toString());
                    formPanel.getBloodGroupTextField().setText(employeeFind.getBloodGroup());
                    formPanel.getContactNoTextField().setText(employeeFind.getContactNo());
                    formPanel.getImagePathTextField().setText(employeeFind.getEmployeeImage());
                    formPanel.getChooser().setDate(employeeFind.getDoj());
                    formPanel.getAdressTextArea().setText(employeeFind.getAddress());
                    int indexQualification = listQualification.indexOf(employeeFind.getQualification());
                    formPanel.getQualificationComboBox().setSelectedIndex(indexQualification);
                    if(employeeFind.getGender().equals("MALE")){
                        formPanel.getMaleRadioButton().setSelected(true);
                    }
                    else{
                        formPanel.getFemaleRadioButton().setSelected(true);
                    }
                }
                else{
                    buttonPanel.getNewButton().setEnabled(true);
                    buttonPanel.getAddButton().setEnabled(false);
                    buttonPanel.getUpdateButton().setEnabled(false);
                    buttonPanel.getDeleteButton().setEnabled(false);
                    buttonPanel.getClearButton().setEnabled(true);
                    buttonPanel.getPrintButton().setEnabled(true);
                }
            }
        });

        tablePanel.add(table);
        tableRefresh();
    }
    public void tableRefresh (){
         List<Employee> listEmployee = employeeDao.findAll();
        dtm = new DefaultTableModel(null, columnNames) {
            @Override
            public Class<?> getColumnClass(int col) {
                return getValueAt(0, col).getClass();
            }
        };
        dtm.addRow(new Object[]{"EmployeeId","Name","Gender","Age","BloodGroup","ContactNo","Qualification","DOJ","Address","EmplImage"});

        listEmployee.forEach(e->{
             dtm.addRow(new Object[]{
                     e.getId(),
                     e.getName(),
                     e.getGender(),
                     e.getAge(),
                     e.getBloodGroup(),
                     e.getContactNo(),
                     e.getQualification(),
                     e.getDoj(),
                     e.getAddress(),
                     e.getEmployeeImage()
             });
         });
        table.setModel(dtm);
    }
}
