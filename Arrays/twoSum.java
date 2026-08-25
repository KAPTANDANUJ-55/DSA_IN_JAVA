package Arrays;
import java.util.*;
public class twoSum {
    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums,target);
        System.out.println("Indices of the two numbers that add up to " + target + ": [" + result[0] + ", " + result[1] + "]");
    }

    private static int[] twoSum(int[] nums, int target){
        // -----------> Brute Force Approach <-----------

        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{-1, -1};


        // ------------> Optimized Approach <-----------

        int[] res = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int z = target - nums[i];

            if(hm.containsKey(z)){
                res[0] = nums[i];
                res[1] = z;
                return res;
            }
             
            hm.put(nums[i],i);
        }
        return res;
    }
}
