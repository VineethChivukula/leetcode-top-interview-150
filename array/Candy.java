/*
 * Problem Statement:
 * There are n children standing in a line. Each child is assigned a rating
 * value given in an integer array ratings. You are giving candies to these
 * children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the
 * candies to the children.
 * 
 * Thought Process:
 * Approach 1:
 * First, we will initialize an array candies with all elements as 1 because
 * each child must have at least one candy. We will initialize a variable
 * changed to indicate whether the array candies is changed or not. We will run
 * a while loop until the array candies is not changed. Inside the loop, we will
 * set changed to false. We will run a loop from 0 to n-1. Inside the loop, we
 * will check if the current element is greater than the previous element and
 * candies[i] is less than or equal to candies[i-1]. If it is true, we will
 * increment candies[i] and set changed to true. We will also check if the
 * current element is greater than the next element and candies[i] is less than
 * or equal to candies[i+1]. If it is true, we will increment candies[i] and set
 * changed to true. We will return the sum of the array candies.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n^2) since we are running a while
 * loop and a for loop inside it.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(n) since we are using an extra
 * array candies.
 * 
 * Drawback of the approach:
 * The drawback of this approach is that we are running a while loop and a for
 * loop inside it.
 * 
 * Approach 2:
 * 
 */