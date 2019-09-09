package tour.list.web.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import tour.list.web.helper.WebHelper;

@Data
@Slf4j
public class member1 {
	
	
	private int id_num;
	private String id;
	private String password;
	private String name;
	private String gender;
	private String birth;
	private String mail;
	private String phone;
	private String address;
	private String reg;
	
}
