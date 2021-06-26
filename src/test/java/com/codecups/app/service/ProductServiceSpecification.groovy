package com.codecups.app.service

import com.codecups.app.dto.ProductDto
import com.codecups.app.model.Product
import com.codecups.app.repository.ProductRepository
import com.codecups.app.security.util.PublicIdGenerator
import org.modelmapper.ModelMapper
import spock.lang.Specification

/**
 * Copyright CodeCups
 * Created by Niko on 07 June 2021
 */
class ProductServiceSpecification extends Specification{

    def productRepository = Mock(ProductRepository);
    def publicIdGenerator = Mock(PublicIdGenerator);

    def underTest = new ProductServiceImpl(productRepository, publicIdGenerator);

    def "getProduct() should return productDto"() {
        given:
            def product = Mock(Product)
            def productId = "123"
            product.productId >> "testProduct"
            product.name >> "cup"
            product.price >> 9.99
            productRepository.findByProductId(productId) >> product
            new ModelMapper().map(product, ProductDto.class);
        when:
            def returnedProduct = underTest.getProduct(productId)
        then:
            returnedProduct.getProductId() == "testProduct"
            returnedProduct.getName() == "cup"
            returnedProduct.getPrice() == 9.99d
    }
}
