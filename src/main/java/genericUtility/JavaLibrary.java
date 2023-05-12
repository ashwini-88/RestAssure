package genericUtility;

import java.util.Random;

public class JavaLibrary {
	
	public static int random()
    {
	Random ran = new Random();
	int random = ran.nextInt(1000);
	return random;
	}
}
