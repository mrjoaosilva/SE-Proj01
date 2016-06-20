package pt.tecnico.sise.se.insure.domain;

import pt.tecnico.sise.se.insure.domain.exception.EmployeeIdAlreadyInUseException;
import pt.tecnico.sise.se.insure.domain.exception.IllegalEmployeeIdException;
import pt.tecnico.sise.se.insure.domain.exception.IllegalEmployeeRoleException;
import pt.tecnico.sise.se.insure.domain.exception.IllegalInsuranceCompanyNameException;
import pt.tecnico.sise.se.insure.domain.exception.IllegalNameException;

public class Employee {
	private String name;
	private String id;
	private Role role;
	private InsuranceCompany insuranceCompany;

	public Employee(InsuranceCompany insuranceCompany, String employeeId, String employeeName, Role employeeRole) {

		if (insuranceCompany == null)
			throw new IllegalInsuranceCompanyNameException("Error: illegal employee name");
		this.insuranceCompany = insuranceCompany;

		if (employeeId == null || !employeeId.startsWith("E"))
			throw new IllegalEmployeeIdException("Error: illegal id");
		this.id = employeeId;
		if (employeeName == null || !employeeName.trim().contains(" "))
			throw new IllegalNameException("Error: illegal name");

		if (insuranceCompany.getEmployeeMap().containsKey(employeeId))
			throw new EmployeeIdAlreadyInUseException("Error: Id already in use");
		this.name = employeeName;

		if (employeeRole == null)
			throw new IllegalEmployeeRoleException("Error: invalid role");
		this.role = employeeRole;

		insuranceCompany.addEmployee(this);
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public Role getEmployeeRole() {
		return role;
	}

	public InsuranceCompany getInsuranceCompany() {
		return insuranceCompany;
	}
}
