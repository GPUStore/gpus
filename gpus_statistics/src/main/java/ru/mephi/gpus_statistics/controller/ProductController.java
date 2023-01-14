package ru.mephi.gpus_statistics.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

//    @GetMapping
//    public List<ProductRsDto> getAll() {
//        return productService.getAll();
//    }
//
//
//    @PostMapping("/{id}/stores/delete")
//    public void deleteStoreFromProduct(@PathVariable String id, @RequestBody String url) {
//        productService.deleteStoreFromProduct(id, url);
//    }
}