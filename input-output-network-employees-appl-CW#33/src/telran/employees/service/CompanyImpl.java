package telran.employees.service;

import java.util.*;

import telran.employees.dto.Employee;

public class CompanyImpl implements Company {
	HashMap<Long, Employee> employees = new HashMap<>(); //most effective structure for the interface methods
	@Override
	public boolean addEmployee(Employee empl) {
		// TODO Auto-generated method stub
	    if (employees.containsKey(empl.id())) {
	        return false; 
	    }
	    employees.put(empl.id(), empl);
	    return true;
	}

	@Override
	public Employee removeEmployee(long id) {
		// TODO Auto-generated method stub
		return employees.remove(id);
	}

	@Override
	public Employee getEmployee(long id) {
		// TODO Auto-generated method stub
		return employees.get(id);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return new ArrayList<>(employees.values());
	}

}
