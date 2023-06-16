
package question;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyStack {

	private Character[] a; // array of items
	
	// DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

	public MyStack() 
	{
		a = new Character[4];
	}
	//Constructor Method
	
	public boolean isEmpty() 
	{
		for (Character item : a) 
		{
			if (item != null)
				return false;
		}
		return true;
	}
	// Checks if stack is empty and return a boolean.

	public int size() 
	{
		int returnVar = 0;

		if (isEmpty()) 
		{
			return returnVar;
		}

		for (Character item : a) 
		{
			if (item != null) 
			{
				returnVar++;
			}
		}

		return returnVar;
	}
	// Returns the number of elements in stack.

	private void resize() 
	{
		int newSize = a.length * 2;

		if (size() == a.length) 
		{
			Character[] temp = new Character[newSize];
			for (int i = 0; i < a.length; i++) 
			{
				temp[i] = a[i];
			}
			a = temp;
		}
	}
	// Doubles the size of stack without losing the elements in it.

	public void push(char item) 
	{

		if (size() == a.length) 
		{
			resize();
		}
		for (int i = 0; i < a.length; i++) 
		{
			if (a[i] == null) 
			{
				a[i] = item;
				break;
			}
		}
	}
	// Adds new item to stack.

	public Character pop() 
	{
		Character returnChar = a[size() - 1];
		a[size()-1] = null;
		return returnChar;

	}
	// Removes last element from the stack and returns that element.
	
	public Character peek() 
	{
		Character returnChar = a[size() - 1];
		return returnChar;
	}
	// Returns last element without removing.
	
	// DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

}
