// // SLIDING WINDOW.............

// Count Occurences of Anagrams

class Solution {
    
    boolean checkAllZero(int arr[]) {
        for (int ele : arr) {
            if (ele != 0) {
                return false;
            }
        }
        return true;
    }

    int search(String pat, String txt) {
        
        int map[] = new int[26]; 
        
       
        for (int i = 0; i < pat.length(); i++) {
            map[pat.charAt(i) - 'a']++;
        }
        
        int i = 0;
        int j = 0;
        int result = 0;
        
        while (j < txt.length()) {
            
            map[txt.charAt(j) - 'a']--;


            if (j - i + 1 == pat.length()) {
               
                if (checkAllZero(map)) {
                    result++;
                }
                
                map[txt.charAt(i) - 'a']++;
                i++; 
            }
            
            j++; 
        }

        return result; 
    }
}

// 438. Find All Anagrams in a String
class Solution {

    public boolean checkAllZero(int map[]){
 
      for(int ele : map){
         if(ele!=0){
             return false;
         }
      }
      return true;
      
    }
 
     public List<Integer> findAnagrams(String s, String p) {
 
         int map[]=new int[26];
         for(int i=0;i<p.length();i++){
             char ch=p.charAt(i);
             map[ch-'a']++;
         }
 
         int i=0;
         int j=0;
         List<Integer>result=new ArrayList<>();
 
         while(j<s.length()){
 
         map[s.charAt(j)-'a']--;
 
         if(j-i+1==p.length()){
             boolean allZero=checkAllZero(map);
             if(allZero){
                 result.add(i);
             }
 
             map[s.charAt(i)-'a']++;
             i++;
 
         }
 
         j++;
 
 
         }
 
         return result;
         
     }
 }


//  242. Valid Anagram

class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        int map[]=new int[26];
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map[ch-'a']++;
        }

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map[ch-'a']--;
        }

        for(int ele : map){
            if(ele!=0){
                return false;
            }
        }

        return true;
        
    }
}

// 567. Permutation in String

class Solution {

    public boolean checkAllZero(int map[]){
        for(int ele : map){
         if(ele!=0){
             return false;
         }
        }
        return true;
    }
 
     public boolean checkInclusion(String s1, String s2) {
 
         if(s1.length()>s2.length()){
             return false;
         }
 
         int map[]=new int[26];
         for(int i=0;i<s1.length();i++){
             char ch=s1.charAt(i);
             map[ch-'a']++;
         }
 
         int i=0;
         int j=0;
 
         while(j<s2.length()){
 
             map[s2.charAt(j)-'a']--;
 
             if(j-i+1==s1.length()){
                 boolean result=checkAllZero(map);
                 if(result){
                     return true;
                 }
 
                 map[s2.charAt(i)-'a']++;
                 i++;
             }
             j++;
         }  
         return false;      
     }
 
     
 }


//  76. Minimum Window Substring

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0, minLength = Integer.MAX_VALUE, start = 0;
        int count = t.length();

        while (j < s.length()) {

            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0)
                    count--;
                map.put(ch, map.get(ch) - 1);
            }

            while (count == 0) {
                if (j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    start = i;
                }

                char leftChar=s.charAt(i);
                 if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) count++;
                }
                i++;

            }
            j++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);

    }
}