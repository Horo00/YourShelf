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
import helper.JumpPageHelper;
import javabeans.LendingBook;
import javabeans.UserDTO;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/ReturnServlet")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//■Get通信(一般ユーザーメニュー[返却]から/一般ユーザー[返却ボタン]から/直接アクセス）*******************************************
				//リクエストパラメータ取得
				request.setCharacterEncoding("UTF-8");
				String value = request.getParameter("value");

				//ログインユーザー情報を取得
				HttpSession session = request.getSession();
				UserDTO user=(UserDTO)session.getAttribute("user");

				//アクセス元により分岐-------------------------------------------------------------------
				if (user == null) {//直接アクセスした場合
					//TOP画面へリダイレクト
					response.sendRedirect("/YourShelf/Index");

				} else if(value.equals("returnpage")) {//一般ユーザーメニュー[返却]からアクセス
					//ユーザーidに該当するユーザーの借りている本の一覧を取得する
					LendingBookDAO dao=new LendingBookDAO();
					List<LendingBook> lendingBookList=dao.getLendingBookList(user);

					//借りている本一覧情報をセッションスコープに保存
					session.setAttribute("lendingBookList",lendingBookList);

					//書籍返却表示画面へフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/return.jsp");
					dispatcher.forward(request, response);

				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String value = request.getParameter("value");
		if(value == null) {
			response.sendRedirect(JumpPageHelper.INDEX);
			return;
		}

		if(value.equals("return")) {//一般ユーザー[返却ボタン]から
			//★返却する本のデータをbookに格納
			HttpSession session = request.getSession();
			List<LendingBook> lendingBookList= (List<LendingBook>) session.getAttribute("lendingBookList");
			int index=Integer.parseInt(request.getParameter("index"));

			//★該当する書籍のレンタル情報をDBで変更
			LendingBookDAO dao=new LendingBookDAO();
			boolean result=dao.returnBook(lendingBookList.get(index));

			if(result) {//返却に成功した場合
				//返却した本の情報をセッションに保存
				request.setAttribute("book",lendingBookList.get(index));

				//返却結果画面へフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/returnOK.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
