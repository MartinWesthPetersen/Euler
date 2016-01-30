import java.math.*;

class Solver {
	public boolean is_prime(int n) {
		if (n == 2 || n == 3) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		if (n % 3 == 0) {
			return false;
		}
		for (int i = 5; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	public int solve() {
		int number = 33;
		int limit = 0;
		double base;
		double square;
		int pos_prim;
		while (true) {
			number = number + 2;
			base = Math.floor(Math.sqrt((double) number / 2));
			while (base > 0) {
				pos_prim = number - 2 * ((int) (base * base));
				if (is_prime(pos_prim)) {
					break;
				}
				base--;
			}
			if (base == 0 && (! is_prime(number))) {
				return number;
			}
		}
	}
}

class Main {
	public static void main(String[] args) {
		Solver s = new Solver();
		System.out.println(s.solve());
	}
}
