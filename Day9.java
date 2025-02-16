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
