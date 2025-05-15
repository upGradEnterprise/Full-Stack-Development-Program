package com.zeta.testing.bean;

import org.junit.jupiter.api.*;

public class EmployeeEmailAnnotationTest {

    private EmployeeEmail employeeEmail;
    private static int testCount;

    @BeforeAll public static void setUpBeforeClass() throws Exception {
        System.out.println("JUnit Call:" + ++testCount + " :: @BeforeAll setUpBeforeClass");
    }

    @BeforeEach public void setUpBeforeEach() throws Exception {
        System.out.println("JUnit Call:" + ++testCount + " :: @BeforeEach setUpBeforeEach");
        employeeEmail = new EmployeeEmail();
        employeeEmail.addEmployeeEmail("Zeta001", "mail2dilz@gmail.com");
        employeeEmail.addEmployeeEmail("Zeta002", "kiran.rb@gmail.com");
    }

    @AfterEach public void tearDownAfterEach() throws Exception {
        System.out.println("JUnit Call:" + ++testCount + " :: @AfterEach tearDownAfterEach");
        employeeEmail.getEmailMap().clear();
        employeeEmail = null;
    }

    @AfterAll public static void tearDownAfterClass() throws Exception {
        System.out.println("JUnit Call:" + ++testCount + " :: @AfterAll tearDownAfterClass");
        testCount = 0;
    }

    @Test public void testAddEmployeeEmail() {
        System.out.println("JUnit Call:" + ++testCount + " :: @Test addEmployeeEmail");
        EmployeeEmail employeeEmail03 = new EmployeeEmail();
        employeeEmail03.addEmployeeEmail("Zeta003", "rahul.khanna@zeta.com");
    }

    @Test @Disabled public void testIgnore() {
        System.out.println("JUnit Call:" + ++testCount + " :: @Test ignore");
        /*
            Under Construction
         */
    }

    @Test public void testIllegalArgumentException() {
        System.out.println("JUnit Call:" + ++testCount + " :: @Test IllegalArgumentException");
        String value = employeeEmail.getEmailMap().get(1);
    }

}
