package com.shapira.examples.streams.stockstats.model;
/**
 * Created by SUXH on 02/02/2024.
 *  存放每个时间窗口的统计信息即聚合结果（包括平均价格，最低价格和交易数量等等）
 */
public class TradeStats {

    String type;
    String ticker;

    /** 交易数量 */
    int countTrades; // tracking count and sum so we can later calculate avg price

    /**  总的价格 */
    double sumPrice;

    /** 最低价格 */
    double minPrice;

    /** 平均价格 */
    double avgPrice;

    /**
     * <b>概要：</b>
     *  用于更新时间窗口内最低价格、交易数量和总价
     * <b>作者：</b>suxh</br>
     * <b>日期：</b>2024/2/2 15:03</br>
     * @param trade 
     * @return
     **/
    public TradeStats add(Trade trade) {

        if (trade.type == null || trade.ticker == null)
            throw new IllegalArgumentException("Invalid trade to aggregate: " + trade.toString());

        if (this.type == null)
            this.type = trade.type;
        if (this.ticker == null)
            this.ticker = trade.ticker;

        if (!this.type.equals(trade.type) || !this.ticker.equals(trade.ticker))
            throw new IllegalArgumentException("Aggregating stats for trade type " + this.type + " and ticker " + this.ticker + " but recieved trade of type " + trade.type +" and ticker " + trade.ticker );

        if (countTrades == 0) this.minPrice = trade.price;
        
        this.countTrades = this.countTrades+1;
        this.sumPrice = this.sumPrice + trade.price;
        this.minPrice = this.minPrice < trade.price ? this.minPrice : trade.price;

        return this;
    }

    /**
     * <b>概要：</b>
     *  计算平均价格
     * <b>作者：</b>suxh</br>
     * <b>日期：</b>2024/2/2 16:36</br>
     * @return
     **/
    public TradeStats computeAvgPrice() {
        this.avgPrice = this.sumPrice / this.countTrades;
        return this;
    }
}
