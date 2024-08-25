/*
 * Problem Statement:
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be
 * within the range from 1 to 3999.
 * I - 1, V - 5, X - 10, L - 50, C - 100, D - 500, M - 1000.
 * For example, 2 is written as II in Roman numeral, just two ones added
 * together.
 * 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 * 
 * Thought Process::
 * Approach 1:
 * We can use a hashmap to store the integer values as keys and the roman
 * numerals as values. The tricky part is when we see a case like 4 or 9 because
 * for them, we have to subtract the smaller number from the larger number. We
 * will do one thing, let us also include these special cases in the hashmap.
 * There is a reason for this. Let us say we have a number 1994. Since it is
 * greater than 1000, we will first add M to the result. Then we will subtract
 * 1000 from 1994 which results in 994. In the next step without special cases,
 * we could have added D to the result which is wrong. Hence, the special cases
 * are needed. The special cases are 4, 9, 40, 90, 400, 900. So, for 994, we
 * subtract 900 from 994 and get 94. Continue the process and we get the result.
 * We will store these in the hashmap. Whenever a number falls within the range
 * of these special cases, we will add the corresponding roman numeral to the
 * result and subtract the number from the current number. At last, the number
 * will be 0 and we will return the result. This approach might seem a bit
 * tricky but it is very easy to implement. Apart from the hashmap, we will also
 * store the values in an array in descending order. This is because we will run
 * a loop on the array and check if the current number is greater than the
 * number in the array. If it is, we will add the corresponding roman numeral to
 * the result and subtract the number from the current number. We will continue
 * this process until the number becomes 0. Finally, we will return the result.
 * 
 * Time Complexity Analysis:
 * The Time Complexity for checking the special cases is O(1) since we are using
 * a hashmap.
 * The Time Complexity to check the number is O(n) since we are running a while
 * loop until the number becomes 0.
 * The overall Time Complexity is O(n).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) as we use a hashmap and an
 * array of constant size.
 * 
 * Drawback of the Approach:
 * The above approach is not efficient as we use a hashmap.
 * 
 * Approach 2:
 * The second approach that should come to our mind is that we can simply use
 * if-else statements and solve the problem. Yes, we can do that.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) since we are running a while
 * loop until the number becomes 0.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) as we use if-else statements.
 * 
 * Drawback of the Approach:
 * The above approach is not efficient as we use so many if-else statements.
 * 
 * Efficient Approach:
 * Instead of using a hashmap as in the first approach, why don't we use the
 * concept for storing the values in an array in descending order? So, we will
 * store the roman numerals in a String array. Then we can easily fetch them.
 * 
 * Time Complexity Analysis:
 * The Time Complexity for checking the special cases is O(1) since we are using
 * an array.
 * The Time Complexity to check the number is O(n) since we are running a while
 * loop until the number becomes 0.
 * The overall Time Complexity is O(n).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) as we use arrays of constant
 * size.
 */

import java.util.HashMap;

public class IntegerToRoman {
	public String approach1(int num) {
		HashMap<Integer, String> map = new HashMap<>();

		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");

		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				result.append(map.get(values[i]));
				num -= values[i];
			}
		}

		return result.toString();
	}

	public String approach2(int num) {
		StringBuilder result = new StringBuilder();

		while (num > 0) {
			if (num >= 1000) {
				result.append("M");
				num -= 1000;
			} else if (num >= 900) {
				result.append("CM");
				num -= 900;
			} else if (num >= 500) {
				result.append("D");
				num -= 500;
			} else if (num >= 400) {
				result.append("CD");
				num -= 400;
			} else if (num >= 100) {
				result.append("C");
				num -= 100;
			} else if (num >= 90) {
				result.append("XC");
				num -= 90;
			} else if (num >= 50) {
				result.append("L");
				num -= 50;
			} else if (num >= 40) {
				result.append("XL");
				num -= 40;
			} else if (num >= 10) {
				result.append("X");
				num -= 10;
			} else if (num >= 9) {
				result.append("IX");
				num -= 9;
			} else if (num >= 5) {
				result.append("V");
				num -= 5;
			} else if (num >= 4) {
				result.append("IV");
				num -= 4;
			} else {
				result.append("I");
				num -= 1;
			}
		}

		return result.toString();
	}

	public String efficient(int num) {
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				result.append(roman[i]);
				num -= values[i];
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {
		IntegerToRoman itr = new IntegerToRoman();
		int num = 1994;

		// System.out.println(itr.approach1(num));
		// System.out.println(itr.approach2(num));
		System.out.println(itr.efficient(num));
	}
}