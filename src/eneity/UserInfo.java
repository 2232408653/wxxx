package eneity;
/**
 * 
 * @author 15185丁硕
 *用户信息实体类
 */
public class UserInfo {
	String address;
	String email;
	String nickname;
	String pwd;
	String realname;
	String sex;
	String telnum;
	String birthDay;
	String avatarUrl;
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	@Override
	public String toString() {
		return "UserInfo [address=" + address + ", email=" + email + ", nickname=" + nickname + ", pwd=" + pwd
				+ ", realname=" + realname + ", sex=" + sex + ", telnum=" + telnum + ", birthDay=" + birthDay
				+ ", avatarUrl=" + avatarUrl + "]";
	}
}
