package com.nya.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Override
    public IPage<Commodity> getByPage(Integer currentPage, Integer pageSize) {
        IPage page = new Page<Commodity>(currentPage, pageSize);
        return commodityMapper.selectPage(page, null);
    }

    @Override
    public IPage<Commodity> getByPageWithType(Integer currentPage, Integer pageSize, String type) {
        IPage page = new Page<Commodity>(currentPage, pageSize);
        QueryWrapper<Commodity> qw = new QueryWrapper<>();
        qw.like("ctype", type);
        return commodityMapper.selectPage(page, qw);
    }

    @Override
    public IPage<Commodity> getByPageWithKey(Integer currentPage, Integer pageSize, String key) {
        IPage page = new Page<Commodity>(currentPage, pageSize);
        QueryWrapper<Commodity> qw = new QueryWrapper<>();
        qw.like("cname", key).or().like("ctype", key);
        return commodityMapper.selectPage(page, qw);
    }
}
