package servlets;

import model.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet   {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse response) 
			throws ServletException, IOException {
		SyncDatabase sd = new SyncDatabase();
		String mail = req.getParameter("gebruikersnaam"); 
		String wachtwoord = req.getParameter("wachtwoord");
		try {
			wachtwoord = GebruikersIO.SHA1(wachtwoord);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GebruikersIO g = new GebruikersIO();
		if(g.Login(mail, wachtwoord) == true){
			response.sendRedirect("eOverzicht.jsp");
			req.getSession().setAttribute("userMail", mail);
			req.getSession().setAttribute("status", "ingelogd");
			sd.synchronize();
			
		}
		else{
			response.sendRedirect("index.jsp?message=Gebruikersnaam+en+of+wachtwoord+incorrect");
		}
	}

}


