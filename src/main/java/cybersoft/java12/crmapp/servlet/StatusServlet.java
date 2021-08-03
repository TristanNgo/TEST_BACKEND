package cybersoft.java12.crmapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import cybersoft.java12.crmapp.dto.RoleCreateDto;
import cybersoft.java12.crmapp.dto.StatusCreateDto;
//import cybersoft.java12.crmapp.model.Role;
import cybersoft.java12.crmapp.model.Status;
import cybersoft.java12.crmapp.service.StatusService;
import cybersoft.java12.crmapp.util.JspConst;
import cybersoft.java12.crmapp.util.ServletConst;
import cybersoft.java12.crmapp.util.UrlConst;

@WebServlet(name= ServletConst.STATUS, urlPatterns = {
		UrlConst.STATUS_DASHBOARD	,
		UrlConst.STATUS_ADD,
		UrlConst.STATUS_UPDATE,
		UrlConst.STATUS_DELETE	
	})

	public class StatusServlet extends HttpServlet{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private StatusService service;
		
		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
			service = new StatusService();
			}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case UrlConst.STATUS_DASHBOARD: 
			getStatusDashboard(req,resp);
			break;
		case UrlConst.STATUS_ADD:
			getStatusAdd(req,resp);
			break;
		case UrlConst.STATUS_UPDATE:
			getStatustUpdate(req,resp);
			break;
		case UrlConst.STATUS_DELETE:
			getStatusDelete(req,resp);
		break;
		}
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
		switch(req.getServletPath()) {
		case UrlConst.STATUS_DASHBOARD: 
			
			break;
		case UrlConst.STATUS_ADD:
			postStatusAdd(req,resp);
			break;
		case UrlConst.STATUS_UPDATE:
			postStatusUpdate(req,resp);
			break;
		case UrlConst.STATUS_DELETE:
		
			break;
		}
		}	
	
	
	private void getStatusDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Status> statuss = service.findAll();
		
		if(statuss != null && !statuss.isEmpty())
			req.setAttribute("statuss", statuss);
		
		req.getRequestDispatcher(JspConst.STATUS_DASHBOARD)
		.forward(req, resp);
		
		
	}
	

	private void getStatusDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		service.deleteById(id);
		
		resp.sendRedirect(req.getContextPath() + UrlConst.STATUS_DASHBOARD);
		
	}
	
	private void getStatusAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.STATUS_ADD)
		.forward(req, resp);
		
	}
	private void postStatusUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		StatusCreateDto statusdto = extractUpdatetoFromReq(req);
		service.update(statusdto);
		resp.sendRedirect(req.getContextPath() + UrlConst.STATUS_DASHBOARD);
		
	}
	private void postStatusAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	StatusCreateDto statusdto = extractAddDtoFromReq(req);
		service.add(statusdto);
		resp.sendRedirect(req.getContextPath() + UrlConst.STATUS_DASHBOARD);
		
	}
	private void getStatustUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Status status = new Status();
		status = service.findById(id);
		
		req.setAttribute("status", status );
		req.getRequestDispatcher(JspConst.STATUS_UPDATE)
		.forward(req, resp);
		
	}
	private StatusCreateDto extractAddDtoFromReq(HttpServletRequest req) {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		
		return new StatusCreateDto(name,description, 0);

}
	private StatusCreateDto extractUpdatetoFromReq(HttpServletRequest req) {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		 int id = Integer.parseInt(req.getParameter("id"));
		return new StatusCreateDto(name,description, id);

	}
	
}
