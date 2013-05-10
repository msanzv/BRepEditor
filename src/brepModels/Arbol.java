
package brepModels;

import java.util.ArrayList;

import brep.ObjetoBRep;
import brep.Restriccion;
import brep.Vertice;

/**
 * @author mario
 *
 */
public class Arbol extends ObjetoBRep {
	
	public final String IMG_PATH = "res/Arbol.png";
	public final String TXT_PATH = "res/Arbol.txt";
    public final String HTAG = "Altura: ";
    public final String RTAG = "Radio: ";
	
	public final int H1MIN = 1, H1MAX = 10, H1STEP = 1;
	public final int H2MIN = 1, H2MAX = 10, H2STEP = 1;
	public final int H3MIN = 1, H3MAX = 10, H3STEP = 1;
	public final int H4MIN = 1, H4MAX = 10, H4STEP = 1;
	public final int R1MIN = 1, R1MAX =  6, R1STEP = 1;
	public final int R2MIN = 3, R2MAX =  8, R2STEP = 1;
	public final int R3MIN = 5, R3MAX = 10, R3STEP = 1;
	public final int R4MIN = 1, R4MAX =  4, R4STEP = 1;

	private int h1, h2, h3, h4;
	private int r1, r2, r3, r4;

	/**
	 * Constructor vacio
	 */
	public Arbol() {
	}
	
	/**
	 * Constructor con nombre
	 * @param nombre
	 */
	public Arbol(String nombre) {
		super(nombre);
	}
	
	/**
	 * Especifica todas las restricciones propias de la figura
	 */
	public void initRestricciones(){
		
		ArrayList<Restriccion> restricciones = this.getRestricciones();
		
		restricciones.add(new Restriccion("h1", "Altura: ", 1, 10, 1, 3));
		restricciones.add(new Restriccion("h2", "Altura: ", 1, 10, 1, 2));
		restricciones.add(new Restriccion("h3", "Altura: ", 1, 10, 1, 2));
		restricciones.add(new Restriccion("h4", "Altura: ", 1, 10, 1, 2));
		
		restricciones.add(new Restriccion("r1", "Radio: ", 1,  6, 1, 2));
		restricciones.add(new Restriccion("r2", "Radio: ", 3,  8, 1, 4));
		restricciones.add(new Restriccion("r3", "Radio: ", 5, 10, 1, 6));
		restricciones.add(new Restriccion("r4", "Radio: ", 1,  4, 1, 2));
		
		this.setRestricciones(restricciones);
	}
	
	/**
	 * Calcula todos los vertices del arbol a partir de los valores
	 * de alturas y radios seleccionados en la interfaz
	 */
	public void calcularVertices(int h1, int h2, int h3, int h4, int r1, int r2, int r3, int r4){
		
		ArrayList<Vertice> vertices = this.getVertices();
		
		vertices.get(0).setXYZ(0, h1+h2+h3+h4, 0);

		vertices.get(1).setXYZ(  r1,    h2+h3+h4,   r1);
		vertices.get(2).setXYZ(  r1,    h2+h3+h4,  -r1);
		vertices.get(3).setXYZ( -r1,    h2+h3+h4,  -r1);
		vertices.get(4).setXYZ( -r1,    h2+h3+h4,   r1);
		vertices.get(5).setXYZ(  r1/2,  h2+h3+h4,   r1/2);
		vertices.get(6).setXYZ(  r1/2,  h2+h3+h4,  -r1/2);
		vertices.get(7).setXYZ( -r1/2,  h2+h3+h4,  -r1/2);
		vertices.get(8).setXYZ( -r1/2,  h2+h3+h4,   r1/2);
		vertices.get(9).setXYZ(  r2,    h3+h4,      r2);
		vertices.get(10).setXYZ( r2,    h3+h4,     -r2);
		vertices.get(11).setXYZ(-r2,    h3+h4,     -r2);
		vertices.get(12).setXYZ(-r2,    h3+h4,      r2);
		vertices.get(13).setXYZ( r2/2,  h3+h4,      r2/2);
		vertices.get(14).setXYZ( r2/2,  h3+h4,     -r2/2);
		vertices.get(15).setXYZ(-r2/2,  h3+h4,     -r2/2);
		vertices.get(16).setXYZ(-r2/2,  h3+h4,      r2/2);
		vertices.get(17).setXYZ( r3,    h4,         r3);
		vertices.get(18).setXYZ( r3,    h4,        -r3);
		vertices.get(19).setXYZ(-r3,    h4,        -r3);
		vertices.get(20).setXYZ(-r3,    h4,         r3);
		vertices.get(21).setXYZ( r3/2,  h4,         r3/2);
		vertices.get(22).setXYZ( r3/2,  h4,        -r3/2);
		vertices.get(23).setXYZ(-r3/2,  h4,        -r3/2);
		vertices.get(24).setXYZ(-r3/2,  h4,         r3/2);
		vertices.get(25).setXYZ( r4,     0,         r4);
		vertices.get(26).setXYZ( r4,     0,        -r4);
		vertices.get(27).setXYZ(-r4,     0,        -r4);
		vertices.get(28).setXYZ(-r4,     0,         r4);
		
		this.setVertices(vertices);
	}
	
	
	/**
	 * Especifica todos los parametros
	 * 
	 * @param h1
	 * @param h2
	 * @param h3
	 * @param h4
	 * @param r1
	 * @param r2
	 * @param r3
	 * @param r4
	 */
	public void setAllHR(int h1, int h2, int h3, int h4, 
						 int r1, int r2, int r3, int r4) {
		
		this.getRestById("h1").setValue(h1);
		this.getRestById("h2").setValue(h2);
		this.getRestById("h3").setValue(h3);
		this.getRestById("h4").setValue(h4);
		this.getRestById("r1").setValue(r1);
		this.getRestById("r2").setValue(r2);
		this.getRestById("r3").setValue(r3);
		this.getRestById("r4").setValue(r4);
	}
	
	/**
	 * @return the h1
	 */
	public int getH1() {
		return h1;
	}

	/**
	 * @param h1 the h1 to set
	 */
	public void setH1(int h1) {
		this.h1 = h1;
	}

	/**
	 * @return the h2
	 */
	public int getH2() {
		return h2;
	}

	/**
	 * @param h2 the h2 to set
	 */
	public void setH2(int h2) {
		this.h2 = h2;
	}

	/**
	 * @return the h3
	 */
	public int getH3() {
		return h3;
	}

	/**
	 * @param h3 the h3 to set
	 */
	public void setH3(int h3) {
		this.h3 = h3;
	}

	/**
	 * @return the h4
	 */
	public int getH4() {
		return h4;
	}

	/**
	 * @param h4 the h4 to set
	 */
	public void setH4(int h4) {
		this.h4 = h4;
	}

	/**
	 * @return the r1
	 */
	public int getR1() {
		return r1;
	}

	/**
	 * @param r1 the r1 to set
	 */
	public void setR1(int r1) {
		this.r1 = r1;
	}

	/**
	 * @return the r2
	 */
	public int getR2() {
		return r2;
	}

	/**
	 * @param r2 the r2 to set
	 */
	public void setR2(int r2) {
		this.r2 = r2;
	}

	/**
	 * @return the r3
	 */
	public int getR3() {
		return r3;
	}

	/**
	 * @param r3 the r3 to set
	 */
	public void setR3(int r3) {
		this.r3 = r3;
	}

	/**
	 * @return the r4
	 */
	public int getR4() {
		return r4;
	}

	/**
	 * @param r4 the r4 to set
	 */
	public void setR4(int r4) {
		this.r4 = r4;
	}

}
