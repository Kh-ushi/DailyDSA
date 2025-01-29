// 27. Remove Element
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; 
        
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j]; 
                i++;
            }
        }

        return i; 
    }
}

// 0. Remove Duplicates from Sorted Array II
class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }
        int left = 2;
        for (int right = 2; right < nums.length; right++) {

          if(nums[left-2]!=nums[right]){
            nums[left]=nums[right];
            left++;
          }
               
        }

        return left;

    }
}

// 2460. Apply Operations to an Array
class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int prev = 0;
        for (int curr = 0; curr < nums.length; curr++) {
            if (nums[curr] != 0) {
                if (curr != prev) {
                    int temp = nums[curr];
                    nums[curr] = nums[prev];
                    nums[prev] = temp;
                }
                prev++;
            }
        }

        return nums;
    }
}


// 283. Move Zeroes
class Solution {
    public void moveZeroes(int[] nums) {

        int prev = 0;
        for (int curr = 0; curr < nums.length; curr++) {
            if (nums[curr] != 0) {
                if (curr != prev) {
                    int temp = nums[curr];
                    nums[curr] = nums[prev];
                    nums[prev] = temp;
                }
                prev++;
            }
        }

     

    }
}



// 1685. Sum of Absolute Differences in a Sorted Array
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {

        int prefix[]=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
          prefix[i]=prefix[i-1]+nums[i];
        }

        int suffix[]=new int[nums.length];
        suffix[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            suffix[i]=suffix[i+1]+nums[i];
        }

        // MAIN LOGIC
        int result[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
           int prefixSum=i==0?0:prefix[i-1];
           int suffixSum=i==nums.length-1?0:suffix[i+1];

           result[i]=nums[i]*i-prefixSum+suffixSum-nums[i]*(nums.length-i-1);
           
        }

        return result;
        
    }


 // 2615. Sum of Distances


 class Solution {
     public long[] distance(int[] nums) {
 
         int n = nums.length;
         long[] result = new long[n];
 
         Map<Integer, List<Integer>> indexMap = new HashMap<>();
         for (int i = 0; i < n; i++) {
             indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
         }
 
         for (List<Integer> indices : indexMap.values()) {
             int size = indices.size();
             if (size == 1) {
                 continue;
             }
 
             long prefixSum = 0;
             long prefixCount = 0;
             long suffixSum = 0;
             long suffixCount = size;
 
             for (int idx : indices) {
                 suffixSum += idx;
             }
 
             for (int i = 0; i < size; i++) {
                 int index = indices.get(i);
 
                 suffixSum -= index;
                 suffixCount--;
 
                 long leftSum = prefixCount * index - prefixSum;
                 long rightSum = suffixSum - suffixCount * index;
                 result[index] = leftSum + rightSum;
 
                 prefixSum += index;
                 prefixCount++;
             }
         }
 
         return result;
     }
 }
 


//  442. Find All Duplicates in an Array
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; 
            if (nums[index] < 0) {
                result.add(Math.abs(nums[i])); 
            } else {
                nums[index] = -nums[index];
            }
        }
        return result;
    }
}


// 2602. Minimum Operations to Make All Array Elements Equal


class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        List<Long> result = new ArrayList<>();

        Arrays.sort(nums);
        long[] prefixSum = new long[n];

        prefixSum[0] = (long) nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int q : queries) {
            int idx = Arrays.binarySearch(nums, q);
            if (idx < 0) {
                idx = -idx - 1;
            }

            long leftSum = idx > 0 ? (long) idx * q - prefixSum[idx - 1] : (long) idx * q;
            long rightSum = idx < n ? (prefixSum[n - 1] - (idx > 0 ? prefixSum[idx - 1] : 0)) - (long) (n - idx) * q : 0;

            result.add(leftSum + rightSum);
        }

        return result;
    }
}