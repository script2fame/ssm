package com.hungteshun.ssm.service;

import java.util.List;

import com.hungteshun.ssm.po.ItemsCustom;
import com.hungteshun.ssm.po.ItemsQueryVo;

/**
 * 商品查询service接口
 * 
 * @author hungteshun
 *
 */
public interface ItemsService {

	// 商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
