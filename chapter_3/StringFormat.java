public class StringFormat {
	public static void main(String[] args) {
		int countryCode = 5;
		int areaCode = 24;
		int lineNumber = 4211;
		PhoneNumber phone = new PhoneNumber(countryCode, areaCode, lineNumber);

		System.out.printf("Parameters provided: \n\t%6d - Country\n\t%6d - Area\n\t%6d - Number\n", countryCode, areaCode, lineNumber);
		System.out.println("My phone number is: " + phone);
	}

	static class PhoneNumber {
		public final int countryCode;
		public final int areaCode;
		public final int number;

		public PhoneNumber(int countryCode, int areaCode, int number) {
			this.countryCode = countryCode;
			this.areaCode = areaCode;
			this.number = number;
		}

		@Override public String toString() {
			return String.format("+%02d-%03d-%06d", countryCode, areaCode, number);
		}
	}
}