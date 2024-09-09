package TRaMis8khae.starbucks.purchase.dto;

import TRaMis8khae.starbucks.purchase.entity.Purchase;
import TRaMis8khae.starbucks.purchase.vo.PurchaseReadResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor // querydsl은 @Builder를 못 읽기에 따로 생성자가 필요하다
public class PurchaseReadResponseDto {

    private String serialNumber;

    private Double deliveryPrice;

    private Double totalPrice;

    private String cardInfo;

    private String memberName;

    private String memberPhone;

    private String addressDetail;

    private String deliveryMemo;

    private String deliveryAddressNickname;

    private String recipient;

    private String phone1;

    private String phone2;

    public static PurchaseReadResponseDto toDto(Purchase purchase) {
        return PurchaseReadResponseDto.builder()
                .serialNumber(purchase.getSerialNumber())
                .deliveryPrice(purchase.getDeliveryPrice())
                .totalPrice(purchase.getTotalPrice())
                .cardInfo(purchase.getCardInfo())
                .memberName(purchase.getMemberName())
                .memberPhone(purchase.getMemberPhone())
                .addressDetail(purchase.getAddressDetail())
                .deliveryMemo(purchase.getDeliveryMemo())
                .deliveryAddressNickname(purchase.getDeliveryAddressNickname())
                .recipient(purchase.getRecipient())
                .phone1(purchase.getPhone1())
                .phone2(purchase.getPhone2())
                .build();
    }

    public static PurchaseReadResponseVo toVo(PurchaseReadResponseDto responseDto) {
        return PurchaseReadResponseVo.builder()
                .serialNumber(responseDto.getSerialNumber())
                .deliveryPrice(responseDto.getDeliveryPrice())
                .totalPrice(responseDto.getTotalPrice())
                .cardInfo(responseDto.getCardInfo())
                .memberName(responseDto.getMemberName())
                .memberPhone(responseDto.getMemberPhone())
                .addressDetail(responseDto.getAddressDetail())
                .deliveryMemo(responseDto.getDeliveryMemo())
                .deliveryAddressNickname(responseDto.getDeliveryAddressNickname())
                .recipient(responseDto.getRecipient())
                .phone1(responseDto.getPhone1())
                .phone2(responseDto.getPhone2())
                .build();
    }
}