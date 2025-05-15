package com.zeta.testing.bean;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeEmailTest {

    private EmployeeEmail employeeEmail01;
    private EmployeeEmail employeeEmail02;

    @BeforeAll public static void setUpBeforeClass() throws Exception {
        System.out.println("Before Class");
    }

    @AfterAll public static void tearDownAfterClass() throws Exception {
        System.out.println("After Class");
    }

    @BeforeEach public void setUp() {
        System.out.println("Before Each");
        employeeEmail01 = new EmployeeEmail();
        employeeEmail02 = new EmployeeEmail();
    }

    @AfterEach public void tearDown() {
        System.out.println("After Each");
        employeeEmail01 = null;
        employeeEmail02 = null;
    }

    @Test public void testValidEmployeeEmailId() {
        EmployeeEmail employeeEmail = new EmployeeEmail();
        boolean result = employeeEmail.isValidEmailId("mail2dilz@gmail.com");
        assertTrue(result, "Invalid email id");
    }

    @Test public void testInvalidEmployeeEmailId() {
        EmployeeEmail employeeEmail = new EmployeeEmail();
        boolean result = employeeEmail.isValidEmailId("mail2dilz");
        assertFalse(result, "Valid email id");
    }

    @Test public void testAddEmailId() {
        employeeEmail01.addEmployeeEmail("Zeta001", "dilip.malani@zeta.com");
        employeeEmail01.addEmployeeEmail("Zeta002", "kiran.bekalkar@zeta.com");
        employeeEmail01.addEmployeeEmail("Zeta003", "bharath.kumar@zeta.com");
        int size = employeeEmail01.getEmailMap().size();
        assertEquals(3, size, "Employee Email Add Failed!");
    }

    @Test public void testAddEmployeeEmailIdWithDuplicateKey() throws Exception {
        employeeEmail01.addEmployeeEmail("Zeta001", "dilip.malani@zeta.com");
        employeeEmail01.addEmployeeEmail("Zeta002", "kiran.bekalkar@zeta.com");
        employeeEmail01.addEmployeeEmail("Zeta001", "bharath.kumar@zeta.com");
        int size = employeeEmail01.getEmailMap().size();
        assertNotEquals(3, size, "Duplicate Key Employee Email Add Failed!");
    }

    @Test public void testGetExistingEmployeeEmailId() throws Exception {
        employeeEmail01.addEmployeeEmail("Zeta001", "dilip.malani@zeta.com");
        employeeEmail01.addEmployeeEmail("Zeta002", "kiran.bekalkar@zeta.com");
        employeeEmail01.addEmployeeEmail("Zeta003", "bharath.kumar@zeta.com");
        String value = employeeEmail01.getEmployeeEmailId("Zeta001");
        assertNotNull(value, "Employee Email Id Is Null!");
    }

    @Test public void testGetNonExistingEmployeeEmailId() throws Exception {
        employeeEmail01.addEmployeeEmail("Zeta001", "dilip.malani@zeta.com");
        employeeEmail01.addEmployeeEmail("Zeta002", "kiran.bekalkar@zeta.com");
        employeeEmail01.addEmployeeEmail("Zeta003", "bharath.kumar@zeta.com");
        String value = employeeEmail01.getEmployeeEmailId("Zeta005");
        assertNull(value, "Employee Email Id Is Not Null!");
    }

    @Test public void testIfObjectsAreSame() throws Exception {
        employeeEmail01.addEmployeeEmail("Zeta001", "dilip.malani@zeta.com");
        employeeEmail02.addEmployeeEmail("Zeta002", "kiran.bekalkar@zeta.com");
        assertSame(employeeEmail01.getEmailMap(), employeeEmail01.getEmailMap(), "Employee Emails Are Not Same!");
    }

    @Test public void testIfObjectsAreDifferent() throws Exception {
        employeeEmail01.addEmployeeEmail("Zeta001", "dilip.malani@zeta.com");
        employeeEmail02.addEmployeeEmail("Zeta002", "kiran.bekalkar@zeta.com");
        assertNotSame(employeeEmail01.getEmailMap(), employeeEmail02.getEmailMap(), "Employee Emails Are Same!");
    }

    @Test public void testForIllegalArgumentException() {
        employeeEmail01.addEmployeeEmail("Zeta001", "dilip.malani@zeta.com");
        assertThrows(IllegalArgumentException.class, () -> employeeEmail01.getEmployeeEmailId(1));
    }

}