package SlidingWindow;

public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int pt = 0;
        int minima = Integer.MAX_VALUE;
        int currMax = 0;

        while (pt < prices.length) {
            if (prices[pt] < minima) {
                minima = prices[pt];
                pt++;
            } else {
                currMax = Math.max(currMax, prices[pt] - minima);
                pt++;
            }
        }

        return currMax;
    }
}
