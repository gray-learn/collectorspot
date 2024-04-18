package com.collector.productservice;

import java.util.List;

public record OutputDto(String type, List<GameCollectorItem> list) {
}
