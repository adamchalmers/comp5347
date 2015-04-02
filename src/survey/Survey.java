package survey;

import survey.model.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Survey
 * This class handles survey submitted by the user and displays results in another JSP
 */

@WebServlet("/survey")
public class Survey extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Survey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void processResult(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		// add your code here to get the survey data 
		// and to store it in the surveyResult object



		// let a jsp page display the result
		RequestDispatcher view = request.getRequestDispatcher("/surveyResult.jsp");
		view.forward(request,response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processResult(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processResult(request,response);
	}

}
