package com.ryx.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.io.InputStream;
import java.security.MessageDigest;

public class MD5Util
{
    private static String salt = "";
    private static char[] hexChar = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f' };

    private static String byteToArrayString(byte bByte)
    {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;

        return new String(new char[] { hexChar[iD1], hexChar[iD2] });
    }

    private static String byteToNum(byte bByte)
    {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    private static String byteToString(byte[] bByte)
    {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String getFileHash(InputStream fis)
            throws Exception
    {
        String str = "";
        str = getHash(fis, "MD5");
        return str;
    }

    public static MessageDigest getMessageDigest()
            throws Exception
    {
        return MessageDigest.getInstance("MD5");
    }

    private static String getHash(InputStream fis, String hashType)
            throws Exception
    {
        byte[] buffer = new byte['?'];
        MessageDigest md5 = MessageDigest.getInstance(hashType);
        for (int numRead = 0; (numRead = fis.read(buffer)) > 0;) {
            md5.update(buffer, 0, numRead);
        }
        if (fis.markSupported()) {
            fis.reset();
        }
        return toHexString(md5.digest());
    }

    public static String toHexString(byte[] b)
    {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++)
        {
            sb.append(hexChar[((b[i] & 0xF0) >>> 4)]);
            sb.append(hexChar[(b[i] & 0xF)]);
        }
        return sb.toString();
    }
    public  static  String getPassWordSecret(String password, String salt){
        String hashAlgorithmName = "MD5";
        int hashIterations = 1024;
        Object obj = new SimpleHash(hashAlgorithmName, password, ByteSource.Util.bytes(salt), hashIterations);
        return obj.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(MD5Util.getPassWordSecret("12345","141"));
    }
}
