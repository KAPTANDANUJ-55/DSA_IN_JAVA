package Arrays;
import java.util.*;

public class kadanePrint {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = findMaxSubarraySum(nums);
        System.out.println("Maximum Subarray Sum: " + maxSum);
    }
    
    private static int findMaxSubarraySum(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                start = i;
            }

            sum = sum + nums[i];

            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

       
        System.out.print("The maximum subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i]);
            if (i < ansEnd) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

     
        return maxi;
    }
}
