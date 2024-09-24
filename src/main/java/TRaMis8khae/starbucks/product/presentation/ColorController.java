package TRaMis8khae.starbucks.product.presentation;


import TRaMis8khae.starbucks.common.entity.BaseResponse;
import TRaMis8khae.starbucks.product.application.ColorService;
import TRaMis8khae.starbucks.product.dto.in.ColorRequestDto;
import TRaMis8khae.starbucks.product.dto.out.ColorResponseDto;
import TRaMis8khae.starbucks.product.vo.in.ColorRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product-color")
public class ColorController {

	private final ColorService colorService;

	@PostMapping
	public BaseResponse<Void> createColor(@RequestBody ColorRequestVo requestVo) {

		colorService.addColor(ColorRequestDto.toDto(requestVo));
		return new BaseResponse<>();
	}

	@GetMapping("/{productUUID}")
	public BaseResponse<ColorResponseDto> getColor(@PathVariable String productUUID) {

		return new BaseResponse<>(colorService.findColor(productUUID));
	}

}
