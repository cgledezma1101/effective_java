import java.util.Collection;
import java.util.Set;

public class BoundWildcards {
	static class Stack<E> {
		public void pushAllNotBound(Iterable<E> src) {
			for (E e : src) {
				System.out.println("Pushed element: " + e);
			}
		}

		public void popAllNotBound(Collection<E> dst) {
			Collection<E> toPush = Set.of();

			dst.addAll(toPush);
		}

		public void pushAll(Iterable<? extends E> src) {
			for (E e : src) {
				System.out.println("Pushed element: " + e);
			}
		}

		public void popAll(Collection<? super E> dst) {
			Collection<E> toPush = Set.of();

			dst.addAll(toPush);
		}
	}

	public static <E extends Comparable<? super E>> E max(List<? extends E> c) {
		if (c.isEmpty()) {
			throw new IllegalArgumentException("Empty collection");
		}

		E result = null;
		for (E e : c) {
			if (result == null || e.compareTo(result) > 0) {
				result = Objects.requireNonNull(e);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Stack<Number> numberStack = new Stack<>();
		Iterable<Integer> integers = Set.of(1, 2, 3, 4);
		// numberStack.pushAllNotBound(integers); // This will not compile
		numberStack.pushAll(integers);

		Collection<Object> objects = Set.of();
		// numberStack.popAllNotBound(objects); // This will not compile
		numberStack.popAll(objects);
	}
}