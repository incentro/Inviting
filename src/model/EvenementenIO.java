package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import domein.Evenement;

public class EvenementenIO extends DbAbstract {

	public EvenementenIO() {
		super();
	}

	public Evenement getEvent(String id) {
		Evenement e = new Evenement("", "", "", "", 0, 0, "", "");
		try {
			super.makeConnection();
			ResultSet rs = super.makeResultSet("SELECT * FROM event WHERE eventID= '"+id+"'");
			while (rs.next()) {
					e.setEventID( id);
					e.setNaam(rs.getString("naam"));
					e.setSubtitel(rs.getString("subtitel"));
					e.setDatum(dateToString(rs.getDate("datum")));
					e.setLocatieID(rs.getInt("locatieID"));
					e.setProgrammaID(rs.getInt("programmaID"));
					e.setContactPersoon( rs.getString("contactpersoon"));
					e.setOrganisator(rs.getString("organisator"));
			}
			super.closeConnectRst();
			return e;
		} catch (SQLException ex) {
			super.closeConnectRst();
			System.out.println(e + "het ophalen van alle evenementen is mislukt");
			return e;
		}
	}
	
	
	public ArrayList<Evenement> listEvenementen() {
		ArrayList<Evenement> eList = new ArrayList<Evenement>();
		try {
			super.makeConnection();
			ResultSet rs = super.makeResultSet("SELECT * FROM event ORDER BY datum DESC; ");
			while (rs.next()) {
				String EventID = rs.getString("eventID");
				String naam = rs.getString("naam");
				String subtitel = rs.getString("subtitel");
				String Datum  = dateToString(rs.getDate("datum"));
				int locatieID = rs.getInt("locatieID");
				int programmaID = rs.getInt("programmaID");
				String contactPersoon = rs.getString("contactpersoon");
				String organisator = rs.getString("organisator");
				Evenement e = new Evenement(EventID, naam, subtitel, Datum, locatieID, programmaID, contactPersoon, organisator);
				eList.add(e);
			}
		} catch (SQLException ex) {
			System.out.println(ex +"Lijst evenementen ophalen mislukt.");
		}
		super.closeConnectRst();
		return eList; 
	}
	
	public ArrayList<Evenement> listUpcomingEvents() throws ParseException {
		ArrayList<Evenement> eList = new ArrayList<Evenement>();
		try {
			super.makeConnection();
			String query = "SELECT * FROM event  WHERE datum > '"+date()+"' ORDER BY datum DESC";
			ResultSet rs = super.makeResultSet(query);
			while (rs.next()) {
				String EventID = rs.getString("eventID");
				String naam = rs.getString("naam");
				String subtitel = rs.getString("subtitel");
				String Datum  = dateToString(rs.getDate("datum"));
				int locatieID = rs.getInt("locatieID");
				int programmaID = rs.getInt("programmaID");
				String contactPersoon = rs.getString("contactpersoon");
				String organisator = rs.getString("organisator");
				Evenement e = new Evenement(EventID, naam, subtitel, Datum, locatieID, programmaID, contactPersoon, organisator);
				
				eList.add(e);
			}
		} catch (SQLException ex) {
			System.out.println(ex +"Lijst evenementen ophalen mislukt.");
		}
		super.closeConnectRst();
		return eList; 
	}
	
	public ArrayList<Evenement> listPastEvents() throws ParseException {
		ArrayList<Evenement> eList = new ArrayList<Evenement>();
		try {
			super.makeConnection();
			ResultSet rs = super.makeResultSet("SELECT * FROM event  WHERE datum <= '"+date()+"' ORDER BY datum DESC");
			while (rs.next()) {
				
				String EventID = rs.getString("eventID");
				String naam = rs.getString("naam");
				String subtitel = rs.getString("subtitel");
				String Datum  = dateToString(rs.getDate("datum"));
				int locatieID = rs.getInt("locatieID");
				int programmaID = rs.getInt("programmaID");
				String contactPersoon = rs.getString("contactpersoon");
				String organisator = rs.getString("organisator");
				Evenement e = new Evenement(EventID, naam, subtitel, Datum, locatieID, programmaID, contactPersoon, organisator);
				eList.add(e);
			}
		} catch (SQLException ex) {
			System.out.println(ex +"Lijst evenementen ophalen mislukt.");
		}
		super.closeConnectRst();
		return eList; 
	}
	
	public void voegEvenementToe(Evenement e) throws ParseException{
		String naam = e.getNaam();
		String subTitel = e.getSubtitel();
		Date date= stringToDate(e.getDatum());
		int locatieID = e.getLocatieID();
		String contactPersoon = e.getContactPersoon();
		String organisator = e.getOrganisator();
		
		
		String query = "INSERT INTO event (naam, subtitel, datum, locatieID,  contactpersoon,organisator)";
		query += "VALUES('" + naam + "', '" + subTitel + "',  " + date + ", "+ locatieID  + ", '" + contactPersoon + "', '"+ organisator + "')";

		try {
			 makeConnection();
			 makeResultSetUpdate(query);

		} catch (Exception ex) {
				System.out.println("het toevoegen van een evenement is mislukt");
		} 
	}
	
	public void pasEvenementAan(Evenement e) throws ParseException{
		String naam = e.getNaam();
		String subTitel = e.getSubtitel();
		int locatieID = e.getLocatieID();
		String contactPersoon = e.getContactPersoon();
		String organisator = e.getOrganisator();
		//Date date= stringToDate(e.getDatum());
		

		String query = "UPDATE event SET naam='"+naam+"', subtitel='"+subTitel+"',datum='"+e.getDatum()+"',  locatieid="+locatieID+" , contactpersoon='"+contactPersoon+"', organisator='"+organisator+"'  where eventID='"+e.getEventID()+"'";
		System.out.println("Query is ***********************" +query);
		try {
			super.addUpdateRecord(query);
			super.closeConnectRst();

		} catch (Exception ex) {
			System.out.println(ex + "het aanpassen van een evenement is mislukt");
		}
	}
	
	public void linkProgramma(String eId, int pId){
		String query = "UPDATE event SET programmaID='"+pId+"' where eventID='"+eId+"'";

		try {
			super.addUpdateRecord(query);
			super.closeConnectRst();

		} catch (Exception ex) {
			System.out.println(ex + "het linken van programma aan een event is mislukt");
		}
	}
	public Date stringToDate(String Sdate) throws ParseException {
		DateFormat formatter ; 
		Date date ; 
		   formatter = new SimpleDateFormat("dd-MM-yyyy");
		   date = formatter.parse(Sdate);
		   return date;
	}
	public String dateToString(Date date) {
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return  df.format(date);
	}
	public String date() throws ParseException{
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateBufferString = format.format(date);
		return dateBufferString;
	}
}
