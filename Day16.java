// 899. Orderly Queue

class Solution {

    public String orderlyQueue(String s, int k) {
        
        String str=new String(s);
       
       if(k==1){
         
         for(int i=1;i<s.length();i++){
             
             char ch=s.charAt(0);
             s=s.substring(1)+ch;

             if(s.compareTo(str)<0){
                str=s;
             }

         }

         return str;

       }


       char charArray[]=s.toCharArray();
       Arrays.sort(charArray);
       String sortedStr = new String(charArray);
       return sortedStr;
      
    }
}


// 1544. Make The String Great
class Solution {
    public String solve(String s) {
        if (s.length() <= 1) {
            return s;
        }
        
        if (Math.abs(s.charAt(0) - s.charAt(1)) == 32) {
            return solve(s.substring(2));
        }
        
        String result= s.charAt(0) + solve(s.substring(1));

        if(result.length()>=2 && Math.abs(result.charAt(0)-result.charAt(1))==32){
           result=result.substring(2);
        }

        return result;
    }

    public String makeGood(String s) {
        if (s.length() == 0) {
            return "";
        }
        return solve(s);
    }
}


// 1704. Determine if String Halves Are Alike

class Solution {
    public Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public boolean halvesAreAlike(String s) {
        int lcount = 0, rcount = 0;
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (vowels.contains(s.charAt(left))) {
                lcount++;
            }
            if (vowels.contains(s.charAt(right))) {
                rcount++;
            }
            left++;
            right--;
        }
        return lcount == rcount;
    }
}



// 1657. Determine if Two Strings Are Close
class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        if(word1.length()!=word2.length()){
            return false;
        }

        HashSet<Character>set=new HashSet<>();

        int list1[]=new int[26];
        

        for(int i=0;i<word1.length();i++){
            char ch=word1.charAt(i);
            set.add(ch);
            list1[ch-'a']++;
        }

        int list2[]=new int[26];
        for(int i=0;i<word2.length();i++){
            char ch=word2.charAt(i);

            if(!set.contains(ch)){
                return false;
            }
            list2[ch-'a']++;
        }

        Arrays.sort(list1);
        Arrays.sort(list2);

        for(int i=0;i<26;i++){
            if(list1[i]!=list2[i]){
                return false;
            }
        } 

        return true;

    }
}

// 859. Buddy Strings
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (int count : map.values()) {
                if (count > 1) {
                    return true;
                }
            }
            return false;
        }

        int count = 0;
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
                if (first == -1) {
                    first = i;
                } else {
                    second = i;
                }
            }
        }

        return count == 2 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first);
    }
}

// 1247. Minimum Swaps to Make Strings Equal

class Solution {
    public int minimumSwap(String s1, String s2) {

        if(s1.length()!=s2.length()){
            return -1;
        }
        
        int xy=0;
        int yx=0;

        for(int i=0;i<s1.length();i++){

          if(s1.charAt(i)=='x' && s2.charAt(i)=='y'){
            xy++;
          }
          else if(s1.charAt(i)=='y' && s2.charAt(i)=='x'){
            yx++;
          }
          
        }

        if((xy+yx)%2==1){
            return -1;
        }

        return (xy/2)+(yx/2)+(xy%2)*2;

    }
}

// 1347. Minimum Number of Steps to Make Two Strings Anagram

class Solution {
    public int minSteps(String s, String t) {

        int list[] = new int[26];

        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            list[ch - 'a']++;
        }

      
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            list[ch - 'a'] = Math.max(0, list[ch - 'a'] - 1);
        }

        
        int sum = 0;
        for (int i = 0; i < 26; i++) {  
            sum += list[i];
        }

        return sum;
    }
}


// 944. Delete Columns to Make Sorted

class Solution {
    public int minDeletionSize(String[] strs) {
        int count=0;
        for(int i=0;i<strs[0].length();i++){

            for(int j=1;j<strs.length;j++){

                if(strs[j].charAt(i)<strs[j-1].charAt(i)){
                    count++;break;
                }
            }
        }

       return count;
    }
}