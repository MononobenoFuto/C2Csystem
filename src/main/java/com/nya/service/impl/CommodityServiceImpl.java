package com.nya.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nya.domain.Commodity;
import com.nya.mapper.CommodityMapper;
import com.nya.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {
    @Autowired
    private CommodityMapper commodityMapper;
}
