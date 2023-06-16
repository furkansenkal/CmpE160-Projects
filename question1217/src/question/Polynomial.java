
package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.*;
public class Polynomial {

	private double deltaX = 0.0001;

	//Example solution:
	//Index 0: Coef. of x^0
	//Index 1: Coef. of x^1
	//Index 2: Coef. of x^2
	//Index 3: Coef. of x^3
	//Index 4: Coef. of x^4
	//If there is no x^n, that coefficient should be 0.

	private ArrayList<Integer> coefficients = new ArrayList<Integer>();

	//Fill in coefficients inside the constructor
	public Polynomial(String polynomial) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		for(int a = 0; a < 5; a++)
			coefficients.add(0);
		// adds 5 zeros to coefficients since the coefficients arraylist will contain 5 elements. 
		String[] polynomialLst = polynomial.split("(?=[+-])");
		// Splits string polynomial around plus and minus signs.
		String strCoef = "";
		String strPower = "";
		Integer power = 0;
		Integer coef = 0;
		// I have defined the variables I use.
		// strCoef: string type of one element's coefficient that is in polynomialLst.
		// strPower: string type of one element's power that is in polynomialLst.
		// coef: integer type of one element's coefficient that is in polynomialLst.
		// power: integer type of one element's power that is in polynomialLst.
		for(int i = 0; i < polynomialLst.length; i++)
		{
			String[] altList = polynomialLst[i].split("");
			strCoef = "";
			strPower = "";
			// Iterating over polynomialLst and defining the altList.
			// Setting strCoef and strPower to empty string again for another element of polynomialLst.
			for(int j=0; j<(altList.length); j++)
			{		
				// Iterating over altList.
				if(!altList[j].equals("x")) 
				{
					strCoef = strCoef + altList[j];
					strPower = "0";
				}
				// If corresponding element in altLst is not equals to "x" than add it to the strCoef variable and set strPower to "0" for now.
				else if(altList[j].equals("x"))
				{	
					strPower = "1";
					// If corresponding element is equals to "x" than strPower is equals to "1" at least.
					if(altList.length > strCoef.split("").length + 1)
					{
						strPower = altList[j+2];
					}
					// If altList's length is bigger than coefficient of it plus 1, that means there are another things other than single "x" so our "x" has a power.
					// Sets strPower to "x"'s power.
					if (strCoef.equals("") || strCoef.equals("-") || strCoef.equals("+"))
					{
						strCoef = strCoef + "1";
					}
					// If our strCoef is containing only empty string or "-" or "+", that means there is a hidden 1 so this block adds it.
					
					break;
				}
			}
			
			try
			{
	            power = Integer.valueOf(strPower);
	            coef = Integer.valueOf(strCoef);
	        }
			
	        catch (NumberFormatException ex)
			{
	            ex.printStackTrace();
	        }
			coefficients.set(power, coef);
			// Converting strCoef and strPower variables to integer and add coefficients to the coefficients list according to their powers.
		}
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}

	public double valueAt(double point) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		double value = 0.0;
		for(int i = 0; i < coefficients.size(); i++) 
		{
			value += coefficients.get(i) * Math.pow(point, i);
		}
		return value;
		// Calculating the value of polynomial function at a given "x" point and returning the value.
		
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}

	public void setDeltaX(double deltaX) {
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		this.deltaX = deltaX;
		//Basic setter method.
		
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}


	public int computeIntegral(int min, int max) {
		
		double integration = 0;
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		double n = (max-min)/deltaX;
		// Number of subintervals.
		for(int k = 0; k <= n - 1; k++)
		{
			integration += valueAt(min + k * deltaX) * deltaX;
		}
		// Calculating every subinterval's area and adding it to the integration variable.
		
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
		
		return (int)integration;
	}

}

