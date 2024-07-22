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
 * 
 */