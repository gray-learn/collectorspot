package com.collector.productservice;

import com.collector.productservice.kafka.FunctionConfiguration;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final Logger logger =  LoggerFactory.getLogger(ProductService.class);
    private final GameCollectorRepository repo;
    StreamBridge streamBridge;

    public void deleteProduct(Long id){
        repo.deleteById(id);
    }

    public String processProductImageId(Long id){
        Optional<GameCollectorItem> image = repo.findById(id);
        if(image.isPresent()){
            String imageId = image.get().getImageId();
            logger.info("Delete request to Image Server");
            streamBridge.send("product-out-0", new ImageDto(imageId));
        }
        return "success";
    }

    // TODO
//    public GameCollectorItem create(CreateProductDto productDto) {
//        GameCollectorItem newItem = productDto.toGameCollectorItem();
//        return gameCollectorItemRepository.save(newItem);
//    }
}
