package kr.or.hoseo.springproject.chapter4;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.hoseo.springproject.chapter4.config.AppConfig;
import kr.or.hoseo.springproject.chapter4.dao.OwnerRepository;
import kr.or.hoseo.springproject.chapter4.dao.PetDao;
import kr.or.hoseo.springproject.chapter4.vo.Owner;
import kr.or.hoseo.springproject.chapter4.vo.Pet;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigWebContextLoader.class)
public class JpaTest {
	@Autowired
	PetDao petDao;
	
	@Autowired
	OwnerRepository ownerRepository;
	
	@Before
	public void before() {
		Owner jhPark = new Owner("동대문구", "서울특별시", "02-882-0000", null);
		jhPark.setFirstName("박");
		jhPark.setLastName("진현");
		
		Owner jhKim = new Owner("양평구", "서울특별시", "02-882-1668", null);
		jhKim.setFirstName("김");
		jhKim.setLastName("진현");

		Pet pikachu = new Pet();
		pikachu.setBirthDate(new Date());
		pikachu.setName("피카츄");
		
		jhPark.addPet(pikachu);

		ownerRepository.save(jhPark);
		ownerRepository.save(jhKim);
	}
	
	@Test
	public void test() {
		List<Pet> petList = petDao.findByName("피카츄");
		assertEquals(1, petList.size());
		assertEquals(2,ownerRepository.count());
	}
	
}