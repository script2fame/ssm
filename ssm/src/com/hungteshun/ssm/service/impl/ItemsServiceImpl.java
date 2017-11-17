package com.hungteshun.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.hungteshun.ssm.mapper.ItemsMapper;
import com.hungteshun.ssm.mapper.ItemsMapperCustom;
import com.hungteshun.ssm.po.Items;
import com.hungteshun.ssm.po.ItemsCustom;
import com.hungteshun.ssm.po.ItemsQueryVo;
import com.hungteshun.ssm.service.ItemsService;

/**
 * 商品查询service实现类
 * 
 * @author hungteshun
 *
 */
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// 通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		//中间对商品信息进行业务处理
		//....
		//因为service层涉及到业务，所以最后可能会需要添加其他的字段，所以这里返回ItemsCustom
		ItemsCustom itemsCustom = new ItemsCustom();
		//将items的属性值拷贝到itemsCustom
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	//在实际的前后端分离协作开发过程中，这里需要定义一个id参数，目的是告诉前端写controller的人，需要根据id来更新Items
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		//添加业务校验，通常在service接口对关键参数进行校验
		//校验 id是否为空，如果为空抛出异常
		//更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括 大文本类型字段
		//updateByPrimaryKeyWithBLOBs要求必须转入id
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}
	
	

}
