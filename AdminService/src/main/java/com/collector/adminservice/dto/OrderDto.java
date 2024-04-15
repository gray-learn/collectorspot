package com.collector.adminservice.dto;

import java.math.BigDecimal;
import java.util.Date;

public record OrderDto(String type, Integer id, BigDecimal total_price) {
}
