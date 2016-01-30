import java.math.*;
import java.util.*;

class Solver {
	public int solve() {
		int n = 20;
		int i = 0;
		while (true) {
			for (i = 19; i >= 2; i -= 1) {
				if (n % i != 0) {
					break;
				}
			}
			if (i <= 2) {
				return n;
			}
			n += 20;
		}
	}
}

class Main {
	public static void main(String[] args) {
		Solver s = new Solver();
		System.out.println(s.solve());
	}
}
