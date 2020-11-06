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

import de.umass.lastfm.Artist;
import de.umass.lastfm.Chart;
import de.umass.lastfm.User;

/**
 * Servlet implementation class Total
 */
@WebServlet("/Total")
public class Total extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Total() {
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
		String user = (String) request.getSession().getAttribute("user");
		String key = (String) request.getSession().getAttribute("key");
		int number = (int) request.getSession().getAttribute("number");

		Chart<Artist> chart = User.getWeeklyArtistChart(user, "0", "99999999999", number, key);
		DateFormat format = DateFormat.getDateInstance();
		String from = format.format(chart.getFrom());
		String to = format.format(chart.getTo());
		System.out.printf("Charts for %s for the week from %s to %s:%n", user, from, to);
		Collection<Artist> artists = chart.getEntries();
		request.setAttribute("artists", artists);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/total.jsp");
		rd.forward(request, response);
	}
}