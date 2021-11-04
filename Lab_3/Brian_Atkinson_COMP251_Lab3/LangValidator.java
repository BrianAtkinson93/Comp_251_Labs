package Lab_3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class LangValidator {
	public static boolean isValidString(String string) {
		if (string == "")
			return false;
		// Creating two empty strings for later
		String firstHalf = null;
		String secondHalf = null;
		
		// Index of first occurance of '$' in string 
		int index = string.indexOf('$');
		// System.out.println(index);

		// obviously false if index is less than 0
		if (index < 0)
			return false;
		
		if (index != 0) {
			// Substring returns a "sub string" of the string. 
			// The provided parameteres here are 0 and index.
			// The substring will begin at the parameter (0)
			// extending until the last provided parameter (index).
			// The first parameter is inclusive and the last is exclusive.
			firstHalf = string.substring(0, index);
			// System.out.println("firstHalf : " + firstHalf);
		} else
			firstHalf = "";
		if (index != string.length() - 1) {
			// This second "sub string" of the string will create
			// a sub string from parameters (index + 1) extnding
			// until (string.length). (remembering index == first '$' occurance)
			// The first parameter is inclusive and the last is exclusive
			secondHalf = string.substring(index + 1, string.length());
			// System.out.println("secondHalf : " +secondHalf);
		} else
			secondHalf = "";
		
		if (firstHalf.length() != secondHalf.length())
			// This will return false because the string is not
			// the correct length. example : abab$aba
			// firstHalf = abab
			// secondHalf = aba
			return false;

		// Hint: use a stack of characters:
		// Below we are creating a stack and adding the characters from
		// the second half to the stack in increasing index position
		// we then check if the first half and second half characters
		// are the same and if they are, we remove them from stack
		// incrementing until the stack is empty at which point
		// we can confirm that they were in the same order.
		// If they are not in the same order, we return false.
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < secondHalf.length(); i++)
			stack.push(secondHalf.charAt(i));

		for (int i = 0; i < firstHalf.length(); i++) {
			Character C = stack.pop();
			if (C == firstHalf.charAt(i))
				continue;
			else
				return false;
		}

		return true;
	}
	
	// Main function with the output for string and boolean
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fin = new Scanner(
				new FileReader("/Users/brianatkinson1/Documents/GitHub/COMP 251/Labs/src/Lab_3/input.txt"));
		while (fin.hasNext()) {
			String str = fin.nextLine();
			System.out.println(str + " : " + isValidString(str));
			System.out.println();
		}
	}

}
