// 1793. Maximum Score of a Good Subarray

class Solution {
    public int maximumScore(int[] nums, int k) {

        int n=nums.length;

        int i = k;
        int j = k;

        int currMin=nums[k];
        int result=nums[k];

        while (i > 0 || j < n - 1) {
             
             int leftValue=i>0?nums[i-1]:0;
             int rightValue=j<n-1?nums[j+1]:0;

             if(leftValue>rightValue){
                i--;
                currMin=Math.min(currMin,nums[i]);
             }
             else{
                j++;
                currMin=Math.min(currMin,nums[j]);
             }

             result=Math.max(result,(j-i+1)*currMin);

        }
        
        return result;

    }
}

// 1921. Eliminate Maximum Number of Monsters

class Solution {
    class Pair {
    float time;
    int index;

    Pair(float time, int index) {
        this.time = time;
        this.index = index;
    }
}

public int eliminateMaximum(int[] dist, int[] speed) {
    Pair[] timeTaken = new Pair[dist.length];

    for (int i = 0; i < dist.length; i++) {
        timeTaken[i] = new Pair((float) dist[i] / speed[i], i);
    }

    Arrays.sort(timeTaken, Comparator.comparingDouble(a -> a.time));

    int count = 0;
    int time = 0;

    for (int i = 0; i < timeTaken.length; i++) {
        int idx = timeTaken[i].index;

        if (dist[idx] - (time * speed[idx]) <= 0) {
            return count;
        }

        time++;
        count++;
    }

    return count;
}
}

//1846. Maximum Element After Decreasing and Rearranging

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);

        if(arr[0]!=1){
            arr[0]=1;
        }
        
        for(int right=1;right<arr.length;right++){

           if(arr[right]-arr[right-1]>1){
              arr[right]=arr[right-1]+1;
           }

        }

        return arr[arr.length-1];
        
    }
}


// 1561. Maximum Number of Coins You Can Get
class Solution {
    public int maxCoins(int[] piles) {
        
        Arrays.sort(piles);

        int left=0;
        int right=piles.length-1;

        int count=0;

        while(left<right){
           
           right--;
           count+=piles[right--];

           left++;

        }

        return count;

    }
}

// 2870. Minimum Number of Operations to Make Array Empty

class Solution {
    public int minOperations(int[] nums) {
        
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int operations=0;

        for(int count:map.values()){
           
           if(count==1){
            return -1;
           }

           int moves=0;

           moves+=count/3;
           count=count%3;

           if(count%2==0){
            moves+=count/2;
           }
           else{
            moves+=(count+3)/3;
           }

           operations+=moves;
           
        }

        return operations;
    }
}

// Water the plants GFG

class Solution {
    class Sprinkler implements Comparable<Sprinkler> {
        int start;
        int end;

        public Sprinkler(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Sprinkler s2) {
            if (this.start == s2.start) {
                return s2.end - this.end; 
            }
            return this.start - s2.start; 
        }
    }

    int min_sprinklers(int gallery[], int n) {
        PriorityQueue<Sprinkler> pq = new PriorityQueue<>();

        for (int i = 0; i < gallery.length; i++) {
            if (gallery[i] < 0) continue; 
            
            int start = Math.max(0, i - gallery[i]);
            int end = Math.min(n - 1, i + gallery[i]);

            pq.add(new Sprinkler(start, end));
        }

        if (pq.isEmpty()) return -1; 

        int maxEnd = 0; 
        int count = 0;
        int farthest = 0;

        while (!pq.isEmpty() && maxEnd < n) {
            if (pq.peek().start > maxEnd) return -1; 
            
           
            while (!pq.isEmpty() && pq.peek().start <= maxEnd) {
                farthest = Math.max(farthest, pq.poll().end);
            }

            count++;
            maxEnd = farthest + 1;

            if (maxEnd >= n) return count; 
        }

        return -1; 
    }
}

// 2971. Find Polygon With the Largest Perimeter
class Solution {
    public long largestPerimeter(int[] nums) {

       Arrays.sort(nums);

        long sum=0;
        long maxSum=Integer.MIN_VALUE;

        for(int right=0;right<nums.length;right++){

           if(right>=2 && sum>nums[right]){
              maxSum=Math.max(maxSum,sum+nums[right]);
           }

           sum+=nums[right];

        }

        return maxSum==Integer.MIN_VALUE?-1:maxSum;
        
    }
}

// 1481. Least Number of Unique Integers after K Removals


class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        
        int left = 0;
        for (int right = 1; right < arr.length; right++) { 
            if (arr[right] != arr[right - 1]) { 
                list.add(right - left); 
                left = right; 
            }
        }
        list.add(arr.length - left); 
        
        Collections.sort(list); 
        
        int uniqueCount = list.size();
        for (int freq : list) {
            if (freq <= k) {
                k -= freq;
                uniqueCount--; 
            } else {
                break;
            }
        }
        
        return uniqueCount;
    }
}

// 1642. Furthest Building You Can Reach
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        for (; i < heights.length - 1; i++) {

            if (heights[i + 1] <= heights[i]) {
                continue;
            }

            int diff = heights[i + 1] - heights[i];

            if (bricks >= diff) {
                bricks -= diff;
                pq.add(diff);
            } else if (ladders > 0) {
                if (!pq.isEmpty()) {
                    if (pq.peek() > diff) {
                        bricks += pq.poll();
                        bricks -= diff;
                        pq.add(diff);
                    }
                }

                ladders--;

            }

            else{
                break;
            }

        }

        return i;

    }
}