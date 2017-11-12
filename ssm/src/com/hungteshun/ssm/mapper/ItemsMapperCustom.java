package com.hungteshun.ssm.mapper;

import com.hungteshun.ssm.po.ItemsCustom;
import com.hungteshun.ssm.po.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}