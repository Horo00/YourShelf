package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data_access.LendingBookDAO;
import javabeans.Book;
import javabeans.UserDTO;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckOutServlet() {
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

		//■GET通信（直接アクセス）*********************************************************************
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

		//■POST通信（直接/一般ユーザー[借りる]ボタンからアクセス）**************************************
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher;

		//index値が入っていない場合などは暫定処置としてトップページにリダイレクトさせる
		//一般ユーザー[借りる]ボタンからアクセスの場合
		//ログイン確認のためセッションスコープからユーザ情報を取得
		HttpSession session = request.getSession();
		UserDTO loginUser = (UserDTO) session.getAttribute("user");

		if (loginUser == null) {//ログインをしていない場合（セッションスコープにユーザー情報がない場合）
			//ログイン画面へフォワード
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
			dispatcher.forward(request, response);
			return;
		}

		if (loginUser.getId() == 0) {
			//管理者でログインしている場合
			//何もせずログイン画面(管理者)へフォワード
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginAdmin.jsp");
			dispatcher.forward(request, response);
			return;
		}

		int index = Integer.parseInt(request.getParameter("index"));//どの位置の本が押されたか取得

		//全書籍データからか、検索された後の書籍データからかのチェック
		String value = request.getParameter("value");

		List<Book> books = new ArrayList<Book>();

		//セッションに保存されている所有書籍リストを取得
		if (value.equals("all")) {
			books = (List<Book>) session.getAttribute("book");
		}
		if (value.equals("search")) {
			books = (List<Book>) session.getAttribute("searchBook");
		}

		//※書籍情報を「book」変数に格納
		Book lendBook = books.get(index);

		//もし該当書籍が借りられている場合所有書籍一覧に戻す
		if (lendBook.isCheckedOut()) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewBook.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//★取得した書籍データをDBへ保存⇒結果をbooleanで返す
		LendingBookDAO dao = new LendingBookDAO();
		boolean result = dao.lendBook(loginUser, lendBook);

		if (result) {//借りることに成功した場合
			//借りた書籍の情報をセッションスコープに保存
			request.setAttribute("lendBook", lendBook);

			//借りられた本のビーンズのカウントを１上げる
			lendBook.addCount();
			lendBook.setCheckedOut(true);

			//貸出完了表示画面にフォワード
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/checkOutOK.jsp");
			dispatcher.forward(request, response);
			return;

		} else {//借りることに失敗した場合
			//貸出完了表示画面にフォワード
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewBook.jsp");
			dispatcher.forward(request, response);
			return;
		}

	}

}