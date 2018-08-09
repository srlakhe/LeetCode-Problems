 // Complete the worstPerformingStock function below.
    static int worstPerformingStock(List<List<Integer>> prices) {
        Double minRate = Double.MAX_VALUE;
        int answer = 0;
        for(List<Integer> list : prices) {
            int id = list.get(0);
            double openingPrice = (double)list.get(1);
            double closingPrice = (double)list.get(2);
            double rate = (closingPrice - openingPrice) / openingPrice;
            if(rate < minRate) {
                answer = id;
                minRate = rate;
            }
        }
        return answer;
    }
