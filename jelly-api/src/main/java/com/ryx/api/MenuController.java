package com.ryx.api;

import com.ryx.common.BaseController;
import com.ryx.ryxrzt.entity.RoleAndMenu;
import com.ryx.ryxrzt.entity.UserInfo;
import com.ryx.ryxrzt.service.MenuService;
import com.ryx.utils.JsonResult;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 */
@RestController
@RequestMapping("/sys/menu")
public class MenuController extends BaseController {
	@Resource
	private MenuService menuService;
	/*@RequiresPermissions("menu:show")*/
    @RequestMapping("/show")
    public JsonResult showMenu(HttpServletRequest request)  {
    	Map<String,Object> map=getParamsToMap(request);
		String username= MapUtils.getString(map,"username");
		JsonResult jsonResult=new JsonResult();
		if(StringUtils.isBlank(username)){
			jsonResult=JsonResult.FAIL();
			return  jsonResult;
		}
    	UserInfo userInfo=new UserInfo();
    	userInfo.setLoginName(username);
		List<RoleAndMenu> roleAndMenus= menuService.selectPermissionByLoginName(userInfo);
		jsonResult.setCode("0000");
		jsonResult.setMsg("查询成功！");
		jsonResult.setResult(roleAndMenus);
        return jsonResult;


    }


	
}
