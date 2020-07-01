package start.portfolio.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //기본생성자 필요
public class BannerDto {
	
	private String bannerName;
	private int bannerOrders;
	private String fileName;
	
	public BannerDto(String bannerName, int bannerOrders, String fileName) {
		this.bannerName = bannerName;
		this.bannerOrders = bannerOrders;
		this.fileName = fileName;
	}
	


}
