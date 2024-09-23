package TRaMis8khae.starbucks.product.application;

import TRaMis8khae.starbucks.media.dto.MediaAddRequestDto;
import TRaMis8khae.starbucks.media.entity.MediaKind;
import TRaMis8khae.starbucks.product.dto.*;
import TRaMis8khae.starbucks.product.entity.Product;

import java.util.List;

public interface ProductService {

    void addProduct(ProductRequestDto requestDto);

    void updateProduct(String uuid, ProductUpdateRequestDto requestDto);

    void deleteProduct(String productUUID);

    ProductResponseDto findProduct(String productUUID);

    List<ProductResponseDto> findProducts();

    void addProductOption(ProductOptionRequestDto requestDto);

    void updateProductOption(ProductOptionRequestDto requestDto);

    void deleteProductOption(String productUUID);

    ProductOptionResponseDto findProductOption(String productUUID);


    VolumeResponseDto findVolume(String productUUID);

    ColorResponseDto findColor(String productUUID);

    List<ProductResponseDto> findByPrice(Double MinPrice, Double MaxPrice);

    List<ProductResponseDto> findProductDtosByProductUUID(List<String> productUUID);

    List<Product> findProductsByProductUUID(List<String> productUUID);

    void addProductAdditionalProduct(ProductAdditionalProductListRequestDto requestDto);

    void updateProductAdditionalProduct(ProductAdditionalProductListRequestDto requestDto);

    void deleteProductAdditionalProduct(String uuid);

    List<String> findProductAdditionalProduct(String uuid);

}