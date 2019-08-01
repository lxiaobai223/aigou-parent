package cc.wenjun.service.impl;

import cc.wenjun.domain.Product;
import cc.wenjun.mapper.ProductMapper;
import cc.wenjun.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author æä¿
 * @since 2019-07-31
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
