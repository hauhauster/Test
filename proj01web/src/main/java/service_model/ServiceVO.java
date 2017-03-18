package service_model;

import java.sql.Date;

public class ServiceVO {
	private String servno;
	private String servclassno;
	private String servname;
	private String servdiscribe;
	private byte[] servimage;
	private Date servupdate;
	private Integer status;
	public String getServno() {
		return servno;
	}
	public void setServno(String servno) {
		this.servno = servno;
	}
	public String getServclassno() {
		return servclassno;
	}
	public void setServclassno(String servclassno) {
		this.servclassno = servclassno;
	}
	public String getServname() {
		return servname;
	}
	public void setServname(String servname) {
		this.servname = servname;
	}
	public String getServdiscribe() {
		return servdiscribe;
	}
	public void setServdiscribe(String servdiscribe) {
		this.servdiscribe = servdiscribe;
	}
	public byte[] getServimage() {
		return servimage;
	}
	public void setServimage(byte[] servimage) {
		this.servimage = servimage;
	}
	public Date getServupdate() {
		return servupdate;
	}
	public void setServupdate(Date servupdate) {
		this.servupdate = servupdate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
