public class BuyAndSellStock {
    public static int buySellStock(int[] prices){
        int min_price = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<prices.length;i++){
            if(min_price < prices[i]){
                int profit = prices[i] - min_price;
                maxProfit = Math.max(profit, maxProfit);
            }else{
                min_price = prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(buySellStock(prices));
    }
}
