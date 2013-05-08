package brep;

import java.util.ArrayList;

public class Color {
	
	private String tag;
	private int nombre;
	private float r, g, b;
	private ArrayList<Cara> caras = new ArrayList<Cara>();
	
	public Color(ArrayList<Cara> caras){
		for(int i=0; i<caras.size(); i++){
			this.caras.add(caras.get(i));
		}
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
	public int getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the r
	 */
	public float getR() {
		return r;
	}
	/**
	 * @param r the r to set
	 */
	public void setR(float r) {
		this.r = r;
	}
	/**
	 * @return the g
	 */
	public float getG() {
		return g;
	}
	/**
	 * @param g the g to set
	 */
	public void setG(float g) {
		this.g = g;
	}
	/**
	 * @return the b
	 */
	public float getB() {
		return b;
	}
	/**
	 * @param b the b to set
	 */
	public void setB(float b) {
		this.b = b;
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

}
