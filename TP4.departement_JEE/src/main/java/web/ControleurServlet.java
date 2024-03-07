package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import daoo.DepartementDaolmpl;
import daoo.IDepartementDAO;
import daoo.IDepartementDAO;
import metier.entities.Departement;
@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
IDepartementDAO metier;
@Override
public void init() throws ServletException {
metier = new DepartementDaolmpl();
}@Override
protected void doGet(HttpServletRequest request,
		 HttpServletResponse response)
		 throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/index.do"))
		{
		request.getRequestDispatcher("departement.jsp").forward(request,response);
		}
		else if (path.equals("/chercher.do"))
		{
		String motCle=request.getParameter("motCle");
		DepartementModele model= new DepartementModele();
		model.setMotCle(motCle);
		List<Departement> prods = metier.DepartementParMC(motCle);
		model.setDepartement(prods);
		request.setAttribute("model", model);
		request.getRequestDispatcher("departement.jsp").forward(request,response);
		}
		else if (path.equals("/saisie.do") )
		{
		request.getRequestDispatcher("saisieDepartement.jsp").forward(request,response);
		}
		else if (path.equals("/save.do") &&
		request.getMethod().equals("POST"))
		{
		 String NOM_departement=request.getParameter("NOM_departement");
		int Nb_employee = Integer.parseInt(request.getParameter("Nb_employee"));
		Departement p = metier.save(new Departement(NOM_departement,Nb_employee));
		request.setAttribute("departement", p);
		request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/supprimer.do"))
		{
		 Long id= Long.parseLong(request.getParameter("id"));
		 metier.deleteDepartement(id);
		 response.sendRedirect("chercher.do?motCle=");
		}
		else if (path.equals("/editer.do") )
		{
		Long id= Long.parseLong(request.getParameter("id"));
		 Departement p = metier.getDepartement(id);
		 request.setAttribute("departement", p);
		request.getRequestDispatcher("editerDepartement.jsp").forward(request,response);
		}
		else if (path.equals("/update.do") )
		{
		Long ID_departement = Long.parseLong(request.getParameter("ID_departement"));
		String NOM_departement=request.getParameter("NOM_departement");
		int Nb_employee =Integer.parseInt(request.getParameter("Nb_employee"));
		Departement p = new Departement();
		p.setID_departement(ID_departement);
		p.setNOM_departement(NOM_departement);
		p.setNb_employee(Nb_employee);
		metier.updateDepartement(p);
		request.setAttribute("departement", p);
		request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else
		{
		response.sendError(Response.SC_NOT_FOUND);
		}
		}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request,response);
}
}
