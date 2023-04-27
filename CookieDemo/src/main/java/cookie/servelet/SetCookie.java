package cookie.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import cookie.DAO.CRUDoperations;
import cookie.DTO.LoginForm;
import cookieDemo.database.DbConnection;

/**
 * Servlet implementation class SetCookie
 */
@WebServlet("/SetCookie")
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Cookie ck[] = request.getCookies();
		HashMap userMaping = new HashMap();
		LoginForm formValue = new LoginForm();

		System.out.println(ck);

		try{
			formValue.setUsername(username);
			formValue.setPassword(password);

			userMaping = CRUDoperations.getUsers(formValue);

			System.out.println(userMaping);

		} catch (Exception err) {
			System.out.println(" -- DoGet catch :- " + err);
		}

		if(ck != null && ck[0].getName().equals(username) && userMaping.containsKey(username) &&
			ck[1].getName().equals(password) && userMaping.containsValue(password))
		{
			System.out.println(userMaping.containsKey(username) + " ----> " + userMaping.containsValue(password));
			response.sendRedirect("welcome.html");
		} else if(!username.isEmpty() && !password.isEmpty()) {
			Cookie setCk = new Cookie(username, password);
			
			try {
				int x = CRUDoperations.insert(formValue);

				PrintWriter out = response.getWriter();
				out.print("var xyz = 20;");

				response.sendRedirect("welcome.html");

			} catch (SQLException err) {
				System.out.println(" -- welcome catch :- " + err);
				response.sendRedirect("login.html");
			}
		} else {
			response.sendRedirect("login.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
