package com.modular.service.command;

import com.modular.dto.product.ProductInfo;
import com.modular.dto.request.CreateProductDto;
import com.modular.entity.Product;
import com.modular.persistence.repository.ProductRepository;
import com.modular.port.internal.command.ProductCommandUseCase;
import com.modular.persistence.query.ProductQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommandServiceImpl implements ProductCommandUseCase {

    private final ProductRepository productRepository;
    private final ProductQuery productQuery;

    @Override
    public ProductInfo createProduct(CreateProductDto createMemberDto) {
        Product product = new Product(createMemberDto.getName(), createMemberDto.getPrice(), createMemberDto.getStock());
        Product saveProduct = productRepository.save(product);

        return productQuery.toProductInfo(saveProduct);
    }

}
