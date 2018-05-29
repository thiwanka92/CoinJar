package com.usdcoinjar.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.usdcoinjar.service.ScreenPrinterService;

public class ScreenPrinterServiceImpl implements ScreenPrinterService {
	
	private Map<Integer, String> defaultMap;
	private String startResultMsg;
	private String endResultMsg;
	private String confirmMsg;
	private String warningDataLostMsg;
	private String quitMsg;
	
	public ScreenPrinterServiceImpl() {
		super();
	}
	//default option menu and messages
	public ScreenPrinterServiceImpl(boolean isDefaultValues) {
		if(isDefaultValues) {
			defaultMap = new HashMap<>();
			defaultMap.put(1, "Add Coin");
			defaultMap.put(2, "Check Balance");
			defaultMap.put(3, "Reset Jar");
			
			this.startResultMsg 	= "\n************ RESULT ***************";
			this.endResultMsg 		= "************* END *****************";
			this.confirmMsg 	= "Are you sure want to continue ? (y/n) : ";
			this.warningDataLostMsg = "Warning : Please note Jar will reset all values to 0";
			this.quitMsg 		= "Bye.! -- Seesion closed --";
		}
	}
	public String getStartResultMsg() {
		return startResultMsg;
	}
	public void setStartResultMsg(String startResultMsg) {
		this.startResultMsg = startResultMsg;
	}
	public String getEndResultMsg() {
		return endResultMsg;
	}
	public ScreenPrinterServiceImpl(String endResultMsg) {
		this.endResultMsg = endResultMsg;
	}
	public String getConfirmMsg() {
		return confirmMsg;
	}
	public void setConfirmMsg(String confirmMsg) {
		this.confirmMsg = confirmMsg;
	}
	public String getWarningDataLostMsg() {
		return warningDataLostMsg;
	}
	public void setWarningDataLostMsg(String warningDataLostMsg) {
		this.warningDataLostMsg = warningDataLostMsg;
	}
	public Map<Integer, String> getDefaultMap() {
		return defaultMap;
	}
	
	public void setDefaultMap(Map<Integer, String> defaultMap) {
		this.defaultMap = defaultMap;
	}
	public String getQuitMsg() {
		return quitMsg;
	}
	public void setQuitMsg(String quitMsg) {
		this.quitMsg = quitMsg;
	}
	
	public void printOptionMenu(Map<Integer, String> optionMap) {
		if(optionMap !=null && optionMap.size()>0) {
			optionMap.forEach((k,v)->System.out.println(k+". "+v));
			System.out.println("99. Quit");
			System.out.print("Your choice : ");
		}else {
			System.err.println("Option menu is empty.");
			System.exit(0);
		}
	}
}
