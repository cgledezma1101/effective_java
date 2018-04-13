import java.util.Arrays;
import java.util.Collections;

public class ImmutableFields {
	public static class Thing {
	}

	private static final Thing[] PRIVATE_VALUES = { new Thing(), new Thing(), new Thing() };

	// A correct way to expose a static array field is to have a public method that returns an immutable list out of it.
	public static final List<Thing> VALUES = Collections.unmodifiableList(Arrays.asList((PRIVATE_VALUES)));

	// Alternatively, we can provide a method that returns a copy of the array.
	public static final Thing[] values() {
		return PRIVATE_VALUES.clone();
	}
}