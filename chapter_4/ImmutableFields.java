import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableFields {
	public static class Thing {
	}

	// An array should never be exposed as a constant, as it is always mutable
	private static final Thing[] PRIVATE_VALUES = { new Thing(), new Thing(), new Thing() };

	// A correct way to expose a static array field is to have a public method that returns an immutable list out of it.
	public static final List<Thing> VALUES = Collections.unmodifiableList(Arrays.asList((PRIVATE_VALUES)));

	// There's also this nifty trick new to Java 9
	public static final List<Thing> VALUES_WITH_LIST_OF = Collections.unmodifiableList(List.of(new Thing(), new Thing(), new Thing()));

	// Alternatively, we can provide a method that returns a copy of the array.
	public static final Thing[] values() {
		return PRIVATE_VALUES.clone();
	}
}