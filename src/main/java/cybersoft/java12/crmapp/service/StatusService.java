package cybersoft.java12.crmapp.service;

import java.sql.SQLException;
import java.util.List;

import cybersoft.java12.crmapp.dao.StatusDao;
import cybersoft.java12.crmapp.dto.StatusCreateDto;
import cybersoft.java12.crmapp.model.Status;

public class StatusService {

	private StatusDao statusDao;
	
	public StatusService(){
		statusDao = new StatusDao();
	}
		public List<Status> findAll(){
			List<Status> statuss = null;
			try {
				statuss = statusDao.findAll();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return statuss;
		}
		

		public Status findById(int id) {
			 Status status  = new  Status();
			
			try {
				status = statusDao.findById(id);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return status ;
		}
		

		public void deleteById(int id) {
		try {
			statusDao.deleteById(id);
			} catch (SQLException e) {
			e.printStackTrace();
			}
			
		}
		public void add(StatusCreateDto statusdto) {

			
			try {
				statusDao.add(statusdto);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void update(StatusCreateDto statusdto) {

			try {
				statusDao.update(statusdto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
