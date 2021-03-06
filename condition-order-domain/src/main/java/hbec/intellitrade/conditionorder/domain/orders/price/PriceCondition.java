package hbec.intellitrade.conditionorder.domain.orders.price;

import com.google.common.base.MoreObjects;
import hbec.intellitrade.strategy.domain.condition.AbstractMarketCondition;
import hbec.intellitrade.strategy.domain.factor.BasicTargetPriceFactor;
import hbec.intellitrade.strategy.domain.factor.CompareOperator;

import java.math.BigDecimal;

/**
 * 原始的价格条件，到价触发，基于目标价因子实现
 *
 * @author caosh/caoshuhao@touker.com
 * @date 2018/1/29
 */
public class PriceCondition extends AbstractMarketCondition {
    private final BasicTargetPriceFactor targetPriceFactor;

    public PriceCondition(CompareOperator compareOperator, BigDecimal targetPrice) {
        this.targetPriceFactor = new BasicTargetPriceFactor(compareOperator, targetPrice);
    }

    public CompareOperator getCompareOperator() {
        return targetPriceFactor.getCompareOperator();
    }

    public BigDecimal getTargetPrice() {
        return targetPriceFactor.getTargetPrice();
    }

    @Override
    public BasicTargetPriceFactor getTargetPriceFactor() {
        return targetPriceFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PriceCondition that = (PriceCondition) o;

        return targetPriceFactor.equals(that.targetPriceFactor);
    }

    @Override
    public int hashCode() {
        return targetPriceFactor.hashCode();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(PriceCondition.class).omitNullValues()
                .addValue(targetPriceFactor)
                .toString();
    }
}
