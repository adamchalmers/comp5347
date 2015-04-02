package survey;

import survey.model.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Survey
 * This class handles survey submitted by the user and displays results in another JSP
 */


@WebServlet(value="/survey", initParams = {
	@WebInitParam(name="products", value=survey.model.Config.PRODUCTS)
})
public class SurveyResults extends HttpServlet {
	private static final String VOTED = "voted";
	private static final long serialVersionUID = 1L;
	public String output = "Test.";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SurveyResults() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void processResult(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		// add your code here to get the survey data 
		// and to store it in the surveyResult object

		String[] productList = (String[]) getServletContext().getAttribute(SurveyForm.PRODUCT_LIST);
		SurveyModel surveyModel = (SurveyModel) getServletContext().getAttribute(SurveyForm.SURVEY_RESULT);
		
		if (surveyModel == null || productList == null) {
			String products = getServletConfig().getInitParameter("products");
			productList = products.split(",");
			surveyModel = new SurveyModel(productList.length);
			getServletContext().setAttribute(SurveyForm.PRODUCT_LIST, productList);
			getServletContext().setAttribute(SurveyForm.SURVEY_RESULT, surveyModel);
		}
		
		Integer vote = null, gender = null;
		try {
			vote = Integer.parseInt(request.getParameter("vote"));
			gender = Integer.parseInt(request.getParameter("gender"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// Check if they've already voted recently
		if (vote != null && gender != null) {
			if (request.getSession().getAttribute(VOTED) != null) {
				request.setAttribute("message", "You've already voted!");
				request.setAttribute("style", "red");
			} else {
				request.setAttribute("message", "Thank you for voting!");
				request.setAttribute("style", "green");
	
				// Record their vote 
				surveyModel.addPref(gender, vote);
				request.getSession().setAttribute(VOTED, true);
			}
		} else {
			request.setAttribute("message", "Survey results:");
			request.setAttribute("style", "blue");
		}
		
		// let a jsp page display the result
		String output = "Total votes: " + surveyModel.getVotes();
		request.setAttribute("output", output);
		request.setAttribute("model", surveyModel);
		request.setAttribute("productList", productList);
		RequestDispatcher view = request.getRequestDispatcher("/surveyResult.jsp");
		view.forward(request,response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processResult(request,response);
		request.setAttribute("output", "abcdef");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processResult(request,response);
	}

}
