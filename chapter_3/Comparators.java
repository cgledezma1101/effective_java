import java.util.Comparator;
import static java.util.Comparator.comparingInt;

public class Comparators {
	public static void main(String[] args) {
	}

	static class PhoneNumber implements Comparable<PhoneNumber> {
		public final int countryCode;
		public final int areaCode;
		public final int number;

		public PhoneNumber(int countryCode, int areaCode, int number) {
			this.countryCode = countryCode;
			this.areaCode = areaCode;
			this.number = number;
		}

		private static final Comparator<PhoneNumber> COMPARATOR = comparingInt((PhoneNumber number) -> number.countryCode)
			.thenComparingInt(number -> number.areaCode)
			.thenComparingInt(number -> number.number);

		@Override public int compareTo(PhoneNumber number) {
			return COMPARATOR.compare(this, number);
		}
	}
}