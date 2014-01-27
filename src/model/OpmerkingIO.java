package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import domein.Opmerking;
import domein.Status;

public class OpmerkingIO extends DbAbstract {

	public OpmerkingIO() {
		super();
	}

	/*
	 * 
	 * Lijst opmerkingen ophalen
	 * 
	 * @author rubenhartong
	 */

	public ArrayList<Opmerking> listOpmerkingen(String id, String eventID) {
		ArrayList<Opmerking> oList = new ArrayList<Opmerking>();
		try {
			super.makeConnection();
			ResultSet rs = super.makeResultSet("SELECT DISTINCT * FROM opmerkingen  WHERE opmerkingen.eventID ='"+eventID+"' ORDER BY opmerkingen.datum DESC");
			while (rs.next()) {
				
				Opmerking g = new Opmerking("","", "", "", "", ""); 
				g.setEmail(rs.getString("contact_id"));
				g.setGebruikerID(rs.getString("gebruikerID"));
				g.setEventID(rs.getString("eventID"));
				g.setDatum(rs.getString("datum"));
				g.setOpmerking(rs.getString("opmerking"));
				g.setStatus(null);
				
				oList.add(g);
			}
		} catch (SQLException ex) {
			System.out.println("Lijst opmerkingen ophalen mislukt." + ex);
			
		}
		super.closeConnectRst();
		return oList;
	}
	

	public String getDate(){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String s = dateFormat.format(date);
		
		return s;
	}
	
	public Status getStatus(String contact, String eventID) {
		Status s = new Status(contact, 1, 1, 1, 1, 1, eventID);
		try {
			super.makeConnection();
			ResultSet rs = super.makeResultSet("SELECT * FROM status WHERE contact='"+contact+"' AND eventID='"+eventID+"'");
			while (rs.next()) {
			s.setBellen(rs.getInt("bellen"));
			s.setContact(rs.getString("contact"));
			s.setEventID(rs.getString("eventID"));
			s.setHardcopy(rs.getInt("hardcopy"));
			s.setMailen(rs.getInt("mailen"));
			s.setStatus(rs.getInt("status"));
			s.setPrioriteit(rs.getInt("prioriteit"));
			}
		} catch (SQLException ex) {
			System.out.println("gegevens van contactpersoon ophalen mislukt.");
		}
		super.closeConnectRst();
		return s;
	}
	
	public void setStatus(String eventID, String contact, String name, String valueS){
		int value = Integer.parseInt(valueS);
		String query = "UPDATE `status` SET  `"+name+"`="+value+" WHERE contact='"+contact+"' AND eventID='"+eventID+"' ";

		try {
			 makeConnection();
			 makeResultSetUpdate(query);
			 closeConnection();

		} catch (Exception ex) {
				System.out.println("het toevoegen van een status is mislukt");
		}
	}
	/*
	 * Invoegen van een opmerking
	 * 
	 *  @author rubenhartong
	 */
	
	public void insertOpmerking(String contact, String datum, String opmerking, String gebruikerID, String eventID){
		String query = "INSERT INTO opmerkingen (contact_id, datum, opmerking, gebruikerID, eventID) ";
		query += "VALUES('" + contact + "','" + datum + "', '" + opmerking + "', '" + gebruikerID+ "', '" + eventID + "')";
 
		try {
			super.addUpdateRecord(query);
			super.closeConnection();
			
		} catch (Exception e) {
			System.out.println(e + "toevoegen van een opmerking is mislukt");
		}
	}
	
	
}
