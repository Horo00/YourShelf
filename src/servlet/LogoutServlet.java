// ログアウト処理のコントローラ

package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabeans.UserDTO;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// ■Get通信（管理者ログイン画面/直接アクセス）***********************************************************************
		// リクエストパラメータ取得
		request.setCharacterEncoding("UTF-8");

		//ログインユーザー情報を取得
		HttpSession session = request.getSession();
		UserDTO user=(UserDTO)session.getAttribute("user");

		// アクセス元により分岐--------------------------------------------------------------------------------------------------------------
		if (user == null) {  //直接アクセスした場合
			//TOP画面へリダイレクト
			response.sendRedirect("/YourShelf/Index");
		} else {
			//セッションスコープを破棄
			session = request.getSession();
			session.invalidate();
			// TOP画面へリダイレクト
			response.sendRedirect("/YourShelf/Index");
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		//■POST通信（直接アクセス）********************************************************************
				//ＴＯＰへリダイレクト
				response.sendRedirect("/YourShelf/Index");
	}

}
