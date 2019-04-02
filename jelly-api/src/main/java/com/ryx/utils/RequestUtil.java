package com.ryx.utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class RequestUtil
{
  public static <T> Map<String, T> getParamsToMap(HttpServletRequest request)
  {
    return getParamsToMap(request, "params");
  }
  
  public static <T> Map<String, T> getParamsToMap(HttpServletRequest request, String paramName)
  {
    Map<String, T> requestMap = new HashMap<String, T>();
    Map<String, String[]> paramMap = request.getParameterMap();
    for (Map.Entry<String, String[]> paramEntry : paramMap.entrySet())
    {
      String paramKey = (String)paramEntry.getKey();
      String[] paramValue = (String[])paramEntry.getValue();
      if (paramValue.length == 1) {
        requestMap.put(paramKey, (T) paramValue[0]);
      } else {
        requestMap.put(paramKey, (T) paramValue);
      }
    }
    return requestMap;
  }
}
