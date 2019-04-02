package com.ryx.api;

import com.ryx.ryxpay.entity.PayBindBankCard2;
import com.ryx.ryxpay.entity.PayCustomer;
import com.ryx.ryxpay.service.PayCustomerService;
import com.ryx.ryxrzt.entity.RztAgencyInfo;
import com.ryx.ryxrzt.service.RztAgencyInfoService;
import com.ryx.ryxrzt.vo.AgencyInfoVo;
import com.ryx.utils.ConstantUtil;
import com.ryx.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/agency")
public class RztAgencyInfoController {
    @Resource
    private RztAgencyInfoService rztAgencyInfoService;
    @Resource
    private PayCustomerService payCustomerService;

    private static final Logger log = LoggerFactory.getLogger(RztAgencyInfoController.class);

    //获取代理商信息品牌ID,代理商名称、手机号、A码、加入时间、结束时间、状态、是否直签、代理商层级查询、机构
    @RequestMapping("getRztAgencyInfoList")
    @ResponseBody
    public JsonResult getRztAgencyInfoList(AgencyInfoVo agencyInfoVo,Integer page,Integer limit){
        JsonResult jsonResult = new JsonResult();
        try {
            if (page == null){
                page = 1;
            }
            if (limit == null){
                limit = 20;
            }
            jsonResult = rztAgencyInfoService.getRztAgencyInfoList(agencyInfoVo,page,limit);
            return jsonResult;
        }catch (Exception e){
            e.printStackTrace();
            log.error("查询代理商信息错误",e);
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg(ConstantUtil.QUERY_FAIL_MSG);
            return jsonResult;
        }
    }
    //查询字典表数据（下拉框）
    @RequestMapping("getSelectList")
    @ResponseBody
    public JsonResult getSelectList(){
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult = rztAgencyInfoService.getSelectList();
            return jsonResult;
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取下拉框信息错误",e);
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("获取下拉框信息失败");
            return jsonResult;
        }
    }
    //是否直签   参数：代理商Id
    @RequestMapping("setRztAgencyDirect")
    @ResponseBody
    public JsonResult setRztAgencyDirect(AgencyInfoVo agencyInfoVo){
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult = rztAgencyInfoService.setRztAgencyDirect(agencyInfoVo);
            return jsonResult;
        }catch (Exception e){
            e.printStackTrace();
            log.error("设置直签错误",e);
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("设置直签失败");
            return jsonResult;
        }
    }
    //冻结    FREEZE_RELATION：1/0     agencyId
    @RequestMapping("setAgencyFreeze")
    @ResponseBody
    public JsonResult setAgencyFreeze(RztAgencyInfo  rztAgencyInfo, HttpServletRequest request){
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult = rztAgencyInfoService.setAgencyFreeze(rztAgencyInfo,request);
            return jsonResult;
        }catch (Exception e){
            e.printStackTrace();
            log.error("冻结错误",e);
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("冻结失败");
            return jsonResult;
        }
    }
    //解冻    FREEZE_RELATION：1/0   agencyId
    @RequestMapping("setAgencyUnFreeze")
    @ResponseBody
    public JsonResult setAgencyUnFreeze(RztAgencyInfo  rztAgencyInfo, HttpServletRequest request){
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult = rztAgencyInfoService.setAgencyUnFreeze(rztAgencyInfo,request);
            return jsonResult;
        }catch (Exception e){
            e.printStackTrace();
            log.error("解冻错误",e);
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("解冻失败");
            return jsonResult;
        }
    }
    //新增代理商信息、代理商结算账户
    /*@RequestMapping("insertPayCustomer")
    @ResponseBody
    public JsonResult insertPayCustomer(PayCustomer payCustomer, RztAgencyInfo rztAgencyInfo, PayBindBankCard2 payBindBankCard2){
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult = payCustomerService.insertPayCustomer(payCustomer,rztAgencyInfo,payBindBankCard2);
            return jsonResult;
        }catch (Exception e){
            e.printStackTrace();
            log.error("新增代理商错误",e);
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("新增代理商失败");
            return jsonResult;
        }
    }*/
    //查询下级代理商   agencyId
    @RequestMapping("getAgencyInfoByAgencyId")
    @ResponseBody
    public JsonResult getAgencyInfoByAgencyId(String  agencyId) {
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult = rztAgencyInfoService.getAgencyInfoByAgencyId(agencyId);
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询下级代理商错误", e);
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("查询下级代理商失败");
            return jsonResult;
        }
    }
    //查询所有下级代理商   agencyId      （二选一,不一定有用）
    @RequestMapping("getAgencyInfoAllSonByAgencyId")
    @ResponseBody
    public JsonResult getAgencyInfoAllSonByAgencyId(String  agencyId) {
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult = rztAgencyInfoService.getAgencyInfoAllSonByAgencyId(agencyId);
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询所有下级代理商错误", e);
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("查询所有下级代理商失败");
            return jsonResult;
        }
    }
    //查看代理商详情    agencyId
    @RequestMapping("getAgencyPayCustomerBindBankCard")
    @ResponseBody
    public JsonResult getAgencyPayCustomerBindBankCard(AgencyInfoVo agencyInfoVo){
        JsonResult jsonResult = new JsonResult();
        try {
            //查询代理商相关信息根据agencyId
            AgencyInfoVo agency = rztAgencyInfoService.getAgencyByAgencyId(agencyInfoVo);
            //查询代理商层级关系根据agencyId
            String cjgx = rztAgencyInfoService.getAgencyInfoAllParentByAgencyId(agencyInfoVo);
            //根据AgencyCode查询代理商客户信息
            PayCustomer payCustomer = payCustomerService.getPayCustomerByAgencyCode(agency.getAgencyCode());
            //根据AgencyCode查询代理商结算账户信息
            List<PayBindBankCard2> list = payCustomerService.getPayBindBankCardByAgencyCode(agency.getAgencyCode());
            HashMap map = new HashMap();
            map.put("agency",agency);
            map.put("cjgx",cjgx);
            map.put("payCustomer",payCustomer);
            map.put("list",list);
            jsonResult.setCode(ConstantUtil.SUCCESS_CODE);
            jsonResult.setMsg("查看代理商详情成功");
            jsonResult.setResult(map);
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查看代理商详情错误", e);
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("查看代理商详情失败");
            return jsonResult;
        }
    }
    //添加结算信息 用户编号、账户类型、账号、开户行、身份证、名称、卡序列号
    @RequestMapping("insertPayBindBankCard")
    @ResponseBody
    public JsonResult insertPayBindBankCard(PayBindBankCard2 payBindBankCard){
        JsonResult jsonResult = new JsonResult();
        try {
            jsonResult = payCustomerService.insertPayBindBankCard(payBindBankCard);
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("添加结算信息错误", e);
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("添加结算信息失败");
            return jsonResult;
        }
    }
}
