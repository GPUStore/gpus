package ru.mephi.gpus_statistics.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.mephi.gpus_statistics.entity.products.Product;
import ru.mephi.gpus_statistics.entity.products.dto.product.ProductRqDto;
import ru.mephi.gpus_statistics.entity.products.dto.product.ProductRsDto;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductRsDto productRqDtoToProductRsDto(ProductRqDto productRqDto);
}
