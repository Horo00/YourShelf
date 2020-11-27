package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data_access.UserDAO;
import javabeans.UserDTO;

/**
 * Servlet implementation class ViewUserServlet
 */
@WebServlet("/ViewUserServlet")
public class ViewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//■Get通信(管理者ログイン画面/直接アクセス）********************************
		//リクエストパラメータ取得
		request.setCharacterEncoding("UTF-8");
		String value = request.getParameter("value");

		//アクセス元により分岐-------------------------------------------------------
		if (value == null) {//直接アクセスした場合
			//TOP画面へリダイレクト
			response.sendRedirect("/YourShelf/Index");

		} else if (value.equals(〇〇)) {//管理者ログイン画面からのアクセスした場合
			//全ユーザー情報を取得
			UserDAO userDAO = new UserDAO();
			List<UserDTO> UserList = userDAO.getUserList();

			//if(UserList!=null) {//データの取得に成功した場合
			//取得した全ユーザー情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("UserList", UserList);

			//全ユーザー一覧表示画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/viewUser.jsp");
			dispatcher.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
