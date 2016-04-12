public class Main {

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		int[] data = { 1, 2, 3, 2, 1, 6, 7, 3, 4, 1, 2 };
		System.out.println(maxSequenceSum(data));
	}

	public int maxSequenceSum(int[] data) {
		int[] maxSumToNow = new int[data.length];
		int[] startPoint = new int[data.length];
		maxSumToNow[0] = data[0];

		int max = Integer.MIN_VALUE;
		int maxStartPoint = -1;
		int maxEndPoint = -1;

		for (int i = 1; i < data.length; i++) {
			if (data[i] >= data[i - 1]) {
				maxSumToNow[i] = maxSumToNow[i - 1] + data[i];
				startPoint[i] = startPoint[i - 1];
			} else {
				maxSumToNow[i] = data[i];
				startPoint[i] = i;
			}

			if (maxSumToNow[i] > max) {
				max = maxSumToNow[i];
				maxStartPoint = startPoint[i];
				maxEndPoint = i;
			}
		}

		for (int i = maxStartPoint; i <= maxEndPoint; i++)
			System.out.print(data[i] + " ");
		
		System.out.println();

		return max;
	}
}
