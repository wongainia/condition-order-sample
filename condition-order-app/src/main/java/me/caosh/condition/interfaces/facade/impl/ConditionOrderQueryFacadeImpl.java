package me.caosh.condition.interfaces.facade.impl;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import hbec.intellitrade.trade.domain.EntrustOrder;
import me.caosh.autoasm.AutoAssemblers;
import me.caosh.condition.interfaces.facade.ConditionOrderQueryFacade;
import me.caosh.condition.domain.dto.order.ConditionOrderDTO;
import me.caosh.condition.infrastructure.repository.EntrustOrderRepository;
import me.caosh.condition.infrastructure.tunnel.model.ConditionOrderDO;
import me.caosh.condition.infrastructure.tunnel.impl.ConditionOrderDoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caosh on 2017/8/14.
 */
@Service
public class ConditionOrderQueryFacadeImpl implements ConditionOrderQueryFacade {

    private final ConditionOrderDoRepository conditionOrderDoRepository;
    private final EntrustOrderRepository entrustOrderRepository;

    public ConditionOrderQueryFacadeImpl(ConditionOrderDoRepository conditionOrderDoRepository,
                                         EntrustOrderRepository entrustOrderRepository) {
        this.conditionOrderDoRepository = conditionOrderDoRepository;
        this.entrustOrderRepository = entrustOrderRepository;
    }

    @Override
    public List<ConditionOrderDTO> listMonitoringOrders(String customerNo) {
        List<ConditionOrderDO> conditionOrderDOList = conditionOrderDoRepository.findMonitoring(customerNo);
        return  Lists.transform(conditionOrderDOList, new Function<ConditionOrderDO, ConditionOrderDTO>() {
            @Override
            public ConditionOrderDTO apply(ConditionOrderDO conditionOrderDO) {
                return AutoAssemblers.getDefault().disassemble(conditionOrderDO, ConditionOrderDTO.class);
            }
        });
    }

    @Override
    public ConditionOrderDTO getConditionOrder(Long orderId) {
        ConditionOrderDO conditionOrderDO = conditionOrderDoRepository.findOne(orderId);
        return AutoAssemblers.getDefault().disassemble(conditionOrderDO, ConditionOrderDTO.class);
    }

    @Override
    public Page<EntrustOrder> listEntrustOrders(String customerNo, Pageable pageable) {
        return entrustOrderRepository.findByCustomerNo(customerNo, pageable);
    }
}