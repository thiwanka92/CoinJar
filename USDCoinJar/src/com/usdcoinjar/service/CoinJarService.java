package com.usdcoinjar.service;

public interface CoinJarService {
	public void depositCoin(int coin);
	public double getJarBalance();
	public void resetJar();
	public double getJarVolume();
	public boolean coinValidate(int coin);
}
