import java.util.Scanner;

public class LinearEquation {

	private double a,b,c,d,e,f;

	LinearEquation(){

	}

	LinearEquation(double a,double b,double c,double d,double e,double f){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}

	public double geta() {
		return a;
	}

	public double getb() {
		return b;
	}

	public double getc() {
		return c;
	}

	public double getd() {
		return d;
	}

	public double gete() {
		return e;
	}

	public double getf() {
		return f;
	}

	public boolean isSolvable() {
		if(a*d - b*c == 0) {
			return false;
		}else {
			return true;
		}
	}

	public double getX() {
		if(a*d - b*c == 0) {
			return -1;
		}else {
			return (e*d - b*f) / (a*d - b*c);
		}
	}

	public double getY() {
		if(a*d - b*c == 0) {
			return -1;
		}else {
			return (a*f - e*c) / (a*d - b*c);
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter x1,y1,x2,y2,x3,y3,x4,y4:");
		double x1,y1,x2,y2,x3,y3,x4,y4;
		double a,b,c,d,e,f;
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		x3 = input.nextDouble();
		y3 = input.nextDouble();
		x4 = input.nextDouble();
		y4 = input.nextDouble();

		a = y1 - y2;
		b = x1 - x2;
		c = y3 - y4;
		d = x3 - x4;
		e = (y1-y2)*x1 - (x1-x2)*y1;
		f = (y3-y4)*x3 - (x3-x4)*y3;

		LinearEquation point = new LinearEquation(a,b,c,d,e,f);
		if(point.isSolvable()) {
			System.out.println("The interesting point is at ("+point.getX()+","+point.getY()+")");
		}else {
			System.out.println("The two lines are parallel");
		}
	}

}