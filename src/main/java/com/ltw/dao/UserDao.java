package com.ltw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
//import org.springframework.data.repository.CrudRepository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ltw.entity.User;
/*public interface UserDao extends CrudRepository<User, Integer>{

}*/
@Mapper
public interface UserDao{
	@Select("select * from user where id = #{id}")
	User findById(@Param("id") int id);
	
	@Insert("insert into user (name,sex,age) values(#{name},#{sex},#{age})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	void save (User user);
	@Select("select * from user")
	List<User> findAll();
}
