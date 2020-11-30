package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabeans.UserDTO;

/**
 * Servlet implementation class UserHistoryServlet
 */
public class UserHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserHistoryServlet() {
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

		//■GET通信（直接/一般ユーザーメニュー[履歴]から）*********************************************
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String value = request.getParameter("value");

		//アクセス元により分岐------------------------------------------------------------------------
		if (value == null) {//直接アクセスの場合
			//ＴＯＰへリダイレクト
			response.sendRedirect("/YourServlet/Index");

		} else if (value.equals(〇〇)) {//履歴ボタンからアクセスの場合
			//セッションスコープからユーザデータ取得
			UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");

			//★DBから履歴情報を取得
			LendingBookDAO dao = new LendingBookDAO();
			List<LendBookHistroy> bookLists = dao.getBookHistroy(userDTO);

			//★履歴一覧情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("〇〇", 〇〇);

			//履歴一覧画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/YourShelf/userHistory.jsp");
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

		//■POST通信（直接アクセス）****************************************************************
		//ＴＯＰへリダイレクト
		response.sendRedirect("/YourServlet/Index");

	}

}
