package biblioteca;

import java.util.Calendar;

public class Libro {

	private String titulo;
	private String[] autor;
	private Calendar fecha;
	private int numero_paginas;
	private String editorial;
	private String genero;
	private String isbn;
	private Ubicacion ubicacion;
	private String estado;
	private String descripcion;
	
	//Constructor
	public Libro(String titulo, String[] autor, Calendar fecha, int numero_paginas, String editorial, String genero,
			String isbn, Ubicacion ubicacion, String descripcion) {
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = fecha;
		this.numero_paginas = numero_paginas;
		this.editorial = editorial;
		this.genero = genero;
		this.isbn = isbn;
		this.ubicacion = ubicacion;
		this.estado = "disponible";
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		String libro = this.getTitulo() + ". Por "+ this.getAutor()+ ". Fecha de Edición: "+ this.getFecha()+
				". Número de páginas: "+ this.getNumero_paginas()+ ". Editorial: "+ this.getEditorial() + 
				". Género: "+this.getGenero()+ ". ISBN: "+this.getIsbn()+
				". Ubicación "+this.getUbicacion()+ ". Estado: "+this.getEstado()+". Descripción: "+
				this.getDescripcion();
		return libro;
	}

	//Getters
	public String getAutor() {
		return String.join(", ", autor);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getFecha() {
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int mes = fecha.get(Calendar.MONTH) + 1;
		int ano = fecha.get(Calendar.YEAR);
		String fecha = dia + "-" + mes + "-" + ano;
		return fecha;
	}

	public int getNumero_paginas() {
		return numero_paginas;
	}

	public String getEditorial() {
		return editorial;
	}

	public String getGenero() {
		return genero;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getUbicacion() {
		return ubicacion.toString();
	}

	public String getEstado() {
		return estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	
	//setters
	public void setTitulo(String titulo) {
		if(titulo.isBlank()) {
			
		}
		else {
			this.titulo = titulo;
		}
	}
	
	public void setAutor(String[] autores) {
		this.autor = autores;
	}

	public void setNumero_paginas(int numero_paginas) {
		if(numero_paginas > 0) {
			this.numero_paginas = numero_paginas;
		}
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	//Cambios de estado
	public void setEstadoDisponible() {
		this.estado = "disponible";
	}
	public void setEstadoPrestado() {
		this.estado = "prestado";
	}
	public void setEstadoExtraviado() {
		this.estado = "extraviado";
	}
	
	public void setFecha(int dia, int mes, int ano) {
		if(dia > 0 && dia <32 && mes > 0 && mes < 13) {
			Calendar nueva_fecha = Calendar.getInstance();
			nueva_fecha.set(ano, mes-1, dia);
			this.fecha = nueva_fecha;
		}
	}
	
}
