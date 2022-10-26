package com.exult.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "CONFIG")
public class Configurations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idconfig")
	private Integer Id;
	
	
    @Column(columnDefinition = "JSON")
    private String jsonconf ;
    
    @Column(name="sendermail")
    private String sendermail;
    
    @Column(name = "mailpassword")
    private String mailpassword;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getJsonconf() {
		return jsonconf;
	}

	public void setJsonconf(String jsonconf) {
		this.jsonconf = jsonconf;
	}

	public String getSendermail() {
		return sendermail;
	}

	public void setSendermail(String sendermail) {
		this.sendermail = sendermail;
	}

	public String getMailpassword() {
		return mailpassword;
	}

	public void setMailpassword(String mailpassword) {
		this.mailpassword = mailpassword;
	}

	
	
}
