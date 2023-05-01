package edu.neu.csye7374.Creational_Factory;

import edu.neu.csye7374.Employee;
import edu.neu.csye7374.Creational_Builder.*;

public class EmployeeFactory extends AbstractFactory<Employee> {
	
	private static EmployeeFactory instance;  
	
	private  EmployeeFactory() {
		super();
		instance=null;
	}

	//Lazy Singleton factory
	public static synchronized EmployeeFactory getInstance() {
		if (instance == null) {
			instance = new EmployeeFactory();
		}
		return instance;
	}

	@Override
	public Employee getObject(BuilderAPI<Employee> builder) {
		// TODO Auto-generated method stub
		EmployeeBuilder employeeBuilder=(EmployeeBuilder)builder;
		return new Employee(employeeBuilder);
	}

}
