package yaksha;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class MainClass {
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Booking> booking = new ArrayList<Booking>();
		Long bookingId;
		Date dateTimeOfService;
		String paymentMode;
		Long customerId;
		Long carId;
		Double amount;
		String serviceEngineer;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ch = "yes";
		do {
			System.out.println("Enter a booking detail:");
			String details = br.readLine();
			String a[] = details.split(",");
			bookingId = Long.parseLong(a[0]);
			dateTimeOfService = sdf.parse(a[1]);
			paymentMode = a[2];
			customerId = Long.parseLong(a[3]);
			carId = Long.parseLong(a[4]);
			amount = Double.parseDouble(a[5]);
			serviceEngineer = a[6];
			Booking b = new Booking(bookingId, dateTimeOfService, paymentMode, customerId, carId, amount,
					serviceEngineer);
			booking.add(b);
			System.out.println("Do you want to add another booking detail:");
			ch = br.readLine();
		} while (ch.equalsIgnoreCase("yes"));
		Map<String, List<Booking>> sername = FindingBestServiceEngineer.organizeBookings(booking);
		System.out.format("%-15s %s\n", "Name", "No of Booking");
		List<String> service = FindingBestServiceEngineer.findBestServiceEngineer(sername);
		ListIterator<String> ltr = service.listIterator(service.size());
		while (ltr.hasPrevious()) {
			String key = ltr.previous();
			System.out.format("%-15s %s\n", key, sername.get(key).size());
		}
	}
}
