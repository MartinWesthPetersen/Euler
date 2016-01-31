import java.math.*;
import java.util.*;

class Solver {
	public BigInteger solve() {
		BigInteger sum_squares = new BigInteger("0");
		BigInteger square_sum = new BigInteger("0");
		BigInteger counter = new BigInteger("0");
		for (counter = new BigInteger("0"); counter.compareTo(BigInteger.valueOf(100)) <= 0; 
			counter = counter.add(BigInteger.valueOf(1))) {
			sum_squares = sum_squares.add(counter.pow(2));
			square_sum = square_sum.add(counter);
		}
		square_sum = square_sum.pow(2);
		return square_sum.subtract(sum_squares);
	}
}

class Main {
	public static void main(String[] args) {
		Solver s = new Solver();
		System.out.println(s.solve());
	}
}
