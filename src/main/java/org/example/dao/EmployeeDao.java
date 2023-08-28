package org.example.dao;

import org.example.connexion.ConnectionUtil;
import org.example.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private Connection con;

    private PreparedStatement ps;

    private ResultSet resultSet;


    public boolean add(Employee employee) {
        con = ConnectionUtil.getConnection();
        try {
            ps = con.prepareStatement("INSERT INTO employee(`name`,`gender`,`age`,`blood_group`,`contact_no`,`qualification`,`doj`,`address`,`employee_image`) VALUES(?,?,?,?,?,?,?,?,?) ");
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getGender());
            ps.setInt(3, employee.getAge());
            ps.setString(4, employee.getBloodGroup());
            ps.setString(5, employee.getContactNo());
            ps.setString(6, employee.getQualification());
            ps.setDate(7, new Date(employee.getDoj().getTime()));
            ps.setString(8, employee.getAddress());
            ps.setString(9, employee.getEmployeeImage());
            int n = ps.executeUpdate();
            return n>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean update (Employee employee){
        con = ConnectionUtil.getConnection();
        try {
            ps = con.prepareStatement("UPDATE employee SET name=?,gender=?,age=?,blood_group=?,contact_no=?,qualification=?,doj=?,address=?,employee_image=? where id = ?");
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getGender());
            ps.setInt(3, employee.getAge());
            ps.setString(4, employee.getBloodGroup());
            ps.setString(5, employee.getContactNo());
            ps.setString(6, employee.getQualification());
            ps.setDate(7, new Date(employee.getDoj().getTime()));
            ps.setString(8, employee.getAddress());
            ps.setString(9, employee.getEmployeeImage());
            ps.setInt(10, employee.getId());
            int n = ps.executeUpdate();
            return n>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete (int id){
        con = ConnectionUtil.getConnection();
        try {
            ps = con.prepareStatement("DELETE FROM employee WHERE id = ? ");
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Employee findById(int id) {
        con = ConnectionUtil.getConnection();
        try {
            ps = con.prepareStatement("SELECT id,name,gender,age,blood_group,contact_no,qualification,doj,address,employee_image FROM employee where id = ? ");
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            if(resultSet.next()){
                return  new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        resultSet.getString("blood_group"),
                        resultSet.getString("contact_no"),
                        resultSet.getString("qualification"),
                        resultSet.getDate("doj"),
                        resultSet.getString("address"),
                        resultSet.getString("employee_image")
                );

            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Employee> findAll (){
        con = ConnectionUtil.getConnection();
        List<Employee> list = new ArrayList<>();
        try {
            ps = con.prepareStatement("SELECT id,name,gender,age,blood_group,contact_no,qualification,doj,address,employee_image FROM employee ");
            resultSet = ps.executeQuery();
            while(resultSet.next()){
                list.add(new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        resultSet.getString("blood_group"),
                        resultSet.getString("contact_no"),
                        resultSet.getString("qualification"),
                        resultSet.getDate("doj"),
                        resultSet.getString("address"),
                        resultSet.getString("employee_image")
                ));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
