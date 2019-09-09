package tour.list.web.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import tour.list.web.helper.WebHelper;

@Data
@Slf4j
public class member1 {
	
	
	public int id_num;			//아이디 번호
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
