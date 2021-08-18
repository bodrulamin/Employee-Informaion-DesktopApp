/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeinformation.service;

import employeeinformation.Employee;


public interface DaoInterface {
    boolean store(Employee e);

    public void update(Employee e);
    void delete (int id);
   
    
}
