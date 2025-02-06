// 30. Substring with Concatenation of All Words


class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < words[0].length() * words.length) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int wordSize = words[0].length();
        int n = s.length();
        int totalWords = words.length;

        for (int i = 0; i < wordSize; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();

            while (right + wordSize <= n) {
                String currentWord = s.substring(right, right + wordSize);
                right += wordSize;

                if (map.containsKey(currentWord)) {
                    seen.put(currentWord, seen.getOrDefault(currentWord, 0) + 1);
                    count++;

                    while (seen.get(currentWord) > map.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordSize);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordSize;
                    }

                    if (count == totalWords) {
                        result.add(left);
                    }
                } else {
                    left = right;
                    count = 0;
                    seen.clear();
                }
            }
        }
        return result;
    }
}

// 209. Minimum Size Subarray Sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int sum = 0;
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;

        while (right < nums.length) {

            sum += nums[right];

            while(sum>=target){
              result = Math.min(result, right-left+1);
              sum-=nums[left];
              left++;
              
            }

            right++;

        }

        return result==Integer.MAX_VALUE?0:result;

    }
}


// First negative in every window of size k  (GFG)

class Solution {

    // Function to find the first negative integer in every window of size k
    static List<Integer> FirstNegativeInteger(int arr[], int k) {
        
        List<Integer>ans=new ArrayList<>();
        
        int left=0;
        Queue<Integer>q=new LinkedList<>();
        
        for(int right=0;right<arr.length;right++){
            
            if(arr[right]<0){
                q.add(arr[right]);
            }
            
            if(right-left+1==k){
                
                int val=q.isEmpty()?0:q.peek();
                ans.add(val);
                
                if(arr[left]<0){
                    q.remove();
                }
                
                left++;
            }
            
        }
        
        return ans;
    }
}

//219. Contains Duplicate II
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> track = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (track.contains(nums[right])) {
                return true;
            }
            
           
            track.add(nums[right]);

            if (right - left >= k) {
                track.remove(nums[left]);
                left++;
            }
        }

        return false;
    }
}

// 2444. Count Subarrays With Fixed Bounds

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int culprit = -1;
        int maxpos = -1;
        int minpos = -1;
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == minK) minpos = i;
            if (num == maxK) maxpos = i;
            if (num < minK || num > maxK) culprit = i;

            if (minpos != -1 && maxpos != -1) {
                count += Math.max(0, Math.min(minpos, maxpos) - culprit);
            }
        }
        
        return count;
    }
}
