package com.usdcoinjar.enumeration;

import java.util.Arrays;

public enum USDCoinEnum {
	USD_1(1,1),
	USD_5(5,5.7),
	USD_10(10,15),
	USD_25(25,21);
	
	private int coin;
	private double volume;
	
	private USDCoinEnum(int coin, double volume) {
		this.coin = coin;
		this.volume = volume;
	}
	public int getCoin() {
		return coin;
	}
	public double getVolume() {
		return volume;
	}
	
	public static double getVolumeByCoin(int coin) {
		return USDCoinEnum.valueOf("USD_"+coin).getVolume();
	}
	
	public static void printAllCoin() {
		Arrays.asList(USDCoinEnum.values())
			.stream()
			.forEach((i) -> { 
				System.out.print("$"+i.getCoin()+" ");
			});
	}
}
