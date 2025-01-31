package bean;

import java.io.Serializable;

public class UserBean implements Serializable{

	private int no;
	private String mail;
	private String pass;
	private Integer icon;
	private String name;
	private Integer chara_id;
	private String comment;
	private boolean isAuthenticated;

	/**
	 * ゲッター、セッター
	 */
	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	 public int getNo() { return no; }
	 public void setNo(int no) { this.no = no; }

	 public String getMail() { return mail; }
	 public void setMail(String mail) { this.mail = mail; }

	 public String getPass() { return pass; }
	 public void setPass(String pass) { this.pass = pass; }

	 public Integer getIcon() { return icon; }
	 public void setIcon(Integer icon) { this.icon = icon; }

	 public String getName() { return name; }
	 public void setName(String name) { this.name = name; }

	 public Integer getChara_id() { return chara_id; }
	 public void setChara_id(Integer chara_id) { this.chara_id = chara_id; }

	 public String getComment() { return comment; }
	 public void setComment(String comment) { this.comment = comment; }


}