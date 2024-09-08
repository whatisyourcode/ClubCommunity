package mybatis.sql;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import db.AccountDto;

@Mapper
public interface AccountMapper {
	@Select("Select * from account")
	List<AccountDto> selectList();
	
	@Select("Select * from account where no = #{no}")
	AccountDto selectByNo(int no);
	
	@Select("Select * from account where id = #{id}")
	AccountDto selectById(String id);
	
	@Insert("insert into account(no, id, pw, name, joindate) values(#{no}, #{id}, #{pw}, #{name}, now()")
	int insert(AccountDto dto);
	@Delete("delete from account where no = #{no}")
	int delete(int no);
	@Update("update account set pw = #{pw}, name = #{name} where no = #{no} ")
	int update(int no);
}
