package Arrays;

import java.util.Arrays;

public class RearrangeArrayElementBySign {
    public static void main(String[] args) {
        int[] arr = {-3, 2, 3, -4, 5, -6};
        int[] result = rearrangeArrayBySign(arr);
        
       
        System.out.println("Rearranged Array: " + Arrays.toString(result));
       
    }

    private static int[] rearrangeArrayBySign(int[] nums) {
        int n = nums.length;
       
        int[] finalNum = new int[n];
       int posIdx=0;
       int negIdx=1;

      for(int i=0;i<n;i++){
           if(nums[i]>0){
            finalNum[posIdx] = nums[i];
            posIdx+=2;
           }
            else {
                finalNum[negIdx] = nums[i];
                negIdx += 2;
            }
      }
      return finalNum;
    }
}
