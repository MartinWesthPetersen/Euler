import java.math.*;
import java.util.*;

class Solver {
	public boolean is_prime(BigInteger n) {
		BigInteger two = new BigInteger("2");
		if (n.compareTo(two) == 0) {
			return true;
		}
		for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(n) == -1; i = i.add(two)) {
			if (n.mod(i).compareTo(BigInteger.ZERO) == 0) {
				return false;
			}
		}
		return true;
	}
  public BigInteger solve() {
    BigInteger number = new BigInteger("600851475143");
		BigInteger prime = new BigInteger("2");
		BigInteger two = new BigInteger("2");
		BigInteger factor = BigInteger.ZERO;
		while (true) {
			if (prime.multiply(two).compareTo(number) == 1) {
				factor = factor.compareTo(number) < 0 ? number : factor;
				break;
			}
			if (is_prime(prime) && number.mod(prime).compareTo(BigInteger.ZERO) == 0) {
				number = number.divide(prime);
				factor = factor.compareTo(prime) < 0 ? prime : factor;
				prime = two;
			} else {
				prime = prime.add(BigInteger.ONE);
			}
		}
		return factor;
  }
}

class Main {
  public static void main(String[] args) {
    Solver s = new Solver();
    System.out.println(s.solve());
  }
}
