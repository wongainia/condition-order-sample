package me.caosh.condition.application.order;

import hbec.intellitrade.conditionorder.domain.ConditionOrder;

/**
 * Created by caosh on 2017/8/2.
 */
public interface OrderCommandService {
    void save(ConditionOrder conditionOrder);

    void update(ConditionOrder conditionOrder);

    void remove(Long orderId);
}
