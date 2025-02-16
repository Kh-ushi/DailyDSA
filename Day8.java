// BAG OF TOKENS

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        int score = 0, maxScore = 0;

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left++];
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                power += tokens[right--];
                score--;
            } else {
                break;
            }
        }

        return maxScore;
    }
}

// 881. Boats to Save People
class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int left=0;
        int right=people.length-1;

        int boats=0;

        while(left<=right){
          
          if( left!=right && people[left]+people[right]<=limit){
            left++;
            boats++;
          }
          else if(left!=right && people[left]+people[right]>limit && people[right]<=limit){
            boats++;
          }
          else if(left==right && people[right]<=limit){
            boats++;
          }
         
          right--;

        }

        return boats;
        
    }
}

// 1328. Break a Palindrome
class Solution {
    public String breakPalindrome(String palindrome) {

        if(palindrome.length()==1){
            return "";
        }

        int left=0;
        int right=palindrome.length()-1;
        boolean isChanged=false;

        while(left<right){
           
           if(palindrome.charAt(left)!='a'){
            isChanged=true;
             return palindrome.substring(0,left)+'a'+palindrome.substring(left+1);
           }

           left++;
           right--;
        }

        if(!isChanged){
            return palindrome.substring(0,palindrome.length()-1)+'b';
        }
        return "";
        
    }
}

// 91. Broken Calculator
class Solution {
    public int brokenCalc(int startValue, int target) {
        
        if(startValue>=target){
            return startValue-target;
        }
        if(target%2==0){
            return 1 + brokenCalc(startValue,target/2);
        }

        return 1+brokenCalc(startValue,target+1);

    }
}

// 650. 2 Keys Keyboard
class Solution {

    public  int solve(int currA,int clipA,int n,int dp[][]){
     
     if(currA==n){
        return 0;
     }

     if(currA>n){
        return 1000000;
     }

     if(dp[currA][clipA]!=-1){
        return dp[currA][clipA];
     }

     int copyAllPaste=2+solve(currA+currA,currA,n,dp);
     int paste=1+solve(currA+clipA,clipA,n,dp);

     dp[currA][clipA]= Math.min(copyAllPaste,paste);
     return dp[currA][clipA];

    }


    public int minSteps(int n) {

        if(n==1){
            return 0;
        }

        int dp[][]=new int[1001][1001];

        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        return 1+solve(1,1,n,dp);
        
    }
}

// 650. 2 Keys Keyboard
class Solution {
    public int minSteps(int n) {
        int dp[] = new int[n + 1];

        // INITIALIZATION
        dp[0]=0;
        dp[1]=0;
        if(n>=2){
            dp[2]=2;
        }

        // MAIN LOGIC
        for (int i = 3; i <= n; i++) {
            int factor = i / 2;
            while (factor >= 1) {
                if (i % factor == 0) {
                    int steps = dp[factor];
                    int copy = 1;
                    int paste = (i / factor) - 1;
                    dp[i] = steps + copy + paste;
                    break;
                }
                factor--;
            }
        }
        return dp[n];
    }
}

// 1578. Minimum Time to Make Rope Colorful
class Solution {
    public int minCost(String colors, int[] neededTime) {
        
      int left=0;
      int right=0;

      int timeTaken=0;


      while(right<neededTime.length){

         int maxTime=Integer.MIN_VALUE;
         int totalTime=0;

         while(right<neededTime.length-1 && colors.charAt(right)==colors.charAt(right+1)){
            maxTime=Math.max(maxTime,neededTime[right]);
            totalTime+=neededTime[right];
            right++;
         }

         totalTime+=neededTime[right];
         maxTime=Math.max(maxTime,neededTime[right]);
        
        if(right-left+1>1){
           timeTaken+=(totalTime-maxTime);
        }
      
       right++;
       left=right;

      }

      return timeTaken;

    }
}