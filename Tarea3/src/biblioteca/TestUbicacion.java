package biblioteca;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestUbicacion {
	
	Ubicacion ubicacion;
	
	@BeforeEach
	public void initUbicacion() {
		ubicacion = new Ubicacion(1, 3, 1, 25, 20);
	}

	@Test
	public void test_toStringUbicacion(){
		assertEquals("piso: 1; número de pasillo: 3; estante: 1; posición: (25, 20)", ubicacion.toString());
	}
	
	@Test
	public void test_editarUbicacion() {
		//original version
		assertEquals("piso: 1; número de pasillo: 3; estante: 1; posición: (25, 20)", ubicacion.toString());
		
		
		ubicacion.setPiso(2);
		assertEquals("piso: 2; número de pasillo: 3; estante: 1; posición: (25, 20)", ubicacion.toString());
		
		ubicacion.setNumero_pasillo(1);
		assertEquals("piso: 2; número de pasillo: 1; estante: 1; posición: (25, 20)", ubicacion.toString());
		
		ubicacion.setEstante(3);
		assertEquals("piso: 2; número de pasillo: 1; estante: 3; posición: (25, 20)", ubicacion.toString());
		
		ubicacion.setPosicion(20,15);
		assertEquals("piso: 2; número de pasillo: 1; estante: 3; posición: (20, 15)", ubicacion.toString());
		
	}
	
	
}
