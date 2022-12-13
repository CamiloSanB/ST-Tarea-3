package biblioteca;

import java.util.Calendar;
import java.util.List;

public class Biblioteca {

	private List<Libro> libros;
	
	
	
	public Biblioteca(List<Libro> libros) {
		//super();
		this.libros = libros;
	}


	//Obtiene la lista de libros
	public String getLibros() {
		//String lista_libros = String.join("\n", libros.toString());
		String lista_libros = "";
		for(int i=0; i < libros.size(); i++) {
			lista_libros += i + ") " +libros.get(i).toString() + "\n";
		}
		//System.out.println(lista_libros);
		return lista_libros;
	}
	
	//Buscar libros por autor
	public String buscarPorAutor(String autor) {
		String lista_libros = "";
		for(int i=0; i < libros.size(); i++) {
			String autor_actual = libros.get(i).getAutor();
			if(autor_actual.contains(autor)) {
				lista_libros += i + ") " +libros.get(i).toString() + "\n";
			}
		}
		if (lista_libros.isBlank()) {
			return "No se ha encontrado libros de ese Autor.";
		}
		return lista_libros;
	}
	
	public String buscarPorTitulo(String titulo) {
		String lista_libros = "";
		for (int i=0; i < libros.size(); i++) {
			String titulo_actual = libros.get(i).getTitulo();
			if(titulo_actual.contains(titulo)) {
				lista_libros += i + ") " +libros.get(i).toString() + "\n";
			}
		}
		if (lista_libros.isBlank()) {
			return "No se ha encontrado libros con ese título.";
		}
		return lista_libros;
	}
	
	public String buscarPorIsbn(String isbn) {
		String lista_libros = "";
		for (int i=0; i < libros.size(); i++) {
			String isbn_actual = libros.get(i).getIsbn();
			if(isbn_actual.contains(isbn)) {
				lista_libros += i + ") " +libros.get(i).toString() + "\n";
			}
		}
		if (lista_libros.isBlank()) {
			return "No se ha encontrado libros con ese código ISBN.";
		}
		return lista_libros;
	}
	
	//Registrar/Agregar libro
	public void addLibro(Libro libro) {
		libros.add(libro);
	}
	
	public String getLibroDetalle(int numero) {
		if(libros.size() > numero && numero >-1) {
			Libro libro = libros.get(numero);
			return libro.toString();
		}
		else {
			return "No existe libro.";
		}
	}
	
	//Editar estado de libro por su posicion
	public void cambiarEstadoAPrestado(int numero) {
		if(libros.size()>numero && numero >-1) {
			Libro libro = libros.get(numero);
			libro.setEstadoPrestado();
		}
	}
	public void cambiarEstadoADisponible(int numero) {
		if(libros.size()>numero && numero >-1) {
			Libro libro = libros.get(numero);
			libro.setEstadoDisponible();
		}
	}
	public void cambiarEstadoAExtraviado(int numero) {
		if(libros.size()>numero && numero >-1) {
			Libro libro = libros.get(numero);
			libro.setEstadoExtraviado();
		}
	}
	
	public void deleteLibro(int numero) {
		if(libros.size() > numero && numero >-1) {
			libros.remove(numero);
		}
	}

	//Metodos para cambiar datos de libros por su numero
	public void editarTitulo(String nuevo_titulo, int numero) {
		if(libros.size()>numero && numero > -1){
			Libro libro = libros.get(numero);
			libro.setTitulo(nuevo_titulo);
		}
	}
	public void editarAutor(String[] nuevo_autor, int numero) {
		if(libros.size()>numero && numero > -1) {
			Libro libro = libros.get(numero);
			libro.setAutor(nuevo_autor);
		}
	}
	public void editarFecha(int dia, int mes, int ano, int numero) {
		if(libros.size()>numero && numero > -1) {
			if(dia > 0 && dia <32 && mes > 0 && mes < 13) {
				Libro libro = libros.get(numero);
				libro.setFecha(dia, mes, ano);
			}
		}
	}
	public void editarNumeroPaginas(int paginas, int numero) {
		if(libros.size()>numero && numero > -1) {
			Libro libro = libros.get(numero);
			libro.setNumero_paginas(paginas);
		}
	}
	public void editarEditorial(String editorial, int numero) {
		if(libros.size()>numero && numero > -1) {
			Libro libro = libros.get(numero);
			libro.setEditorial(editorial);
		}
	}
	public void editarGenero(String genero, int numero) {
		if(libros.size()>numero && numero > -1) {
			Libro libro = libros.get(numero);
			libro.setGenero(genero);
		}
	}
	public void editarIsbn(String isbn, int numero) {
		if(libros.size()>numero && numero > -1) {
			Libro libro = libros.get(numero);
			libro.setIsbn(isbn);
		}
	}
	public void editarUbicacion(int piso, int numero_pasillo, int estante, int x, int y, int numero) {
		if(libros.size()>numero && numero > -1) {
			Ubicacion nueva_ubicacion = new Ubicacion(piso, numero_pasillo, estante, x, y);
			Libro libro = libros.get(numero);
			libro.setUbicacion(nueva_ubicacion);
			
		}
	}
	public void editarDescripcion(String descripcion, int numero) {
		if(libros.size()>numero && numero > -1) {
			Libro libro = libros.get(numero);
			libro.setDescripcion(descripcion);
		}
	}
}
