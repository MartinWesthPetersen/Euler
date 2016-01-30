import java.math.*;
import java.util.*;
import java.util.Arrays;

class Solver {
	public int solve() {
		int t = 200;
		int counter = 0;
		for (int a = t; a >= 0; a -= 100) {
			for (int b = a; b >= 0; b -= 50) {
				for (int c = b; c >= 0; c -= 20) {
					for (int d = c; d >= 0; d -= 10) {
						for (int e = d; e >= 0; e -= 5) {
							for (int f = e; f >= 0; f -= 2) {
								counter++;
							}
						}
					}
				}
			}
		}
		return counter;
	}
}

class Main {
	public static void main(String[] args) {
		Solver s = new Solver();
		System.out.println(s.solve());
	}
}
