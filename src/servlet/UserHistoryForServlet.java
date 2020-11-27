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

import javabeans.AllBooksDTO;

/**
 * Servlet implementation class UserHistoryForServlet
 */
@WebServlet("/UserHistoryForServlet")
public class UserHistoryForServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHistoryForServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//■Get通信(全ユーザー情報一覧画面から/直接アクセス）********************************
				//リクエストパラメータ取得
				request.setCharacterEncoding("UTF-8");
				String value = request.getParameter("value");

				//アクセス元により分岐-------------------------------------------------------
				if (value == null) {//直接アクセスした場合
					//TOP画面へリダイレクト
					response.sendRedirect("/YourShelf/Index");

				} else {//全ユーザー情報一覧画面からのアクセスした場合
					//value=index番号のため、Index番号のユーザーに対応する「借りた履歴」を取得する
					AllBooksDAO dao = new AllBooksDAO();
					List<AllBooksDTO> AllBooksDTO = dao.searchBookList(value);//※index番号のユーザーの一覧を取得するメソッド

					//if(AllBooksDTO!=null) {//データの取得に成功した場合
					//取得した借りた履歴一覧情報をセッションスコープに保存
					HttpSession session = request.getSession();
					session.setAttribute("AllBooksDTO", AllBooksDTO);

					//借りた履歴一覧表示画面へフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userHistory.jsp");
					dispatcher.forward(request, response);


				}

			}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
