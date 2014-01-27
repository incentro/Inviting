package domein;

public class Opmerking {
	private String datum, opmerking, eventID, Status, gebruikerID, email;

	public Opmerking(String datum, String opmerking,
			String eventID, String status, String gebruikerID, String email) {
		super();
		this.datum = datum;
		this.email = email; 
		this.opmerking = opmerking;
		this.eventID = eventID;
		this.Status = status;
		this.gebruikerID = gebruikerID;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getOpmerking() {
		return opmerking;
	}

	public void setOpmerking(String opmerking) {
		this.opmerking = opmerking;
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getGebruikerID() {
		return gebruikerID;
	}

	public void setGebruikerID(String gebruikerID) {
		this.gebruikerID = gebruikerID;
	}
	
	
}
