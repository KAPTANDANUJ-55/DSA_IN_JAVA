package Arrays;
import java.util.HashMap;
public class majorityElement {
   
    public static void main(String[] args) {
         // ------------> O(n) space and O(n) time complexity <------------
         int[] nums = {3, 2, 3};
            int majority = findMajorityElementLinearSpaceComplexity(nums);
            System.out.println("Majority Element: " + majority);
    }
    private static int findMajorityElementLinearSpaceComplexity(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > nums.length / 2){
                return key;
            }
        }

        return -1; // No majority element found
    }
}
