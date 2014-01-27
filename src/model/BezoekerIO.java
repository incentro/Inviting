package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domein.ContactZoho;

public class BezoekerIO extends DbAbstract {

	public BezoekerIO() {
		super();
	}

	/*
	 * 
	 * Lijst bezoekers ophalen
	 */
	
	public ArrayList<ContactZoho> naamBezoekers(String eventID) {

		ArrayList<ContactZoho> gList = new ArrayList<ContactZoho>();
		try {
			super.makeConnection();
			ResultSet rs = super.makeResultSet("select * from contacts INNER JOIN status ON contacts.id=status.contact AND status.eventID='"+eventID+"'  ORDER BY status ASC");
			while (rs.next()) {
				ContactZoho g = new ContactZoho("","", "", "","","", "", "","", "", "","", true);
				g.setId(rs.getString("id"));
				g.setVoornaam(rs.getString("voornaam"));
				g.setAchternaam(rs.getString("achternaam"));
				g.setMail(rs.getString("email"));
				g.setFunctie(rs.getString("functie"));
				g.setFunctie_level(rs.getString("functie_level"));
				g.setFunctie_domain(rs.getString("functie_domain"));
				g.setBedrijf(rs.getString("bedrijf"));
				g.setTelefoon(rs.getString("telefoon"));
				g.setMobiel(rs.getString("mobiel"));
				g.setContactpersoon(rs.getString("contactpersoon"));
				g.setStatus(rs.getString("status"));
				gList.add(g);
			}
		} catch (SQLException ex) {
			System.out.println("Lijst bezoekers ophalen gefaald.");
		}
		super.closeConnectRst();
		return gList;
	}
	
	
	public ArrayList<ContactZoho> mailingBezoekers(String eventID) {
		ArrayList<ContactZoho> gList = new ArrayList<ContactZoho>();
		try {
			super.makeConnection();
			ResultSet rs = super.makeResultSet("select * from contacts INNER JOIN status ON contacts.id=status.contact AND status.eventID='"+eventID+"'  AND mailing=0 ORDER BY status ASC");
			while (rs.next()) {
				ContactZoho g = new ContactZoho("","", "", "", "", "","","","", "", "","", true);
				g.setId(rs.getString("id"));
				g.setVoornaam(rs.getString("voornaam"));
				g.setAchternaam(rs.getString("achternaam"));
				g.setMail(rs.getString("email"));
				g.setFunctie(rs.getString("functie"));
				g.setFunctie_level(rs.getString("functie_level"));
				g.setFunctie_domain(rs.getString("functie_domain"));
				g.setBedrijf(rs.getString("bedrijf"));
				g.setTelefoon(rs.getString("telefoon"));
				g.setMobiel(rs.getString("mobiel"));
				g.setContactpersoon(rs.getString("contactpersoon"));
				g.setStatus(rs.getString("status"));
				gList.add(g);
			}
		} catch (SQLException ex) {
			System.out.println("Lijst bezoekers ophalen gefaald.");
		}
		super.closeConnectRst();
		return gList;
	}
	
}