// 1248. Count Number of Nice Subarrays

class Solution {
    
    public int atMostSubArray(int nums[],int k){

      if(k<0){
        return 0;
      }  
      
      int left=0;
      int count=0;

      for(int right=0;right<nums.length;right++){

         if(nums[right]%2!=0){
            k--;
         } 
         while(k<0){
            if(nums[left]%2!=0){
                k++;

            }
            left++;
         }

         count+=right-left+1;

      }

      return count;

    }

    public int numberOfSubarrays(int[] nums, int k) {

        return atMostSubArray(nums,k)-atMostSubArray(nums,k-1);
        
    }
}

// 2261. K Divisible Elements Subarrays

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int left = 0;
        Set<String> arrs = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % p == 0) {
                k--;
            }

            while (k < 0) {
                if (nums[left] % p == 0) {
                    k++;
                }
                left++;
            }

            for (int i = left; i <= right; i++) {
                arrs.add(Arrays.toString(Arrays.copyOfRange(nums, i, right + 1))); 
        }

        
    }
    return arrs.size();
}

}
// NUMBER OF GOOD SUBARRAYS
class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int ones = 0;
        for (int num : nums) {
            if (num == 1) ones++;
        }
        
        if (ones == 0 || ones == 1) return ones;

        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                start = i;
                break;
            }
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                end = i;
                break;
            }
        }

        int ans = 1;
        int zeroes = 0;
        
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] == 0) {
                zeroes++;
            } else { 
                ans *= (zeroes + 1);
                zeroes = 0; 
            }
        }

        return ans;
    }
}


// 2750. Ways to Split Array Into Good Subarrays

class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {

       int MOD=1000000000+7;

        int ones = 0;
        for (int num : nums) {
            if (num == 1) ones++;
        }
        
        if (ones == 0 || ones == 1) return ones;

        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                start = i;
                break;
            }
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                end = i;
                break;
            }
        }

        long ans = 1;
        int zeroes = 0;
        
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] == 0) {
                zeroes++;
            } else if(nums[i]==1 && zeroes!=0) { 
                ans =ans*(zeroes + 1)%MOD;
                zeroes = 0; 
            }
        }

        return (int)ans;
    }
}


//1456. Maximum Number of Vowels in a Substring of Given Length 
class Solution {
    public int maxVowels(String s, int k) {

        Set<Character>vowels=new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int left=0;
        int maxVowels=Integer.MIN_VALUE;
        int count=0;

        for(int right=0;right<s.length();right++){
            
            char ch=s.charAt(right);
            if(vowels.contains(ch)){
              count++;
            }

            if(right-left+1==k){
                maxVowels=Math.max(count,maxVowels);
                if(vowels.contains(s.charAt(left))){
                    count--;
                }
                left++;
            }
        }

        return maxVowels;
        
    }
}



// 2090. K Radius Subarray Averages

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);  

        if (2 * k + 1 > n) {
            return ans; 
        }

        long sum = 0; 


        for (int i = 0; i < 2 * k + 1; i++) {
            sum += nums[i];
        }

        ans[k] = (int) (sum / (2 * k + 1));

        // Sliding window
        for (int i = k + 1; i + k < n; i++) {
            sum -= nums[i - k - 1];  
            sum += nums[i + k];  
            ans[i] = (int) (sum / (2 * k + 1));
        }

        return ans;
    }
}


// 1493. Longest Subarray of 1's After Deleting One Element
class Solution {
    public int longestSubarray(int[] nums) {
        
        int left=0;
        int maxLength=Integer.MIN_VALUE;
        int count=0;

        for(int right=0;right<nums.length;right++){

            if(nums[right]==0){
                count++;
            }

            while(count>1){   
                if(nums[left]==0){
                    count--;
                }
                left++;
            }

            maxLength=Math.max(maxLength,right-left);
        }

        return maxLength;

    }
}

// 2024. Maximize the Confusion of an Exam

class Solution {
     
    public int solve(String answerKey,int k,char toBeReplaced){

         int count=0;
        int left=0;
        int maxLength=Integer.MIN_VALUE;

        for(int right=0;right<answerKey.length();right++){
           
           char ch=answerKey.charAt(right);
            if(ch==toBeReplaced){
                count++;
            }

            while(count>k){

                if(answerKey.charAt(left)==toBeReplaced){
                    count--;
                }
                left++;
            }

            maxLength=Math.max(maxLength,right-left+1);
        }

        return maxLength;

    } 

    public int maxConsecutiveAnswers(String answerKey, int k) {

        int trues = 0;
        int falses = 0;

        for (int i = 0; i < answerKey.length(); i++) {

            if (answerKey.charAt(i) == 'T') {
                trues++;
            } else {
                falses++;
            }

        }

        if (trues == answerKey.length() || falses == answerKey.length()) {
            return answerKey.length();
        }

        
       return Math.max(solve(answerKey,k,'T'),solve(answerKey,k,'F'));
    
     

    }
}

// 424. Longest Repeating Character Replacement
class Solution {
    public int characterReplacement(String s, int k) {
        int map[] = new int[26];
        int maxCount = 0;
        int maxLength = 0; 

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            
            char ch = s.charAt(right);
            map[ch - 'A']++;
            maxCount = Math.max(maxCount, map[ch - 'A']);

            while (right - left + 1 - maxCount > k) {
                map[s.charAt(left) - 'A']--;
                left++; 
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
