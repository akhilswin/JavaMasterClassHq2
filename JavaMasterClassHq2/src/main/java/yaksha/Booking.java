package yaksha;

import java.util.Date;

public class Booking {
	private Long bookingId;
	private Date dateTimeOfService;
	private String paymentMode;
	private Long customerId;
	private Long carId;
	private Double amount;
	String serviceEngineer;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Date getDateTimeOfService() {
		return dateTimeOfService;
	}

	public void setDateTimeOfService(Date dateTimeOfService) {
		this.dateTimeOfService = dateTimeOfService;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getServiceEngineer() {
		return serviceEngineer;
	}

	public void setServiceEngineer(String serviceEngineer) {
		this.serviceEngineer = serviceEngineer;
	}

	public Booking(Long bookingId, Date dateTimeOfService, String paymentMode, Long customerId, Long carId,
			Double amount, String serviceEngineer) {
		super();
		this.bookingId = bookingId;
		this.dateTimeOfService = dateTimeOfService;
		this.paymentMode = paymentMode;
		this.customerId = customerId;
		this.carId = carId;
		this.amount = amount;
		this.serviceEngineer = serviceEngineer;
	}
}