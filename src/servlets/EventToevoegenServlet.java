package servlets;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EvenementenIO;
import domein.Evenement;

public class EventToevoegenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public EventToevoegenServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

	// VoeglocatieToe

	req.getParameter("voegToe");
	System.out.println("toevoegen");
	EvenementenIO eIo = new EvenementenIO();
	
	String naam = req.getParameter("naam");
	String subTitel = req.getParameter("subTitel");
	String datum = req.getParameter("datum");
	int locatieID = Integer.parseInt(req.getParameter("locatie"));
	int programmaID = 1;
	String contactPersoon = req.getParameter("contactpersoon");
	String organisator = req.getParameter("organisator");
	Evenement e = new Evenement("", naam, subTitel, datum, locatieID, programmaID, contactPersoon, organisator);
	try {
		eIo.voegEvenementToe(e);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	response.sendRedirect("eOverzicht.jsp?message=Evenement+toegevoegd.");

    }
}
