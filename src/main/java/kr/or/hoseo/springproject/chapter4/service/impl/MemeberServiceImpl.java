package kr.or.hoseo.springproject.chapter4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.hoseo.springproject.chapter4.dao.MemeberDao;
import kr.or.hoseo.springproject.chapter4.service.MemeberService;
import kr.or.hoseo.springproject.chapter4.vo.Member;

@Service
public class MemeberServiceImpl implements MemeberService{
	@Autowired
	MemeberDao memberDao;
	
	@Override
	public List<Member> getAllMemebers(){
		return memberDao.getAllMembers();
	}
}
