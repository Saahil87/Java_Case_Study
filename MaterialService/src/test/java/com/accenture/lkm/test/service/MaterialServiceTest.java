package com.accenture.lkm.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.service.MaterialService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialServiceTest {
	//private static final Logger logger = LoggerFactory.getLogger(MaterialServiceTest.class);
	
	/*
	 * Autowire the MaterialService object below
	 * 
	 */
	@Autowired
	private MaterialService service;
	// Your Code Here

	/*
	 * Method - notNullMaterialServiceTest()
	 * Assert only that MaterialService object is Not null
	 * 
	 */	
	
	@Test
	public void notNullMaterialServiceTest() {
		// Your Code Here
		assertNotNull(service);
	}
	
		
	/*
	 * Method - getMaterialCategoryByIdTest()
	 * Assert that MaterialCategoryBean object fetch using MaterialService getMaterialCategoryById --> C001 is not null
	 * Assert that object fetch name is equal to --> "Thread"
	 */
	
	@Test
	public void getMaterialCategoryByIdTest() {
		// Your Code Here
		MaterialCategoryBean materialCategoryBean = service.getMaterialCategoryById("C001");
		assertNotNull("NULLL materialcatergoryBEANS",materialCategoryBean);
		assertEquals("Thread", materialCategoryBean.getCategoryName());
	}
	
	
	/*
	 * Method - getMaterialCategoriesTest()
	 * Assert that MaterialCategoryBean list fetch using MaterialService getMaterialCategories is not null
	 * Assert that list size matches to --> 3
	 */
	
	@Test
	public void getMaterialCategoriesTest() {
		// Your Code Here
		List<MaterialCategoryBean> categoryBeans = service.getMaterialCategories();
		assertNotNull("NULLL catergoryBEANS", categoryBeans);
		assertEquals(3, categoryBeans.size());
 	}
	
}
