import java.math.*;
import java.util.*;

class Solver {

  public List<Integer> prime_list;

  public boolean is_prime(int n) {
    if (n == 2) {
      return true;
    }
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public List<Integer> gen_primes(int limit) {
    ArrayList<Integer> primes = new ArrayList<Integer>();
    primes.add(2);
    for (int i = 3; i <= limit; i += 2) {
      if (is_prime(i)) {
        primes.add(i);
      }
    }
  return primes;
  }
  
  public int calc_max_length(int prime) {
    int j;
    int sum;
    int max_length = 0;
    for (int i = 0; i < prime_list.size(); i++) {
      sum = 0;
      j = i;
      while (sum < prime && j < prime_list.size()) {
        sum += prime_list.get(j);
        j++;
      }
      if (sum == prime && j - i > max_length) {
        max_length = j - i;
      }
    }
    return max_length;
  }

  public int solve() {
    prime_list = gen_primes(1000000);
    int sum;
    int max = 0;
    int prime = 0;
    int j;
    for (int i = 0; i < prime_list.size(); i++) {
//      System.out.println(i);
      sum = 0;
      for (j = i; j < prime_list.size() - 1 && sum + prime_list.get(j) < 1000000; j++) {
        sum += prime_list.get(j);
      }
/*      System.out.println(j);
      System.out.println(prime_list.size()); */
      for (int k = j; k > i; k--) {
        if (is_prime(sum) && k - i > max) {
          max = k - i;
          prime = sum;
          break;
        }
        sum -= prime_list.get(k);
      }
    }
    return prime;
  }
 /*   prime_list =  gen_primes(1000000);
    int max_res = 0;
    int max_prime = 0;
    int length = 0;
    for (int i = prime_list.size() - 1; i >= 0; i--) {
      length = calc_max_length(prime_list.get(i));
      if (prime_list.get(i) == 881813) {
        return 0;
      }
//      System.out.println(prime_list.get(i));
      if (length > max_res) {
        max_res = length;
        max_prime = prime_list.get(i);
      }
    }
    return max_prime;
  } */
}

class Main {
  public static void main(String[] args) {
    Solver s = new Solver();
    System.out.println(s.solve());
  }
}
