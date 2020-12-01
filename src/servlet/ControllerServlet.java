package servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data_access.HavingBookDAO;
import data_access.UserDAO;
import javabeans.LendingBook;
import javabeans.Login;
import javabeans.UserDTO;
import model.CountSort;
import model.LoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ControllerServlet")
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

		//■Get通信(トップ画面/一般ユーザー[書籍一覧]/ログイン失敗画面から）********************************
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String value = request.getParameter("value");
		HttpSession session = request.getSession();
		if (value == null) {
			value = "null";
		}

		//★TOPメニュー/一般ユーザー[書籍一覧]から飛んできた際の振り分け
		switch (value) {
		case "null": //valueにデータが入っていない場合
			//◇ログイン画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			break;

		case "loginpage": //TOPメニュー[ログイン]
			UserDTO user = (UserDTO) session.getAttribute("user");
			//ユーザー情報がセッションに残っている場合
			if (user != null) {
				switch (user.getName()) {//氏名によってログイン画面を分岐
				case "admin":
					//ログイン成功画面(管理者)へフォワード
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginAdmin.jsp");
					dispatcher.forward(request, response);
					break;
				default:
					//ログイン成功画面(一般USER)へフォワード
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
					dispatcher.forward(request, response);
				}
			}

			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			break;

		case "adduserpage": //TOPメニュー[新規登録]
			UserDAO userDAO = new UserDAO();
			HashSet<String> userNameSet = userDAO.getUserNameSet();
			session.setAttribute("userNameSet", userNameSet);

			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/addUser.jsp");
			dispatcher.forward(request, response);
			break;
		case "viewbookpage": //TOPメニュー[書籍一覧]/一般ユーザー[書籍一覧]
			//書籍一覧データを取得
			HavingBookDAO dao = new HavingBookDAO();
			List<LendingBook> book = dao.searchBook();

			Collections.sort(book, new CountSort());

			//書籍一覧データをセッションスコープに保存
			session.setAttribute("book", book);

			//書籍一覧表示画面にフォワード
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewBook.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		//■Post通信（ログイン画面から）***************************************************************
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

		RequestDispatcher dispatcher;

		//userDTOデータの有無によって処理を分岐---------------------------------------------
		if (userDTO != null) {//ログイン成功
			//データをセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("user", userDTO);

			switch (name) {//氏名によってログイン画面を分岐
			case "admin":
				//ログイン成功画面(管理者)へフォワード
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginAdmin.jsp");
				dispatcher.forward(request, response);
				break;
			default:
				//ログイン成功画面(一般USER)へフォワード
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
				dispatcher.forward(request, response);
			}
		} //ログイン失敗
		//エラーメッセージをリクエストに格納
		request.setAttribute("message", "ログインに失敗しました");
			//ログイン画面にフォワード
		dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

}
