package biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLibro {
	
	Libro libro;
	
	@BeforeEach
	public void initLibro() {
		String titulo = "DUNE";
		String[] autores = new String[1];
		autores[0] = "Frank Herbert";
		Calendar fecha = Calendar.getInstance();
		fecha.set(Calendar.YEAR, 2022);
		fecha.set(Calendar.MONTH, Calendar.APRIL);
		fecha.set(Calendar.DAY_OF_MONTH, 1);
		int numero_paginas = 782;
		String editorial = "DEBOLSILLO";
		String genero = "Ciencia Ficción";
		String isbn = "978-987-725-411-2";
		Ubicacion ubicacion = new Ubicacion(1,1, 5, 15,10);
		String descripcion = "En el desértico planeta Arrakis, el agua es el bien más";
		
		libro = new Libro(titulo, autores, fecha, numero_paginas, editorial, genero, isbn, ubicacion, descripcion);
		
	}

	@Test
	public void test_toStringLibro() {
		String esperado = "DUNE. Por Frank Herbert. Fecha de Edición: 1-4-2022. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más";
		assertEquals(esperado, libro.toString());
	}
	
	@Test
	public void test_toStringLibroVariosAutores() {
		String[] autores = new String[3];
		autores[0] = "Autor Uno";
		autores[1] = "Autor Dos";
		autores[2] = "Autor Tres";
		libro.setAutor(autores);
		
		String esperado = "DUNE. Por Autor Uno, Autor Dos, Autor Tres. Fecha de Edición: 1-4-2022. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más";
		
		assertEquals(esperado, libro.toString());
		
	}
	
	@Test
	public void test_settersLibro() {
		String nuevo_titulo = "Nuevo Titulo";
		libro.setTitulo(nuevo_titulo);
		assertEquals(libro.getTitulo(), "Nuevo Titulo");
		
		libro.setTitulo("   ");
		assertEquals("Nuevo Titulo", libro.getTitulo() );
		
		libro.setNumero_paginas(600);
		assertEquals(libro.getNumero_paginas(), 600);
		libro.setNumero_paginas(-600);
		assertEquals(libro.getNumero_paginas(), 600);
		
		libro.setEditorial("Nueva Editorial");
		assertEquals(libro.getEditorial(), "Nueva Editorial");
		
		libro.setGenero("Político");
		assertEquals(libro.getGenero(), "Político");
		
		libro.setIsbn("666-666-12");
		assertEquals(libro.getIsbn(), "666-666-12");
		
		Ubicacion nueva_ubicacion = new Ubicacion(4,4,4,1,1);
		libro.setUbicacion(nueva_ubicacion);
		assertEquals(libro.getUbicacion(), nueva_ubicacion.toString());
		
		libro.setDescripcion("Nueva Des");
		assertEquals(libro.getDescripcion(), "Nueva Des");
	}
	
	@Test
	public void test_cambioEstado() {
		libro.setEstadoPrestado();
		assertEquals(libro.getEstado(), "prestado");
		
		libro.setEstadoExtraviado();
		assertEquals(libro.getEstado(), "extraviado");
		
		libro.setEstadoDisponible();
		assertEquals(libro.getEstado(), "disponible");
	}
	
	@Test
	public void test_cambioFecha() {
		libro.setFecha(1, 3, 2000);
		assertEquals(libro.getFecha(), "1-3-2000");
		
		libro.setFecha(0, 3, 2000);
		assertEquals(libro.getFecha(), "1-3-2000");
		libro.setFecha(32, 3, 2000);
		assertEquals(libro.getFecha(), "1-3-2000");
		
		libro.setFecha(1, 0, 2000);
		assertEquals(libro.getFecha(), "1-3-2000");
		libro.setFecha(1, 13, 2000);
		assertEquals(libro.getFecha(), "1-3-2000");
	}
}
