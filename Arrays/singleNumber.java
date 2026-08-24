package Arrays;


import java.util.HashMap;
public class singleNumber{

    public static void main(String[] args) {
    
   int[] nums = {4, 1, 2, 1, 2};
    System.out.println("Your OutPut is: "+ singleNumber(nums));
}

     private static int singleNumber(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int num : map.keySet()){
            if(map.get(num) == 1){
                return num;
            }
        }

        return -1;
     }}

