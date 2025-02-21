// 2136. Earliest Possible Day of Full Bloom

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
         
         int arr[][]=new int[plantTime.length][2];

         for(int i=0;i<arr.length;i++){
           
           arr[i][0]=plantTime[i];
           arr[i][1]=growTime[i];

         }

         Arrays.sort(arr,(a,b)->b[1]-a[1]);

         int plant=0;

         int timeTaken=0;

         for(int i=0;i<arr.length;i++){
            plant+=arr[i][0];
            timeTaken=Math.max(timeTaken,plant+arr[i][1]);
         }

         return timeTaken;

    }
}

// 2131. Longest Palindrome by Concatenating Two Letter Words
class Solution {
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            if (!map.containsKey(word)) continue;

            int freq = map.get(word);
            if (freq == 0) continue;

            if (word.charAt(0) == word.charAt(1)) {
                if (freq % 2 == 0) {
                    count += freq;
                } else {
                    count += freq - 1;
                    hasMiddle = true;
                }
                map.remove(word);
            } else {
                String rev = reverse(word);
                int revFreq = map.getOrDefault(rev, 0);
                int minPair = Math.min(freq, revFreq);

                count += minPair * 2;
                map.put(word, freq - minPair);
                map.put(rev, revFreq - minPair);
                if (map.get(word) == 0) map.remove(word);
                if (map.get(rev) == 0) map.remove(rev);
            }
        }

        if (hasMiddle) count++;

        return count * 2;
    }
}

// 1323. Maximum 69 Number

class Solution {
    public int maximum69Number(int num) {
        int place = 0;
        int maxPlaceValue = -1; 

        int temp = num; 

        while (temp != 0) {
            int digit = temp % 10;
            if (digit == 6) {
                maxPlaceValue = place; 
            }
            temp /= 10; 
            place++;
        }

        if (maxPlaceValue == -1) {
            return num; 
        }

        return num + 3 * (int) Math.pow(10, maxPlaceValue);
    }
}


// 2279. Maximum Bags With Full Capacity of Rocks
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int remainingCapacity[]=new int[capacity.length];
        for(int i=0;i<capacity.length;i++)
        {
            remainingCapacity[i]=capacity[i]-rocks[i];
        }
          
          int maxBags=0;

        Arrays.sort( remainingCapacity);
        for(int i=0;i<remainingCapacity.length;i++){
            if(additionalRocks>=remainingCapacity[i]){
                additionalRocks-=remainingCapacity[i];
                maxBags++;
            }

            if(additionalRocks==0){
              break;
            }
        }

         return maxBags;
        
    }
}


//1833. Maximum Ice Cream Bars
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        int largest=Integer.MIN_VALUE;

        for(int cost:costs){
          largest=Math.max(largest,cost);
        }

        int count[]=new int[largest+1];
        for(int cost:costs){
            count[cost]++;
        }

        int maxBars=0;

        for(int i=0;i<count.length;i++){
            
            if(count[i]==0){
                continue;
            }
            
            while(coins>=i && count[i]>0){
                coins-=i;
                maxBars++;
                count[i]--;
            }

            if(coins==0){
                break;
            }

        }

        return maxBars;

    }
} 


// 134. Gas Station
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int totalGas=0;
        for(int i=0;i<gas.length;i++){
            totalGas+=gas[i];
        }

        int totalCost=0;
        for(int j=0;j<cost.length;j++){
            totalCost+=cost[j];
        }

        if(totalGas<totalCost){
            return -1;
        }

        int total=0;
        int result=0;

        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];

            if(total<0){
                total=0;
                result=i+1;
            }
        }

       return result;

    }
}

// DAY