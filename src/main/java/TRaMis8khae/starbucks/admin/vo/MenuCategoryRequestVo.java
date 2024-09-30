package TRaMis8khae.starbucks.admin.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuCategoryRequestVo {

	private String topCode;

	private String imageUrl;

}
