package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUser() {
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
		//■GET通信（ページに直接アクセス）**********************************
		//TOP画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/YourShelf/Index.java");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//■POST通信（ユーザ登録画面から）***********************************
		//◇データ（userId,pass）があれば登録する

		//パラメータから情報を取得
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");

		//データの有無の確認
		if (userName != null && userName.length() != 0) {//氏名の入力有
			if (passWord != null && passWord.length() != 0) {//パスワードの入力有
				//DBにユーザ情報を登録
				//UserDAO dao = new UserDAO();
				//dao.addUser(userName, passWord);

				//セッションスコープに氏名を保存
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);//氏名

				//一般ユーザログイン画面にフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/YourShelf/LoginOK.jsp");
				dispatcher.forward(request, response);

			} else {//パスワード入力なし
				//TOP画面にフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/YourShelf/Index.java");
				dispatcher.forward(request, response);
			}
		} else {//氏名入力なし
			//TOP画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/YourShelf/Index.java");
			dispatcher.forward(request, response);

		}

	}
}
