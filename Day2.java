// 453. Minimum Moves to Equal Array Elements

class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        
        return sum - min * nums.length;
    }
}


// 2033. Minimum Operations to Make a Uni-Value Grid

import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int rows = grid.length, cols = grid[0].length;
        int n = rows * cols;
        int[] arr = new int[n];

        int idx = 0;
        for (int[] row : grid) {
            for (int num : row) {
                arr[idx++] = num;
            }
        }


        Arrays.sort(arr);


        int median1 = arr[n / 2]; 
        int median2 = (n % 2 == 0) ? arr[(n / 2) - 1] : median1; 

        boolean isMedian1=true;
        boolean isMedian2=true;
        for (int num : arr) {
            if ((num - median1) % x != 0) {
                isMedian1=false;
                break;
            }
        }

        for (int num : arr) {
            if ((num - median2) % x != 0) {
                isMedian2=false;
                break;
            }
        }

        if(isMedian1==true && isMedian2==true){
        return Math.min(getOperations(arr, median1, x), getOperations(arr, median2, x));

        }

        else if(isMedian1){
          return getOperations(arr, median1, x);
        }
        else if(isMedian2){
          return getOperations(arr, median2, x);
        }
        return -1;

    }

    private int getOperations(int[] arr, int median, int x) {
        int operations = 0;
        for (int num : arr) {
            operations += Math.abs(num - median) / x;
        }
        return operations;
    }
}

