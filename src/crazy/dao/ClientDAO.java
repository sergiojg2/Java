package crazy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import crazy.model.client.Cliente;

@Component
public class ClientDAO implements IClienteDAO{
	@Autowired
	//poner el id que tenemos en el fichero de configuracion de los beans
	//@Qualifier("dataSource")
	DataSource dataSource;	
	

public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public Cliente getClientbd(String email){
	  Cliente c=null;
		String consulta="select * from cliente where email =?";
		Connection conn = null;
		try {
			conn=dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(consulta);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
				c=new Cliente();
				c.setEmail(rs.getString("email"));
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}


@Override
public Cliente getClient(String email){
		

	Cliente c=new Cliente();
		c.setEmail("federico@gmail.com");
		c.setNombre("Federico");
		c.setApellido("Fellini");
		
		return c;
	}
}
