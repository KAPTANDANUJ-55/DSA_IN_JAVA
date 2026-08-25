package Arrays;

import java.util.*;


public class KadaneProduct {
    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        int maxProduct = maxProductSubarray(arr);
        System.out.println("Maximum Product Subarray: " + maxProduct);
    }

    private static int maxProductSubarray(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int maxProduct = arr[0];
        int minProduct = arr[0];
        int result = arr[0];

        int i=0;

        while(i<arr.length){
            maxProduct = Math.max(arr[i], Math.max(maxProduct * arr[i], minProduct * arr[i]));
            minProduct = Math.min(arr[i], Math.min(maxProduct * arr[i], minProduct * arr[i]));
            result = Math.max(result, maxProduct);
            i++;
        }

        return result;
    }
}