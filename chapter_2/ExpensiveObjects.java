import java.util.regex.Pattern;

public class ExpensiveObjects {
	public static void main(String[] args) {
		System.out.println("XLV: " + isRomanNumeral("XLV"));
		System.out.println("XLV: " + RomaNumerals.isRomanNumeral("XLV"));

		System.out.println("FOO: " + isRomanNumeral("FOO"));
		System.out.println("FOO: " + RomaNumerals.isRomanNumeral("FOO"));
	}

	// Performance can be greatly improved
	static boolean isRomanNumeral(String s) {
		// This wil internally create a Pattern instance every time it is invoked
		return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	}

	// This class caches the pattern and reuses it on every call
	static class RomanNumerals {
		private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

		static boolean isRomanNumeral(String s) {
			return ROMAN.matcher(s).matches();
		}
	}
}