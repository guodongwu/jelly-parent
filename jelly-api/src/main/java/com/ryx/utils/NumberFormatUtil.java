package com.ryx.utils;

import java.math.BigDecimal;
import java.util.Random;

public class NumberFormatUtil {
	public static String keepTwoDecimalPlacesRoundUp(String number) {
		 BigDecimal bg = new BigDecimal(number).setScale(2, BigDecimal.ROUND_DOWN);
		 return bg.toString();
	}
	
    public static int getCheckCode(){
    	Random random=new Random();
    	return random.nextInt(899999)+100000;
    }
    
    public static String formatBalanceAppendUnit(BigDecimal jfProfitBigDecimal) {
		String result = null;
//		BigDecimal jfProfitBigDecimal = new BigDecimal(jfProfit);
		if (jfProfitBigDecimal.compareTo(new BigDecimal("1000000")) < 0) {
			result = NumberFormatUtil.keepTwoDecimalPlacesRoundUp(jfProfitBigDecimal.toPlainString()) + " 元";
		} else if (jfProfitBigDecimal.compareTo(new BigDecimal("1000000")) >= 0
				&& jfProfitBigDecimal.compareTo(new BigDecimal("10000000000")) < 0) {
			result = NumberFormatUtil.keepTwoDecimalPlacesRoundUp(jfProfitBigDecimal.divide(
							new BigDecimal("10000")).toString()) + " 万元";
		} else if (jfProfitBigDecimal.compareTo(new BigDecimal("10000000000")) >= 0) {
			result = NumberFormatUtil.keepTwoDecimalPlacesRoundUp(jfProfitBigDecimal.divide(
							new BigDecimal("100000000")).toString()) + " 亿元";
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(keepTwoDecimalPlacesRoundUp("12345.6789"));
		System.out.println(keepTwoDecimalPlacesRoundUp("1.2345"));
		BigDecimal bigDecimal=new BigDecimal(3.9093);
		System.out.println(keepTwoDecimalPlacesRoundUp(bigDecimal.toString()));
	}
}
