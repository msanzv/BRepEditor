package brep;

/**
 * @author mario
 *
 */
public class Restriccion {
	
	private String id, tag;
	private int min, max, step;
	private int value;

	/**
	 * Constructor vacio
	 */
	public Restriccion() {
	}

	/**
	 * Constructor inicializado
	 * 
	 * @param id
	 * @param tag
	 * @param min
	 * @param max
	 * @param step
	 * @param value
	 */
	public Restriccion(String id, String tag, int min, int max, int step, int value) {
		super();
		this.id = id;
		this.tag = tag;
		this.min = min;
		this.max = max;
		this.step = step;
		this.value = value;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}

	/**
	 * @return the step
	 */
	public int getStep() {
		return step;
	}

	/**
	 * @param step the step to set
	 */
	public void setStep(int step) {
		this.step = step;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

}