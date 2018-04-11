public class Builders  {
	public static void main(String[] args) {
		NutritionFactsTelescoping cocaColaTelescoping = new NutritionFactsTelescoping(240, 8, 100, 0, 35, 27);

		NutritionFactsBeans cocaColaBeans = new NutritionFactsBeans();
		cocaColaB.setServingSize(240);
		cocaColaB.setServings(8);
		cocaColaB.setCalories(100);
		cocaColaB.setSodium(35);
		cocaColaB.setCarbs(27);

		NutritionFactsBuilder cocaColaBuilder = NutritionFactsBuilder
			.Builder(240, 8)
			.calories(100)
			.sodium(35)
			.carbs(27)
			.build();
	}

	class NutritionFactsBuilder {
		private final int servingSize;
		private final int servings;
		private final int calories;
		private final int fat;
		private final int sodium;
		private final int carbohydrate;

		private NutritionFactsBuilder(Builder builder) {
			servingSize = builder.servingSize;
			servings = builder.servings;
			calories = builder.calories;
			fat = builder.fat;
			sodium = builder.sodium;
			carbohydrate = builder.carbohydrate;
		}

		public static class Builder {
			// Required parameters
			private final int servingSize;
			private final int servings;

			// Optional parameters - initialized to default values
			private int calories = 0;
			private int fat = 0;
			private int sodium = 0;
			private int carbohydrate = 0;

			public Builder(int servingSize, int servings) {
				this.servingSize = servingSize;
				this.servings = servings;
			}

			public Builder calories(int val) {
				calories = val;
				return this;
			}

			public Builder fat(int val) {
				fat = val;
				return this;
			}

			public Builder sodium(int val) {
				sodium = val;
				return this;
			}

			public Builder carbs(int val) {
				carbohydrate = val;
				return this;
			}

			public NutritionFactsBuilder build() {
				return new NutritionFactsBuilder(this);
			}
		}
	}

	class NutritionFactsTelescoping {
		private final int servingSize;
		private final int servings;
		private final int calories;
		private final int fat;
		private final int sodium;
		private final int carbohydrate;

		public NutritionFactsTelescoping(int servingSize, int servings) {
			this(servingSize, servings, 0);
		}

		public NutritionFactsTelescoping(int servingSize, int servings, int calories) {
			this(servingSize, servings, calories, 0);
		}

		public NutritionFactsTelescoping(int servingSize, int servings, int calories, int fat) {
			this(servingSize, servings, calories, fat, 0);
		}

		public NutritionFactsTelescoping(int servingSize, int servings, int calories, int fat, int sodium) {
			this(servingSize, servings, calories, fat, sodium, 0);
		}

		public NutritionFactsTelescoping(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
			this.servingSize = servingSize;
			this.servings = servings;
			this.calories = calories;
			this.fat = fat;
			this.sodium = sodium;
			this.carbohydrate = carbohydrate;
		}
	}

	class NutritionFactsBeans {
		private int servingSize;
		private int servings;
		private int calories;
		private int fat;
		private int sodium;
		private int carbohydrate;

		public NutritionFactsBeans() { }

		// Setters
		public void setServingSize(int val) { servingSize = val; }
		public void setServings(int val) { servings = val; }
		public void setCalories(int val) { calories = val; }
		public void setFat(int val) { fat = val; }
		public void setSodium(int val) { sodium = val; }
		public void setCarbs(int val) { carbohydrate = val; }
	}
}