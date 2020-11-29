package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestDA
 */
@WebServlet("/TestDA")
public class TestDA extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		InitialContext ic;
		DataSource ds = null;

		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:/comp/env/jdbc:db");

			try (Connection connection = ds.getConnection()){
				out.println("<h1>接続処理に成功しました</h1>");
			} catch (Exception e) {
				out.println("<h1>接続処理に失敗しました!</h1>");
			}
		} catch (Exception e) {
			out.println("<h1>JNDI処理で問題が発生しました</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
