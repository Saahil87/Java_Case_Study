package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.dao.UnitDAO;
import com.accenture.lkm.entity.UnitEntity;

@Service
public class UnitServiceImpl implements UnitService {
	
	@Autowired
	private UnitDAO unitDAO;

	@Override
	public List<UnitBean> getUnits(String categoryId) {
		// TODO Auto-generated method stub
		List<UnitEntity> unitEntityList=unitDAO.findByCategoryId(categoryId);
		List<UnitBean> unitBeanList=new ArrayList<>();
		
		for (UnitEntity unitEntity : unitEntityList) {
			UnitBean unitBean=new UnitBean();
			BeanUtils.copyProperties(unitEntity, unitBean);
			
			
			unitBean.setCategoryId(unitEntity.getCategoryEntity().getCategoryId());
			
			unitBeanList.add(unitBean);
			
		}
		return unitBeanList;
	}

	@Override
	public List<UnitBean> getUnits() {
		// TODO Auto-generated method stub
		List<UnitEntity> unitEntityList=unitDAO.findAll();
		List<UnitBean> unitBeanList=new ArrayList<>();
		
		for (UnitEntity unitEntity : unitEntityList) {
			UnitBean unitBean=new UnitBean();
			BeanUtils.copyProperties(unitEntity, unitBean);
			
			unitBean.setCategoryId(unitEntity.getCategoryEntity().getCategoryId());
			
			
			unitBeanList.add(unitBean);
			
		}
		return unitBeanList;
	}

	public UnitServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
