package crazy.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import crazy.dao.IClienteDAO;
import crazy.model.client.Cliente;

@Component
public class ClienteService {
	@Autowired
	private IClienteDAO clDao; 
	
	public IClienteDAO getClDao() {
		return clDao;
	}
	public void setClDao(IClienteDAO clDao) {
		this.clDao = clDao;
	}
	public Cliente getClient(String email){
		
		 return clDao.getClient(email);
	}
	public Cliente getClientbd(String email){
		
		 return clDao.getClientbd(email);
	}
	
	
}
