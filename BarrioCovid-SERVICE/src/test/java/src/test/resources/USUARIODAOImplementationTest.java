package src.test.resources;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.Lob;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.barriocovid.model.USUARIO;

class USUARIODAOImplementationTest {

	@Test
    final void testUSUARIO() {
		
        USUARIODAO usuariodao = USUARIODAOImplementation.getInstance();

       
       
        USUARIO usuario = new USUARIO();
        usuariodao.deleteUSUARIO(usuario);
        usuario.setEmail("as@gmail.com");
        usuario.setPassword("safe");
        usuario.setZona("Latina");
        usuario.setDireccion("Moncloa");
        usuario.setRol("Comprador");
        usuario.setPedidosRealizados(2);
        usuario.setPedidosEntregados(3);
    	usuario.setIdUsuario(1);
      /**  byte b[] = new byte[2];
        b[0] = 0;
        b[1] = 1;
        b[2] = 1;
        **/
	//	usuario.setProductos(b);
    	
        usuariodao.createUSUARIO(usuario);

        

        USUARIO usuario2 = usuariodao.readUSUARIO("as@gmail.com");
       
        
        assertEquals(usuario2.getEmail(), usuario.getEmail());
        assertEquals(usuario2.getPassword(), "safe");
        assertEquals(usuario2.getZona(),"Latina");
        assertEquals(usuario2.getDireccion(), usuario.getDireccion());
        assertEquals(usuario2.getRol(), usuario.getRol());
        assertEquals(usuario2.getPedidosRealizados(), usuario.getPedidosRealizados());
        assertEquals(usuario2.getPedidosEntregados(), 3);
        //assertEquals(usuario2.getProductos(), usuario.getProductos());
        assertNotEquals(usuario2.getIdUsuario(), 4);
        
        

        usuario.setRol("Vendedor");
        usuario.setPassword("newPass");
        usuariodao.updateUSUARIO(usuario);
        usuario2 = usuariodao.readUSUARIO("tu@gmail.com");
        assertEquals(usuario2.getRol(), "Vendedor");
        assertNotEquals(usuario2.getPassword(), usuario.getPassword());
        
       
        usuariodao.deleteUSUARIO(usuario);
        usuario2 = usuariodao.readUSUARIO("tu@gmail.com");
        assertNull(usuario2);


}
	}