package biblioteca;

//Clase para manejar la ubicación de un libro
public class Ubicacion {
	private int piso;
	private int numero_pasillo;
	private int estante;
	private int x;
	private int y;
	
	//Constructor
	public Ubicacion(int piso, int numero_pasillo, int estante, int x, int y) {
		//super();
		this.piso = piso;
		this.numero_pasillo = numero_pasillo;
		this.estante = estante;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "piso: " + piso + "; número de pasillo: " + numero_pasillo + "; estante: " + estante + "; posición: (" + x
				+ ", " + y + ")";
	}

	//Setters
	public void setPiso(int piso) {
		this.piso = piso;
	}

	public void setNumero_pasillo(int numero_pasillo) {
		this.numero_pasillo = numero_pasillo;
	}

	public void setEstante(int estante) {
		this.estante = estante;
	}
	
	public void setPosicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
