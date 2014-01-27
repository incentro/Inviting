package domein;

public class Evenement {
	private int locatieID, programmaID;
	private String eventID, naam, subtitel, contactPersoon, organisator, datum;
	
	public Evenement(String eID, String nm, String subT, String dat, int lID, int pID, String cp, String org){
		eventID = eID;
		naam = nm;
		subtitel = subT;
		datum = dat;
		locatieID = lID;
		programmaID = pID;
		contactPersoon = cp;
		organisator = org;
	}

	public String getSubtitel() {
		return subtitel;
	}

	public void setSubtitel(String subtitel) {
		this.subtitel = subtitel;
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public int getLocatieID() {
		return locatieID;
	}

	public void setLocatieID(int locatieID) {
		this.locatieID = locatieID;
	}

	public int getProgrammaID() {
		return programmaID;
	}

	public void setProgrammaID(int programmaID) {
		this.programmaID = programmaID;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getDatum() {
		return datum;
	} 

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getContactPersoon() {
		return contactPersoon;
	}

	public void setContactPersoon(String contactPersoon) {
		this.contactPersoon = contactPersoon;
	}

	public String getOrganisator() {
		return organisator;
	}

	public void setOrganisator(String organisator) {
		this.organisator = organisator;
	}


}
