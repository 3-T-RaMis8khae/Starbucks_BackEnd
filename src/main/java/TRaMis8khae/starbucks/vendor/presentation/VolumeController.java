package TRaMis8khae.starbucks.vendor.presentation;


import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.vendor.application.VolumeService;
import TRaMis8khae.starbucks.vendor.dto.in.VolumeRequestDto;
import TRaMis8khae.starbucks.vendor.dto.out.VolumeResponseDto;
import TRaMis8khae.starbucks.vendor.vo.in.VolumeRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product-volume")
public class VolumeController {

	private final VolumeService volumeService;

	@Operation(summary = "상품 용량 추가", description = "상품의 용량을 추가합니다", tags = {"Product Volume Service"})
	@PostMapping
	public BaseResponse<Void> createVolume(@RequestBody VolumeRequestVo requestVo) {

		volumeService.addVolume(VolumeRequestDto.toDto(requestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 용량 조회", description = "상품의 용량을 조회합니다.", tags = {"Product Volume Service"})
	@GetMapping("/{productUUID}")
	public BaseResponse<VolumeResponseDto> getVolume(@PathVariable String productUUID) {
		log.info(productUUID);
		return new BaseResponse<>(volumeService.findVolume(productUUID));
	}

}
