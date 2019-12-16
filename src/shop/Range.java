package shop;

public class Range {

	private String brand = null;
	private Integer price;

	public Range() {
	}

	public Range(String brand, Integer price) {
		this.brand = brand;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
