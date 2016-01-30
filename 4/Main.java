import java.math.*;
import java.util.*;
import java.lang.StringBuilder;

class Solver {
	private boolean is_palindrome(int n) {
		String digits = Integer.toString(n);
		String head = new StringBuilder(digits.substring(0, digits.length() / 2)).reverse().toString();
		return head.equals(digits.substring(digits.length() - digits.length() / 2));
	}

  public int solve() {
   	int max = 0;
		int product = 0;
		for (int i = 100; i < 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				product = i * j;
				if (product > max && is_palindrome(product)) {
					max = product;
				}
			}
		}
		return max;
  }
}

class Main {
  public static void main(String[] args) {
    Solver s = new Solver();
    System.out.println(s.solve());
  }
}
