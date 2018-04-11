import java.util.*;

public class PizzaBuilder {
	public static void main(String[] args) {
		NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
			.addTopping(Pizza.Topping.SAUSAGE)
			.addTopping(Pizza.Topping.ONION)
			.build();
		Calzone calzone = new Calzone.Builder()
			.addTopping(Pizza.Topping.HAM)
			.sauceInside()
			.build();
	}
}


abstract class Pizza {
	public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE };
	final Set<Topping> toppings;
	
	abstract static class Builder<T extends Builder<T>> {
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}

		abstract Pizza build();

		// Subclasses must override this method to return "this"
		// This is called "simulated self-type idiom"
		protected abstract T self();

	}

	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone();
	}
}

class NyPizza extends Pizza {
	public enum Size { SMALL, MEDIUM, LARGE }
	private final Size size;

	public static class Builder extends Pizza.Builder<Builder> {
		private final Size size;

		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

		// This implements a pattern where the sublclass method returns a subtype of the return type declared in the super-class.
		// This is known as "covariant return typing" and allows clients to use the class without further casting
		@Override public NyPizza build() {
			return new NyPizza(this);
		}

		@Override protected Builder self() {
			return this;
		}
	}

	private NyPizza(Builder builder) {
		super(builder);
		size = builder.size;
	}
}

class Calzone extends Pizza {
	private final boolean sauceInside;

	public static class Builder extends Pizza.Builder<Builder> {
		private boolean sauceInside = false;

		public Builder sauceInside() {
			sauceInside = true;
			return this;
		}

		@Override public Calzone build() {
			return new Calzone(this);
		}

		@Override protected Builder self() {
			return this;
		}
	}

	private Calzone(Builder builder) {
		super(builder);
		sauceInside = builder.sauceInside;
	}
}

