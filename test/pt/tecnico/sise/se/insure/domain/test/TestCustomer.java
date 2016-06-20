package pt.tecnico.sise.se.insure.domain.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import pt.tecnico.sise.se.insure.domain.Customer;
import pt.tecnico.sise.se.insure.domain.InsuranceCompany;
import pt.tecnico.sise.se.insure.domain.Policy;
import pt.tecnico.sise.se.insure.domain.exception.IllegalNIFException;
import pt.tecnico.sise.se.insure.domain.exception.IllegalNameException;
import pt.tecnico.sise.se.insure.domain.exception.IllegalPolicyException;
import pt.tecnico.sise.se.insure.domain.exception.MissingInsuranceCompanyException;
import pt.tecnico.sise.se.insure.domain.exception.NIFAlreadyInUseException;

public class TestCustomer {

	private InsuranceCompany VALID_INSURANCE_COMPANY;
	
	private static final String VALID_INSURANCE_COMPANY_NAME = "Sebulba Insurances";

	private static final String VALID_NIF = "123456789";
	private static final String VALID_NAME = "Luke Skywalker";
	
	private static final String INVALID_NIF = "312";
	private static final String INVALID_NON_NUMERIC_NIF = "HELLOWORLD";
	private static final String INVALID_NAME = "Chewbacca";
	
	private static final Policy VALID_POLICY = new Policy(LocalDate.now(), LocalDate.now().plusYears(2), new BigDecimal(100000));
	
	@Before
	public void setup() {
		VALID_INSURANCE_COMPANY = new InsuranceCompany(VALID_INSURANCE_COMPANY_NAME);
	}
	
	@Test
	public void testCustomerCreationSuccess() {
		Customer customer = new Customer(VALID_INSURANCE_COMPANY, VALID_NIF, VALID_NAME, VALID_POLICY);
		assertEquals(VALID_NIF, customer.getNIF());
		assertEquals(VALID_NAME, customer.getName());
		assertEquals(VALID_POLICY, customer.getPolicy());
	}
	
	@Test(expected=MissingInsuranceCompanyException.class)
	public void testMissingInsuranceCompany() {
		new Customer(null, VALID_NIF, VALID_NAME, VALID_POLICY);
		fail("This line should not be reached.");
	}

	@Test(expected=IllegalNIFException.class)
	public void testCustomerCreationFailWithNullNIF() {
		new Customer(VALID_INSURANCE_COMPANY, null, VALID_NAME, VALID_POLICY);
		fail("This line should never be reached");
	}

	@Test(expected=IllegalNIFException.class)
	public void testCustomerCreationFailWithInvalidNIF() {
		new Customer(VALID_INSURANCE_COMPANY, INVALID_NIF, VALID_NAME, VALID_POLICY);
		fail("This line should never be reached");
	}

	@Test(expected=IllegalNIFException.class)
	public void testCustomerCreationFailWithNonNumericNIF() {
		new Customer(VALID_INSURANCE_COMPANY, INVALID_NON_NUMERIC_NIF, VALID_NAME, VALID_POLICY);
		fail("This line should never be reached");
	}

	@Test(expected=IllegalNameException.class)
	public void testCustomerCreationNullName() {
		new Customer(VALID_INSURANCE_COMPANY, VALID_NIF, null, VALID_POLICY);
		fail("This line should never be reached");
	}
	
	@Test(expected=IllegalNameException.class)
	public void testCustomerCreationInvalidName() {
		new Customer(VALID_INSURANCE_COMPANY, VALID_NIF, INVALID_NAME, VALID_POLICY);
		fail("This line should never be reached");
	}
	
	@Test(expected=NIFAlreadyInUseException.class)
	public void testCustomerNIFAlreadyInUse() {
		Customer customer = new Customer(VALID_INSURANCE_COMPANY, VALID_NIF, VALID_NAME, VALID_POLICY);
		assertEquals(VALID_NIF, customer.getNIF());
		assertEquals(VALID_NAME, customer.getName());
		assertEquals(VALID_POLICY, customer.getPolicy());
		new Customer(VALID_INSURANCE_COMPANY, VALID_NIF, VALID_NAME, VALID_POLICY);
		fail("This line should never be reached.");
	}
	
	@Test(expected=IllegalPolicyException.class)
	public void testIllegalPolicyException() {
		new Customer(VALID_INSURANCE_COMPANY, VALID_NIF, VALID_NAME, null);
		fail("This line should never be reached.");
	}
}
