package biblioteca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBibioteca {
	Biblioteca biblioteca;

	@BeforeEach
	public void initBiblioteca() {
		List<Libro> libros = new ArrayList<Libro>();
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
		Libro libro1 = new Libro(titulo, autores, fecha, numero_paginas, editorial, genero, isbn, ubicacion, descripcion);
		libros.add(libro1);
		
		String titulo2 = "A Song of Ice and Fire I";
		String[] autore2 = new String[1];
		autore2[0] = "George R.R. Martin";
		//Calendar fech2 = Calendar.getInstance();
		//fecha.set(Calendar.YEAR, 2022);
		//fecha.set(Calendar.MONTH, Calendar.APRIL);
		//fecha.set(Calendar.DAY_OF_MONTH, 1);
		int numero_paginas2 = 795;
		String editorial2 = "DEBOLSILLO";
		String genero2 = "Fantasía";
		String isbn2 = "978-987-725-147-0";
		Ubicacion ubicacion2 = new Ubicacion(1,3, 1, 30,50);
		String descripcion2 = "En el legendario mundo de los Siete Reinos, donde el verano puede durar";
		Libro libro2 = new Libro(titulo2, autore2, fecha, numero_paginas2, editorial2, genero2, isbn2, ubicacion2, descripcion2);
		libros.add(libro2);
		
		biblioteca = new Biblioteca(libros);
	}
	
	@Test 
	public void test_getLibros() {
		String esperado = "0) DUNE. Por Frank Herbert. Fecha de Edición: 1-4-2022. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más\n"+
				"1) A Song of Ice and Fire I. Por George R.R. Martin. Fecha de Edición: 1-4-2022. Número de páginas: 795"+
				". Editorial: DEBOLSILLO. Género: Fantasía. ISBN: 978-987-725-147-0."+
				" Ubicación piso: 1; número de pasillo: 3; estante: 1; posición: (30, 50). Estado: disponible. Descripción: "+
				"En el legendario mundo de los Siete Reinos, donde el verano puede durar\n";
		assertEquals(esperado, biblioteca.getLibros());
	}
	
	@Test
	public void test_getLibrosPorAutor() {
		//Se crea un nuevo libro con el mismo autor de uno de los libros por defecto.
		String titulo = "DUNE 2";
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
		Libro libro1 = new Libro(titulo, autores, fecha, numero_paginas, editorial, genero, isbn, ubicacion, descripcion);
		
		biblioteca.addLibro(libro1);
		
		String esperado = "0) DUNE. Por Frank Herbert. Fecha de Edición: 1-4-2022. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más\n"+
				"2) DUNE 2. Por Frank Herbert. Fecha de Edición: 1-4-2022. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más\n";
		
		String autor_buscado = "Frank Herbert";
		assertEquals(esperado, biblioteca.buscarPorAutor(autor_buscado));//busqueda exacta
		assertEquals(esperado, biblioteca.buscarPorAutor("Frank"));//si contiene
		
		assertEquals("No se ha encontrado libros de ese Autor.", biblioteca.buscarPorAutor("Personaje que no existe"));
	}
	
	@Test
	public void test_getLibrosPorTitulo() {
		String titulo = "DUNE";
		String[] autores = new String[1];
		autores[0] = "Frank Herbert hijo";
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
		Libro libro1 = new Libro(titulo, autores, fecha, numero_paginas, editorial, genero, isbn, ubicacion, descripcion);
		biblioteca.addLibro(libro1);
		
		String esperado = "0) DUNE. Por Frank Herbert. Fecha de Edición: 1-4-2022. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más\n"+
				"2) DUNE. Por Frank Herbert hijo. Fecha de Edición: 1-4-2022. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más\n";
		
		assertEquals(esperado, biblioteca.buscarPorTitulo("DUNE"));
		assertEquals(esperado, biblioteca.buscarPorTitulo("DU"));
		assertEquals("No se ha encontrado libros con ese título.", biblioteca.buscarPorTitulo("Libro que no existe"));
	}
	
	@Test public void test_getLibrosPorISBN() {
		String titulo = "DUNE 2";
		String[] autores = new String[1];
		autores[0] = "Frank Herbert hijo";
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
		Libro libro1 = new Libro(titulo, autores, fecha, numero_paginas, editorial, genero, isbn, ubicacion, descripcion);
		biblioteca.addLibro(libro1);
		
		String esperado = "0) DUNE. Por Frank Herbert. Fecha de Edición: 1-4-2022. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más\n"+
				"2) DUNE 2. Por Frank Herbert hijo. Fecha de Edición: 1-4-2022. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más\n";
		
		assertEquals(esperado, biblioteca.buscarPorIsbn("978-987-725-411-2"));
		assertEquals(esperado, biblioteca.buscarPorIsbn("987-725-411"));
		assertEquals("No se ha encontrado libros con ese código ISBN.", biblioteca.buscarPorIsbn("ISBN que no existe"));
	}
	
	@Test
	public void test_cambiarEstadoLibro() {
		String esperado = "DUNE. Por Frank Herbert. Fecha de Edición: 1-4-2022. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: prestado. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más";
		biblioteca.cambiarEstadoAPrestado(0);
		assertEquals(esperado, biblioteca.getLibroDetalle(0));
		biblioteca.cambiarEstadoAPrestado(3);
		biblioteca.cambiarEstadoAPrestado(-1);
		assertEquals("No existe libro.", biblioteca.getLibroDetalle(3));
		assertEquals("No existe libro.", biblioteca.getLibroDetalle(-1));
		
		esperado = "DUNE. Por Frank Herbert. Fecha de Edición: 1-4-2022. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más";
		biblioteca.cambiarEstadoADisponible(0);
		biblioteca.cambiarEstadoADisponible(3);
		biblioteca.cambiarEstadoADisponible(-1);
		assertEquals(esperado, biblioteca.getLibroDetalle(0));
		
		esperado = "DUNE. Por Frank Herbert. Fecha de Edición: 1-4-2022. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: extraviado. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más";
		biblioteca.cambiarEstadoAExtraviado(0);
		biblioteca.cambiarEstadoAExtraviado(3);
		biblioteca.cambiarEstadoAExtraviado(-1);
		assertEquals(esperado, biblioteca.getLibroDetalle(0));
	}
	
	@Test
	public void test_ElminarRegistroLibro() {
		String libro2 = biblioteca.getLibroDetalle(1); //conseguir detalle de libro2
		biblioteca.deleteLibro(0); //la posicion 0 es la de DUNE. Deberia agarrar la siguiente, que se guarda la salida en libro2
		biblioteca.deleteLibro(1);
		biblioteca.deleteLibro(-1);
		assertEquals(libro2, biblioteca.getLibroDetalle(0));
	}
	
	@Test
	public void test_EditarDatosLibroPorNumero() {
		String esperado = "Nuevo Titulo. Por Frank Herbert. Fecha de Edición: 1-4-2022. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más";
		biblioteca.editarTitulo("Nuevo Titulo", 0);
		biblioteca.editarTitulo("Nuevo Titulo", 3);
		biblioteca.editarTitulo("Nuevo Titulo", -1);
		assertEquals(esperado, biblioteca.getLibroDetalle(0));
		
		esperado = "Nuevo Titulo. Por Frank 1, Frank 2. Fecha de Edición: 1-4-2022. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más";
		String[] nuevos_autores = new String[2];
		nuevos_autores[0] = "Frank 1";
		nuevos_autores[1] = "Frank 2";
		biblioteca.editarAutor(nuevos_autores, 0);
		biblioteca.editarAutor(nuevos_autores, 3);
		biblioteca.editarAutor(nuevos_autores, -1);
		assertEquals(esperado, biblioteca.getLibroDetalle(0));
		
		esperado = "Nuevo Titulo. Por Frank 1, Frank 2. Fecha de Edición: 5-5-2020. Número de páginas: 782. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más";
		biblioteca.editarFecha(5, 5, 2020, 0);
		biblioteca.editarFecha(5, 5, 2019, 3);
		biblioteca.editarFecha(5, 5, 2021, -1);
		biblioteca.editarFecha(32, 5, 2020, 0);
		biblioteca.editarFecha(0, 5, 2020, 0);
		biblioteca.editarFecha(5, 13, 2020, 0);
		biblioteca.editarFecha(5, 0, 2020, 0);
		assertEquals(esperado, biblioteca.getLibroDetalle(0));
		
		esperado = "Nuevo Titulo. Por Frank 1, Frank 2. Fecha de Edición: 5-5-2020. Número de páginas: 600. "
				+ "Editorial: DEBOLSILLO. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más";
		biblioteca.editarNumeroPaginas(600, 0);
		biblioteca.editarNumeroPaginas(600, -1);
		biblioteca.editarNumeroPaginas(600, 3);
		assertEquals(esperado, biblioteca.getLibroDetalle(0));
		
		esperado = "Nuevo Titulo. Por Frank 1, Frank 2. Fecha de Edición: 5-5-2020. Número de páginas: 600. "
				+ "Editorial: Nueva Editorial. Género: Ciencia Ficción. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más";
		biblioteca.editarEditorial("Nueva Editorial", 0);
		biblioteca.editarEditorial("Nueva Editoriala", 3);
		biblioteca.editarEditorial("Nueva Editoriale", -1);
		assertEquals(esperado, biblioteca.getLibroDetalle(0));
		
		esperado = "Nuevo Titulo. Por Frank 1, Frank 2. Fecha de Edición: 5-5-2020. Número de páginas: 600. "
				+ "Editorial: Nueva Editorial. Género: Nuevo Genero. ISBN: 978-987-725-411-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más";
		biblioteca.editarGenero("Nuevo Genero", 0);
		biblioteca.editarGenero("Cosa", -1);
		biblioteca.editarGenero("cosasas", 3);
		assertEquals(esperado, biblioteca.getLibroDetalle(0));
		
		esperado = "Nuevo Titulo. Por Frank 1, Frank 2. Fecha de Edición: 5-5-2020. Número de páginas: 600. "
				+ "Editorial: Nueva Editorial. Género: Nuevo Genero. ISBN: 978-987-725-420-2."
				+ " Ubicación piso: 1; número de pasillo: 1; estante: 5; posición: (15, 10). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más";
		biblioteca.editarIsbn("978-987-725-420-2", 0);
		biblioteca.editarIsbn("978-987-725-420-2321", 3);
		biblioteca.editarIsbn("978-987-725-420-4", -1);
		assertEquals(esperado, biblioteca.getLibroDetalle(0));
		
		esperado = "Nuevo Titulo. Por Frank 1, Frank 2. Fecha de Edición: 5-5-2020. Número de páginas: 600. "
				+ "Editorial: Nueva Editorial. Género: Nuevo Genero. ISBN: 978-987-725-420-2."
				+ " Ubicación piso: 2; número de pasillo: 2; estante: 2; posición: (4, 11). Estado: disponible. Descripción: "
				+ "En el desértico planeta Arrakis, el agua es el bien más";
		biblioteca.editarUbicacion(2, 2, 2, 4, 11, 0);
		biblioteca.editarUbicacion(2, 2, 2, 5, 11, -1);
		biblioteca.editarUbicacion(2, 2, 2, 4, 13, 3);
		assertEquals(esperado, biblioteca.getLibroDetalle(0));
		
		esperado = "Nuevo Titulo. Por Frank 1, Frank 2. Fecha de Edición: 5-5-2020. Número de páginas: 600. "
				+ "Editorial: Nueva Editorial. Género: Nuevo Genero. ISBN: 978-987-725-420-2."
				+ " Ubicación piso: 2; número de pasillo: 2; estante: 2; posición: (4, 11). Estado: disponible. Descripción: "
				+ "Nueva descripcion";
		biblioteca.editarDescripcion("Nueva descripcion", 0);
		biblioteca.editarDescripcion("Nueva descripcioaan", -1);
		biblioteca.editarDescripcion("Nueva descripcionasd", 3);
		assertEquals(esperado, biblioteca.getLibroDetalle(0));
	}
}
