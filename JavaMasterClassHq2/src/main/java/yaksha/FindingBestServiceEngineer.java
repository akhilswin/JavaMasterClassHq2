package yaksha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindingBestServiceEngineer {

	public static Map<String, List<Booking>> organizeBookings(List<Booking> bookingList) {
		Map<String, List<Booking>> ser = new HashMap<String, List<Booking>>();
		List<String> service = new ArrayList<String>();
		Iterator<Booking> itr = bookingList.iterator();
		while (itr.hasNext()) {
			boolean flag = true;
			Booking b = itr.next();
			Iterator<String> itr1 = service.iterator();
			while (itr1.hasNext()) {
				if (itr1.next().equals(b.getServiceEngineer()))
					flag = false;
			}
			if (flag)
				service.add(b.getServiceEngineer());
		}
		Iterator<String> itr1 = service.iterator();
		while (itr1.hasNext()) {
			List<Booking> service1 = new ArrayList<Booking>();
			String s = itr1.next();
			Iterator<Booking> itr2 = bookingList.iterator();
			while (itr2.hasNext()) {
				Booking b = itr2.next();
				if (s.equals(b.getServiceEngineer())) {
					service1.add(b);
				}
			}
			ser.put(s, service1);
		}
		return ser;
	}

	public static List<String> findBestServiceEngineer(Map<String, List<Booking>> bookingMap) {
		List<String> service = new ArrayList<String>();
		Map<Double, String> bookingSort = new TreeMap<Double, String>();
		Iterator<String> itr = bookingMap.keySet().iterator();
		while (itr.hasNext()) {
			String key = itr.next();
			Double sum = 0.0;
			List<Booking> booking = bookingMap.get(key);
			Iterator<Booking> itr1 = booking.iterator();
			while (itr1.hasNext()) {
				Booking b = itr1.next();
				sum = sum + b.getAmount();
			}
			bookingSort.put(sum, key);
		}
		Iterator<Double> itr2 = bookingSort.keySet().iterator();
		while (itr2.hasNext()) {
			service.add(bookingSort.get(itr2.next()));
		}
		return service;
	}
}
