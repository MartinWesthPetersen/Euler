import java.math.*;
import java.util.*;

class Solver {
	public boolean is_prime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				if (n != i) {
					return false;
				} else {
					return true;
				}
			}
		}
		return true;
	}
	public boolean prime_factor(int n) {
		int number = n;
		Set<Integer> primes = new HashSet<Integer>();
		while (true) {
			if (is_prime(number)) {
				primes.add(number);
				return (primes.size() >= 4);
			}
			for (int i = 2; i <= number / 2; i++) {
				if (number % i == 0) {
					primes.add(i);
					number = number / i;
					break;
				}
			}
		}
	}
	public int solve() {
		int number = 1;
		while (true) {
			if (prime_factor(number)) {
				if (prime_factor(number + 1)) {
					if (prime_factor(number + 2)) {
						if (prime_factor(number + 3)) {
							return number;
						}
					}
				}
			}
			number++;
		}
	}
}

class Main {
	public static void main(String[] args) {
		Solver s = new Solver();
		System.out.println(s.solve());
	}
}
