package com.shapira.examples.streams.stockstats.model;

/**
 * Created by SUXH on 02/02/2024.
 * 股票交易信息
 */
public class Trade {

    /** 交易类型 */
    String type;

    /** 股票名称参见Constants.TICKERS */
    String ticker;

    /** 交易价格 */
    double price;
    int size;

    public Trade(String type, String ticker, double price, int size) {
        this.type = type;
        this.ticker = ticker;
        this.price = price;
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "type='" + type + '\'' +
                ", ticker='" + ticker + '\'' +
                ", price=" + price +
                ", size=" + size +
                '}';
    }
}
