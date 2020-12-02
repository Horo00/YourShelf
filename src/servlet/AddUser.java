package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data_access.UserDAO;
import javabeans.UserDTO;
import model.Hash;

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
		//ＴＯＰへリダイレクト
		response.sendRedirect("/YourServlet/Index");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//■POST通信（ユーザ登録画面から）***********************************
		//◇データ（name,password）があれば登録する

		//パラメータから情報を取得
		request.setCharacterEncoding("UTF-8");
		String name = "";
		String password = "";
		String passwordCheck = "";

		//入力項目チェック。不備があれば登録画面に戻す
		try {
			name = request.getParameter("name");
			//nameパラメータが入っていない場合（未入力や重複チェックボタンが押されていない場合)
			if (name == null || name.length() == 0) {
				request.setAttribute("message", "名前を入力し、重複チェックボタンを押してください");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/addUser.jsp");
				dispatcher.forward(request, response);
				return;
			}
			password = request.getParameter("password");
			passwordCheck = request.getParameter("password-check");
			//２つのパスワードが違っていた場合
			if (!password.equals(passwordCheck)) {
				request.setAttribute("message", "パスワードを確認してください");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/addUser.jsp");
				dispatcher.forward(request, response);
				return;
			}
			//nullポなどの例外発生時
		} catch (Exception e) {
			request.setAttribute("message", "入力項目を確認してください");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/addUser.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//データの整合性が取れた場合
		//passwordのハッシュ化
		password = Hash.getHash(password);

		//DBにユーザ情報を登録
		UserDAO dao = new UserDAO();
		UserDTO user = dao.addUser(name, password);

		if (user != null) {//DBへの登録成功
			//セッションスコープにユーザー情報を保存
			HttpSession session = request.getSession();
			session.setAttribute("user", user);//氏名・パスの保存されたビーンズ

			//一般ユーザログイン画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
			dispatcher.forward(request, response);

			return;
		}
		//DBへの登録失敗
		request.setAttribute("message", "新規登録に失敗しました");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/addUser.jsp");
		dispatcher.forward(request, response);
	}

}
