package Agentzia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class agentziaTest {

	Tiketak t = new Tiketak(1,"33333333C", 250, "150A", "Bai", "Turista", "Bai" );
	
	@Test
	void testDeskontua() {	
		assertEquals(90.0, Tiketak.kalkulatuDesk(t, 10), 0.01);
	}
	@Test
	void testPrezioFinala() {
		assertEquals(10, Tiketak.deskontuaFun(10)); 
        assertEquals(20, Tiketak.deskontuaFun(35)); 
        assertEquals(30, Tiketak.deskontuaFun(85));
        assertEquals(0, Tiketak.deskontuaFun(0));
	}
	

}
