package com.nya.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommodityMapperTest {
    @Autowired
    private CommodityMapper commodityMapper;

    @Test
    void testGetPage() {
        IPage page = new Page(1, 8);
        commodityMapper.selectPage(page, null);
    }
}
