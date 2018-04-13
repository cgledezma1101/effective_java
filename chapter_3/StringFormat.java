public class StringFormat {
	public static void main(String[] args) {
		PhoneNumber phone = new PhoneNumber(61, 424, 338978);

		System.out.printf("Parameters provided: \n\t%6d - Country\n\t%6d - Area\n\t%6d - Number\n", 61, 424, 338978);
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
			return String.format("+%s-%s-%s", countryCode, areaCode, number);
		}
	}
}