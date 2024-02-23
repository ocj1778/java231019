package xyz.itwill.el;

public class Car {
	private String modelName;
	private String carColor;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String modelName, String carColor) {
		super();
		this.modelName = modelName;
		this.carColor = carColor;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
}
