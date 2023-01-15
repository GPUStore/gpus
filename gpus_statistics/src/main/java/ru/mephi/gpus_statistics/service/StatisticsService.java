package ru.mephi.gpus_statistics.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import ru.mephi.gpus_statistics.entity.clients.Client;
import ru.mephi.gpus_statistics.entity.products.dto.product.ProductRqDto;
import ru.mephi.gpus_statistics.entity.products.dto.product.ProductRsDto;
import ru.mephi.gpus_statistics.mapper.ProductMapper;
import ru.mephi.gpus_statistics.repository.clients.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticsService {
    private final ClientRepository clientRepository;
    private final ProductMapper productMapper;
    private final WebClient webClient;
    private final ObjectWriter objectWriter;

    public void submitChangesToSender(ProductRqDto productRqDto) throws JsonProcessingException {
        log.info("Got submit request: {}",productRqDto);
        List<Client> list = clientRepository.findAllByProductId(productRqDto.getProductId());
        log.info("Got clients from db: {}", list.toString());
        list.forEach(client -> client.setProductIds(null));
        ProductRsDto productRsDto = productMapper.productRqDtoToProductRsDto(productRqDto);
        productRsDto.setClients(list);
        String strng = objectWriter.writeValueAsString(productRsDto);

        webClient
                .post()
                .uri(uriBuilder -> uriBuilder
                        .path("/email")
                        .build())
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(objectWriter.writeValueAsString(productRsDto)))
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
