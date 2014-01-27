package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import domein.Mail;
import domein.MailLogin;

public class MailIO extends DbAbstract {

    public MailIO() {
	super();
    }

    /*
     * toevoegen van een programma
     * 
     * @author rwijhe
     */

    public String SendMail(String msg, String receiver, String subject) {
    		String s = "Uw bericht is verstuurd naar:" ;
    	   
    	   try {
    	/*Retrieve value from the text field using getParameter() method on Request object. Otherwise you can set it directly also if you are not using any interface */ 
    		   MailLogin ml = getMailLogin();
	         final String user	= ml.getEmail();
    	     final String pass	= ml.getPass();
    	     //create an instance of Properties Class     
    	     Properties props = new Properties();
    	     
    	/* Specifies the IP address of your default mail server
    	  for e.g if you are using gmail server as an email sever
    	  you will pass smtp.gmail.com as value of mail.smtp host. As shown here in the coding. Change accordingly, if your email id is not an gmail id*/
    	    
    	     props.put("mail.smtp.auth", "true");
    			props.put("mail.smtp.starttls.enable", "true");
    			props.put("mail.smtp.host", "smtp.gmail.com");
    			props.put("mail.smtp.port", "587");

    	     
    	 /*Pass Properties object(props) and Authenticator object   for authentication to Session instance */     

    	    Session session = Session.getInstance(props,
    	                        new javax.mail.Authenticator() {
    	  protected PasswordAuthentication getPasswordAuthentication() {
    	   return new PasswordAuthentication(user,pass);
    	   }
    	});
    	 /* Create an instance of MimeMessage, it accept MIME types and headers */    
    	 MimeMessage message = new MimeMessage(session);
    	 message.setFrom(new InternetAddress(user));
    	 message.addRecipient(Message.RecipientType.TO,new InternetAddress(receiver));
    	 message.setSubject(subject);
    	 message.setContent(msg, "text/html; charset=utf-8");
    	 /* Transport class is used to deliver the message to the recipients */
    	 Transport.send(message);
    	 
    	

    	        }catch(Exception e){
    	        	System.out.println(e + "Mailen mislukt");
    	        	s = "verkeerd email adres ingevoerd: ";
    	   e.printStackTrace(); 
    	  }
    	   
    	   return s;
    	
    }
    	public Mail getGegevens(String eventID, int mailID){
    		Mail u = new Mail(mailID, "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    		try {
    		    super.makeConnection();
    		    // Deze query gaat wat fout mee, eventID word er dubbel ingezet
    		    ResultSet rs = super.makeResultSet("SELECT * FROM mail WHERE id="+mailID+"");
    		    while (rs.next()) {
    		    	u.setId(rs.getInt("id"));
    		    	u.setEventID(rs.getString("eventID"));
    		    	u.setAanhef(rs.getString("aanhef"));
    			    u.setOnderwerp(rs.getString("onderwerp"));
    			    u.setLink(rs.getString("link"));
    			    u.setImage_header(rs.getString("image_header"));
    			    u.setImage_subheader(rs.getString("image_subheader"));
    			    u.setImage(rs.getString("image"));
    			    u.setContent1(rs.getString("content1"));
    			    u.setContent2(rs.getString("content2"));
    			    u.setHeader1(rs.getString("header1"));
    			    u.setHeader2(rs.getString("header2"));
    			    
    			    return u;
    			}
    		    super.closeConnectRst();
    		}
    		catch(Exception e){
    			System.out.print(e + "ophalen van een enkele maildata door middel van mailID mislukt");
    		}
			return u;	
    	}
    	
    	public ArrayList<Mail> getEventGegevens(int mailID, String eventID){
    		ArrayList<Mail> aMail = new ArrayList<Mail>();
    		try {
    		    super.makeConnection();
    		    // Deze query gaat wat fout mee, eventID word er dubbel ingezet
    		    ResultSet rs = super.makeResultSet("SELECT * FROM mail WHERE id="+mailID+"");
    		   
    		    while (rs.next()) {
    		    	int 	id				= rs.getInt("id");
    		    	String naam				= rs.getString("naam");
    		    	String aanhef			= rs.getString("aanhef");
    		    	String onderwerp		= rs.getString("onderwerp");
    		    	String link				= rs.getString("link");
    		    	String image_header 	= rs.getString("image_header");
    		    	String image_subheader	= rs.getString("image_subheader");
    		    	String image			= rs.getString("image");
    		    	String content1      	= rs.getString("content1");
    		    	String content2			= rs.getString("content2");
    		    	String header1			= rs.getString("header1");
    		    	String header2 			= rs.getString("header2");
    			    
    			    Mail m = new Mail(id, eventID, naam, link, image_header, image_subheader, image, content1, content2, header1, header2, "", "", onderwerp, aanhef);
    				aMail.add(m);
    			    
    			    return aMail;
    			}
    		    super.closeConnectRst();
    		}
    		catch(Exception e){
    			System.out.print(e + "ophalen van maildata door middel van MailID is mislukt");
    		}
			return aMail;
    		
    	}
    	
    	public ArrayList<Mail> getEventsGegevens(String eventID){
    		ArrayList<Mail> aMail = new ArrayList<Mail>();
    		try {
    		    super.makeConnection();
    		    
    		    ResultSet rs = super.makeResultSet("SELECT * FROM mail WHERE eventID='"+eventID+"'");
    		   
    		    while (rs.next()) {
    		    	int 	id				= rs.getInt("id");
    		    	String naam				= rs.getString("naam");
    		    	String aanhef			= rs.getString("aanhef");
    		    	String onderwerp		= rs.getString("onderwerp");
    		    	String link				= rs.getString("link");
    		    	String image_header 	= rs.getString("image_header");
    		    	String image_subheader	= rs.getString("image_subheader");
    		    	String image			= rs.getString("image");
    		    	String content1      	= rs.getString("content1");
    		    	String content2			= rs.getString("content2");
    		    	String header1			= rs.getString("header1");
    		    	String header2 			= rs.getString("header2");
    			    
    			    Mail m = new Mail(id, eventID, naam, link, image_header, image_subheader, image, content1, content2, header1, header2, "", "", onderwerp, aanhef);
    				aMail.add(m);
    			}
    		    super.closeConnectRst();
    		}
    		catch(Exception e){
    			System.out.print(e + "ophalen van maildata door middel van eventID is mislukt");
    		}
			return aMail;
    		
    	}
    	
    	public MailLogin getMailLogin(){
    		MailLogin ml = new MailLogin("", "");
    		try {
    		    super.makeConnection();
    		    
    		    ResultSet rs = super.makeResultSet("SELECT email, pass FROM cache WHERE id=1");
    		   
    		    while (rs.next()) {	    
    			    ml.setEmail(rs.getString("email"));
    			    ml.setPass(rs.getString("pass"));
    			}
    		    super.closeConnectRst();
    		}
    		catch(Exception e){
    			System.out.print(e + "ophalen van maildata is mislukt");
    		}
			return ml;	
    	}
    	
    	public void setLogin(String mail, String pass){
    		super.makeConnection();
    		String query = "UPDATE `cache` SET `email`='"+mail+"',`pass`='"+pass+"' WHERE id=1";

    		try {
    			super.addUpdateRecord(query);
    			super.closeConnection();
    		} catch (Exception ex) {
    			System.out.println(ex + "updaten van nieuwe maildata is mislukt");
    		}

    	}
    	
    	public void addMailData(String eventID, String naam, String aanhef, String onderwerp, String link, String image_header, String image_subheader, String image, String content1, String header1, String header2, String content2) {
    		super.makeConnection();
    		String query = "INSERT INTO mail (eventID, naam, aanhef, onderwerp, link, image_header, image_subheader, image, content1, header1, header2, content2)"
    				+ "VALUES ('"+eventID+"','"+naam+"','"+aanhef+"','"+onderwerp+"','"+link+"','"+image_header+"','"+image_subheader+"','"+image+"','"+content1+"','"+header1+"','"+header2+"','"+content2+"')";

    		try {
    			super.addUpdateRecord(query);
    			super.closeConnection();
    		} catch (Exception ex) {
    			System.out.println(ex + "aanmaken van nieuwe maildata is mislukt");
    		}
    	}
    	public void updateMailData(int mailID, String eventID, String naam, String aanhef, String onderwerp, String link, String image_header, String image_subheader, String image, String content1, String header1, String header2, String content2) {
    		super.makeConnection();
    		String query = "UPDATE mail SET naam='"+ naam + "', aanhef='"+aanhef+"', onderwerp='"+onderwerp+"', link='"+link+"',"
    				+ "image_header='"+image_header+"', image_subheader='"+image_subheader+"', image='"+image+"', content1='"+content1+"', "
    						+ "header1='"+header1+"', header2='"+header2+"', content2='"+content2+"' WHERE id = "+mailID+"";
    		try {
    			super.addUpdateRecord(query);
    			super.closeConnection();
    		} catch (Exception ex) {
    			System.out.println(ex+ "updaten van de maildata is mislukt");
    		}
    	}
}