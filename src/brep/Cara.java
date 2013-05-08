package brep;

import java.util.ArrayList;

public class Cara {
	
	private String tag = "c";
	private String nombre;
	private ArrayList<String> aristas = new ArrayList<String>();
	
	/**
	 * Constructor vacio
	 */
	public Cara() {
		super();
	}

	/**
	 * Constructor con nombre
	 * 
	 * @param nombre
	 */
	public Cara(String nombre) {
		super();
		this.nombre = nombre;
	}


	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
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
	 * @return the aristas
	 */
	public ArrayList<String> getAristas() {
		return aristas;
	}
	
	/**
	 * @param aristas the aristas to set
	 */
	public void setAristas(ArrayList<String> aristas) {
		this.aristas = aristas;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "";
		str += tag + " " + nombre;
		for(int i=0; i<aristas.size(); i++)
			str += " " + aristas.get(i);
		return str;
	}

}
