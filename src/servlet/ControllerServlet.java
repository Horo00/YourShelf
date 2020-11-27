package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabeans.Login;
import javabeans.UserDTO;
import model.LoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
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

		//■Get通信(トップ画面から/ログイン失敗画面から）********************************
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String value = request.getParameter("value");

//		★TOPメニューから飛んできた際の振り分け
//						switch(value) {
//						case:"null"  //valueにデータが入っていない場合
//						//◇ログイン画面にフォワード
//						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
//						dispatcher.forward(request, response);
//						case:〇〇  //ログイン
//						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
//						dispatcher.forward(request, response);
//						break;
//						case:〇〇  //新規登録
//						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/addUser.jsp");
//						dispatcher.forward(request, response);
//						break;
//						case:〇〇  //書籍一覧
//						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewBook.jsp");
//						dispatcher.forward(request, response);
//						break;
//						}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		//■Post通信（ログイン画面から）*************************************************
		//◇ログイン成功⇒データをセッションに保存後、ログイン成功画面にフォワード
		//◇ログイン失敗⇒ログイン画面にリダイレクト

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		//ログイン処理の実行
		Login login = new Login(name, password);
		LoginLogic bo = new LoginLogic();
		UserDTO userDTO = bo.execute(login);

		//userDTOデータの有無によって処理を分岐
		if (userDTO != null) {//ログイン成功
			//データをセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("userDTO", userDTO);

			switch (name) {//氏名によってログイン画面を分岐
			case "admin":
				//ログイン成功画面(管理者)へフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginAdmin.jsp");
				dispatcher.forward(request, response);
				break;
			default:
				//ログイン成功画面(一般USER)へフォワード
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
				dispatcher.forward(request, response);
			}
		}//ログイン失敗
		//ログイン画面にリダイレクト
		response.sendRedirect("/YourShelf/ControllerServlet");
	}

}
