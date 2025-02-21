
// 239. Sliding Window Maximum
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int ans[]=new int[nums.length-k+1];

        if(nums.length<k){
            return ans;
        }

        Deque<Integer>dq=new ArrayDeque<>();

        for(int i=0;i<nums.length;i++){
             
           while(!dq.isEmpty() && dq.peekFirst()<=i-k){
            dq.removeFirst();
           }

           while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
            dq.removeLast();
           }

           dq.addLast(i);

           if(i-k+1>=0){
            ans[i-k+1]=nums[dq.peekFirst()];
           }

        }

        return ans;

    }
}

// 1838. Frequency of the Most Frequent Element

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int maxFrequency = 1;
        long totalCost = 0;

        for (int right = 1; right < nums.length; right++) {
            totalCost += (long) (nums[right] - nums[right - 1]) * (right - left);

            while (totalCost > k) {
                totalCost -= nums[right] - nums[left]; 
                left++;
            }

            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }

        return maxFrequency;
    }
}

// 2150. Find All Lonely Numbers in the Array
Day8
class Solution {
    public List<Integer> findLonely(int[] nums) {

        List<Integer>ans=new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){

           if(i >0 && (nums[i-1]==nums[i] || nums[i-1]==nums[i]-1)){
            continue;
           }
           if(i<nums.length-1 && (nums[i]==nums[i+1] || nums[i+1]==nums[i]+1)){
            continue;
           }


           ans.add(nums[i]);
        }

        
        return ans;
    }
}