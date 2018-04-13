// Final modifier guarantees the class can't be extended
public final class ImmutableComplex {
	// Private final fields guartantee immutability and hide the implementation details
	private final double re;
	private final double im;

	public ImmutableComplex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public double realPart() { return re; }

	public double imaginaryPart() { return im; }

	public ImmutableComplex plus(ImmutableComplex c) {
		return new ImmutableComplex(re + c.re, im + c.im);
	}

	public ImmutableComplex minus(ImmutableComplex c) {
		return new ImmutableComplex(re - c.re, im - c.im);
	}

	public ImmutableComplex times(ImmutableComplex c) {
		return new ImmutableComplex(re * c.re - im * c.im, re * c.im + im * c.re);
	}

	public ImmutableComplex dividedBy(ImmutableComplex c) {
		double tmp = c.re * c.re + c.im * c.im;
		return new ImmutableComplex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
	}

	@Override public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof ImmutableComplex)) {
			return false;
		}

		ImmutableComplex c = (ImmutableComplex)o;
		return Double.compare(c.re, re) == 0 && Double.compare(c.im, im) == 0;
	}

	@Override public int hashCode() {
		return 31 * Double.hashCode(re) + Double.hashCode(im); // This is a clever way of implementing hashCode, due to how the compiler treats (* 31)
	}

	@Override public String toString() {
		return "(" + re + " + " + im + "i";
	}
}