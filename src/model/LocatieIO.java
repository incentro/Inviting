package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domein.Locatie;

public class LocatieIO extends DbAbstract {

	public LocatieIO() {
		super();
	}

	/*
	 * toevoegen van locatie
	 * 
	 * @author rwijhe
	 */

	public void voegLocatieToe(Locatie l){
		String adres = l.getAdres();
		String plaats = l.getPlaats();
		String postcode = l.getPostcode();
		String telefoonnummer = l.getTelefoonnummer();
		String website = l.getWebsite();

		String query = "INSERT INTO locatie (adres, plaats, postcode, telefoonnummer, locatiecol, website) ";
		query += "VALUES('" + adres + "',  '" + plaats + "', '" + postcode + "', '" + telefoonnummer + "', 'NULL', '" + website + "')";
		
		try {
			super.addUpdateRecord(query);
			super.closeConnection();

		} catch (Exception ex) {
			System.out.println(ex + "toevoegen van locatie is mislukt");
		}
	}
	
	/*
	 * opzoeken van het adres doormiddel van het ID
	 * 
	 * @author dennisverleg
	 * 
	 */

	public String getAdres(int id) {
		String adres = "";
		try {
			super.makeConnection();
			ResultSet rs = super.makeResultSet("SELECT * FROM locatie WHERE locatieID = "+id+"");
			while (rs.next()) {			
					adres = rs.getString("adres");
				}		
		} catch (Exception e) {
			System.out.println(e + "ophalen van adres mislukt");
		}
		super.closeConnectRst();
		return adres;
	}
	
	public Locatie getLocatie(int id) {
		Locatie l = new Locatie( id, "", "", "", "", "");
		try {
			super.makeConnection();
			ResultSet rs = super.makeResultSet("SELECT * FROM locatie WHERE locatieID = "+id+"");
			while (rs.next()) {
				// System.out.println(mail);
				// System.out.println(mail	if (id == idCheck) {
					l.setAdres(rs.getString("adres"));
					l.setPlaats(rs.getString("plaats"));
					l.setPostcode(rs.getString("postcode"));
					l.setTelefoonnummer(rs.getString("telefoonnummer"));
					l.setWebsite(rs.getString("website"));
			}
		} catch (Exception e) {
			System.out.println(e + "ophalen van locatie is mislukt");
		}
		super.closeConnectRst();
		return l;
	}
	
	/*
	 * het verkrijgen van de plaats doormiddel van het ID
	 * 
	 * @author dennisverleg
	 * 
	 */

	public String getPlaats(int id) {
		String plaats = "";
		try {
			super.makeConnection();
			ResultSet rs = super.makeResultSet("SELECT * FROM locatie");
			while (rs.next()) {
				int idCheck = (rs.getInt("locatieID"));
				// System.out.println(mail);
				// System.out.println(mailCheck);
				if (id == idCheck) {
					plaats = rs.getString("plaats");
				}
			}

		} catch (Exception e) {
			System.out.println("Plaats ophalen mislukt.");
		}
		super.closeConnectRst();
		return plaats;
	}
	
	/*
	 * het verkrijgen van alle locaties
	 * 
	 * @author kevinwtenweerde
	 * 
	 */
	
	public ArrayList<Locatie> listLocaties() {
		ArrayList<Locatie> lList = new ArrayList<Locatie>();
		try {
			super.makeConnection();
			ResultSet rs = super.makeResultSet("SELECT * FROM locatie");
			while (rs.next()) {
				Locatie l  = new Locatie(0, "", "", "", "", ""); 
				l.setLocatieID(rs.getInt("locatieID"));
				l.setAdres(rs.getString("adres"));
				l.setPlaats(rs.getString("plaats"));
				l.setPostcode(rs.getString("postcode"));
				l.setTelefoonnummer(rs.getString("telefoonnummer"));
				l.setWebsite(rs.getString("website"));
				lList.add(l);
			}
		} catch (SQLException ex) {
			System.out.println("Lijst locaties ophalen mislukt.");
		}
		super.closeConnectRst();
		return lList;
	}
}

