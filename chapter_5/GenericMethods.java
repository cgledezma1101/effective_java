import java.util.HashSet;
import java.util.Set;

public class GenericMethods {
	// Uses raw types, unacceptable. This generates a compiler warninf due to the usage of unsafe raw types
	public static Set unionRaw(Set s0, Set s1) {
		Set result = new HashSet(s0);
		result.addAll(s1);
		return result;
	}

	// Generic method
	public static <E> Set<E> union(Set<E> s0, Set<E> s1) {
		Set<E> result = new HashSet<>(s0);
		result.addAll(s1);
		return result;
	}

	public static void main(String[] args) {
		Set<String> guys = Set.of("Tom", "Dick", "Harry");
		Set<String> stooges = Set.of("Larry", "Moe", "Curly");
		Set<String> aflCio = union(guys, stooges);

		System.out.println(aflCio);
	}
}