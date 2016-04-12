public class Main {

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		int[] coins = {1,2,5};
		System.out.println(minCoins(12,coins));
	}

	int minCoins(int money, int[] coins) {
		int[] best = new int[money + 1];
		best[0] = 0;

		for (int c = 1; c <= money; c++) {
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < coins.length; i++) {
				try {
					if (best[c - coins[i]] + 1 < min)
						min = best[c - coins[i]] + 1;
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}

			best[c] = min;
		}
		
		return best[money];
	}
}
