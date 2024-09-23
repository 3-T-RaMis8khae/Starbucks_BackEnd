package TRaMis8khae.starbucks.member.presentation;

import TRaMis8khae.starbucks.common.entity.CommonResponseEntity;
import TRaMis8khae.starbucks.common.entity.CommonResponseMessage;
import TRaMis8khae.starbucks.member.application.MemberAddressService;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressRequestDto;
import TRaMis8khae.starbucks.member.dto.DeliveryAddressResponseDto;
import TRaMis8khae.starbucks.member.dto.UpdateDeliveryAddressRequestDto;
import TRaMis8khae.starbucks.member.vo.DeliveryAddressRequestVo;
import TRaMis8khae.starbucks.member.vo.DeliveryAddressResponseVo;
import TRaMis8khae.starbucks.member.vo.UpdateDeliveryAddressRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberAddressService memberAddressService;

    @PostMapping("delivery/{memberUUID}")
    public CommonResponseEntity<Void> addDeliveryAddress(
            @PathVariable String memberUUID,
            @RequestBody DeliveryAddressRequestVo deliveryAddressRequestVo) {

        DeliveryAddressRequestDto deliveryAddressRequestDto = DeliveryAddressRequestDto.toDto(deliveryAddressRequestVo);

        memberAddressService.addDeliveryAddress(memberUUID, deliveryAddressRequestDto);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

    @GetMapping("delivery/{memberUUID}")
    public CommonResponseEntity<List<DeliveryAddressResponseVo>> getMemberDeliveryAddress(
            @PathVariable String memberUUID) {

        List<DeliveryAddressResponseDto> memberAddressList = memberAddressService.getMemberDeliveryAddress(memberUUID);

        if (memberAddressList.isEmpty()) {
            return new CommonResponseEntity<>(
                    HttpStatus.OK,
                    true,
                    "배송지가 없습니다.",
                    null);
        }

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                memberAddressList.stream().
                        map(DeliveryAddressResponseDto::toVo).
                        toList());
    }

    @DeleteMapping("delivery/{deliveryAddressId}")
    public CommonResponseEntity<Void> deleteDeliveryAddress(@PathVariable Long deliveryAddressId) {

        memberAddressService.deleteDeliveryAddress(deliveryAddressId);



        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

    @PutMapping("delivery/{deliveryAddressId}")
    public CommonResponseEntity<Void> updateDeliveryAddress(
            @PathVariable Long deliveryAddressId,
            @RequestHeader("Authorization") String token,
            @RequestBody UpdateDeliveryAddressRequestVo requestVo) {

        UpdateDeliveryAddressRequestDto requestDto = UpdateDeliveryAddressRequestDto.toDto(requestVo);

        memberAddressService.updateDeliveryAddress(deliveryAddressId, token, requestDto);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                true,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

}