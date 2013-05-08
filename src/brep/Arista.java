package brep;

public class Arista {

	private String tag = "a";
	private String nombre;
	private String v1, v2;
	private String caraIzq, caraDer;
	private String aristasIzq[], aristasDer[];
	
	public Arista() {
		super();
	}

	/**
	 * @param nombre
	 * @param v1
	 * @param v2
	 * @param caraIzq
	 * @param caraDer
	 */
	public Arista(String nombre, String v1, String v2, String caraIzq, String caraDer) {
		super();
		this.nombre = nombre;
		this.v1 = v1;
		this.v2 = v2;
		this.caraIzq = caraIzq;
		this.caraDer = caraDer;
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
	public String getV1() {
		return v1;
	}

	/**
	 * @param v1 the v1 to set
	 */
	public void setV1(String v1) {
		this.v1 = v1;
	}

	/**
	 * @return the v2
	 */
	public String getV2() {
		return v2;
	}

	/**
	 * @param v2 the v2 to set
	 */
	public void setV2(String v2) {
		this.v2 = v2;
	}

	/**
	 * @return the caraIzq
	 */
	public String getCaraIzq() {
		return caraIzq;
	}

	/**
	 * @param caraIzq the caraIzq to set
	 */
	public void setCaraIzq(String caraIzq) {
		this.caraIzq = caraIzq;
	}

	/**
	 * @return the caraDer
	 */
	public String getCaraDer() {
		return caraDer;
	}

	/**
	 * @param caraDer the caraDer to set
	 */
	public void setCaraDer(String caraDer) {
		this.caraDer = caraDer;
	}

	/**
	 * @return the aristasIzq
	 */
	public String[] getAristasIzq() {
		return aristasIzq;
	}

	/**
	 * @param aristasIzq the aristasIzq to set
	 */
	public void setAristasIzq(String[] aristasIzq) {
		this.aristasIzq = aristasIzq;
	}

	/**
	 * @return the aristasDer
	 */
	public String[] getAristasDer() {
		return aristasDer;
	}

	/**
	 * @param aristasDer the aristasDer to set
	 */
	public void setAristasDer(String[] aristasDer) {
		this.aristasDer = aristasDer;
	}

	@Override
	public String toString(){
		String str = "";
		str += tag + " " + nombre + " " + v1 + " " + v2 + " ";
		str += caraIzq + " " + caraDer + " ";
		str += aristasIzq[0] + " " + aristasIzq[1] + " " + aristasDer[0] + " " + aristasDer[1];
		return str;	
	}

}
