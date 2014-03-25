import java.util.Random;

class QuickSort {

	//If you aren't using random input, switch the data structure to an ArrayList and use Collections.shuffle prior to sorting to maintain that expected O(nlgn) runtime
	public static void main(String[] args)

	{
		int[] values = new int[10];
		Random random = new Random();
		for (int i = 0; i < values.length; i++)
			values[i] = random.nextInt(10);
		quickSort(values);
		for (int i : values)
			System.out.print(i + " ");

	}

	private static void quickSort(int[] values) {
		partition(values, 0, values.length - 1);
	}

	private static void partition(int[] values, int start, int end) {
		int leftPartition = start;
		int rightPartition = end;
		int pivotValue = values[start + (end - start) / 2];

		while (leftPartition <= rightPartition) {
			while (values[leftPartition] < pivotValue)
				leftPartition++;
			while (values[rightPartition] > pivotValue)
				rightPartition--;
			if (leftPartition <= rightPartition) {
				swap(values, leftPartition, rightPartition);
				rightPartition--;
				leftPartition++;
			}
		}

		if (leftPartition < end)
			partition(values, leftPartition, end);
		if (rightPartition > start)
			partition(values, start, rightPartition);
	}

	private static void swap(int[] values, int i, int j) {
		int temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}

}