package com.ryx.api;

import com.alibaba.fastjson.JSONObject;
import com.ryx.ryxpay.entity.RyxTermOrder;
import com.ryx.ryxpay.service.RyxTermOrderService;
import com.ryx.utils.ConstantUtil;
import com.ryx.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商户订单管理
 */
@RestController
@RequestMapping("/ryxtermorder")
@Api(value = "RyxTermOrderController|商户订单管理")
public class RyxTermOrderController {

    @Autowired
    private RyxTermOrderService ryxTermOrderService;

    @ResponseBody
    @ApiOperation(value = "根据条件查询订单列表信息", notes = "根据条件查询订单列表信息")
    @GetMapping("/termorderList")
    public JsonResult termorderList(RyxTermOrder ryxTermOrder){
        JsonResult jsonResult=new JsonResult();
        jsonResult.setCode(ConstantUtil.SUCCESS_CODE);
        int page=ryxTermOrder.getPage();
        ryxTermOrder.setStartRownum(ConstantUtil.PAGE_SIZE*(page-1));
        ryxTermOrder.setEndRownum(ConstantUtil.PAGE_SIZE*page);
       int totalcount= ryxTermOrderService.selectCountByRyxTermOrder(ryxTermOrder);
       List<RyxTermOrder> ryxTermOrderList= ryxTermOrderService.selectByRyxTermOrder(ryxTermOrder);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("total",totalcount);
        jsonObject.put("items",ryxTermOrderList);
        jsonResult.setResult(jsonObject);
        jsonResult.setMsg("处理成功");
        return jsonResult;
    }
    @ResponseBody
    @ApiOperation(value = "根据条件查询订单信息", notes = "根据条件查询终端订单列表信息")
    @GetMapping("/orderDetails")
    public JsonResult orderDetails(String orderId){
        JsonResult jsonResult=new JsonResult();
        if (StringUtils.isEmpty(orderId)) {
            jsonResult.setCode("1001");
            jsonResult.setMsg("订单编号不可为空");
            return jsonResult;
        }
      RyxTermOrder ryxTermOrder=  ryxTermOrderService.selectRyxTermOrder(orderId);
        jsonResult.setCode(ConstantUtil.SUCCESS_CODE);
        jsonResult.setResult(ryxTermOrder);
        jsonResult.setMsg("处理成功");

        return jsonResult;
    }

}
