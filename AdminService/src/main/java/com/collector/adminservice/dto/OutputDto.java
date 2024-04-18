package com.collector.adminservice.dto;

import java.util.List;

public record OutputDto(String type, List<GameCollectorItemDto> list) {
}
