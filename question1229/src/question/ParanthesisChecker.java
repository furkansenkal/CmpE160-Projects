
package question;

import java.util.Arrays;

public class ParanthesisChecker {
	

	public boolean isCorrect(String javaCode) { 
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		MyStack stack = new MyStack();
		// Creating a stack.
		Boolean flag = true;
		// Creating a boolean which is initially true.
		char check;
		// Defining the char variable named check.
        for (int i = 0; i < javaCode.length(); i++) 
        {
        	// Iterating through given string.
            char item = javaCode.charAt(i);
            if (flag) 
		    {
            	if (item == '\"') 
              	{
              		stack.push(item);
              		flag = false;
              		continue;
              	}
            	// If statement that looks for the '\"' char in given string,
            	//if executes pushing the char to the stack and changing flag to false.
              	
            	if (item == '(' || item == '{' ) 
		        {
		            stack.push(item);
		            continue;
		        }
            	// If statement that looks for the '(' or '{' chars in given string,
          		
		        switch (item) 
		        {
		        	case ')':
		        		check = stack.peek();
		        		if (check == '{')
		        			return false;
		        		stack.pop();
		        		break;
		  
		        	case '}':
		        		check = stack.peek();
		        		if (check == '(')
		        			return false;
		        		stack.pop();
		        		break;
		        }
		        // Switch statement that looks for any closing paranthesis in the given string
		        // if finds any check the stacks last element,
		        // if they are not matching returns false otherwise pops the stacks last element
		    }
		    
		    if(!flag) 
		    {
		    	switch (item) 
		        {
		        	case '\"':
		        		check = stack.peek();
		        		if (check == '"')
		        			flag = true;
		        		stack.pop();
		        		break;
		            
		        }
		    }
		    // If flag has turned to false by finding a '\"' character,
		    // then we are only looking for another '\"' character in given string.
        }
        
        return (stack.isEmpty());
        // At the end, if stack is empty all paranthesis were matched and our code must be give true.


		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
		
	}
	
}


