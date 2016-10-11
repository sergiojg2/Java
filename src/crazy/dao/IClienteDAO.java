package crazy.dao;

import crazy.model.client.Cliente;

public interface IClienteDAO {
	
	public Cliente getClientbd(String email);
	public Cliente getClient(String email);

}
