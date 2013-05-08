package brep;

public class Arista {

	private String tag = "a";
	private String nombre;
	private Vertice v1, v2;
	private Cara caraIzq, caraDer;
	private Arista aristasIzq[], aristasDer[];
	
	
	@Override
	public String toString(){
		String str = "a ";
		//str += this.name + " " + v1.getName() + " " + v2.getName();
		return str;	
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
	 * @return the v1
	 */
	public Vertice getV1() {
		return v1;
	}

	/**
	 * @param v1 the v1 to set
	 */
	public void setV1(Vertice v1) {
		this.v1 = v1;
	}

	/**
	 * @return the v2
	 */
	public Vertice getV2() {
		return v2;
	}

	/**
	 * @param v2 the v2 to set
	 */
	public void setV2(Vertice v2) {
		this.v2 = v2;
	}

	/**
	 * @return the caraIzq
	 */
	public Cara getCaraIzq() {
		return caraIzq;
	}

	/**
	 * @param caraIzq the caraIzq to set
	 */
	public void setCaraIzq(Cara caraIzq) {
		this.caraIzq = caraIzq;
	}

	/**
	 * @return the caraDer
	 */
	public Cara getCaraDer() {
		return caraDer;
	}

	/**
	 * @param caraDer the caraDer to set
	 */
	public void setCaraDer(Cara caraDer) {
		this.caraDer = caraDer;
	}

	/**
	 * @return the aristasIzq
	 */
	public Arista[] getAristasIzq() {
		return aristasIzq;
	}

	/**
	 * @param aristasIzq the aristasIzq to set
	 */
	public void setAristasIzq(Arista[] aristasIzq) {
		this.aristasIzq = aristasIzq;
	}

	/**
	 * @return the aristasDer
	 */
	public Arista[] getAristasDer() {
		return aristasDer;
	}

	/**
	 * @param aristasDer the aristasDer to set
	 */
	public void setAristasDer(Arista[] aristasDer) {
		this.aristasDer = aristasDer;
	}


}
