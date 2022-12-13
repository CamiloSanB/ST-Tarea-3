package biblioteca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) {
		//Crea Lista de Libro vacia y con él, crea la biblioteca (vacia) que usará el sistema
		List<Libro> libros_aux = new ArrayList<Libro>();
		Biblioteca biblioteca = new Biblioteca(libros_aux);
		
		String titulo3 = "DUNE";
		String[] autores3 = new String[1];
		autores3[0] = "Frank Herbert";
		Calendar fecha3 = Calendar.getInstance();
		fecha3.set(2022, 3, 1);
		int numero_paginas3 = 782;
		String editorial3 = "DEBOLSILLO";
		String genero3 = "Ciencia Ficción";
		String isbn3 = "978-987-725-411-2";
		Ubicacion ubicacion3 = new Ubicacion(1,1, 5, 15,10);
		String descripcion3 = "En el desértico planeta Arrakis, el agua es el bien más";
		Libro libro1 = new Libro(titulo3, autores3, fecha3, numero_paginas3, editorial3, genero3, isbn3, ubicacion3, descripcion3);
		biblioteca.addLibro(libro1);
		String titulo2 = "A Song of Ice and Fire I";
		String[] autore2 = new String[1];
		autore2[0] = "George R.R. Martin";
		int numero_paginas2 = 795;
		String editorial2 = "DEBOLSILLO";
		String genero2 = "Fantasía";
		String isbn2 = "978-987-725-147-0";
		Ubicacion ubicacion2 = new Ubicacion(1,3, 1, 30,50);
		String descripcion2 = "En el legendario mundo de los Siete Reinos, donde el verano puede durar";
		Libro libro2 = new Libro(titulo2, autore2, fecha3, numero_paginas2, editorial2, genero2, isbn2, ubicacion2, descripcion2);
		biblioteca.addLibro(libro2);
		
		Scanner input = new Scanner(System.in);
		int input_menu = 0;
		
		while (input_menu != 6) {
			System.out.println("Bienvenido a la Aplicación...");
			System.out.println("Menu de opciones disponibles: \n");
			System.out.println("\t1. Registrar Libro");
			System.out.println("\t2. Buscar Libro");
			System.out.println("\t3. Editar Libro");
			System.out.println("\t4. Eliminar registro de Libro");
			System.out.println("\t5. Cambio de Estado de Libro");
			System.out.println("\t6. Salir\n");
			
			System.out.print("Ingrese el número de la opción a usar: ");
			input_menu = input.nextInt();
			input.nextLine();
			
			//Registrar Libro
			if(input_menu == 1) {
				System.out.print("\n\nBienvenido al Registro de libros.");
				System.out.print("Ingrese los campos a medida que continue (el estado por defecto es disponible).\n");
				System.out.print("Titulo: ");
				String titulo = input.nextLine();
				
				System.out.print("Cantidad de autores: ");
				input_menu = input.nextInt();
				input.nextLine();
				if(input_menu >0) {
					String[] autores = new String[input_menu];
					for(int i=0; i < input_menu; i++) {
						int i_aux = i +1;
						System.out.print("Ingrese nombre de autor "+ i_aux+ ": " );
						String autor = input.nextLine();
						autores[i] = autor;
					}
				System.out.println("Fecha de la edición (ingrese el número correspondiente");
				System.out.print("Año: ");
				int year = input.nextInt();
				input.nextLine();
				System.out.print("Mes: ");
				int mes = input.nextInt();
				input.nextLine();
				System.out.print("Día: ");
				int dia = input.nextInt();
				input.nextLine();
				System.out.print("Número de páginas: ");
				int n_paginas = input.nextInt();
				input.nextLine();
				System.out.print("Editorial: ");
				String editorial = input.nextLine();
				System.out.print("Género: ");
				String genero = input.nextLine();
				System.out.print("Código ISBN: ");
				String isbn = input.nextLine();
				System.out.println("A continuación, ingrese el número de los detalles de la ubicación del libro");
				System.out.print("Piso de la biblioteca: ");
				int piso = input.nextInt();
				input.nextLine();
				System.out.print("Número de pasillo: ");
				int n_pasillo = input.nextInt();
				input.nextLine();
				System.out.print("Número de estante: ");
				int estante = input.nextInt();
				input.nextLine();
				System.out.print("Posicion x: ");
				int x = input.nextInt();
				input.nextLine();
				System.out.print("Posicion y: ");
				int y = input.nextInt();
				input.nextLine();
				System.out.print("Descripción: ");
				String descripcion = input.nextLine();
				
				Calendar fecha = Calendar.getInstance();
				fecha.set(year, mes, dia);
				
				Ubicacion ubicacion = new Ubicacion(piso, n_pasillo, estante, x , y);
				
				Libro nuevo_libro = new Libro(titulo, autores, fecha, n_paginas, editorial, genero, isbn, ubicacion, descripcion);
				biblioteca.addLibro(nuevo_libro);
				System.out.println(nuevo_libro.toString());
				}
			}
			
			else if(input_menu == 2) {
				System.out.println("Busqueda de libros. Use la \"id\" (numero inicial del libro) para editar, eliminar y cambiar estado en las otras opciones.");
				System.out.println("1) Por Titulo");
				System.out.println("2) Por Autor");
				System.out.println("3) Por código ISBN");
				System.out.println("4) Menú principal");
				System.out.print("Ingrese número de opción: ");
				input_menu = input.nextInt();
				input.nextLine();
				if(input_menu == 1) {
					System.out.print("Ingrese titulo a buscar: ");
					String titulo = input.nextLine();
					System.out.println(biblioteca.buscarPorTitulo(titulo));
					System.out.print("Aprete Enter para continuar");
					input.nextLine();
				}
				else if(input_menu == 2) {
					System.out.print("Ingrese Autor a buscar: ");
					String titulo = input.nextLine();
					System.out.println(biblioteca.buscarPorAutor(titulo));
					System.out.print("Aprete Enter para continuar");
					input.nextLine();
				}
				else if(input_menu == 3) {
					System.out.print("Ingrese ISBN a buscar: ");
					String titulo = input.nextLine();
					System.out.println(biblioteca.buscarPorIsbn(titulo));
					System.out.print("Aprete Enter para continuar");
					input.nextLine();
				}
				else {
					System.out.println("Usted ha ingresado 4 o una opción inexistente. Volviendo a menú principal...");
				}
			}
			
			else if(input_menu==3) {
				System.out.println("Debe conocer la id del registro a editar. Si no lo conoce, regrese al menu principal y busque en la opción \"Buscar libro \" ");
				System.out.println("1) Editar por ID");
				System.out.println("2 u otra) Regresar");
				System.out.print("Ingrese opcion: ");
				input_menu = input.nextInt();
				input.nextLine();
				if(input_menu==1) {
					System.out.print("Ingrese id: ");
					int id = input.nextInt();
					input.nextLine();
					System.out.println(biblioteca.getLibroDetalle(id));
					System.out.println("1) Titulo");
					System.out.println("2) Autor(es)");
					System.out.println("3) Fecha de edición");
					System.out.println("4) Número de páginas");
					System.out.println("5) Editorial");
					System.out.println("6) Género");
					System.out.println("7) ISBN");
					System.out.println("8) Ubicación");
					System.out.println("9) Descripción");
					System.out.println("10 u otra) Volver a menu principal");
					System.out.print("Ingrese opción: ");
					input_menu = input.nextInt();
					input.nextLine();
					if(input_menu==1) {
						System.out.print("Nuevo Titulo: ");
						String nuevo_titulo = input.nextLine();
						biblioteca.editarTitulo(nuevo_titulo, id);
					}
					else if(input_menu==2) {
						System.out.print("Cantidad de autores: ");
						int n_autores = input.nextInt();
						input.nextLine();
						String[] autores = new String[n_autores];
						for(int i=0; i<n_autores; i++) {
							int i_aux = i +1;
							System.out.print("Ingrese nombre de autor "+ i_aux+ ": " );
							String autor = input.nextLine();
							autores[i] = autor;
						}
						biblioteca.editarAutor(autores, id);
					}
					else if(input_menu == 3) {
						System.out.print("Año: ");
						int year = input.nextInt();
						input.nextLine();
						System.out.print("Mes: ");
						int mes = input.nextInt();
						input.nextLine();
						System.out.print("Día: ");
						int dia = input.nextInt();
						input.nextLine();
						biblioteca.editarFecha(dia, mes, year, id);
					}
					else if(input_menu==4) {
						System.out.print("Cantidad de paginas: ");
						int n_paginas = input.nextInt();
						input.nextLine();
						biblioteca.editarNumeroPaginas(n_paginas, id);
					}
					else if(input_menu==5) {
						System.out.print("Ingrese Editorial: ");
						String editoria = input.nextLine();
						biblioteca.editarEditorial(editoria, id);
					}
					else if(input_menu==6) {
						System.out.print("Ingrese Género: ");
						String genero = input.nextLine();
						biblioteca.editarGenero(genero, id);
					}
					else if(input_menu==7) {
						System.out.print("Ingrese ISBN: ");
						String isbn = input.nextLine();
						biblioteca.editarIsbn(isbn, id);
					}
					else if(input_menu==8) {
						System.out.print("Piso de la biblioteca: ");
						int piso = input.nextInt();
						input.nextLine();
						System.out.print("Número de pasillo: ");
						int n_pasillo = input.nextInt();
						input.nextLine();
						System.out.print("Número de estante: ");
						int estante = input.nextInt();
						input.nextLine();
						System.out.print("Posicion x: ");
						int x = input.nextInt();
						input.nextLine();
						System.out.print("Posicion y: ");
						int y = input.nextInt();
						input.nextLine();
						biblioteca.editarUbicacion(piso, n_pasillo, estante, x, y, id);
					}
					else if(input_menu==9) {
						System.out.print("Ingrese Descripción: ");
						String descripcion = input.nextLine();
						biblioteca.editarDescripcion(descripcion, id);
					}
				}
			}
			else if(input_menu==4) {
				System.out.println("Debe conocer la id del registro a eliminar. Si no lo conoce, regrese al menu principal y busque en la opción \"Buscar libro \" ");
				System.out.println("1) Eliminar por ID");
				System.out.println("2 u otra) Regresar");
				System.out.print("Ingrese opcion: ");
				input_menu = input.nextInt();
				input.nextLine();
				if(input_menu==1) {
					System.out.print("Ingrese id de registro a eliminar: ");
					int id = input.nextInt();
					input.nextLine();
					System.out.println("Eliminando " + biblioteca.getLibroDetalle(id));
					biblioteca.deleteLibro(id);
					System.out.println("Eliminado");
					System.out.print("Aprete Enter para continuar.");
					input.nextLine();
				}
			}
			else if(input_menu==5) {
				System.out.println("Debe conocer la id del registro a cambiar de estado. Si no lo conoce, regrese al menu principal y busque en la opción \"Buscar libro \" ");
				System.out.println("1) Cambio de estado por ID");
				System.out.println("2 u otra) Regresar");
				System.out.print("Ingrese opcion: ");
				input_menu = input.nextInt();
				input.nextLine();
				if(input_menu==1) {
					System.out.print("Ingrese id de registro a cambiar de estado: ");
					int id = input.nextInt();
					input.nextLine();
					System.out.println("Cambiando de estado de " + biblioteca.getLibroDetalle(id));
					System.out.println("1) Cambio a disponible");
					System.out.println("2) Cambio a prestado");
					System.out.println("3) Cambio a extraviado");
					System.out.println("4 u otra) Regresar");
					System.out.print("Ingrese opcion: ");
					input_menu = input.nextInt();
					input.nextLine();
					if(input_menu==1) {
						System.out.println("Cambiado a estado: disponible.");
						biblioteca.cambiarEstadoADisponible(id);
					}
					else if(input_menu==2) {
						System.out.println("Cambiado a estado: prestado.");
						biblioteca.cambiarEstadoAPrestado(id);
					}
					else if(input_menu==3) {
						System.out.println("Cambiado a estado: extraviado.");
						biblioteca.cambiarEstadoAExtraviado(id);
					}
					System.out.print("Aprete Enter para continuar.");
					input.nextLine();
				}
			}
			if(input_menu==6) {
				break;
			}
			
		}
		
		System.out.println("Saliendo...");
		input.close();
		

	}

}
