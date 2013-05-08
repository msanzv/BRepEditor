package brep;

public class Vertice {
	
	private String tag = "v";
	private String nombre;
	private float x;
	private float y;
	private float z;
	

	public Vertice(String nombre, float x, float y, float z){
		this.nombre = nombre;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return tag + " " + nombre + " " + x + " " + y + " " + z;
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
	 * @return the name
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the name to set
	 */
	public void setNombre(String name) {
		this.nombre = name;
	}

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * @return the z
	 */
	public float getZ() {
		return z;
	}
	
	/**
	 * @param z the z to set
	 */
	public void setZ(float z) {
		this.z = z;
	}
	
	/**
	 * @param z the z to set
	 */
	public void setXYZ(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

}
