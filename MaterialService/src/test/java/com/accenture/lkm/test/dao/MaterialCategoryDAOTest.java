package com.accenture.lkm.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.dao.MaterialCategoryDAO;
import com.accenture.lkm.entity.MaterialCategoryEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialCategoryDAOTest {
	//private static final Logger logger = LoggerFactory.getLogger(MaterialCategoryDAOTest.class);
	
	/*
	 * Autowire the MaterialCategoryDAO object below
	 */
	
	// Your Code Here
	@Autowired
	private MaterialCategoryDAO dao;
	
	/*
	 * Method - notNullMaterialCategoryDAOTest()
	 * Assert only that MaterialCategoryDAO object is Not null
	 */	
	
	@Test
	public void notNullMaterialCategoryDAOTest() {
		// Your Code Here
		assertNotNull(dao);
	}
	
	
	/*
	 * Method - findByIdMaterialCategoryTest()
	 * Using MaterialCategoryDAO fetch an entity by its ID --> "C001" 
	 * Assert that the entity fetch and it is Not null 
	 * Assert that the name of the material category entity fetch is equal to --> "Thread"
	 */
	
	@Test
	public void findByIdMaterialCategoryTest() {
		// Your Code Here
		MaterialCategoryEntity categoryEntity = dao.findOne("C001");
		assertNotNull(categoryEntity);
		assertEquals("Thread", categoryEntity.getCategoryName());
	}

	/*
	 * Method - findAllMaterialCategoryTest()
	 * Using MaterialCategoryDAO to fetch all the entities 
	 * Assert that the list is Not null 
	 * Assert that the count of entities matches to --> 3
	 */
			
	@Test
	public void findAllMaterialCategoryTest() {
		// Your Code Here
		List<MaterialCategoryEntity> categoryEntities = (List<MaterialCategoryEntity>) dao.findAll();
		assertNotNull(categoryEntities);
		assertEquals(3, categoryEntities.size());
	}
	
}
