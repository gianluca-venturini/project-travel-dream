package dto;

import entity.PersonalizedProductFlight;
import exceptions.FieldNotPresentException;


public class PersonalizedFlightDTO extends PersonalizedProductDTO {
	private FlightDTO flight;
	private ClassPersonalizationDTO classPersonalization;
	private DatePersonalizationDTO datePersonalization;
	
	public PersonalizedFlightDTO(PersonalizedProductFlight flight) throws FieldNotPresentException {
		this.flight = new FlightDTO(flight.getFlight());
		this.id = flight.getId();
		if(flight.getClassPersonalization() != null) {
			this.classPersonalization = new ClassPersonalizationDTO(flight.getClassPersonalization());
		}
		if(flight.getDatePersonalization() != null) {
			this.datePersonalization = new DatePersonalizationDTO(flight.getDatePersonalization());
		}
	}
	
	public PersonalizedFlightDTO(FlightDTO flight) {
		super();
		this.flight = flight;
		this.id = -1;
	}

	public PersonalizedFlightDTO() {
		super();
		this.flight = flight;
		this.id = -1;
	}

	public FlightDTO getFlight() {
		return flight;
	}

	public void setFlight(FlightDTO flight) {
		this.flight = flight;
	}

	public ClassPersonalizationDTO getClassPersonalization() {
		return classPersonalization;
	}

	public void setClassPersonalization(ClassPersonalizationDTO classPersonalization) {
		this.classPersonalization = classPersonalization;
	}

	public DatePersonalizationDTO getDatePersonalization() {
		return datePersonalization;
	}

	public void setDatePersonalization(DatePersonalizationDTO datePersonalization) {
		this.datePersonalization = datePersonalization;
	}

	@Override
	public String toString() {
		return "PersonalizedFlightDTO [flight=" + flight
				+ ", classPersonalization=" + classPersonalization
				+ ", datePersonalization=" + datePersonalization + "]";
	}
	
	public double getPrice() {
		double price = 0;
		if(classPersonalization != null)
			price += flight.getPrices().get(classPersonalization);
		if(datePersonalization != null)
			price += flight.getPrices().get(datePersonalization);
		return price;
	}
}
