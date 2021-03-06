import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenericVarargs {
	// UNSAFE - Exposes reference to its generic parameter array
	static <T> T[] toArray(T... args) {
		return args;
	}

	static <T> T[] pickTwo(T a, T b, T c) {
		switch (ThreadLocalRandom.current().nextInt(3)) {
			case 0: return toArray(a, b);
			case 1: return toArray(a, c);
			case 2: return toArray(b, c);
		}

		throw new AssertionError(); // Can't get here
	}

	// This is an alternative, safe version of pickTwo
	static <T> List<T> pickTwo(T a, T b, T c) {
		switch (ThreadLocalRandom.current().nextInt(3)) {
			case 0: return List.of(a, b);
			case 1: return List.of(a, c);
			case 2: return List.of(b, c);
		}

		throw new AssertionError(); // Can't get here
	}

	// This is safe because (a) it doesn't store anything in the varargs array and 
	// (b) it doesn't expose the varargs array
	// Annotating with SafeVarargs prevents the warning
	@SafeVarargs
	static <T> List<T> flatten(List<? extends T>... lists) {
		List<T> result = new ArrayList<>();
		for (List<? extends T> list : lists) {
			result.addAll(list);
		}

		return result;
	}

	// Alternatively, the method can be implemented using generic lists
	// This can be used along witht List.of(T...)
	static <T> List<T> flatten(List<List<? extends T>> lists) {
		List<T> result = new ArrayList<>();
		for (List<? extends T> list : lists) {
			result.addAll(list);
		}

		return result;
	}

	public static void main(String[] args) {
		String[] attributes = pickTwo("Good", "Fast", "Cheap"); // This throws a ClassCastException because the return type of toArray is determined to be Object[]
	}
}