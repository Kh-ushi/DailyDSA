// 2405. Optimal Partition of String

class Solution {
    public int partitionString(String s) {
        
        Map<Character,Integer>map=new HashMap<>();

        int left=0;

        int count=0;

        for(int right=0;right<s.length();right++){
           
           char ch=s.charAt(right);

           if(map.containsKey(ch) && map.get(ch)>=left){
             count++;
             left=right;
           }

            map.put(ch,right);
        }

        return count+1;
        
    }
}

// 649. Dota2 Senate
class Solution {
      
    public void removeNextOptimal(String senate,char ch,int idx,boolean removed[]){

       while(true){
          
          if(senate.charAt(idx)==ch && removed[idx]==false){
            removed[idx]=true;
            break;
          }

          idx=(idx+1)%senate.length();

       }

    }


    public String predictPartyVictory(String senate) {
        
        boolean removed[]=new boolean[senate.length()];

        int Rcount=0;
        int Dcount=0;

        // COUNTNING D AND R

         for(int i=0;i<senate.length();i++){
            
            char ch=senate.charAt(i);
            
            if(ch=='R'){
                Rcount++;
            }
            else{
                Dcount++;
            }
         }
         
         //MAIN LOGIC
         int idx=0;

         while(Rcount>0 && Dcount>0){
          
          if(removed[idx]==false){
             if(senate.charAt(idx)=='R'){
            removeNextOptimal(senate,'D',(idx+1)%senate.length(),removed);
             Dcount--;
          }else{
             removeNextOptimal(senate,'R',(idx+1)%senate.length(),removed);
             Rcount--;
          }
          }

          idx=(idx+1)%senate.length();
             
         }

         return Rcount==0?"Dire":"Radiant";


    }
}

// 495. Teemo Attacking
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0 || duration <= 0) {
            return 0;
        }

        int totalDuration = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {
            totalDuration += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }

        return totalDuration + duration;
    }
}


// 2366. Minimum Replacements to Sort the Array
class Solution {
    public long minimumReplacement(int[] nums) {

        long count=0;

        for(int i=nums.length-2;i>=0;i--){

            if(nums[i]<=nums[i+1]){
             continue;
            }
            
            int parts=nums[i]/nums[i+1];
            if(nums[i]%nums[i+1]!=0){
                parts++;
            }

            count+=parts-1;
            nums[i]=nums[i]/parts;
             
        }

        return count;
        
    }
}

// 1326. Minimum Number of Taps to Open to Water a Garden

class Solution {
    class Range implements Comparable<Range> {

        int start;
        int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Range r2) {
            if (this.start == r2.start) {
                return r2.end - this.end;
            }
            return this.start - r2.start;
        }
    }

    public int minTaps(int n, int[] ranges) {

        PriorityQueue<Range> pq = new PriorityQueue<>();

        for (int i = 0; i < ranges.length; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);

            if (start < end) {
                pq.add(new Range(start, end));
            }
        }

        int taps = 0;
        int maxEnd = 0;
        int minEnd = 0;

        while (!pq.isEmpty()) {

            Range curr = pq.poll();

            if (curr.start > maxEnd) {
                return -1;
            }

            if (curr.start > minEnd) {
                taps++;
                minEnd = maxEnd;
            }

            maxEnd = Math.max(maxEnd, curr.end);

            if (maxEnd >= n) {
                return taps + 1;
            }
        }

        return -1;
    }
}

// 1647. Minimum Deletions to Make Character Frequencies Uniqueg

class Solution {
    public int minDeletions(String s) {
        
        char charArray[] = s.toCharArray();
        Arrays.sort(charArray);

        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            
            if (charArray[left] != charArray[right]) {
                int count = right - left;

                while (count > 0 && set.contains(count)) {
                    count--;
                    ans++;
                }

                if (count > 0) {
                    set.add(count);
                }

                left = right;
            }
        }

        
        if (left < s.length()) {
            int count = s.length() - left;
            while (count > 0 && set.contains(count)) {
                count--;
                ans++;
            }
            if (count > 0) {
                set.add(count);
            }
        }

        return ans;
    }
}
