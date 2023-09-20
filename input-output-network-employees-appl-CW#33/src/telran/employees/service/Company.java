package telran.employees.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import telran.employees.dto.*;

public interface Company {
boolean addEmployee(Employee empl); //adds a given employee object, returns true if added otherwise false (if employee with the id exists)
Employee removeEmployee(long id); //returns reference to an employee being removed otherwise null (if employee doesn't exist)
Employee getEmployee(long id);//returns reference to an employee by the given id otherwise null (if employee doesn't exist)
List<Employee> getEmployees(); //returns list of all employee objects. In the case of none exists it returns empty list
default void restore(String dataFile) {
	//TODO
	//restoring all employees from a given file
	//if there is no file it just means that application doen't have any saved data, that is no exception should be thrown
	//all possible exceptions should be propagated as a RuntimeException
	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFile))) {
		@SuppressWarnings("unchecked")
        List<Employee> list = (List<Employee>) ois.readObject();
        list.forEach(employee -> addEmployee(employee));
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
default void save(String dataFile) {
	//TODO
	//saving all employee objects to a given file
	//Implementation hint: use getEmployees() method to get the list of all employee objects and to serialize whole list to the file
	//all possible exceptions should be propagated as a RuntimeException
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFile))) {
        oos.writeObject(getEmployees());
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
}
