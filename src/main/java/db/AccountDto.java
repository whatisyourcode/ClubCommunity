package db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDto {
	int account_num;
	String id;
	String pw;
	String name;
	String birth;
	String tel;
	String email;
	String nickname;
	String joindate;
}
