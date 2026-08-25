package Arrays;

public class dutchNationalFlag {
    // -----------> Brute Force Approach <-----------
    //   sorting is the brute force approach to solve this problem. We can sort the array and get the desired output. But the time complexity of this approach is O(nlogn) and space complexity is O(1).

    // -----------> Dutch National Flag Algorithm <-----------
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        dutchNationalFlag(arr);
        System.out.println("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void dutchNationalFlag(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, low++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high--);
                    break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
//   ----------Better Approach----------


/*
int c0 = 0, c1 = 0, c2 = 0;
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == 0) {
        c0++;
        } else if (arr[i] == 1) {
        c1++;
        } else {
        c2++;
    }
}  

int idx =0;

while(c0-->0){
    arr[idx++] = 0;
}
while(c1-->0){
    arr[idx++] = 1;
}
while(c2-->0){
    arr[idx++] = 2;
}                  

*/