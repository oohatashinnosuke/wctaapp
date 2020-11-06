package wcta;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.umass.lastfm.Artist;
import de.umass.lastfm.Chart;
import de.umass.lastfm.User;

/**
 * Servlet implementation class Oneweek
 */
@WebServlet("/Oneweek")
public class Oneweek extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Oneweek() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("user");
		String key = request.getParameter("key");
		String num = request.getParameter("num");
		String pri = request.getParameter("pri");
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		session.setAttribute("key", key);
		int number = Integer.parseInt(num);
		double price = Double.parseDouble(pri);
		session.setAttribute("number", number);
		session.setAttribute("price", price);

		try {

			Chart<Artist> chart = User.getWeeklyArtistChart(user, number, key);
			DateFormat format = DateFormat.getDateInstance();
			String from = format.format(chart.getFrom());
			String to = format.format(chart.getTo());
			System.out.printf("Charts for %s for the week from %s to %s:%n", user, from, to);
			Collection<Artist> artists = chart.getEntries();
			request.setAttribute("artists", artists);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/oneweek.jsp");
			rd.forward(request, response);

		} catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			rd.forward(request, response);
		}
	}
}
