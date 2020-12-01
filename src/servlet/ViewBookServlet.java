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

import helper.SearchBook;
import javabeans.LendingBook;

/**
 * Servlet implementation class ViewBookServlet
 */
@WebServlet("/ViewBookServlet")
public class ViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		// Get通信：所蔵書籍から検索
		// セッションスコープの利用
		HttpSession session = request.getSession();
		List<LendingBook> book = (List<LendingBook>) session.getAttribute("book");

		// フォームからデータを取得
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");

//		 取得した結果を保存するListを作成
		List<LendingBook> selectBook = SearchBook.search(book,keyword);

//		 取得したArrayListをセッションスコープに保存
		session.setAttribute("SelectBook", selectBook);

		// 結果を表示するJSPファイルにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/YourShelf/viewBook.jsp");
		dispatcher.forward(request, response);
	}
}
