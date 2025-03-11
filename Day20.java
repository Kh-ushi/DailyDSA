// 300. Longest Increasing Subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {

        int dp[]=new int[nums.length];
        int ans=1;
        
        Arrays.fill(dp,1);

        for(int i=1;i<dp.length;i++){
             
             int maxLength=0;
             for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxLength=Math.max(maxLength,dp[j]);
                }
             }

             dp[i]=dp[i]+maxLength;
             ans=Math.max(ans,dp[i]);
        }

        return ans;
        
    }
}


// 1048. Longest String Chain
class Solution {

    public boolean isPredecessor(String str1,String str2){

        if(str1.length()-str1.length()>1 || str2.length()-str1.length()!=1){
            return false;
        }

        int i=0,j=0;
        while(i<str1.length() && j<str2.length()){
          
          if(str1.charAt(i)==str2.charAt(j)){
            i++;
          }
          j++;

        }

        return i==str1.length();
    }
   
    public int solve(String words[],int idx,int prev,int dp[][]){
     
     if(idx>=words.length){
        return 0;
     }

     if(prev!=-1 && dp[idx][prev]!=-1){
        return dp[idx][prev];
     }

     int take=0;
     if(prev==-1 || isPredecessor(words[prev],words[idx])){
        take=1+solve(words,idx+1,idx,dp);
     }
     int skip=solve(words,idx+1,prev,dp);

     if(prev!=-1){
        dp[idx][prev]=Math.max(skip,take);
     }

     return Math.max(skip,take);

    }

    public int longestStrChain(String[] words) {

        Arrays.sort(words,(a,b)->a.length()-b.length());
        int dp[][]=new int[words.length][words.length];

        for(int d[]:dp){
            Arrays.fill(d,-1);
        }

        return solve(words,0,-1,dp);


        
    }
}


// 1048. Longest String Chain -tabulation
class Solution {

    public boolean isPredecessor(String str1,String str2){

        if(str2.length()-str1.length()!=1){
            return false;
        }

        int i=0,j=0;
        while(i<str1.length() && j<str2.length()){
          
          if(str1.charAt(i)==str2.charAt(j)){
            i++;
          }
          j++;

        }

        return i==str1.length();
    }
   
   

    public int longestStrChain(String[] words) {

        if(words.length==1){
            return 1;
        }

        Arrays.sort(words,(a,b)->a.length()-b.length());
        
        int dp[]=new int[words.length];
        Arrays.fill(dp,1);
        int ans=1;

        for(int i=1;i<words.length;i++){

            int maxLength=0;
            for(int j=0;j<i;j++){
              if(isPredecessor(words[j],words[i])){
                dp[i] = Math.max(dp[i], dp[j] + 1);
              }
              ans=Math.max(ans,dp[i]);
            }
        }

       
      return ans;

        
    }
}


// 420. Build Array Where You Can Find The Maximum Exactly K Comparisons

class Solution {

    int mod = 1000000007;

    public int solve(int idx, int searchCost, int max, int n, int m, int k, int dp[][][]) {
        if (idx == n) {
            return searchCost == k ? 1 : 0;
        }

        if (searchCost > k) {
            return 0;
        }

        
        if (dp[idx][searchCost][max + 1] != -1) {
            return dp[idx][searchCost][max + 1];
        }

        int ans = 0;
        for (int i = 1; i <= m; i++) {
            if (i > max) {
                ans = (ans + solve(idx + 1, searchCost + 1, i, n, m, k, dp)) % mod;
            } else {
                ans = (ans + solve(idx + 1, searchCost, max, n, m, k, dp)) % mod;
            }
        }

        return dp[idx][searchCost][max + 1] = ans;
    }

    public int numOfArrays(int n, int m, int k) {
        int dp[][][] = new int[n][k + 1][m + 2]; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l <= m + 1; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }

        return solve(0, 0, -1, n, m, k, dp);
    }
}
