package eneity;
/***
 * 
 * @author 15185丁硕
 *购物车信息简单版
 */
public class buyInfo {
	String userName;
	int productID;
	int number;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getProductID() {
		return productID;
	}
	@Override
	public String toString() {
		return "buyInfo [userName=" + userName + ", productID=" + productID + ", number=" + number + "]";
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
