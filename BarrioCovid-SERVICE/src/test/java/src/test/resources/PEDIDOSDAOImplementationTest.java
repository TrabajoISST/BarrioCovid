package src.test.resources;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import es.upm.dit.isst.barriocovid.model.PEDIDO;

class PEDIDODAOImplementationTest {


	@Test
    final void testPEDIDO() {

        PEDIDODAO pedidodao = PEDIDODAOImplementation.getInstance();

        
     /**   byte b[] = new byte[2];
        b[0] = 0;
        b[1] = 1;
        b[2] = 1;
        **/
        
        PEDIDO pedido = new PEDIDO();
        pedido.setComprador("ola@gmail.com");
        pedido.setVendedor("Mercadona@company.es");
        pedido.setVoluntario("jose@gmail.com");
        pedido.setId_pedido(0);
        // pedido.setProductos(b);

    

        pedidodao.create(pedido);

        

        PEDIDO pedido2 = pedidodao.read("ola@gmail.com");
       
        
        assertEquals(pedido2.getComprador(), pedido.getComprador());
        assertEquals(pedido2.getVendedor(), "Mercadona@company.es");
        assertEquals(pedido2.getVoluntario(),"jose@gmail.com");
        assertNotNull(pedido.getId_pedido());
        //assertEquals(pedido2.getProductos(), pedido.getProductos());

        

        pedido.setVoluntario("juan@gmail.com");
        pedidodao.update(pedido);
        pedido2 = pedidodao.read("jose@gmail.com");
        assertEquals(pedido2.getVoluntario(), "juan@gmail.com");
        assertEquals(pedido2.getVendedor(), "Mercadona@company.es");
        
       
        pedidodao.delete(pedido);
        pedido2 = pedidodao.read("ana@gmail.com");
        assertNull(pedido2);


		}
	}
