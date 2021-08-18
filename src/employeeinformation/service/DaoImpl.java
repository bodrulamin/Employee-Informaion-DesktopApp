/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeinformation.service;

import employeeinformation.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author b
 */
public class DaoImpl implements DaoInterface {

    static Connection conn = DBConnector.getConnection();
    public static Object lastMsg = "";

    @Override
    public boolean store(Employee e) {

        try {
            String sql = "insert into employees values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setString(3, e.getDesignation());
            ps.setInt(4, e.getSalary());
            ps.setString(5, e.getAddress());

            ps.execute();

            System.out.println("Inserted successfully");
            lastMsg = "Inserted successfully";
            return true;

        } catch (SQLIntegrityConstraintViolationException ee) {
            System.out.println(ee.getMessage());
            lastMsg = ee.getMessage();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        }
        return false;
    }

    @Override
    public void update(Employee e) {
        delete(e.getId());
        store(e);
        lastMsg = "Updated successfully";

    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from employees where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

            lastMsg = "deleted successfully";

        } catch (SQLIntegrityConstraintViolationException ee) {
            System.out.println(ee.getMessage());
            lastMsg = ee.getMessage();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lastMsg = ex.getMessage();
        }
    }

}
