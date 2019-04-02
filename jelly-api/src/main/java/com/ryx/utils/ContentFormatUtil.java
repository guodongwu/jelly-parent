package com.ryx.utils;
import com.ryx.exception.MyException;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ContentFormatUtil {
	public static String handlePhoneByStar(String phone) {
		if (phone!=null&&phone.trim().length()==11) {
			return phone.substring(0, 3)+ "****" + phone.substring(7);
		} else if (phone==null) {
			return "";
		} else {
			return phone;
		}
	}
	
	public static String getDateStringWithoutSecond() {
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY年MM月dd日  HH:mm");
		return sdf.format(new Date());
	}
	
	public static String handleDateFormat(String date) {
		try {
			if (date!=null&&date.trim().length()==14) {
				SimpleDateFormat sdfForDate = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat sdfForString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return sdfForString.format(sdfForDate.parse(date));
			} else {
				return "";
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}
	

	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
    }


	public static String originStringToHexString(String originString, String encode) throws Exception {
		byte[] src = originString.getBytes(encode);
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
	
	public static String hexStringToOriginString(String hexString, String encode) throws Exception {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
 
        }
        return new String(d, encode);
    }

	public static void main(String[] args) {
		System.out.println(handlePhoneByStar("13693160390"));
		System.out.println(getDateStringWithoutSecond());
		String inviteCode = "0123450987650001";
		try {
			String encode = "utf-8";
			String inviteCodeHex = originStringToHexString(inviteCode, encode);
			System.out.println(inviteCodeHex);
			String inviteCodeBack = hexStringToOriginString(inviteCodeHex, encode);
			System.out.println(inviteCodeBack);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String convertTime(String date){
		if(StringUtils.isBlank(date) || date.length()!=8){
			throw new MyException("时间格式错误");
		}
		return date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);

	}
}
