package recursion;

public class PrintLinearly {
	
	public static void print1ToN(int x, int N) {
		if (x > N) return ;
		System.out.println(x);
		print1ToN(x+1,N);
	}
	
	public static void printNto1(int x, int N) {
		if (x > N) return ;
		printNto1(x+1,N);
		System.out.println(x);
		
	}
	
	
	public static void print1ToNReverse(int x, int N) {
		
	}
	
	public static void main(String[] args) {
		printNto1(1, 5);
	}

}
