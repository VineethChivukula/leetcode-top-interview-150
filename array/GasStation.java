/*
 * Problem Statement:
 * There are N gas stations along a circular route, where the amount of gas at
 * the ith station is gas[i]. You have a car with an unlimited gas tank and it
 * costs cost[i] of gas to travel from the ith station to its next (i + 1)th
 * station. You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit
 * once in the clockwise direction, otherwise return -1.
 * 
 * Thought Process:
 * Approach 1:
 * The first approach that should come to our mind is that we follow the rules
 * of the problem statement. We take startIndex, travelCost, and travelIndex.
 * startIndex will store the starting gas station's index. travelCost will store
 * the cost of traveling from the current gas station to the next gas station.
 * travelIndex will store the index of the gas station to which we are
 * traveling. So, startIndex will be running from 0 to n. Inside the loop, we
 * initialize travelCost to 0 and travelIndex to startIndex. We also initialize
 * canComplete to true. We run another loop from 0 to n. Inside the loop, we
 * calculate travelCost as travelCost + gas[travelIndex] - cost[travelIndex]. If
 * travelCost is less than 0, we set canComplete to false and break the loop. We
 * increment travelIndex by 1. If travelIndex is equal to n, we set travelIndex
 * to 0. Instead we will use travelIndex = (travelIndex + 1) % n. If canComplete
 * is true, we return startIndex. We return -1 if we come out of the loop.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n^2) since we are running two
 * loops.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 * 
 * Efficient Approach:
 * The concept here is very interesting to observe. What we will do is that we
 * calculate the total gas balance right from the starting index. We keep track
 * of this balance in order to check if we can complete the circuit. We are
 * doing this in order to avoid the extra loop that we were running in the above
 * approach. We will run a loop from 0 to n. Inside the loop, we will calculate
 * the gas[i] - cost[i] and store it in the totalGasBalance. We will also
 * calculate the currentGasBalance as currentGasBalance + gas[i] - cost[i].
 * currentGasBalance will keep track of the gas balance from the ith station to
 * the future stations. If currentGasBalance is less than 0, we will set
 * currentGasBalance to 0 and set startIndex to i+1. We will return startIndex
 * if totalGasBalance is greater than or equal to 0. We will return -1 if we
 * come out of the loop.
 * 
 * Time Complexity Analysis:
 * The Time Complexity of this approach is O(n) since we are running a single
 * loop.
 * 
 * Space Complexity Analysis:
 * The Space Complexity of this approach is O(1) since we are not using any
 * extra space.
 */

public class GasStation {
	public int approach1(int[] gas, int[] cost) {
		int n = gas.length;
		for (int startIndex = 0; startIndex < n; startIndex++) {
			int travelCost = 0;
			int travelIndex = startIndex;
			boolean canComplete = true;
			for (int i = 0; i < n; i++) {
				travelCost = travelCost + gas[travelIndex] - cost[travelIndex];
				if (travelCost < 0) {
					canComplete = false;
					break;
				}
				travelIndex = (travelIndex + 1) % n;
			}
			if (canComplete) {
				return startIndex;
			}
		}
		return -1;
	}

	public int efficientApproach(int[] gas, int[] cost) {
		int n = gas.length;
		int totalGasBalance = 0;
		int currentGasBalance = 0;
		int startIndex = 0;
		for (int i = 0; i < n; i++) {
			totalGasBalance += gas[i] - cost[i];
			currentGasBalance += gas[i] - cost[i];
			if (currentGasBalance < 0) {
				currentGasBalance = 0;
				startIndex = i + 1;
			}
		}
		return totalGasBalance >= 0 ? startIndex : -1;
	}

	public static void main(String[] args) {
		GasStation gs = new GasStation();
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		// System.out.println(gs.approach1(gas, cost));
		System.out.println(gs.efficientApproach(gas, cost));
	}
}