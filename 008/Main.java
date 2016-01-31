import java.math.*;
import java.util.*;
import java.io.*;

class Solver {
	private BigInteger prod(String digits) {
		BigInteger sum = new BigInteger("1");
		for (int i = 0; i < digits.length(); i++) {
			sum = sum.multiply(new BigInteger(digits.substring(i, i + 1)));
		}
		return sum;
	}

	public BigInteger solve() {
		try {
			FileReader fr = new FileReader("number.txt");
			BufferedReader br = new BufferedReader(fr);
			String digits = br.readLine();
			BigInteger max = new BigInteger("0");
			BigInteger product;
			for (int i = 0; i + 13 < digits.length(); i++) {
				product = prod(digits.substring(i, i + 13));
				if (product.compareTo(max) > 0) {
					max = product;
				}
			}
			return max;
		} catch (IOException e) {
			return new BigInteger("0");
		}
	}
}

class Main {
	public static void main(String[] args) {
		Solver s = new Solver();
		System.out.println(s.solve());
	}
}
