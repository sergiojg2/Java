package crazy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import crazy.model.Client;

@Component
public class ClientDAO implements IClientDAO {
	@Autowired
	DataSource ds;

	@Override
	public Client getCliente(String email) {
		Client c = null;
		String consulta = "select * from cliente where email=?";

		try {
			Connection con = ds.getConnection();
			PreparedStatement query = con.prepareStatement(consulta);
			query.setString(1, email);
			ResultSet rs = query.executeQuery();
			if (rs.next()) {
				c = new Client();
				c.setName(rs.getString(rs.findColumn("nombre")));
				c.setSurname(rs.getString(rs.findColumn("apellido")));
				c.setEmail(rs.getString(rs.findColumn("email")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return c;
	}
	
	public List<Client> getClientes() {
		
		List<Client> lista=new ArrayList<Client>();
		String consulta = "select * from cliente ";
		Statement st;
		Client c = null;
		
			try {
				Connection con = ds.getConnection();
				 st = con.createStatement(); 
				ResultSet rs = st.executeQuery (consulta);
				
				while (rs.next()) {
					c = new Client();
					c.setName(rs.getString(rs.findColumn("nombre")));
					c.setSurname(rs.getString(rs.findColumn("apellido")));
					c.setEmail(rs.getString(rs.findColumn("email")));
				
					lista.add(c);
				}
					
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		return lista;
	}

}
