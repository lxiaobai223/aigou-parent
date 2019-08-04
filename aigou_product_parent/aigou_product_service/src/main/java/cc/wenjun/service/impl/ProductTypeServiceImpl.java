package cc.wenjun.service.impl;

import cc.wenjun.common.client.RedisClient;
import cc.wenjun.common.client.StaticPageClient;
import cc.wenjun.domain.ProductType;
import cc.wenjun.mapper.ProductTypeMapper;
import cc.wenjun.service.IProductTypeService;
import cc.wenjun.util.AjaxResult;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private StaticPageClient staticPageClient;

    @Override
    public void genHomePage() {
      //生成product.type.vm.html
        HashMap<String, Object> map = new HashMap<>();
        String templatePath = "F:\\Java\\IDEA\\aigou-parent\\aigou_product_parent\\aigou_product_service\\src\\main\\resources\\cc\\wenjun\\mapper\\template\\product.type.vm";
        String targetPath = "F:\\Java\\IDEA\\aigou-parent\\aigou_product_parent\\aigou_product_service\\src\\main\\resources\\cc\\wenjun\\mapper\\template\\product.type.vm.html";
        List<ProductType> productTypes = loadTypeTree();
        map.put("model",productTypes);
        map.put("templatePath",templatePath);
        map.put("targetPath",targetPath);
        staticPageClient.genStaticPage(map);
     /*   //生成home.html
        map = new HashMap<>();
        templatePath = "F:\\Java\\IDEA\\aigou-parent\\aigou_product_parent\\aigou_product_service\\src\\main\\resources\\cc\\wenjun\\mapper\\template\\home.vm";
        targetPath = "F:\\Java\\IDEA\\aigou-web-parent\\aigou-web-home\\home.html";
        Map<String,String> model = new HashMap<>();
        model.put("staticRoot","F:\\Java\\IDEA\\aigou-parent\\aigou_product_parent\\aigou_product_service\\src\\main\\resources\\");
        map.put("model",model);
        map.put("templatePath",templatePath);
        map.put("targetPath",targetPath);
        staticPageClient.genStaticPage(map);*/


        //第二步 ： 生成home.html
        map = new HashMap<>();
        templatePath = "F:\\Java\\IDEA\\aigou-parent\\aigou_product_parent\\aigou_product_service\\src\\main\\resources\\cc\\wenjun\\mapper\\template\\home.vm";
        targetPath = "F:\\Java\\IDEA\\aigou-web-parent\\aigou-web-home\\home.html";
        //model 中要有一个数据是staticRoot
        Map<String,String> model = new HashMap<>();
        model.put("staticRoot","F:\\Java\\IDEA\\aigou-parent\\aigou_product_parent\\aigou_product_service\\src\\main\\resources");
        map.put("model",model);
        map.put("templatePath",templatePath);
        map.put("targetPath",targetPath);

        staticPageClient.genStaticPage(map);

    }

        @Override
        public List<ProductType> loadTypeTree() {
            AjaxResult result = redisClient.get("productTypes");
            String restObj = (String) result.getRestObj();
            List<ProductType> productTypes = JSON.parseArray(restObj, ProductType.class);
            if (productTypes == null || productTypes.size() <= 0) {
                productTypes = fff();
                redisClient.set("productTypes", JSON.toJSONString(productTypes));
            }


            return productTypes;
        }


        //循环
        private List<ProductType> fff () {
            //先查出全部出来
            List<ProductType> productTypes = baseMapper.selectList(null);
            //定义一个List存放一级菜单
            List<ProductType> list = new ArrayList<>();

            //定义一个Map存放所有的ProductType，key是id，value是类型对象
            Map<Long, ProductType> map = new HashMap<>();

            for (ProductType pt : productTypes) {
                map.put(pt.getId(), pt);
            }
            for (ProductType productType : productTypes) {
                if (productType.getPid() == 0) {
                    list.add(productType);
                } else {
                    ProductType pa = map.get(productType.getPid());
                    List<ProductType> children = pa.getChildren();

                    if(children==null){
                      children = new ArrayList<>();
                    }
                    children.add(productType);
                    pa.setChildren(children);

                }
            }
            return list;
        }

    }
