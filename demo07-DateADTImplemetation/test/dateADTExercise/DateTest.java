package dateADTExercise;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author kitty
 */
 
/**
 * ANNOTATIONS:
 * @Test -  The annotation @Test identifies that a method is a test method. 
 * @Ignore - Will ignore the test method. This is useful when the underlying code has been changed and 
 * 		the test case has not yet been adapted. Or if the execution time of this test is too long to be included. 
 * @Test(expected=Exception.class) - Fails, if the method does not throw the named exception. 
 * @Test(timeout=100) - Fails, if the method takes longer than 100 milliseconds.
 * 
 * ASSERTS: [] = optional message to display
 * fail([String]) - Let the method fail. Might be used to check that a certain part of the code is not reached. 
 * 		Or to have failing test before the test code is implemented.
 * assertTrue(boolean) - Will always be true / false. Can be used to predefine a test result, 
 * 		if the test is not yet implemented.
 * assertTrue([String], boolean condition) - Checks that the boolean condition is true.
 * assertsEquals([String], expected, actual) - Tests that two values are the same. 
 * 		Note: for arrays the reference is checked not the content of the arrays.
 * assertsEquals([String], expected, actual, tolerance) - Test that float or double values match. 
 * 		The tolerance is the number of decimals which must be the same.
 * assertNull([String], object) - Checks that the object is null.
 * assertNotNull([String], object) - Checks that the object is not null.
 * assertSame([String], expected, actual) - Checks that both variables refer to the same object.
 * assertNotSame([String], expected, actual) - Checks that both variables refer to different objects. 
 * 
 * For a list of all test classes - check out http://junit.org/javadoc/latest/
 */

public class DateTest {

	/**
	 * @BeforeClass - Will execute the method once, before the start of all tests. 
	 * 		This can be used to perform time intensive activities, for example to connect to a database. 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//
	}

	/**
	 * @AfterClass - Will execute the method once, after all tests have finished. 
	 * 		This can be used to perform clean-up activities, for example to disconnect from a database. 
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @Before - Will execute the method before each test. 
	 * 		This method can prepare the test environment (e.g. read input data, initialize the class). 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @After - Will execute the method after each test. 
	 * 		This method can cleanup the test environment (e.g. delete temporary data, restore defaults). 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link dateADTExercise.Date#Date()}.
	 */
	@Test
	public final void testDate() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link dateADTExercise.Date#Date(int, int, int)}.
	 */
	@Test
	public final void testDateIntIntInt() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link dateADTExercise.Date#getDays()}.
	 */
	@Test
	public final void testGetDays() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link dateADTExercise.Date#createDate(int, int, int)}.
	 */
	@Test
	public final void testCreateDate() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link dateADTExercise.Date#dateFormatISO()}.
	 */
	@Test
	public final void testDateFormatISO() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link dateADTExercise.Date#changeDate(int)}.
	 */
	@Test
	public final void testChangeDate() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link dateADTExercise.Date#compareTo(dateADTExercise.DateADT)}.
	 */
	@Test
	public final void testCompareTo() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link dateADTExercise.Date#daysBetween(dateADTExercise.DateADT)}.
	 */
	@Test
	public final void testDaysBetween() {
		fail("Not yet implemented"); // TODO
	}

}
