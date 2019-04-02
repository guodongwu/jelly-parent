package com.ryx.api;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.ryx.common.BaseController;
import com.ryx.ryxrzt.service.RztDealService;
import com.ryx.ryxrzt.vo.RztDealVo;
import com.ryx.utils.EasyExcelUtil;
import com.ryx.utils.JsonResult;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * 交易管理
 */
@RestController
@RequestMapping("/deal")

public class DealController extends BaseController {

    @Autowired
    private RztDealService rztDealService;
    /**
     * 获取交易列表
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(HttpServletRequest request){
       Map<String,Object> map= getParamsToMap(request);
       JsonResult jsonResult= rztDealService.getDealList(map);
       return jsonResult;
    }

    /**
     * 导出
     * @param request
     * @return
     */
    @PostMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = URLEncoder.encode(("交易明细" + DateTime.now().toString("yyyy-MM-dd")),"UTF-8");
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");

        Map<String,Object> map=getParamsToMap(request);
        List<RztDealVo> vo= rztDealService.getDealTable(map);
        ServletOutputStream outputStream= response.getOutputStream();
        EasyExcelUtil.writeExcelWithModel(outputStream,vo,RztDealVo.class, ExcelTypeEnum.XLSX);
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 撤销
     * @param request
     * @return
     */
    @PostMapping("/revoke")
    public JsonResult revoke(HttpServletRequest request){

        return null;
    }

}
