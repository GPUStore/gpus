package ru.mephi.gpus_statistics.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mephi.gpus_statistics.entity.products.dto.product.ProductRqDto;
import ru.mephi.gpus_statistics.service.StatisticsService;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsService statisticsService;

    @PostMapping("/collect_and_send_updates")
    public void collectAndSendUpdates(@RequestBody ProductRqDto productRqDto) throws JsonProcessingException {
        statisticsService.submitChangesToSender(productRqDto);
    }
    //http://localhost:8765/gpus_statistics/statistics/collect_and_send_updates
    //localhost
}
