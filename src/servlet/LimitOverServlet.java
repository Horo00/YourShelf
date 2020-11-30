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

import data_access.BookInfoDAO;
import data_access.LendingBookDAO;
import javabeans.LendingBook;
import javabeans.LimitOverBooks;
import javabeans.UserDTO;

/**
 * Servlet implementation class LimitOverServlet
 */
@WebServlet("/LimitOverServlet")
public class LimitOverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LimitOverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//■Get通信(管理者ログイン画面[返却期限切れ一覧]/直接）********************************
		//リクエストパラメータ取得
		request.setCharacterEncoding("UTF-8");
		String value = request.getParameter("value");

		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO)session.getAttribute("userDTO");

		//アクセス元により分岐-------------------------------------------------------
		if (dto.getId() != 0) {//管理者でログインしていない場合
			//TOP画面へリダイレクト
			response.sendRedirect("/YourShelf/Index");

		} else {//管理者ログイン画面[返却期限切れ一覧]からのアクセスした場合
			//期限切れの一覧情報を取得するための流れ

			//現在貸し出し中の本のリストを抜き取る
			LendingBookDAO dao = new LendingBookDAO();
			List<LendingBook> books = dao.getLendingBookList();

			//貸し出し中のリストの中から期限切れだけを抜き取る
			BookInfoDAO dao2 = new BookInfoDAO();
			List<LimitOverBooks> overBooks = dao2.getLimitOverBookList(books);

			//期限切れ一覧情報をセッションスコープに保存
			session.setAttribute("overBooks",overBooks);

			//期限切れ一覧表示画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/limitOver.jsp");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		//■POST通信（直接アクセス）********************************************
			//ＴＯＰへリダイレクト
			response.sendRedirect("/YourServlet/Index");
	}

}
