
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import pt.tecnico.sise.se.insure.domain.Employee;
import pt.tecnico.sise.se.insure.domain.InsuranceCompany;
import pt.tecnico.sise.se.insure.domain.Role;
import pt.tecnico.sise.se.insure.domain.exception.EmployeeIdAlreadyInUseException;
import pt.tecnico.sise.se.insure.domain.exception.IllegalEmployeeIdException;
import pt.tecnico.sise.se.insure.domain.exception.IllegalEmployeeRoleException;
import pt.tecnico.sise.se.insure.domain.exception.IllegalNameException;
import pt.tecnico.sise.se.insure.domain.exception.IllegalInsuranceCompanyNameException;

public class TestEmployee {
	
	private InsuranceCompany VALID_INSURANCE_COMPANY; 

	private static final String VALID_INSURANCE_COMPANY_NAME = "Sebulba Insurances";
	private static final String VALID_JUNIOR_NAME = "Anakin Skywalker";
	private static final String VALID_SENIOR_NAME = "Obi-wan Kenobi";
	private static final String VALID_ADJUSTER_NAME = "Master Yoda";

	private static final String VALID_JUNIOR_EMPLOYEE_ID = "E001";
	private static final String VALID_SENIOR_EMPLOYEE_ID = "E002";
	private static final String VALID_ADJUSTER_EMPLOYEE_ID = "E003";
	
	private static final String INVALID_EMPLOYEE_ID = "A123123";
	private static final String INVALID_NAME = "R2D2";

	
	@Before
	public void cleanup() {
		VALID_INSURANCE_COMPANY = new InsuranceCompany(VALID_INSURANCE_COMPANY_NAME);
	}
	
	@Test
	public void testEmployeesCreationSuccess() {
		Employee junior = new Employee(VALID_INSURANCE_COMPANY, VALID_JUNIOR_EMPLOYEE_ID, VALID_JUNIOR_NAME, Role.JUNIOR);
		Employee senior = new Employee(VALID_INSURANCE_COMPANY, VALID_SENIOR_EMPLOYEE_ID, VALID_SENIOR_NAME, Role.SENIOR);
		Employee adjuster = new Employee(VALID_INSURANCE_COMPANY, VALID_ADJUSTER_EMPLOYEE_ID, VALID_ADJUSTER_NAME, Role.ADJUSTER);
		assertEquals(VALID_INSURANCE_COMPANY, junior.getInsuranceCompany());
		assertEquals(VALID_JUNIOR_EMPLOYEE_ID, junior.getId());
		assertEquals(VALID_SENIOR_EMPLOYEE_ID, senior.getId());
		assertEquals(VALID_ADJUSTER_EMPLOYEE_ID, adjuster.getId());
		assertEquals(VALID_JUNIOR_NAME, junior.getName());
		assertEquals(VALID_SENIOR_NAME, senior.getName());
		assertEquals(VALID_ADJUSTER_NAME, adjuster.getName());
	}

	@Test(expected=IllegalNameException.class)
	public void testEmployeeCreationInvalidName() {
		new Employee(VALID_INSURANCE_COMPANY, VALID_JUNIOR_EMPLOYEE_ID, INVALID_NAME, Role.JUNIOR);
		fail("This line should never be reached.");
	}
	

	@Test(expected=IllegalEmployeeIdException.class)
	public void testEmployeeCreationNullEmployeeId() {
		new Employee(VALID_INSURANCE_COMPANY, null, VALID_JUNIOR_NAME, Role.JUNIOR);
		fail("This line should never be reached.");
	}

	@Test(expected=IllegalEmployeeIdException.class)
	public void testEmployeeCreationInvalidEmployeeId() {
		new Employee(VALID_INSURANCE_COMPANY, INVALID_EMPLOYEE_ID, VALID_JUNIOR_NAME, Role.JUNIOR);
		fail("This line should never be reached.");
	}

	@Test(expected=IllegalNameException.class)
	public void testEmployeeCreationNullName() {
		new Employee(VALID_INSURANCE_COMPANY, VALID_JUNIOR_EMPLOYEE_ID, null, Role.JUNIOR);
		fail("This line should never be reached.");
	}
	
	@Test(expected=IllegalEmployeeRoleException.class)
	public void testEmployeeCreationNullRole() {
		new Employee(VALID_INSURANCE_COMPANY, VALID_JUNIOR_EMPLOYEE_ID, VALID_JUNIOR_NAME, null);
		fail("This line should never be reached.");
	}
	
	@Test(expected=EmployeeIdAlreadyInUseException.class)
	public void testEmployeeIdAlreadyInUse() {
		Employee junior = new Employee(VALID_INSURANCE_COMPANY, VALID_JUNIOR_EMPLOYEE_ID, VALID_JUNIOR_NAME, Role.JUNIOR);
		assertEquals(VALID_INSURANCE_COMPANY, junior.getInsuranceCompany());
		assertEquals(VALID_JUNIOR_EMPLOYEE_ID, junior.getId());
		assertEquals(VALID_JUNIOR_NAME, junior.getName());
		String SAME_EMPLOYEE_ID = VALID_JUNIOR_EMPLOYEE_ID;
		new Employee(VALID_INSURANCE_COMPANY, SAME_EMPLOYEE_ID, VALID_JUNIOR_NAME, Role.JUNIOR);
		fail("This line should never be reached.");
	}

	@Test(expected=IllegalInsuranceCompanyNameException.class)
	public void testMissingInsuranceCompany() {
		new Employee(null, VALID_JUNIOR_EMPLOYEE_ID, VALID_JUNIOR_NAME, Role.JUNIOR);
		fail("This line should never be reached.");
	}

}
