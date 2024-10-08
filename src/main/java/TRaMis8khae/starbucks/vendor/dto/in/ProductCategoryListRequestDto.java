package TRaMis8khae.starbucks.vendor.dto.in;

import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;
import TRaMis8khae.starbucks.vendor.vo.in.ProductCategoryListRequestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryListRequestDto {

    private String topCode;
    private String middleCode;
    private String bottomCode;
    private String productUUID;

    public static ProductCategoryListRequestDto toDto(ProductCategoryListRequestVo productCategoryListRequestVo) {
        return ProductCategoryListRequestDto.builder()
            .topCode(productCategoryListRequestVo.getTopCode())
            .middleCode(productCategoryListRequestVo.getMiddleCode())
            .bottomCode(productCategoryListRequestVo.getBottomCode())
            .productUUID(productCategoryListRequestVo.getProductUUID())
            .build();
    }

    public ProductCategoryList toEntity() {
        return ProductCategoryList.builder()
            .topCode(topCode)
            .middleCode(middleCode)
            .bottomCode(bottomCode)
            .productUUID(productUUID)
            .build();
    }

}