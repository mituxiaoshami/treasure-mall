Feature: 订单单测场景
  Scenario: 订单单测场景
    When 查询所有订单
    Then 所有订单查询结果
    When 根据订单ID查询订单 "1"
    Then 根据订单ID查询订单返回结果

  Scenario Outline: 根据条件查询订单
    Given 根据条件查询订单,用例名 "<case>"
    When 条件 "<param>"
    Then 根据条件查询订单返回结果 "<data>"
    Examples:
      |case| param | data |
      | 根据订单编号查询订单| {"retailTotalOrderNum":"123"} | null |


