package yaksha;

import static yaksha.TestUtils.businessTestFile;
import static yaksha.TestUtils.currentTest;
import static yaksha.TestUtils.yakshaAssert;
import java.text.SimpleDateFormat;
import java.util.*;
import org.junit.jupiter.api.Test;

class MainClassTest {

	@Test
	public void testExceptionConditon() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.boundaryTestFile);
	}

	@Test
	public void testBoundaryCondition() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.exceptionTestFile);
	}

	@Test
	void testfindBestServiceEngineer() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Booking> booking = new ArrayList<Booking>();
		Booking booking1 = new Booking((long) 1, sdf.parse("06-01-2015"), "CC", (long) 11, (long) 1001, 100.00, "John");
		Booking booking2 = new Booking((long) 2, sdf.parse("01-06-2017"), "CC", (long) 12, (long) 1002, 200.00,
				"Peter");
		Booking booking3 = new Booking((long) 3, sdf.parse("28-02-2015"), "DC", (long) 13, (long) 1003, 150.00,
				"Peter");
		Booking booking4 = new Booking((long) 4, sdf.parse("24-06-2015"), "CC", (long) 14, (long) 1004, 250.00, "John");
		Booking booking5 = new Booking((long) 5, sdf.parse("14-06-2016"), "DC", (long) 15, (long) 1005, 75.00, "John");
		Booking booking6 = new Booking((long) 6, sdf.parse("12-05-2017"), "DC", (long) 16, (long) 1006, 125.00,
				"Peter");
		Booking booking7 = new Booking((long) 7, sdf.parse("24-12-2011"), "CC", (long) 17, (long) 1007, 185.00,
				"Peter");
		booking.add(booking1);
		booking.add(booking2);
		booking.add(booking3);
		booking.add(booking4);
		booking.add(booking5);
		booking.add(booking6);
		booking.add(booking7);
		Map<String, List<Booking>> sername = FindingBestServiceEngineer.organizeBookings(booking);
		String expectedResult[] = { "John", "Peter" };
		List<String> service1 = Arrays.asList(expectedResult);
		List<String> service = FindingBestServiceEngineer.findBestServiceEngineer(sername);
		yakshaAssert(currentTest(), (service.containsAll(service1) ? "true" : "false"), businessTestFile);
	}
}
