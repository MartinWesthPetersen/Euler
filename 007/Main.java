import java.math.*;
import java.util.*;

class Solver {
	private boolean is_prime(int n) {
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public int solve() {
		int counter = 1;
		int prime = 3;
		while (counter != 10001) {
			if (is_prime(prime)) {
				counter++;
			}
			prime += 2;
		}
		return prime - 2;
	}
}

class Main {
	public static void main(String[] args) {
		Solver s = new Solver();
		System.out.println(s.solve());
	}
}
