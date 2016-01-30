import java.math.*;

class Solver {
  public long pmult(long n, long m) {
    String s = Long.toString(n);
    s = s.substring(Math.max(s.length() - 10, 0));
    return Long.valueOf(s) * m;
  }
/*  public int padd(int n, int m) {
    String s = Integer.toString(n);
    s = s.substring(Math.max(s.length - 10, 0));
    return Integer.parseInt(s) + m;
  }
*/
  public long solve() {
    long res = 0L;
    long sum;
    long j;
    for (long i = 1L; i <= 1000L; i++) {
      sum = 1L;
      j = 0L;
      while (j++ < i) {
        sum = pmult(sum, i);
      }
      res += sum;
    }
    String s = Long.toString(res);
    s = s.substring(Math.max(s.length() - 10, 0));
    return Long.valueOf(s);
  }
}

class Main {
  public static void main(String[] args) {
    Solver s = new Solver();
    System.out.println(s.solve());
  }
}
