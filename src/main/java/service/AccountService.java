package service;

import db.AccountDao;
import db.AccountDto;

public class AccountService {
	private AccountDao dao = AccountDao.getInstance();
	
	public int login(String id, String pw) {
		AccountDto dto;
		if((dto = dao.selectById(id)) != null&&dto.getPw().equals(pw)) {
			return dto.getNo();
		}
		return 0;
	}
	
	public AccountDto selectByNo(int no) {
		AccountDto dto = dao.selectByNo(no);
		return dto!=null?dto:null;
	}
}
