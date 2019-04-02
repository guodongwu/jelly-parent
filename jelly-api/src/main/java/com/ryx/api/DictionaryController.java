package com.ryx.api;

import com.ryx.ryxpay.entity.RyxTermBrand;
import com.ryx.ryxpay.service.DictionaryService;
import com.ryx.utils.ConstantUtil;
import com.ryx.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dictionary")
@Api("dictionary|公共数据字典")
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

    /**
     * 获取品牌列表
     * @return
     */
    @ApiOperation(value ="获取品牌列表" )
    @ApiImplicitParam(name = "ryxTermBrand",value = "ryxTermBrand",dataTypeClass =RyxTermBrand.class)
    @RequestMapping(value = "/getMouldList",method = {RequestMethod.POST,RequestMethod.GET})
    public JsonResult getMouldList(RyxTermBrand ryxTermBrand){
        JsonResult jsonResult=new JsonResult();
        jsonResult.setMsg("处理成功");
        jsonResult.setCode(ConstantUtil.SUCCESS_CODE);
        List<RyxTermBrand> ryxTermBrandList= dictionaryService.selectRyxTermBrandList(ryxTermBrand);
        jsonResult.setResult(ryxTermBrandList);
        return jsonResult;
    }

}
