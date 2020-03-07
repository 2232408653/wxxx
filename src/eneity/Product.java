package eneity;
/***
 * 
 * @author 15185丁硕
 *产品信息
 */
public class Product {
	int goods_id;
	String image_url;
	String goods_message;
	double goods_evaluate;//好评百分数
	int goods_cell;//销量
	double goods_prise;
	
	public int getGoods_cell() {
		return goods_cell;
	}
	public void setGoods_cell(int goods_cell) {
		this.goods_cell = goods_cell;
	}
	
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getGoods_message() {
		return goods_message;
	}
	public void setGoods_message(String goods_message) {
		this.goods_message = goods_message;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	@Override
	public String toString() {
		return "Product [goods_id=" + goods_id + ", image_url=" + image_url + ", goods_message=" + goods_message
				+ ", goods_evaluate=" + goods_evaluate + ", goods_cell=" + goods_cell + ", goods_prise=" + goods_prise
				+ "]";
	}
	
	public double getGoods_evaluate() {
		return goods_evaluate;
	}
	public void setGoods_evaluate(double goods_evaluate) {
		this.goods_evaluate = goods_evaluate;
	}
	public double getGoods_prise() {
		return goods_prise;
	}
	public void setGoods_prise(double goods_prise) {
		this.goods_prise = goods_prise;
	}
	
}
