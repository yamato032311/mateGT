package bean;

import java.io.Serializable;

public class UserBean implements Serializable{

	private int no;
	private String mail;
	private String pass;
	private int icon;
	private String name;
	private Character chara_id;
	private String comment;


	 public int getNo() { return no; }
	 public void setNo(int no) { this.no = no; }

	 public String getMail() { return mail; }
	 public void setMail(String mail) { this.mail = mail; }

	 public String getPass() { return pass; }
	 public void setPass(String pass) { this.pass = pass; }

	 public int getIcon() { return icon; }
	 public void setIcon(int icon) { this.icon = icon; }

	 public String getName() { return name; }
	 public void setName(String name) { this.name = name; }

	 public Character getChara_id() { return chara_id; }
	 public void setChara_id(Character chara_id) { this.chara_id = chara_id; }

	 public String getComment() { return comment; }
	 public void setComment(String comment) { this.comment = comment; }


}