import java.util.Arrays;
import java.util.List;

class Main
{
	// Function to find the longest common prefix between two Strings
	public static String LCP(String X, String Y)
	{
		int i = 0, j = 0;
		while (i < X.length() && j < Y.length())
		{
			if (X.charAt(i) != Y.charAt(j)) {
				break;
			}
			i++; j++;
		}

		return X.substring(0, i);
	}

	// Function to find the longest common prefix (LCP) between given set of Strings
	public static String findLCP(List<String> words)
	{
		String prefix = words.get(0);
		for (String s: words) {
			prefix = LCP(prefix, s);
		}
		return prefix;
	}

	public static void main(String[] args)
	{
		List<String> words = Arrays.asList("techie delight", "tech", "techie",
													"technology", "technical");

		System.out.println("The longest common prefix is " + findLCP(words));
	}
}