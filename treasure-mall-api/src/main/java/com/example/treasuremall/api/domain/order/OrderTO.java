package com.example.treasuremall.api.domain.order;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author 小沙弥
 * @description 订单接口统一对外模型
 * @date 2022/3/23 7:04 下午
 */
@Data
public class OrderTO {

    private static final long serialVersionUID=1L;

    private Long id;

    private String retailTotalOrderNum;

    private String retailCarOrderNum;

    private String ordersCreateType;

    private String carOrdersType;

    private String softwareId;

    private String customerId;

    private LocalDateTime lockTime;

    private LocalDateTime ordersTransferTime;

    private LocalDateTime ordersChangeTime;

    private String ordersType;

    private String buyCarType;

    private String buyCarPlan;

    private String customerName;

    private String birthday;

    private String recommendCode;

    private BigDecimal carInitPrice;

    private BigDecimal carDiscountPrice;

    private BigDecimal initPriceZad;

    private BigDecimal realPriceZad;

    private BigDecimal unpaidMoneyZad;

    private LocalDateTime hdVehicleTime;

    private BigDecimal interestSubsidyMoney;

    private String invoiceMode;

    private String specialOrderType;

    private LocalDateTime DeliveryTime;

    private String receptionPartner;

    private LocalDateTime receptionPartnerTime;

    private Integer temporaryCardStatus;

    private String temporaryCardNum;

    private Integer sendVehicleStatus;

    private String customerNum;

    private String customerInvoiceType;

}
