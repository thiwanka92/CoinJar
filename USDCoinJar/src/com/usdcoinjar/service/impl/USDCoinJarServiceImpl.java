package com.usdcoinjar.service.impl;

import java.util.Arrays;

import com.usdcoinjar.enumeration.USDCoinEnum;
import com.usdcoinjar.service.CoinJarService;

public class USDCoinJarServiceImpl implements CoinJarService{
	ScreenPrinterServiceImpl printerServiceImpl =new ScreenPrinterServiceImpl(true);
	static int jarTotal;
	static double jarVolumeTotal;
	static double maxJarVolume = 32;
	
	@Override
	public void depositCoin(int coin) {
		System.out.println(printerServiceImpl.getStartResultMsg());
		if(coinValidate(coin) && coin!=0) {
			if(!isJarFull(coin)) {
				jarTotal += coin;
				jarVolumeTotal += USDCoinEnum.getVolumeByCoin(coin);
				System.out.println("$" + coin + " coin has been added.");
			}else {
				System.out.println("Jar is full..!");
			}
		}else {
			System.out.println("Invalid Coin Value - Support USD Coins Only");
			USDCoinEnum.printAllCoin();
		}
		System.out.println("\n"+printerServiceImpl.getEndResultMsg());
	}
	
	public void printJarBalance() {
		System.out.println(printerServiceImpl.getStartResultMsg());
	  	System.out.println("Your coin balance: $" + getJarBalance() + " AND used volume: "+ getJarVolume());
	  	System.out.println(printerServiceImpl.getEndResultMsg());
	}

	@Override
	public double getJarBalance() {
		return jarTotal;
	}

	@Override
	public void resetJar() {
		System.out.println(printerServiceImpl.getStartResultMsg());
		jarTotal = 0;
		jarVolumeTotal = 0;
    	System.out.println("Jar Reset Completed");
    	System.out.println("Your coin balance: $" + getJarBalance() + " AND used volume: "+getJarVolume());
    	System.out.println(printerServiceImpl.getEndResultMsg());
	}

	@Override
	public double getJarVolume() {
		return jarVolumeTotal;
	}
	
	private boolean isJarFull(int coin){
		return ((jarVolumeTotal + USDCoinEnum.getVolumeByCoin(coin)) >= maxJarVolume)?true:false;
	}

	@Override
	public boolean coinValidate(int coin) {
		return Arrays.asList(USDCoinEnum.values())
					.stream().anyMatch(c -> c.getCoin()==coin);
	}
}
