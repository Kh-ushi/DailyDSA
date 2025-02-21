//135. Candy 

class Solution {
    public int candy(int[] ratings) {
        
        int candies[]=new int[ratings.length];
        Arrays.fill(candies,1);

        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }

        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            }
        }

        int count=0;

        for(int i=0;i<candies.length;i++){
            count+=candies[i];
        }

        return count;

    }
}

// 2038. Remove Colored Pieces if Both Neighbors are the Same Color
class Solution {
    public boolean winnerOfGame(String colors) {
        int aliceMoves = 0, bobMoves = 0;
        
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') {
                    aliceMoves++;
                } else {
                    bobMoves++;
                }
            }
        }

        return aliceMoves > bobMoves;
    }
}


