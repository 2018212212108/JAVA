public class RegularPolygon {

	private int n;//多边形边数
	private double side;//边的长度
	private double x;//中点xz坐标
	private double y;//中点y坐标

	//带默认值的无参构造方法
	RegularPolygon(){
		n = 3;
		side = 1;
		x = 0;
		y = 0;
	}
	//带指定边数，边长度，中心在（0，0）的构造方法
	RegularPolygon(int n,double side){
		this.n = n;
		this.side = side;
		x = 0;
		y = 0;
	}
	//带指定边数，边长度，中心在（x，y）的构造方法
	RegularPolygon(int n,double side,double x,double y){
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}

	public int getn() {
		return n;
	}

	public void setn(int n) {
		this.n = n;
	}

	public double getside(){
		return side;
	}

	public void setside(double side) {
		this.side = side;
	}

	public double getx() {
		return x;
	}

	public double gety() {
		return y;
	}

	public void getxy(double x,double y) {
		this.x = x;
		this.y = y;
	}

	public double getPermeter() {
		return n*side;
	}

	public double getArea() {
		return (n*1.0*side*side)/(4.0*Math.tan(Math.PI/n*1.0));
	}

	public static void main(String[] args) {
		RegularPolygon p1 = new RegularPolygon();
		RegularPolygon p2 = new RegularPolygon(6,4);
		RegularPolygon p3 = new RegularPolygon(10,4,5.6,7.8);

		System.out.println("p1 perimeter: " + p1.getPermeter() + "; area: " + p1.getArea() + ".");
		System.out.println("p2 perimeter: " + p2.getPermeter() + "; area: " + p2.getArea() + ".");
		System.out.println("p3 perimeter: " + p3.getPermeter() + "; area: " + p3.getArea() + ".");

	}

}
