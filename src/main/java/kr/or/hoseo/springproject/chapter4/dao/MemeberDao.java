package kr.or.hoseo.springproject.chapter4.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.hoseo.springproject.chapter4.vo.Member;

@Repository
public class MemeberDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Member> getAllMembers(){
		return jdbcTemplate.query("select * from member", 
				new BeanPropertyRowMapper<>(Member.class));
	}
}
