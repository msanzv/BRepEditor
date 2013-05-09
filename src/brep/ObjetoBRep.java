package brep;

import java.util.ArrayList;

public class ObjetoBRep {
	
	private String nombre;
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	private ArrayList<Arista> aristas = new ArrayList<Arista>();
	private ArrayList<Cara> caras = new ArrayList<Cara>();
	private ArrayList<Color> colores = new ArrayList<Color>(); 
	private ArrayList<Restriccion> restricciones = new ArrayList<Restriccion>();
	
	
	public ObjetoBRep(){
	}
	
	public ObjetoBRep(String nombre){
		this.nombre = nombre;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "";
		str += "Objeto " + this.nombre + "\n";
		str += "\n# Vertices\n";
		for(int i=0; i<getVertices().size(); i++)	
			str += this.getVertices().get(i).toString() + "\n";
		str += "\n# Aristas\n";
		for(int i=0; i<getAristas().size(); i++) 	
			str += this.getAristas().get(i).toString() + "\n";
		str += "\n# Caras\n";
		for(int i=0; i<getCaras().size(); i++) 		
			str += this.getCaras().get(i).toString() + "\n";
		str += "\n# Colores\n";
		for(int i=0; i<getColores().size(); i++) 	
			str += this.getColores().get(i).toString() + "\n";
		return str;
	}
	

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the vertices
	 */
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}

	/**
	 * @param vertices the vertices to set
	 */
	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}

	/**
	 * @return the aristas
	 */
	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	/**
	 * @param aristas the aristas to set
	 */
	public void setAristas(ArrayList<Arista> aristas) {
		this.aristas = aristas;
	}

	/**
	 * @return the caras
	 */
	public ArrayList<Cara> getCaras() {
		return caras;
	}

	/**
	 * @param caras the caras to set
	 */
	public void setCaras(ArrayList<Cara> caras) {
		this.caras = caras;
	}

	/**
	 * @return the colores
	 */
	public ArrayList<Color> getColores() {
		return colores;
	}

	/**
	 * @param colores the colores to set
	 */
	public void setColores(ArrayList<Color> colores) {
		this.colores = colores;
	}

	/**
	 * @return the restricciones
	 */
	public ArrayList<Restriccion> getRestricciones() {
		return restricciones;
	}

	/**
	 * @param restricciones the restricciones to set
	 */
	public void setRestricciones(ArrayList<Restriccion> restricciones) {
		this.restricciones = restricciones;
	}
	
	public Restriccion getRestById(String id){
		for(int i=0; i<restricciones.size(); i++){
			if(restricciones.get(i).getId().equalsIgnoreCase(id)){
				return restricciones.get(i);
			}
		}
		return null;
	}


}
