package Arrays;
import java.util.*;
public class ThreeSum {
   
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        threeSum(arr);//prints the 3Sum
        System.out.println(finalThreeSum(arr));
    }

    private static void threeSum(int[] arr) {
        int n = arr.length;
        boolean found = false;
        // ---------->Brute Force Approach<----------
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        System.out.println("Triplet: " + arr[i] + ", " + arr[j] + ", " + arr[k]);
                        found = true;
                    }
                }
            }
        }

        if (!found) {
            System.out.println("No triplets found that sum to zero.");
        }
    }
    private static  List<List<Integer>> finalThreeSum(int[] arr){
        // ---------->Optimized Approach<----------
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;

            int left = i+1;
            int right = arr.length-1;

            while(left<right){
                int sum = arr[i]+arr[left]+arr[right];

                if(sum==0){
                    result.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++;
                    right--;

                    while(left<right && arr[left]==arr[left-1]) left++;
                    while(left<right && arr[right]==arr[right+1]) right--;
                }
                else if(sum<0) left++;
                else right--;
            }
        }
        return result;
    }
}
