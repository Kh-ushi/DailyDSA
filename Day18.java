// 472. Concatenated Words

class Solution {

    public boolean isConcatenated(String word, HashSet<String> set,HashMap<String,Boolean>map) {
        if (word.length() == 0) {
            return false;
        }

        if(map.containsKey(word)){
            return map.get(word);
        }

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (set.contains(prefix) && (set.contains(suffix) || isConcatenated(suffix, set,map))) {
               map.put(word,true);
                return true;
            }
        }
        
        map.put(word,false);
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        List<String> list = new ArrayList<>();
        HashMap<String,Boolean>map=new HashMap<>();

        

        for (String word : words) {
            set.remove(word);
            if (isConcatenated(word, set,map)) {
                list.add(word);
            }
            
            set.add(word);
        }

        return list;
    }
}




// 140. Word Break II
class Solution {
     
    public void solve(String str,HashSet<String>set,List<String>ans,String build){

        if(str.length()==0){
            return;
        }

        if(set.contains(str)){
            ans.add(build+str);
        }
      

      for(int i=1;i<=str.length();i++){
        
        String prefix=str.substring(0,i);
        String suffix=str.substring(i);

        if(set.contains(prefix)){
            solve(suffix,set,ans,build+prefix+" ");
        }

      }

    } 

    public List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String>set=new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }

        List<String>ans=new ArrayList<>();

        solve(s,set,ans,"");
        
        return ans;
    }
}




// 139. Word Break 

class Solution {
   
    public boolean solve(String s,HashSet<String>set,HashMap<String,Boolean>map){
 
     if(s.length()==0){
         return false;
     }
 
     if(set.contains(s)){
         return true;
     }
 
     if(map.containsKey(s)){
         return map.get(s);
     }
     
 
     for(int i=1;i<=s.length();i++){
       
       String prefix=s.substring(0,i);
       String suffix=s.substring(i);
 
       if(set.contains(prefix) && (set.contains(suffix) || solve(suffix,set,map))){
         map.put(s,true);
         return true;
       }
 
     }
 
    map.put(s,false);
     return false;
 
 
    }
 
     public boolean wordBreak(String s, List<String> wordDict) {
         
         HashSet<String>set=new HashSet<>();
 
         for(int i=0;i<wordDict.size();i++){
             set.add(wordDict.get(i));
         }
 
        HashMap<String,Boolean>map=new HashMap<>();
        
        return solve(s,set,map);
       
       
    
 
     }
 }

//  VERY VERY IMPORTANT
// REVISE KNUTH MORRIS ALGORITHM
// 214. Shortest Palindrome

class Solution {

    public int computeLPS(String str) {
        int LPS[] = new int[str.length()];
        LPS[0] = 0;
        int length = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                LPS[i] = length;
            } else {
                if (length != 0) {
                    length = LPS[length - 1];
                    i--; 
                } else {
                    LPS[i] = 0;
                }
            }
        }

        return LPS[LPS.length - 1];
    }

    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder(s).reverse();
        String rev = sb.toString();

        String combined = s + '#' + rev;
        int commonLength = computeLPS(combined);

        String part = rev.substring(0, rev.length() - commonLength);

        return part + s;
    }
}
