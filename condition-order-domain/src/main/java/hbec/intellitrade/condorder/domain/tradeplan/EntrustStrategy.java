package hbec.intellitrade.condorder.domain.tradeplan;

import me.caosh.autoasm.ConvertibleEnum;

/**
 * Created by caosh on 2017/8/2.
 */
public enum EntrustStrategy implements ConvertibleEnum<Integer> {
    ASSIGNED_PRICE(0),
    CURRENT_PRICE(1),
    SELL5(2),
    SELL4(3),
    SELL3(4),
    SELL2(5),
    SELL1(6),
    BUY1(7),
    BUY2(8),
    BUY3(9),
    BUY4(10),
    BUY5(11),
    MARKET_PRICE(99);

    int value;

    EntrustStrategy(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
