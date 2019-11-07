package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.dao.MaterialTypeDAO;
import com.accenture.lkm.entity.MaterialTypeEntity;

@Service
public class MaterialTypeServiceImpl implements MaterialTypeService{
	
	@Autowired
	private MaterialTypeDAO materialTypeDAO;

	@Override
	public List<MaterialTypeBean> getMaterialTypes(String categoryId) {
		// TODO Auto-generated method stub
		List<MaterialTypeBean> materialTypeBeanList=new ArrayList<>();
		MaterialTypeBean materialTypeBean;
		List<MaterialTypeEntity> materialTypeEntityList=materialTypeDAO.findByCategoryId(categoryId);
		
		
		
		for (MaterialTypeEntity materialTypeEntity : materialTypeEntityList) {
			materialTypeBean = new MaterialTypeBean();
			BeanUtils.copyProperties(materialTypeEntity, materialTypeBean);
			
			
			/*
			 * Important
			 */
			materialTypeBean.setCategoryId(materialTypeEntity.getCategoryEntity().getCategoryId());
			
			
			
			
			materialTypeBeanList.add(materialTypeBean);
		}
		
		
		return materialTypeBeanList;
	}

	@Override
	public List<MaterialTypeBean> getMaterialTypes() {
		// TODO Auto-generated method stub
		List<MaterialTypeBean> materialTypeBeanList=new ArrayList<>();
		List<MaterialTypeEntity> materialTypeEntityList=materialTypeDAO.findAll();
		for (MaterialTypeEntity materialTypeEntity : materialTypeEntityList) {
			MaterialTypeBean materialTypeBean=new MaterialTypeBean();
			BeanUtils.copyProperties(materialTypeEntity, materialTypeBean);
			
			/*
			 * Important
			 */
			materialTypeBean.setCategoryId(materialTypeEntity.getCategoryEntity().getCategoryId());
			
			materialTypeBeanList.add(materialTypeBean);
		}
		return materialTypeBeanList;
	}

	public MaterialTypeServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
