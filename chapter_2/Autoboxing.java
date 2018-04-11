public class Autoboxing {
	public static void main(String[] args) {
	}

	private static long sumSlow() {
		// This will unnecessarily construct instances of the Long class
		Long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; ++i) {
			sum += i;
		}

		return i;
	}

	private static long sumFast() {
		long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; ++i) {
			sum += i;
		}

		return i;
	}
}