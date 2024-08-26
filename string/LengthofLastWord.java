/*
 * Problem Statement:
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * For example, Given s = "Hello World", return 5.
 * Given s = "Hello World ", return 5.
 * Given s = "  Hello World  ", return 5.
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Thought Process::
 * Approach 1:
 * This approach is simple. We initialize a variable count to keep track of the
 * length of the last word. We also initialize an arraylist to keep track of the
 * length of each word. We will run a for loop from the start of the string. So,
 * inside the loop, we will check if the character is a space or not. If it is
 * not a space, we will increment the count and also we will check if we are at
 * the last character of the string. If we are at the last character of the
 * string, then we will add the count to the arraylist. This step is necessary
 * because, we have calculated the length of the last word but we have not added
 * it to the arraylist. So, we should add it to the arraylist. If the character
 * is a space, then we will add the count to the arraylist and reset the count
 * to 0. One important thing to note is that, we should not add the count to the
 * arraylist if the count is 0. This is because, the word's length can be 0. At
 * last, we will return the last element of the arraylist.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n) because we are running a for
 * loop from the start of the string.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(n) because we are using an
 * arraylist to store the length of each word.
 * 
 * Drawback of the Approach:
 * The above approach is not efficient as we are using an arraylist to store the
 * length of each word.
 * 
 * Approach 2:
 * This approach is similar to the above approach. Instead of using an arraylist
 * we will use a variable ans to store the length of the last word. What I mean
 * by that is, at last we want the length of the last word, so instead of
 * appending in the arraylist, we will simply replace the value in the ans with
 * the length of the each word. When we exit the loop, we will have the length
 * of the last word in the variable.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n) because we are running a for
 * loop from the start of the string.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(1) because we are using only one
 * variable to store the length of the last word.
 * 
 * Drawback of the Approach:
 * The above approach is not efficient as we are traversing from the start of
 * the string.
 * 
 * Approach 3:
 * In Java, we can use the trim() method to remove the leading and trailing
 * white spaces. Then, we will convert the string to a string array using the
 * split() method. The split() method will split the string based on the space.
 * So, we will get an array of words. We will return the length of the last word
 * in the array.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n) because we are using the
 * split() method.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(n) because we are using an array
 * to store the words.
 * 
 * Drawback of the Approach:
 * The above approach is not efficient as we are using an array to store the
 * words.
 * 
 * Efficient Approach:
 * Here, we will start from the end of the string. Initialize a variable count
 * to 0 to keep track of the length of the last word. Also, initialize a boolean
 * variable flag to false to indicate that we have encountered a character. We
 * will run a for loop from the end of the string. So, inside the loop, we will
 * check if the character is a space or not. If it is not a space, we will
 * increment the count and set the flag to true. If the character is a space and
 * the flag is true, then we will break the loop. If the character is a space
 * and the flag is false, then we will continue. At last, we will return the
 * count.
 * 
 * Time Complexity Analysis:
 * The time complexity for this approach is O(n) because we are running a for
 * loop from the end of the string.
 * 
 * Space Complexity Analysis:
 * The space complexity for this approach is O(1) because we are using only two
 * variables.
 */

import java.util.ArrayList;

public class LengthofLastWord {
	public int approach1(String s) {
		int count = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				count++;
				if (i == s.length() - 1) {
					list.add(count);
				}
			} else {
				if (count != 0) {
					list.add(count);
					count = 0;
				}
			}
		}
		return list.get(list.size() - 1);
	}

	public int approach2(String s) {
		int ans = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				count++;
				if (i == s.length() - 1) {
					ans = count;
				}
			} else {
				if (count != 0) {
					ans = count;
					count = 0;
				}
			}
		}
		return ans;
	}

	public int approach3(String s) {
		String[] words = s.trim().split(" ");
		return words[words.length - 1].length();
	}

	public int efficient(String s) {
		int count = 0;
		boolean flag = false;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				count++;
				flag = true;
			} else {
				if (flag) {
					break;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		LengthofLastWord lolw = new LengthofLastWord();
		String s = "Hello World";
		System.out.println(lolw.approach1(s));
		System.out.println(lolw.approach2(s));
		System.out.println(lolw.approach3(s));
		System.out.println(lolw.efficient(s));
	}
}