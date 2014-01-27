package domein;

public class ContactZoho {
	String voornaam, achternaam, mail, functie, functie_domain, functie_level, bedrijf, telefoon, mobiel, contactpersoon, status;
	String id;
	boolean optOut;
	public ContactZoho(String voornaam, String achternaam, String mail,
			String functie, String functie_domain, String functie_level,
			String bedrijf, String telefoon, String mobiel,
			String contactpersoon, String status, String id, boolean optOut) {
		super();
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.mail = mail;
		this.functie = functie;
		this.functie_domain = functie_domain;
		this.functie_level = functie_level;
		this.bedrijf = bedrijf;
		this.telefoon = telefoon;
		this.mobiel = mobiel;
		this.contactpersoon = contactpersoon;
		this.status = status;
		this.id = id;
		this.optOut = optOut;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getFunctie() {
		return functie;
	}
	public void setFunctie(String functie) {
		this.functie = functie;
	}
	public String getFunctie_domain() {
		return functie_domain;
	}
	public void setFunctie_domain(String functie_domain) {
		this.functie_domain = functie_domain;
	}
	public String getFunctie_level() {
		return functie_level;
	}
	public void setFunctie_level(String functie_level) {
		this.functie_level = functie_level;
	}
	public String getBedrijf() {
		return bedrijf;
	}
	public void setBedrijf(String bedrijf) {
		this.bedrijf = bedrijf;
	}
	public String getTelefoon() {
		return telefoon;
	}
	public void setTelefoon(String telefoon) {
		this.telefoon = telefoon;
	}
	public String getMobiel() {
		return mobiel;
	}
	public void setMobiel(String mobiel) {
		this.mobiel = mobiel;
	}
	public String getContactpersoon() {
		return contactpersoon;
	}
	public void setContactpersoon(String contactpersoon) {
		this.contactpersoon = contactpersoon;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isOptOut() {
		return optOut;
	}
	public void setOptOut(boolean optOut) {
		this.optOut = optOut;
	}
	
	
}
