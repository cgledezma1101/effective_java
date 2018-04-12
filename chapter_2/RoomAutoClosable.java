import java.lang.ref.Cleaner;

public class RoomAutoClosable {
	public static void main(String[] args) {
		adultRoom();
		teenagerRoom();
	}
	
	static void adultRoom() {
		// Thiss seems to be like the 'using' in C#. The close method wil be automatically called when the try exits
		try(Room myRoom = new Room(7)) {
			System.out.println("Goodbye");
		}
	}

	static void teenagerRoom() {
		new Room(99);
		System.out.println("Peace out");
		System.gc(); // This should force the cleaner to execute, but not always. Without this line, the second "Cleaning Room" never prints
	}

	static class Room implements AutoCloseable {
		private static final Cleaner cleaner = Cleaner.create();
	
		// This needs to be a static nested class. Non-static nested classes contain references to their
		// containing classes, hence cannot be properly collected
		private static class State implements Runnable {
			int numJunkPiles;
	
			State(int numJunkPiles) {
				this.numJunkPiles = numJunkPiles;
			}
	
			@Override public void run() {
				System.out.println("Cleaning room");
	
				numJunkPiles = 0;
			}
		}
	
		private final State state;
		private final Cleaner.Cleanable cleanable;
	
		public Room(int numJunkPiles) {
			state = new State(numJunkPiles);
			cleanable = cleaner.register(this, state);
		}
	
		@Override public void close() {
			cleanable.clean();
		}
	}
}