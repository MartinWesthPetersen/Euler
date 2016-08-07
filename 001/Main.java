class Solver {
	public int solve() {
		int sum = 0;
		for (int i = 0; i < 1000; i += 3) {
			sum += i;
		}
		for (int i = 0; i < 1000; i += 5) {
			if (i % 15 != 0) {
				sum += i;
			}
		}
		return sum;
	}
}


class Main {
	public static void main(String[] args) {
		Solver s = new Solver();
		System.out.println("Hej);
		System.out.println(s.solve());
	}
}
