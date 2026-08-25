package Arrays;
import java.util.HashMap;
public class subArraySumEqualsK{
    public static void main(String[] args) {
        int[] nums = {6000,44000,300000,555000000,67808008};
        int k = 623158008;
        int count = subarraySum(nums, k);
        System.out.println("Count of subarrays with sum " + k + ": " + count);
    }
    private static int subarraySum(int[] nums, int k){
        int count =0;
        int Currsum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i=0;i<nums.length;i++){
            Currsum+=nums[i];
            if(map.containsKey(Currsum-k)){
                count+=map.get(Currsum-k);
            }
            map.put(Currsum, map.getOrDefault(Currsum, 0) + 1);
        }
        return count;
    }
}