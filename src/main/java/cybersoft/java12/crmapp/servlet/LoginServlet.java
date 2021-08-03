package cybersoft.java12.crmapp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybersoft.java12.crmapp.dto.UserCreateDto;
import cybersoft.java12.crmapp.dto.UserLoginDto;
import cybersoft.java12.crmapp.service.UserService;
import cybersoft.java12.crmapp.service.AuthService;
import cybersoft.java12.crmapp.util.JspConst;
import cybersoft.java12.crmapp.util.ServletConst;
import cybersoft.java12.crmapp.util.UrlConst;

@WebServlet(name = ServletConst.LOGIN, urlPatterns = {
		UrlConst.LOGIN,
		UrlConst.LOGOUT,
		UrlConst.FORGOT_PASSWORD,
		UrlConst.SIGNUP
})
public class LoginServlet extends HttpServlet {
	private AuthService service;
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		service = new AuthService();
		userService = new UserService();
	}
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case UrlConst.LOGIN: 
			// cookies demo
			Cookie cookie = new Cookie("firstcookie","Thisisthefirstcookie");
			cookie.setMaxAge(60);
			resp.addCookie(cookie);
			
			// kiem tra cookie - email
			Cookie[] cookies = req.getCookies();
			int cookiesCount = cookies == null ? 0 : cookies.length;
			for(int i = 0; i < cookiesCount; i++)
				if(cookies[i].getName().equals("email"))
					req.setAttribute("email", cookies[i].getValue());
			
			String status = String.valueOf(req.getSession().getAttribute("status"));
			if(!status.equals("null"))
				resp.sendRedirect(req.getContextPath() + UrlConst.HOME);
			else
				req.getRequestDispatcher(JspConst.AUTH_LOGIN)
					.forward(req, resp);
			break;
		case UrlConst.SIGNUP: 
			req.getRequestDispatcher(JspConst.AUTH_SIGNUP)
			.forward(req, resp);
		break;
		case UrlConst.LOGOUT: 
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath() + UrlConst.LOGIN);
			break;	
		default:
			throw new IllegalArgumentException("Unexpected value: " + req.getServletPath());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case UrlConst.LOGIN: 
			// cookies demo
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String remember = req.getParameter("rememberUsername");
//			AuthService service = new AuthService();
//			UserLoginDto loginDto = service.login(email, password);
			
			boolean isLogin = true;
			
			if(remember != null) {
				Cookie cookie = new Cookie("email", email);
				cookie.setMaxAge(60*60*24*30);
				resp.addCookie(cookie);
			}
			
			System.out.printf("Email: %s, Remember: %s\n", email, remember);
			
			// session demo
			HttpSession currentSession = req.getSession();
			String pingo = (String)currentSession.getAttribute("pingo");
			System.out.printf("Pingo: %s\n", pingo);
			
			// logic dang nhap
			
			if(email == null || password == null)
				isLogin = false;
			
			else if(!service.login(email, password))
				isLogin = false;
			
			if(isLogin) {
				currentSession.setAttribute("status", "Logged in successfully.");
				currentSession.setAttribute("email", email);
				resp.sendRedirect(req.getContextPath() + UrlConst.HOME);
			} else
				resp.sendRedirect(req.getContextPath() + UrlConst.LOGIN);
			break;
		case UrlConst.SIGNUP: 
			String nameRegis = req.getParameter("nameSignUp");
			String emailRegis = req.getParameter("emailSignUp");
			String passwordRegis = req.getParameter("passwordSignUp");
			//check email already exist in DB
			try {
				boolean isExistDuplicateEmail  = userService.findUserExist(emailRegis);
				if(!isExistDuplicateEmail)
				{
					UserCreateDto user = new UserCreateDto();
					user.setName(nameRegis);
					user.setEmail(emailRegis);
					user.setPassword(passwordRegis);
					user.setRoleId(2);
					userService.add(user);
					resp.sendRedirect(req.getContextPath() + UrlConst.LOGIN);
				}
				else {
					System.out.println("User Have already Register!");
					req.setAttribute("existUser", "Email already exist. Please select another one!");
					req.getRequestDispatcher(JspConst.AUTH_SIGNUP)
					.forward(req, resp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case UrlConst.LOGOUT: 
			
			break;	
		default:
			throw new IllegalArgumentException("Unexpected value: " + req.getServletPath());
		}
	}
}

