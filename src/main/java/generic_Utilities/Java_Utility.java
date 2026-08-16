package generic_Utilities;

import java.util.Date;

public class Java_Utility {
	
	public static String getName() {
		return new Date().toString().replace(':',' ');
	}

}
