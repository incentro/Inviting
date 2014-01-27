package model;

import java.util.ArrayList;

import domein.ContactZoho;
import domein.Evenement;

public class SyncDatabase extends DbAbstract {
	private boolean status = false;
	private ArrayList<ContactZoho> contacts;
	private ArrayList<Evenement> event;
	private int aCount = 0;
	private int aCounte = 0;
	private int maxRecords= 200;
	private ZohoAPI api = new ZohoAPI(); 
	
	public boolean synchronize() {
		// get contacts form zoho data base after last updated time
		
		contacts = api.ContactenOphalenNaDatum();
		aCount = contacts.size();
		
		event = api.EventsOphalen();
		aCounte = event.size();
		
		//check of het onder de 200 zit
		if (aCount <= maxRecords){
			try {
			super.makeConnection();			
			for(ContactZoho g : contacts) {
				//System.out.println("ervoor: " + g.getFunctie());
				//String functie = g.getFunctie().replaceAll( "\'", "\\\'");
				//System.out.println("de functie is= " + functie +"einde van functie tonen");
				String query = "REPLACE INTO contacts(id, voornaam, achternaam,email,functie,functie_level, functie_domain, bedrijf,telefoon, mobiel, contactpersoon)"
						+ "VALUES("+g.getId()+", '"+g.getVoornaam()+"', '"+g.getAchternaam()+"', '"+g.getMail()+"','"+ g.getFunctie()+"','"+g.getFunctie_level()+"','"+g.getFunctie_domain()+"','"+g.getBedrijf()+"','"+g.getTelefoon()+"', '"+g.getMobiel()+"', '"+g.getContactpersoon()+"')";
				System.out.println("query = \n" +query);
				try {
					 super.makeResultSetUpdate(query);
				} catch (Exception e) {
					System.out.println("Query error name: "+ g.getMail() +"and error: "+ e);
				}
			}
			} finally {
				super.closeConnection();
			}
				
		}
		else {
			System.out.println("meer dan 200 gewijzigde/aangemaakte accounts");
		}
		
		if (aCounte <= maxRecords){
			try {
			super.makeConnection();			
			for(Evenement g : event) {
				String name = g.getNaam().replaceAll( "\'", "\\\'");
				System.out.println("naam vervangen:" + name +"\n");
				String query = "REPLACE INTO event (eventID, contactpersoon, datum, naam)"
						+ "VALUES('"+g.getEventID()+"', '"+g.getContactPersoon()+"',  '"+g.getDatum()+"',  \""+name+"\")";
				try {
					 super.makeResultSetUpdate(query);
				} catch (Exception e) {
					System.out.println("Query error name: "+ g.getNaam() +"and error: "+ e);
				}
			}
			} finally {
				super.closeConnection();
			}
				
		}
		else {
			System.out.println("meer dan 200 gewijzigde/aangemaakte accounts");
		}
		
		return status;	
	}

}
