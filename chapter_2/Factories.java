import java.math.BigInteger;
import java.util.*;

public class Factories
{
	public static void main(String[] args)
	{
		System.out.println("Boolean parse (true): " + ParseBool(true));
		System.out.println("Boolean parse (false): " + ParseBool(false));
		System.out.println("EnumSet: " + FaceCards());
		System.out.println("Big prime: " + BigInteger.valueOf(Integer.MAX_VALUE));
	}

	static Boolean ParseBool(boolean bool)
	{
		return Boolean.valueOf(bool);
	}

	static Set<Rank> FaceCards() {
		return EnumSet.of(Rank.JACK, Rank.QUEEN, Rank.KING);
	}

	enum Rank {
		JACK, QUEEN, KING, ACE
	}
}