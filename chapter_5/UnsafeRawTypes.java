import java.util.ArrayList;
import java.util.List;

public class UnsafeRawTypes {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		unsafeAdd(strings, Integer.valueOf(42));
		String s = strings.get(0); // Has compiler generated cast which means it fails at runtime
	}

	private static void unsafeAdd(List list, Object o) {
		list.add(o);
	}
}