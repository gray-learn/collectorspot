package com.collector.orderservice;

import java.math.BigDecimal;

public record OrderDto(String type, Integer id, BigDecimal total_price) {
}
