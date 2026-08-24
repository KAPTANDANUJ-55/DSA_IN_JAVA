package Arrays;
import java.util.ArrayList;

public class removeDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println("Your OutPut is: " + removeDuplicates(nums));
           System.out.print("Modified Array (First k elements): [");
        for (int i = 0; i < removeDuplicates(nums); i++) {
            System.out.print(nums[i] + (i < removeDuplicates(nums) - 1 ? ", " : ""));
        }
        System.out.println("]\n");
        System.out.println("Your OutPut is: " + removeDuplicatesOptimized(nums));
    }
// Brute Force Approach
    private static int removeDuplicates(int[] nums){
        ArrayList<Integer> uniqueList = new ArrayList<>();
              for (int i = 0; i < nums.length; i++) {
            if (!uniqueList.contains(nums[i])) {
                uniqueList.add(nums[i]);
            }


        }

        int k = uniqueList.size();

        for(int i = 0; i < k; i++) {
            nums[i] = uniqueList.get(i);
        }
        return k;
    }


    // Optimized Approach

    private static int removeDuplicatesOptimized(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int k = 1; // Pointer for the next unique element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
