import java.math.*;
import java.util.*;

class Solver {
	public BigInteger solve() {
		int a = 0;
		int b = 0;
		int c = 0;
		double c_double = 0.0;
		for (a = 1; a <= 500; a++) {
			for (b = a; b <= 500; b++) {
				c_double = Math.sqrt(Math.pow((double) a, 2.0) + Math.pow((double) b, 2.0));
				c = (int) c_double;
				if (c_double == Math.floor(c_double) && b < c) {
					if (a + b + c == 1000) {
						BigInteger res = new BigInteger("1");
						res = res.multiply(new BigInteger(Integer.toString(a)));
						res = res.multiply(new BigInteger(Integer.toString(b)));
						res = res.multiply(new BigInteger(Integer.toString(c)));
						return res;
					}
				}
			}
		}
		return BigInteger.valueOf(0);
	}
}

class Main {
	public static void main(String[] args) {
		Solver s = new Solver();
		System.out.println(s.solve());
	}
}
