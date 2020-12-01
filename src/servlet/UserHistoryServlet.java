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

import data_access.LendingBookDAO;
import javabeans.LendBookHistroy;
import javabeans.UserDTO;

/**
 * Servlet implementation class UserHistoryServlet
 */
@WebServlet("/UserHistoryServlet")
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

		HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("userDTO");

		//アクセス元により分岐------------------------------------------------------------------------
		if (user == null) {//直接アクセスの場合
			//ＴＯＰへリダイレクト
			response.sendRedirect("/YourShelf/Index");

		} //User情報が残っている場合

		//★DBから履歴情報を取得
		LendingBookDAO dao = new LendingBookDAO();
		List<LendBookHistroy> userBookHis = dao.getBookHistroy(user);

		//★履歴一覧情報をリクエストスコープに保存
		request.setAttribute("userBookHis", userBookHis);

		//履歴一覧画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userHistory.jsp");
		dispatcher.forward(request, response);
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
		response.sendRedirect("/YourShelf/Index");

	}

}
