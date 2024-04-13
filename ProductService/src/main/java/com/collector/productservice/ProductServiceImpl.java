package com.collector.productservice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl {//implements ProductService {
    private final GameCollectorRepository gameCollectorItemRepository;

    // TODO
//    public GameCollectorItem create(CreateProductDto productDto) {
//        GameCollectorItem newItem = productDto.toGameCollectorItem();
//        return gameCollectorItemRepository.save(newItem);
//    }
}
