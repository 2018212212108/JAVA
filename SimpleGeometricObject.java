public class SimpleGeometricObject {
	private String color = "white";//对象的颜色
	private boolean filled;//表明对象是否填充颜色
	private java.util.Date dateCreated;//对象创建的日期

	public SimpleGeometricObject() {
		dateCreated = new java.util.Date();
	}

	public SimpleGeometricObject(String color,boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public java.util.Date getDateCreated(){
		return dateCreated;
	}

	public String toString() {
		return "created on" + dateCreated + "\ncolor: " + color + " and filled: "+ filled;
	}
}