package com.shareyi.jshow.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;


/**
 * 数据处理工具类
 * @author zhangshibin
 * @since 2014-11-13
 */
public class KaStringUtils {

	/**
	 * 是否自营实物商品,6-7位 sku
	 * @param skuIds
	 * @return
	 */
	public static boolean isSelfMaterialWare(String skuId){
		if(StringUtils.isEmpty(skuId)){
			return false;
		}
		return skuId.length()<8;
	}
	
	public static boolean isSelfMaterialWare(Long skuId) {
		if(skuId==null){
			return false;
		}
		return skuId<1e8;
	}
	/**
	 * 检查数据格式是否正确
	 * @param skuIds
	 * @return
	 */
	public static boolean isSkuIds(String skuIds){
		Pattern pattern = Pattern.compile("^[\\d\\,]+");
		Matcher matcher = pattern.matcher(skuIds);
		return matcher.matches();
	}
	
	
	
	/**
	 * skuId数据转换,需要去重复
	 * @param skuIds
	 * @return
	 */
	public static List<Long> skuIdStrToList(String skuIds){
		String[] skuIdArr=skuIds.split(",");
		Set<Long> skuIdSet=new HashSet<Long>(skuIdArr.length);
		for (String str : skuIdArr) {
			if(StringUtils.isNotBlank(str)){
				skuIdSet.add(Long.valueOf(str));
			}
		}
		return new ArrayList<Long>(skuIdSet);
	}
	
	
	/**
	 * skuId数据转换,内部操作，已经去重复，数据格式严谨
	 * @param skuIds
	 * @return
	 */
	public static List<String> skuIdStrToListStr(String skuIds) {
		String[] skuIdArr=skuIds.split(",");
		ArrayList<String> list=new ArrayList<String>(skuIdArr.length);
		for (String str : skuIdArr) {
			if(StringUtils.isNotBlank(str)){
				list.add(str);
			}
		}
		return list;
	}
	
	
	
	/**
	 * skuId数据转换,需要去重复
	 * @param
	 * @return
	 */
	public static String joinCollection(Collection collection,String seperator){
		if(CollectionUtils.isEmpty(collection)){
			return "";
		}
		StringBuilder sb=new StringBuilder();
		for (Object object : collection) {
			sb.append(object).append(seperator);
		}
		sb.delete(sb.length()-seperator.length(), sb.length());
		return sb.toString();
	}

    /**
     * 过滤非法字符
     * @return
     */
    public static String filterStr(String str){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        String regEx = "[~!@#_%^&*()\\-|//[//]<>《》/～！＠＃￥％＆＊（）——|\\【】|a-z|A-Z|0-9|\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String line="";
        while(m.find()){
            line=line+m.group();
        }
        return line;
    }

    public static String stringNumFilter(String str) {
        try {
            if(StringUtils.isEmpty(str)){
                return null;
            }
            String regEx = "[0-9.]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            String line = "";
            while (m.find()) {
                line = line + m.group();
            }
            if (line.indexOf(".") != -1) {
                line = line.substring(0, line.indexOf("."));
            }
            return line;
        } catch (Exception e) {
            return null;
        }
    }


	
	
	public static void main(String[] args) {
		System.out.println(isSkuIds("238834,,,,,,,,,,"));
		System.out.println(isSkuIds("238834,238993,"));
		System.out.println(isSkuIds("238834ds"));
		System.out.println(isSkuIds("238834,dse"));

	}


	
	/**
	 * 将long的数据转换为String
	 * @param idList
	 * @return
	 */
	public static List<String> long2StringCollection(List<Long> idList) {
		List<String> strList=new ArrayList<String>(idList.size());
		for (Long l: idList) {
			strList.add(String.valueOf(l));
		}
		return strList;
	}


	/**
	 * 将long的数据转换为String
	 * @param idList
	 * @return
	 */
	public static List<Long> string2LongCollection(List<String> strList) {
		List<Long> longList=new ArrayList<Long>(strList.size());
		for (String str: strList) {
			longList.add(Long.valueOf(str));
		}
		return longList;
	}





}
