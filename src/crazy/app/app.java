package crazy.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import crazy.model.client.Cliente;
import crazy.service.client.ClienteService;
import crazy.service.client.IClientService;

public class app {

	public static void main(String[] args) {
		//Obtener fichero de configuración
		ApplicationContext appCtx= new ClassPathXmlApplicationContext("clientes-bean.xml");
		IClientService cmio= (IClientService) appCtx.getBean(ClienteService.class); 
		Cliente client=cmio.getClientbd("pperez@gmail.com");
		System.out.println(client.getNombre());
		//la haremos mediante el fichero a traves de dependencias
		//DriverManagerDataSource ds=new DriverManagerDataSource();
		
		/* Cliente c1= (Cliente) appCtx.getBean("cliente1");
		Cliente c2= (Cliente)appCtx.getBean("cliente2");
		//obtenerlo por clase para no ponerlo en el fichero de configuracion
		//xml 
		ClienteService cs= (ClienteService) appCtx.getBean(ClienteService.class); 
		
		System.out.println(c1.getNombre());
		System.out.println(c1.getApellido());
		System.out.println(c1.getEmail());
		
		System.out.println(c2.getNombre());
		System.out.println(c2.getApellido());
		System.out.println(c2.getEmail());
		
		Cliente c3= cs.getClient("hola");
		System.out.println(c3.getNombre());
		System.out.println(c3.getApellido());
		System.out.println(c3.getEmail());
		*/
		
	}

}
