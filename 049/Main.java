import java.math.*;
import java.util.*;

class Solver {
  public boolean is_prime(int n) {
    if (n == 2) {
      return true;
    }
    for (int i = 2; i * i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public ArrayList<Integer> gen_primes(int min, int max) {
    ArrayList<Integer> primes = new ArrayList<Integer>();
    String p;
    for (int i = min; i <= max; i += 2) {
      if (is_prime(i)) {
        primes.add(i);
      }
    }
    return primes;
  }

  public ArrayList<ArrayList<Integer>> gen_primes_set(int min, int max) {
    ArrayList<ArrayList<Integer>> primes = new ArrayList<ArrayList<Integer>>();
    String p;
    for (int i = min; i <= max; i += 2) {
      if (is_prime(i)) {
        p = Integer.toString(i);
        ArrayList<Integer> per = new ArrayList<Integer>();
        for (char c : p.toCharArray()) {
          per.add(Character.getNumericValue(c));
        }
        Collections.sort(per);
        primes.add(per);
      }
    }
    return primes;
  }

  public String solve() {
    ArrayList<ArrayList<Integer>> primes = gen_primes_set(1001, 10000);
    ArrayList<Integer> primes2 = gen_primes(1001, 10000);
    ArrayList<Integer> p;
    int dist;
    int dist_n;
    ArrayList<Integer> indices = new ArrayList<Integer>();
    ArrayList<Integer> dists = new ArrayList<Integer>();
    for (int i = 0; i < primes.size(); i++) {
      p = primes.get(i);
      indices.clear();
      indices.add(primes2.get(i));
      for (int j = i + 1; j < primes.size(); j++) {
        if (p.equals(primes.get(j))) {
          indices.add(primes2.get(j));
        }
      }
      if (indices.size() < 4) {
        continue;
      }
      int count;
      int next;
      ArrayList<Integer> pers = new ArrayList<Integer>();
      for (int j = 0; j < indices.size(); j++) {
        for (int k = j + 1; k < indices.size(); k++) {
          count = 1;
          dist = indices.get(k) - indices.get(j);
          pers.clear();
          pers.add(indices.get(j));
          next = indices.get(k);
          while (next <= Collections.max(indices)) {
            if (indices.contains(next)) {
              pers.add(next);
              count++;
              if (count >= 3) {
                System.out.println(pers);
              }
            } else {
              break;
            }
            next += dist;
          }
        }
      }
    }
    return "";
  }
}

class Main {
  public static void main(String[] args) {
    Solver s = new Solver();
    System.out.println(s.solve());
  }
}
