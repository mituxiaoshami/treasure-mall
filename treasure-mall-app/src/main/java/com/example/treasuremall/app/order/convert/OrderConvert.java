package com.example.treasuremall.app.order.convert;

import com.example.treasuremall.api.domain.order.OrderTO;
import com.example.treasuremall.app.order.entity.Order;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 小沙弥
 * @description 订单模型转换类
 * @date 2022/3/23 7:09 下午
 */
public class OrderConvert {


    /**
     * Entity List transfer TO List
     * @param orderList Entity List
     * @return TO List
     */
    public static List<OrderTO> transferOrderTOListFromOrderList(List<Order> orderList) {

        if (orderList == null || orderList.isEmpty()) {
            return null;
        }
        return orderList.stream().map(OrderConvert::transferOrderTOFromOrder).filter(Objects::nonNull).collect(Collectors.toList());
    }



    /**
     * Entity transfer TO
     * @param order Entity
     * @return TO
     */
    public static OrderTO transferOrderTOFromOrder(Order order) {
        if (order == null) {
            return null;
        }
        OrderTO orderTO = new OrderTO();
        orderTO.setId(order.getId());
        orderTO.setRetailTotalOrderNum(order.getRetailTotalOrderNum());
        orderTO.setRetailCarOrderNum(order.getRetailCarOrderNum());
        orderTO.setOrdersCreateType(order.getOrdersCreateType());
        orderTO.setCarOrdersType(order.getCarOrdersType());
        orderTO.setSoftwareId(order.getSoftwareId());
        orderTO.setCustomerId(order.getCustomerId());
        orderTO.setLockTime(order.getLockTime());
        orderTO.setOrdersTransferTime(order.getOrdersTransferTime());
        orderTO.setOrdersChangeTime(order.getOrdersChangeTime());
        orderTO.setOrdersType(order.getOrdersType());
        orderTO.setBuyCarType(order.getBuyCarType());
        orderTO.setBuyCarPlan(order.getBuyCarPlan());
        orderTO.setCustomerName(order.getCustomerName());
        orderTO.setBirthday(order.getBirthday());
        orderTO.setRecommendCode(order.getRecommendCode());
        orderTO.setCarInitPrice(order.getCarInitPrice());
        orderTO.setCarDiscountPrice(order.getCarDiscountPrice());
        orderTO.setInitPriceZad(order.getInitPriceZad());
        orderTO.setRealPriceZad(order.getRealPriceZad());
        orderTO.setUnpaidMoneyZad(order.getUnpaidMoneyZad());
        orderTO.setHdVehicleTime(order.getHdVehicleTime());
        orderTO.setInterestSubsidyMoney(order.getInterestSubsidyMoney());
        orderTO.setInvoiceMode(order.getInvoiceMode());
        orderTO.setSpecialOrderType(order.getSpecialOrderType());
        orderTO.setDeliveryTime(order.getDeliveryTime());
        orderTO.setReceptionPartner(order.getReceptionPartner());
        orderTO.setReceptionPartnerTime(order.getReceptionPartnerTime());
        orderTO.setTemporaryCardStatus(order.getTemporaryCardStatus());
        orderTO.setTemporaryCardNum(order.getTemporaryCardNum());
        orderTO.setSendVehicleStatus(order.getSendVehicleStatus());
        orderTO.setCustomerNum(order.getCustomerNum());
        orderTO.setCustomerInvoiceType(order.getCustomerInvoiceType());
        return orderTO;
    }

}
