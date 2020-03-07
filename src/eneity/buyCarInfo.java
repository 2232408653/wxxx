package eneity;
/**
 * 
 * @author 丁硕
 *购物车信息读取
 */
public class buyCarInfo {
	int goods_id;
	String image_url;
	String goods_introduce;
	String goods_style;
	double goods_price;
	int goods_number;
	boolean is_check=false;
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getGoods_introduce() {
		return goods_introduce;
	}
	public void setGoods_introduce(String goods_introduce) {
		this.goods_introduce = goods_introduce;
	}
	public String getGoods_style() {
		return goods_style;
	}
	public void setGoods_style(String goods_style) {
		this.goods_style = goods_style;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public int getGoods_number() {
		return goods_number;
	}
	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}
	public boolean isIs_check() {
		return is_check;
	}
	public void setIs_check(boolean is_check) {
		this.is_check = is_check;
	}
	@Override
	public String toString() {
		return "buyCarInfo [goods_id=" + goods_id + ", image_url=" + image_url + ", goods_introduce=" + goods_introduce
				+ ", goods_style=" + goods_style + ", goods_price=" + goods_price + ", goods_number=" + goods_number
				+ ", is_check=" + is_check + "]";
	}
	
}
