import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();

        // Create a map to store the next greater element for each element in nums2
        int[] nextGreater = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            nextGreater[i] = -1;
        }

        // Iterate through nums2 to find the next greater element for each element
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                nextGreater[stack.pop()] = nums2[i];
            }
            stack.push(i);
        }

        // Create a map to store the index of each element in nums2
        int[] indexMap = new int[10001]; // assuming the maximum value in nums2 is 10000
        for (int i = 0; i < nums2.length; i++) {
            indexMap[nums2[i]] = i;
        }

        // Fill the result array with the next greater element for each element in nums1
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater[indexMap[nums1[i]]];
        }

        return result;
    }
}