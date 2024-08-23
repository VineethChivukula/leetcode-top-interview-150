/*
 * Problem Statement:
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be
 * within the range from 1 to 3999.
 * I - 1, V - 5, X - 10, L - 50, C - 100, D - 500, M - 1000.
 * For example, given IV, return 4.
 * 
 * Thought Process:
 * Approach 1:
 * By taking two examples, we can understand the tricky part of the problem. Let
 * us say we want to convert VI to integer. The answer is 6. How do we get 6? We
 * first see V and know it is 5, then we see I and know it is 1. Adding them, we
 * get 6. But what about IV? Suprisingly, the answer is 4. But why? because when
 * we go from left to right, we see I first and then V. So, we subtract 1 from 5
 * and get 4. So, the tricky part is when we see a smaller number to the left of
 * the current number, we subtract it from the current number. Otherwise, we add
 * it. We will store the integer values of the roman numerals in a hashmap. We
 * then run a loop from 1 to n-1 and check the conditions mentioned above.
 * Finally, we return the result.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) since we are running a loop from
 * 1 to n-1.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) as we use a hashmap of constant
 * size.
 * 
 * Drawback of the Approach:
 * The above approach is not efficient as we use a HashMap.
 * 
 * Efficient Approach:
 * Instead of using a hashmap, we can use a switch case to store the integer
 * values of the roman numerals. Remaining logic is the same as the above.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) since we are running a loop from
 * 1 to n-1.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) as we use a switch case.
 */

import java.util.HashMap;

public class RomanToInteger {
	public int approach1(String s) {
		HashMap<Character, Integer> map = new HashMap<>();

		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int result = map.get(s.charAt(0));

		for (int i = 1; i < s.length(); i++) {
			int currentValue = map.get(s.charAt(i));
			int prevValue = map.get(s.charAt(i - 1));

			if (currentValue > prevValue) {
				result = result - prevValue + (currentValue - prevValue);
			} else {
				result += currentValue;
			}
		}

		return result;
	}

	public int efficient(String s) {
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
				case 'I':
					result += 1;
					break;
				case 'V':
					result += 5;
					break;
				case 'X':
					result += 10;
					break;
				case 'L':
					result += 50;
					break;
				case 'C':
					result += 100;
					break;
				case 'D':
					result += 500;
					break;
				case 'M':
					result += 1000;
					break;
			}

			if (i > 0) {
				if ((s.charAt(i) == 'V' || s.charAt(i) == 'X') && s.charAt(i - 1) == 'I') {
					result -= 2;
				}

				if ((s.charAt(i) == 'L' || s.charAt(i) == 'C') && s.charAt(i - 1) == 'X') {
					result -= 20;
				}

				if ((s.charAt(i) == 'D' || s.charAt(i) == 'M') && s.charAt(i - 1) == 'C') {
					result -= 200;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		RomanToInteger obj = new RomanToInteger();
		String s = "IV";
		// System.out.println(obj.approach1(s));
		System.out.println(obj.efficient(s));
	}
}