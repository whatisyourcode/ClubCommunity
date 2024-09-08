package db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapConfig;
import mybatis.sql.AccountMapper;

public class AccountDao {
	private SqlSession session;
	private AccountMapper am;
	private static AccountDao dao = new AccountDao();
	
	private AccountDao() {
		session = SqlMapConfig.getSqlMapInstance().openSession(true);
		am = session.getMapper(AccountMapper.class);
	}
	
	public static AccountDao getInstance() {
		return dao;
	}
	
	public List<AccountDto> selectList(){
		return am.selectList();
	};
	public AccountDto selectByNo(int no) {
		return am.selectByNo(no);
	};
	public AccountDto selectById(String id) {
		return am.selectById(id);
	};	
	public int insert(AccountDto dto) {
		return am.insert(dto);
	};
	public int delete(int no) {
		return am.delete(no);
	};
	public int update(int no) {
		return am.update(no);
	};
}
