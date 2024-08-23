package db;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {
	@Select("Select * from account")
	List<AccountDto> selectList();
	
	@Select("Select * from account where no = #{no}")
	AccountDto selectByNo(int no);
	
	@Select("Select * from account where id = #{id}")
	AccountDto selectById(String id);
	
	int insert(AccountDto dto);
	int delete(int no);
	int update(int no);
}
