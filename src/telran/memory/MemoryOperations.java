package telran.memory;

public class MemoryOperations {
	public static int getMaxAvailableMemory() {
		int max = Integer.MAX_VALUE;
		int min = 0;
		int middle = max;
		int res = 0;
		byte ar[] = null;
		while (min <= max) {			
			try {
				ar = new byte[middle];
				ar = null;
				res = middle;			
				min = middle + 1;
			} catch (Throwable e) {
				max = middle - 1;
			}
			middle = (min + max) / 2;
		}
		return res;
	}

}
