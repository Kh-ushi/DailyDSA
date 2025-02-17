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
