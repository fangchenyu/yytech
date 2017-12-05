package com.yytech.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @description : 一些公用的工具函数
 * @author：wangxianwei
 * @date : 20170929
 * */
public class XwCommon {

    public static String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
    public static Pattern specialChar = Pattern.compile(regEx);

    /**
     * description: 验证工号
     * param 格式: 第一位为：字母，不分大小写, 后面要有6位以上的数字    如  p101010  A12345678   等
     * param temp:传入参数
     */
    public static boolean checkJobnumb(String jobnumb) {
        String pattern = "^[a-z|A-Z]\\d{6,}";
        Pattern jobnumbCompile = Pattern.compile(pattern);
        Pattern.compile(pattern);
        Matcher m = jobnumbCompile.matcher(jobnumb);
        Matcher specialMatcher = specialChar.matcher(jobnumb);
        if (specialMatcher.find()) {
            return false;
        }
        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * description: 校验密码是不是6位以上
     * param name
     */
    public static boolean checkPassword(String pass) {
        if (null == pass) {
            return false;
        }
        String flag = "[a-zA-Z0-9]{6,}";
        Pattern pattern = Pattern.compile(flag);
        Matcher passMatcher = pattern.matcher(pass);
        Matcher specialMatcher = specialChar.matcher(pass);
        if (specialMatcher.find()) {
            return false;
        }
        if (pass.length() < 6) {
            return false;
        }
        if (!passMatcher.find()) {
            return false;
        }
        return true;
    }

    /**
     * description: 校验姓名是不是汉字
     * param name
     */
    public static boolean checkName(String name) {
        String regName = "^[\\u4e00-\\u9fa5]{2,8}$";
        Pattern nameP = Pattern.compile(regName);
        Matcher m = nameP.matcher(name);
        Matcher specialMatcher = specialChar.matcher(name);
        if (specialMatcher.find()) {
            return false;
        }
        if (!m.find()) {
            return false;
        }
        return true;

    }

    /**
     * description: 将base64转成图片保存到/fileData文件夹下
     * param request
     * param base64
     * param fileName
     */
    public static boolean saveImage(HttpServletRequest request, String base64, String fileName) {

        System.out.println("base64=" + base64);
        // 去掉base64数据头部data:(image/png;base64),和尾部的” " “
        String[] data1 = base64.split(",");
        base64 = data1[1];
        String[] data2 = base64.split("\"");
        base64 = data2[0];
        // 文件上传
        String path = request.getSession().getServletContext().getRealPath("fileData");
        File file = new File(path, fileName);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            byte[] bytes1 = new BASE64Decoder().decodeBuffer(base64);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);
            ImageIO.write(bi1, "png", file);
            // System.out.println("file=" + file.length());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * description: 判断用户输入是否为18位的身份证号
     * param IDStr：
     * 要判断的字符串
     * return true : 是一个18位的身份证号 false : 不是一个18位的身份证号
     */
    public static boolean checkIDCard(String IDStr) {
        Pattern idNumPattern = Pattern.compile("(\\d{17}[0-9a-zA-Z])");
        // 通过Pattern获得Matcher
        Matcher idNumMatcher = idNumPattern.matcher(IDStr);
        // 判断用户输入是否为身份证号
        if (idNumMatcher.matches()) {
            return true;
        }
        return false;
    }


    /**
     * yingyitech 本项目的密码加密方法。
     * <p>
     * param str
     * return
     */
    public static String yytMd5(String password) {
        return XwCommon.md5(XwCommon.md5(password) + "yingyitech");
    }

    /**
     * description: 是不是手机号
     * param
     */
    public static boolean isPhoneNum(String mobile) {
        if (null == mobile) {
            return false;
        }
        Pattern p = Pattern.compile("^1(1|2|3|4|5|6|7|8|9)\\d{9}$");
        Matcher matcherP = p.matcher(mobile);
        if (matcherP.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 是不是部分手机号
     * <p>
     * description:
     * param
     */
    public static boolean isPartOfPhoneNum(String mobile) {
        Pattern p = Pattern.compile("\\d{1,11}$");
        Matcher matcherP = p.matcher(mobile);
        if (matcherP.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 邮箱是否合法
     * <p>
     * param email
     * return
     */
    public static boolean isEmail(String email) {
        Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$");
        Matcher matcherP = p.matcher(email);
        if (matcherP.matches()) {
            return true;
        }
        return false;
    }

    /**
     * description: 得到有后缀名的文件名
     * param fileName：
     * 文件名 defaultExt： 默认的后缀名都不带点
     * return 有后缀名的文件名
     */
    public static String getFileWithExt(String fileName, String defaultExt) {
        String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (prefix.equals(fileName) && defaultExt != null && defaultExt.length() > 0) {
            prefix = defaultExt;
            return fileName + "." + defaultExt;
        }
        return fileName;
    }

    /**
     * description: 用来替换system.out.println
     */
    public static int isDebug = 2;

    public static void println(String str) {
        if (isDebug == 2) {
            isDebug = 0;
            String fileName = "/opt/tomcat/logs/debug.txt";
            File f = new File(fileName);
            if (f.exists()) {
                isDebug = 1;
            }
        }
        if (isDebug == 1) {
            LogXw("/opt/tomcat/logs/logXw.txt", str);
        }
        System.out.println(str);
    }


    public static void LogXw(String fileName, String str) {
        try {
            File f = new File(fileName);
            if (true == f.exists() && f.length() > 5024000) {
                f.delete();
            }
            if (false == f.exists()) {
                f.createNewFile();
            }
            FileOutputStream outStream = new FileOutputStream(fileName, true);
            outStream.write(str.getBytes("UTF-8"));
            outStream.write("\r\n".getBytes("UTF-8"));
            outStream.flush();
            outStream.close();
        } catch (Exception e) {
            ;
        }//加载本地的证书进行https加密传输
    }


    /**
     * description: 字符串转long,如果发生错误,就返回0;
     */
    public static long parseLong(String str) {
        if ((str == null) || (str.length() < 1)) {
            return 0;
        }
        str = getSubStringForInteger(str);
        if ((str == null) || (str.length() < 1)) {
            return 0;
        }
        boolean bOk = false;
        long v = 0;
        try {
            v = Long.parseLong(str);
            bOk = true;
        } catch (Exception e) {
            ;
        } finally {
            ;
        }
        if (bOk == true) {
            return v;
        }
        return 0;
    }

    /**
     * description: 字符串转int,如果发生错误,就返回0;
     */
    public static int parseInt(String str) {
        if ((str == null) || (str.length() < 1)) {
            return 0;
        }
        str = getSubStringForInteger(str);
        if ((str == null) || (str.length() < 1)) {
            return 0;
        }
        boolean bOk = false;
        int v = 0;
        try {
            v = Integer.parseInt(str);
            bOk = true;
        } catch (Exception e) {
            ;
        } finally {
            ;
        }
        if (bOk == true) {
            return v;
        }
        return 0;
    }

    /**
     * description: 字符串转float,如果发生错误,就返回0;
     */
    public static float parseFloat(String str) {
        if ((str == null) || (str.length() < 1)) {
            return 0F;
        }
        boolean bOk = false;
        float v = 0F;
        try {
            v = Float.parseFloat(str);
            bOk = true;
        } catch (Exception e) {
            ;
        } finally {
            ;
        }
        if (bOk == true) {
            return v;
        }
        return 0F;
    }

    /**
     * description: 随机字符串
     * param length
     * 表示生成字符串的长度;
     */
    public static String getRandomNum(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * description: 随机字符串
     * param length
     * 表示生成字符串的长度; baseString 表示字符串中只包含这些字符
     */
    public static String getRandomString(int length, String baseString) {
        String base = baseString;
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * description: 以字符串中的数字字符，遇到一个非数字的字符就结束
     * param
     */
    public static String getSubStringForInteger(String str) {
        int i = str.length();
        int len = i;
        for (int j = 0; j < i; j++) {
            if (str.charAt(j) != '0' && str.charAt(j) != '1' && str.charAt(j) != '2' && str.charAt(j) != '3'
                    && str.charAt(j) != '4' && str.charAt(j) != '5' && str.charAt(j) != '6' && str.charAt(j) != '7'
                    && str.charAt(j) != '8' && str.charAt(j) != '9') {
                len = j;
                break;
            }
        }
        return xwSubStr(str, 0, len);
    }

    /**
     * description: sStr是不是在sArr表示的字符串数组中
     * param sArr
     * 是 "str1,str2,str3" 或"str1_str2_str3" 这样的字符串
     */
    public static boolean isInArr(String sArr, String sStr) {
        if ((sArr == null) || (sArr.length() < 1)) {
            return false;
        }

        sArr = sArr.replace("_", ",");
        sArr = sArr.replace("，", ",");
        String[] mobiList = sArr.split(",");
        for (int idx = 0; idx < mobiList.length; idx++) {
            if (true == sStr.equals(mobiList[idx])) {
                return true;
            }
        }

        return false;
    }

    /**
     * falsedescription: 随机产生num个，总数为total的 数字
     * param iMax
     * 产生的num个数字中，最大的数值不能超过iMax
     */
    public static String amountRandGen(long total, int num, int iMax) {
        String rst = "";
        int i = 0;
        int iNow = 0;
        if (num < 2) { // 如果少于1
            return "" + ((total > iMax) ? iMax : total);
        }

        // total太大
        if (total >= iMax * num) {
            for (i = 0; i < num; i++) {
                if (rst.length() > 0) {
                    rst += ",";
                }
                rst += iMax;
            }
            return rst;
        }

        // total太小
        iNow = 0;
        if (total <= num) {
            for (i = 0; i < num; i++) {
                if (rst.length() > 0) {
                    rst += ",";
                }
                if (iNow < total) {
                    rst += "1";
                    iNow += 1;
                } else {
                    rst += "0";
                }
            }
            return rst;
        }

        int fRand = 0;
        int itotal = 0;
        int[] iarr = new int[num];
        for (i = 0; i < num * 5; i++) {
            fRand = (int) ((Math.random() * 50 + 50) % 100);
            iarr[i % num] += fRand;
            itotal += fRand;
        }

        float avr = (float) (total * 1.0 / itotal);
        float fMax = iMax / avr;
        int dlt = 0;
        for (i = 0; i < num * 5; i++) {
            if (dlt > 0) {
                iarr[i % num] += dlt;
                dlt = 0;
            }
            if (iarr[i % num] > fMax) {
                dlt = iarr[i % num] - (int) fMax;
                iarr[i % num] -= dlt;
            }
        }

        int itotal2 = 0;
        for (i = 0; i < num; i++) {
            iarr[i] = Math.min(iMax, (int) (iarr[i] * avr));
            itotal2 += iarr[i];
        }
        if (itotal2 < total) {
            int fnum = 0;
            for (i = 0; i < num; i++) {
                if (iarr[i] < iMax) {
                    iarr[i]++;
                    fnum++;
                    if (itotal2 + fnum >= total) {
                        break;
                    }
                }
            }
            itotal2 += fnum;
        }

        // 正常情况
        for (i = 0; i < num; i++) {
            if (rst.length() > 0) {
                rst += ",";
            }
            rst += iarr[i];
        }

        return rst;
    }

    public static String JSONStringify(Object obj) {
        Gson json = new Gson();
        return json.toJson(obj);
    }

    public static JsonObject JSONparse(String str) {
        JsonParser jParser = new JsonParser();
        JsonObject jsonObj = null;
        boolean bOk = false;
        try {
            jsonObj = jParser.parse(str).getAsJsonObject();
            bOk = true;
        } catch (Exception e) {
            ;
        } finally {
            ;
        }
        if (bOk == true) {
            return jsonObj;
        }
        return null;
    }

    public static String xwSubStr(String str, int istart, int length) {
        if (str == null) {
            return "";
        }
        int len = str.length();
        int iend = 0;
        if (len < 1) {
            return "";
        }
        if (length < 1) {
            return "";
        }
        if (istart > len - 1) {
            return "";
        }
        if (istart < 1) {
            istart = 0;
        }
        iend = istart + length;
        if (iend > len) {
            iend = len;
        }
        str = str.substring(istart, iend);
        return str;
    }

    public static List<Map.Entry<String, Object>> xwSortMapByKey(Map<String, Object> map) {
        List<Map.Entry<String, Object>> list = new ArrayList<Map.Entry<String, Object>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Object>>() {
            // 升序排序
            public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
                int rst = o1.getKey().compareTo(o2.getKey());
                // XwCommon.println(o1.getKey() + "" + o1.getValue() + " => " + o2.getKey() + ""
                // + o2.getValue() + " = "+ rst);
                return rst;
            }
        });
        return list;
    }

    public static String md5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            XwCommon.println(e.toString());
            return "";
        }

        byte[] byteArray;
        try {
            byteArray = inStr.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 连接方法 类似于javascript
     * <p>
     * param join
     * 连接字符串
     * param strAry
     * 需要连接的集合
     * return
     */
    public static String implode(String separator, String[] strArray) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0, len = strArray.length; i < len; i++) {
            if (i == (len - 1)) {
                sb.append(strArray[i]);
            } else {
                sb.append(strArray[i]).append(separator);
            }
        }
        return sb.toString();
    }

    public static String implode(String separator, List<String> strList) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0, len = strList.size(); i < len; i++) {
            if (i == (len - 1)) {
                sb.append(strList.get(i));
            } else {
                sb.append(strList.get(i)).append(separator);
            }
        }
        return sb.toString();
    }

    public static String newSessionId() {
        String sId = UUID.randomUUID().toString().replaceAll("-", "");
        sId += XwCalender.nowShortTs();
        return sId;
    }

    // 判断是否是数字
    public static boolean isNumeric(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }


}