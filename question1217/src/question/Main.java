
package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Main
{
	// Main method is for you to test your code
	// You will not get any points here
	public static void main(String[] args) {
		
		Polynomial p1 = new Polynomial("8+x+x^2+8x^3-10x^4");
		p1.setDeltaX(0.2);
		System.out.println(p1.computeIntegral(-1,3));
		
	}

}

