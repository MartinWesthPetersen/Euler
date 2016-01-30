import java.math.*;
import java.util.*;

class Solver {
  public int solve() {
		int sum = 2;
		int fib = 0;
		List<Integer> fibs = new ArrayList<Integer>();
		fibs.add(1);
		fibs.add(2);
		while (fibs.get(fibs.size() - 1) < 4000000) {
			fib = fibs.get(fibs.size() - 2) + fibs.get(fibs.size() - 1);
			fibs.add(fib);
			if (fib % 2 == 0) {
				sum += fib;
			}
		}
		return sum;	
  }
}

class Main {
  public static void main(String[] args) {
    Solver s = new Solver();
    System.out.println(s.solve());
  }
}
