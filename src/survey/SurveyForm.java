package survey;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import survey.model.SurveyModel;
/**
 * Servlet implementation class SurveyForm
 * This servlet displays a survey for user's next purchase
 */

@WebServlet(value="/index.html", initParams = {
	@WebInitParam(name="products", value=survey.model.Config.PRODUCTS)
})
public class SurveyForm extends HttpServlet {
	public static final String SURVEY_RESULT = "surveyResult";
	public static final String PRODUCT_LIST = "productList";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SurveyForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Prepare some initial data
	 */
	public void init(){
		String products = getServletConfig().getInitParameter("products");
		String[] productList = products.split(",");
		SurveyModel sr = new SurveyModel(productList.length);
		getServletContext().setAttribute(PRODUCT_LIST, productList);
		getServletContext().setAttribute(SURVEY_RESULT, sr);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/surveyForm.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
