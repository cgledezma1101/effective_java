import java.util.Set;

public class UnboundedWildcards {
	// Use unbounded wildcards when you don't care about the type of elements in the generic set.
	// Prefer this to raw types
	static int numElementsInCommon(Set<?> s0, Set<?> s1) {
		int result = 0;
		for(Object o0 : s0) {
			if (s1.contains(o0)) {
				++result;
			}
		}
		return result;
	}
}