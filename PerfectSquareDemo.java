import java.util.Scanner;
import java.util.ArrayList;

public class PerfectSquareDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer m: ");
		int num = input.nextInt();

		ArrayList<Integer> factorList = new ArrayList<>();
		ArrayList<Integer> oddFactorList = new ArrayList<>();
		getFactor(factorList,num);
		getOddFactor(factorList,oddFactorList);

		int answer = 1;
		for(int i:oddFactorList) {
			answer = answer * i;
		}

		System.out.println("The smallest number n for m m * n to be a perfect square is " + answer*num);
	}

	public static void getFactor(ArrayList<Integer> List,int num) {
		while(true) {
			boolean flag = true;
			for(int i=2;i<=(int)Math.sqrt(num);i++) {
				if(num % i == 0) {
					List.add(i);
					num = num / i;
					flag = false;
					break;
				}
			}
			if(flag) {
				List.add(num);
				break;
			}
		}
	}

	public static void getOddFactor(ArrayList<Integer> List1,ArrayList<Integer> List2) {
		//去重
		ArrayList<Integer> list = new ArrayList<>();
		for(int t:List1) {
			if(!list.contains(t)) {
				list.add(t);
			}
		}
		//查找奇数个数的元素放入List2中
		for(int t:list) {
			int count = 0;
			for(int x:List1) {
				if(t == x) {
					count++;
				}
			}
			if(count % 2 != 0) {
				List2.add(t);
			}
		}
	}
}