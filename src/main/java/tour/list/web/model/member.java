package tour.list.web.model;

import lombok.Data;

@Data
public class member {
	
	
	public int idNum;			//아이디 번호
	public String id;			//아이디
	public String password;		//패스워드
	public String name;			//이름
	public String gender;		//성별
	public String birth;		//생년월일
	public String mail;			//이메일
	public String phone;		//핸드폰번호
	public String address;		//주소
	public String reg;			//가입날짜
}
