package multithreading.java;

public class Product {
	
	private String Id;
	private String ProductName;
	private Integer Amount;
	
	public Product() {}
	public Product(String id, String productName, Integer amount) {
		super();
		Id = id;
		ProductName = productName;
		Amount = amount;
	}
	
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public Integer getAmount() {
		return Amount;
	}
	public void setAmount(Integer amount) {
		Amount = amount;
	}
	
	
	
	

}
