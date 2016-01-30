import java.math.*;

class ReciprocSolver {
	public String get_unit_fraction(int x, int precision) {
		int rest = 1;
		int digit = 0;
		StringBuilder s = new StringBuilder();
		for (int p = 1; p < precision; p++) {
			rest = rest * 10;
			digit = rest / x;
			s.append(Integer.toString(digit));
			rest = rest - digit * x;
		}
		return s.toString();
	}
	public int find_cycle_length(int x) {
		String decimals = this.get_unit_fraction(x, x * 10);
		int len = 0;
		for (int i = 0; i < decimals.length() - 2; i++) {
			len = Math.max(len, decimals.substring(i + 3).indexOf(decimals.substring(i, i + 3)));
		}
		return len + 2;
	}
}

class Main {
	public static void main(String[] args) {
		ReciprocSolver s = new ReciprocSolver();
		int max = 0;
		int len = 0;
		int res = 0;
		for (int d = 1; d < 1000; d++) {
			len = s.find_cycle_length(d);
			if (len > max) {
				max = len;
				res = d;
			}  
		}
		System.out.println(res);
	}
}
