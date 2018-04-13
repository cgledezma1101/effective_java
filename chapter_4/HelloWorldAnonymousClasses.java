public class HelloWorldAnonymousClasses {
	interface HelloWorld {
		public void greet();
		public void greetSomeone(String someone);
	}

	public void sayHello() {
		class EnglishGreeting implements HelloWorld {
			final String name = "world";
			@Override public void greet() {
				greetSomeone(name);
			}

			@Override public void greetSomeone(String name) {
				System.out.println("Hello " + name);
			}
		}

		HelloWorld englishGreeting = new EnglishGreeting();

		HelloWorld frenchGreeting = new HelloWorld() {
			final String name = "tout le monde";
			@Override public void greet() {
				greetSomeone(name);
			}

			@Override public void greetSomeone(String someone) {
				System.out.println("Salut " + someone);
			}
		};

		englishGreeting.greet();
		frenchGreeting.greet();
		frenchGreeting.greetSomeone("Fred");
		englishGreeting.greetSomeone("Paul");
	}

	public static void main(String args[]) {
		HelloWorldAnonymousClasses app = new HelloWorldAnonymousClasses();
		app.sayHello();
	}
}