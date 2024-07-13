/*
 * Problem Statement:
 * The problem says that there is an array which is sorted and we have to remove
 * all the duplicates from the array and return the length of the array. We also
 * need to make sure that the remaining elements are in the same order as they
 * were in the original array. For example, if the array is [1,1,2] then the
 * output is [1,2,_].
 * 
 * Thought Process:
 * Approach 1:
 * The first approach that should come to our mind is that we can take an
 * array-list to store the non duplicate elements of the array. We will traverse
 * the array and if the element exists in the array-list, then we will not add
 * it to the array-list. Otherwise we add it to the array-list. Now, we will
 * traverse the array-list and copy the elements of the array-list into the
 * original array. Finally, we will return the size of the array list.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of traversing the array is O(n).
 * The Time Complexity of copying the elements of the array-list into the array
 * is O(n).
 * So, the final Time Complexity of this approach is O(n).
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(n) since we are using an
 * array-list to store the non duplicate elements.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are using extra space and also we
 * are traversing the array multiple times.
 * 
 * Efficient Approach:
 * We will take two pointers i and j. Keep i at 0 and j at 1. We will traverse
 * the array and if the element at the ith index is equal to the element at the
 * jth index, then we will increment the value of j by 1. If the element at the
 * ith index is not equal to the element at the jth index, then we will
 * increment the value of i by 1 and copy the element at the jth index to the
 * ith index. Finally, we will return the value of i+1.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) since we are traversing the
 * array only once.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 */

 import java.util.List;
 import java.util.ArrayList;
 
 public class RemoveDuplicatesfromSortedArray {
	 public int approach1(int[] nums) {
		 List<Integer> list = new ArrayList<>();
		 for (int i = 0; i < nums.length; i++) {
			 if (!list.contains(nums[i])) {
				 list.add(nums[i]);
			 }
		 }
		 for (int i = 0; i < list.size(); i++) {
			 nums[i] = list.get(i);
		 }
 
		 return list.size();
	 }
 
	 public int efficient(int[] nums) {
		 int n = nums.length;
 
		 if (n == 0 || n == 1) {
			 return n;
		 }
 
		 int i = 0, j = 1;
 
		 while (j < n) {
			 if (nums[i] == nums[j]) {
				 j++;
			 } else {
				 i++;
				 nums[i] = nums[j];
				 j++;
			 }
		 }
 
		 return i + 1;
	 }
 
	 public static void main(String[] args) {
		 RemoveDuplicatesfromSortedArray rdsa = new RemoveDuplicatesfromSortedArray();
		 int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		 // System.out.println(rdsa.approach1(nums));
		 // nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		 System.out.println(rdsa.efficient(nums));
	 }
 }