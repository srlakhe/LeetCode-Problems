public class Solution {
     
     private int minCostII(int[][] costs) {
         if(costs.length == 0)
            return 0;
        
         int prevMin = 0;
         int prevSec = 0;
         int prevInd = -1;
         for(int i = 0; i < costs.length; i++) {
             int curMin = Integer.MAX_VALUE;
             int curSec = Integer.MAX_VALUE;
             int curIndex = -1;
             for(int j = 0; j < costs[i].length; j++) {
                 if(prevIndex != j) {
                     costs[i][j] += prevMin;
                 } else {
                     costs[i][j] += prevSec;
                 }
                 
                 if(costs[i][j] < curMin) {
                     curSec = curMin;
                     curMin = costs[i][j];
                     curIndex = j;
                 }
                 else if(costs[i][j] < curSec) {
                     curSec = costs[i][j];
                 }
             }
             prevMin = curMin;
             prevSec = curSec;
             prevInd = curInd;
         }
         
         int res = Integer.MAX_VALUE;
         for(int i = 0; i < costs[0].length; i++)
            if(costs[costs.length-1][i] < res)
                res = costs[costs.length-1][i];
         return res;
     }
}
