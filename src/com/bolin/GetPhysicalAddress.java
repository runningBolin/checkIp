package com.bolin;

import java.util.ArrayList;

/**
 * @author bolin
 * @create 2017年4月20日
 *
 */
public class GetPhysicalAddress {
	
	private static final int PHYSICALLENGTH = 16;
	
	private static ArrayList<String> result;
	

	/**
	 * @author bolin
	 * @create 2017年4月20日
	 * 
	 * @return
	 */
	public static String getPhysicalAddress() {
		String findChinese = "物理地址. . . . . . . . . . . . . :";
		String findEnglish = "Physical Address. . . . . . . . . :";
		if("not find".equals(parseCmd(getIpconfigResult(), findChinese))){
			return parseCmd(getIpconfigResult(), findEnglish);
		}
		
		return parseCmd(getIpconfigResult(), findChinese);
	}

	/**
	 * @author bolin
	 * @create 2017年4月20日
	 * 
	 * @return
	 */
	public static String getIPAddress() {
		String findWin7IpAddr = "IPv4 地址 . . . . . . . . . . . . :";
		String findXPIpAddr = "IP Address. . . . . . . . . . . . :";
		if("not find".equals(parseCmd(getIpconfigResult(), findWin7IpAddr))){
			return parseCmd(getIpconfigResult(), findXPIpAddr);
		}
		
		return parseCmd(getIpconfigResult(), findWin7IpAddr);
	}

	/**
	 * @author bolin
	 * @create 2017年4月20日
	 * 
	 * @return
	 */
	private static String getIpconfigResult() {
		UtilSysCmd shell = new UtilSysCmd();
		String cmd = "cmd.exe /c ipconfig /all";
		result = shell.execute(cmd);
		return result.toString();
	}
	
	/**
	 * @author bolin
	 * @create 2017年4月20日
	 * 
	 * @param ipconfigResult
	 * @param findXPIpAddr
	 * @return
	 */
	private static String parseCmd(String s, String key) {
		int findIndex = s.indexOf(key);
		if(findIndex == -1){
			return "not find";
		}else{
			return s.substring(findIndex + key.length() +1, findIndex + key.length() + 3 + PHYSICALLENGTH);
		}
	}
}
