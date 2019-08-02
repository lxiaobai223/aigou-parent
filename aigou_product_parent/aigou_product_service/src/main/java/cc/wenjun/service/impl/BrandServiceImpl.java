package cc.wenjun.service.impl;

import cc.wenjun.domain.Brand;
import cc.wenjun.mapper.BrandMapper;
import cc.wenjun.query.BrandQuery;
import cc.wenjun.service.IBrandService;
import cc.wenjun.util.PageList;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 品牌信息 服务实现类
 * </p>
 *
 * @author æä¿
 * @since 2019-07-31
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Override
    //有事务就加入事务，没得事务就非事务方式执行
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public PageList<Brand> queryPage(BrandQuery query) {

        Page<Brand> page = new Page<>(query.getPageNum(), query.getPageSize());
        IPage<Brand> ip= baseMapper.queryPage(page,query);
        return new PageList<>(ip.getTotal(),ip.getRecords());
    }
}
