
// 509. Fibonacci Number
class Solution {
    public int fib(int n) {

        if(n==1 || n==0){
            return n;
        }

        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
        
    }
}

// 70. Climbing Stairs
class Solution {
    public int climbStairs(int n) {
        
      int dp[]=new int[n+1];

      dp[0]=1;
      dp[1]=1;

      for(int i=2;i<=n;i++){
        dp[i]=dp[i-1]+dp[i-2];
      }

      return dp[n];
        
    }
}


// 198. House Robber
class Solution {
   
    public int solve(int nums[],int idx,int dp[]){
 
     if(idx>=nums.length){
         return 0;
     }
     
     if(dp[idx]!=-1){
         return dp[idx];
     }
 
     int max=0;
 
     for(int i=idx+2;i<nums.length;i++){
       
       max=Math.max(max,solve(nums,i,dp));
 
     }
 
     return dp[idx]=nums[idx]+max;
 
    }
 
     public int rob(int[] nums) {
 
         int dp[]=new int[nums.length];
         Arrays.fill(dp,-1);
         return Math.max(solve(nums,0,dp),solve(nums,1,dp));
         
     }
 }


 //213. House Robber II
 class Solution {
   
    public int solve(int nums[],int n,int idx,int dp[]){
 
     if(idx>n){
         return 0;
     }
 
     if(n<0){
         return 0;
     }
 
  
 
     if(dp[idx]!=-1){
         return dp[idx];
     }
      
      int max=0;
      for(int i=idx+2;i<=n;i++){
       
       max=Math.max(max,solve(nums,n,i,dp));
 
      }
 
      return dp[idx]=nums[idx]+max;
 
    }
 
     public int rob(int[] nums) {
       int n=nums.length;
 
       if(n==1){
         return nums[0];
       }
 
       int dp[]=new int[n];
       Arrays.fill(dp,-1);
       int ans1=Math.max(solve(nums,n-2,0,dp),solve(nums,n-2,1,dp));
 
        dp=new int[n];
        Arrays.fill(dp,-1);
       int ans2=Math.max(solve(nums,n-1,1,dp),solve(nums,n-1,2,dp));
 
       return Math.max(ans1,ans2); 
         
     }
 }


//  1911. Maximum Alternating Subsequence Sum

class Solution {

    public long solve(int nums[],int idx,int isEven,long dp[][]){
 
      if(idx>=nums.length){
         return 0;
      }
 
      if(dp[idx][isEven]!=-1){
         return dp[idx][isEven];
      }
       
       if(isEven==1){
         return dp[idx][isEven]=Math.max(nums[idx]+solve(nums,idx+1,0,dp),solve(nums,idx+1,isEven,dp));
       }
 
       return dp[idx][isEven]= Math.max(-nums[idx]+solve(nums,idx+1,1,dp),solve(nums,idx+1,isEven,dp));
 
    } 
 
     public long maxAlternatingSum(int[] nums) {
        
        long dp[][]=new long[nums.length][2];
 
        for(long d[]:dp){
         Arrays.fill(d,-1);
        }
 
         return solve(nums,0,1,dp);
         
     }
 }

//  same question diff approach
class Solution {
    public long maxAlternatingSum(int[] nums) {

        long t[][]=new long[nums.length+1][2];

        for(int i=1;i<=nums.length;i++){
         
          t[i][0]=Math.max(t[i-1][1]-nums[i-1],t[i-1][0]);
          t[i][1]=Math.max(t[i-1][0]+nums[i-1],t[i-1][1]);

        }
        
        return Math.max(t[nums.length][0],t[nums.length][1]);
    }
}


// 300. Longest Increasing Subsequence


class Solution {

    public int solve(int nums[], int idx, int lastNum, int dp[][]) {
        if (idx == nums.length) {
            return 0;
        }

        
        if (dp[idx][lastNum + 1] != -1) {
            return dp[idx][lastNum + 1];
        }

        int take = 0;
        if (lastNum == -1 || nums[idx] > nums[lastNum]) {
            take = 1 + solve(nums, idx + 1, idx, dp);
        }

        int skip = solve(nums, idx + 1, lastNum, dp);

        
        return dp[idx][lastNum + 1] = Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int dp[][] = new int[nums.length][nums.length + 1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return solve(nums, 0, -1, dp);
    }
}
