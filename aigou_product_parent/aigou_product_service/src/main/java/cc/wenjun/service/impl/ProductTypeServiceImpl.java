package cc.wenjun.service.impl;

import cc.wenjun.domain.ProductType;
import cc.wenjun.mapper.ProductTypeMapper;
import cc.wenjun.service.IProductTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品目录 服务实现类
 * </p>
 *
 * @author æä¿
 * @since 2019-07-31
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

    @Override
    public List<ProductType> loadTypeTree() {
        return fff();
    }
//循环
    private List<ProductType>fff(){
        //先查出全部出来
        List<ProductType> productTypes = baseMapper.selectList(null);
        //定义一个List存放一级菜单
        List<ProductType> list = new ArrayList<>();

        //定义一个Map存放所有的ProductType，key是id，value是类型对象
        Map<Long,ProductType>map=new HashMap<>();

        for (ProductType pt : productTypes) {
            map.put(pt.getId(),pt);
        }
        for (ProductType productType : productTypes) {
            if(productType.getPid()==0){
                list.add(productType);
            }else{
                ProductType pa = map.get(productType.getPid());
                pa.getChildren().add(productType);
            }
        }
        return list;
    }
}
