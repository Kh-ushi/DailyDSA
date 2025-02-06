//2171. Removing Minimum Number of Magic Beans

class Solution {
    public long minimumRemoval(int[] beans) {

        Arrays.sort(beans);
        int n=beans.length;
        long totalSum=0;

        for(int i=0;i<beans.length;i++){
            totalSum+=beans[i];
        }

       long minMoves=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            long remainingBeans=(long)beans[i]*(n-i);
            long moves=totalSum-remainingBeans;
            minMoves=Math.min(minMoves,moves);

        }

        return minMoves;

        
    }
}

// 2448. Minimum Cost to Make Array Equal

class Solution {
    public long solve(int arr[][], int median) {
        long val = arr[median][0]; 
        long cost = 0;
        
        for (int i = 0; i < arr.length; i++) {
            cost += Math.abs((long) (arr[i][0] - val)) * arr[i][1]; 
        }

        return cost;
    }

    public long minCost(int[] nums, int[] cost) {
        int arr[][] = new int[nums.length][2];
        long totalCost = 0; 

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
            totalCost += cost[i]; 
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int n = arr.length;
        int median = n / 2;
        long prefixCost = 0; 

        for (int i = 0; i < n; i++) {
            prefixCost += arr[i][1];
            if (prefixCost >totalCost / 2) { 
                median = i;
                break;
            }
        }

        return solve(arr, median);
    }
}


// 