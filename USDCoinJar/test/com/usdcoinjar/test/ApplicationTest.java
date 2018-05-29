package com.usdcoinjar.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import com.usdcoinjar.service.impl.USDCoinJarServiceImpl;

public class ApplicationTest {
	private USDCoinJarServiceImpl USDimpl = new USDCoinJarServiceImpl();
	
	@Test
	public void depositCoinTest() {
		int beforeCoinBal = (int) USDimpl.getJarBalance();
		USDimpl.depositCoin(5); //coin 5 volume is 5.7
		assertEquals(beforeCoinBal, (int)USDimpl.getJarBalance()-5);
	}
	
	@Test
	public void depositInvalidCoinTest() {
		int beforeCoinBal = (int) USDimpl.getJarBalance();
		USDimpl.depositCoin(7);
		assertEquals(beforeCoinBal, (int)USDimpl.getJarBalance());
	}
	
	@Test
	public void jarBalanceTest() {
		int beforeCoinBal = (int) USDimpl.getJarBalance();
		USDimpl.depositCoin(10);
		assertEquals((beforeCoinBal+10), (int)USDimpl.getJarBalance());
	}
	
	@Test
	public void jarVolumeTest() {
		double beforeCoinVolume = (double) USDimpl.getJarVolume();
		USDimpl.depositCoin(5); // 5 coin volume is 5.7
		assertEquals(new Double(beforeCoinVolume+5.7), new Double(USDimpl.getJarVolume()));
	}
	
	@Test
	public void jarResetTest() {
		USDimpl.depositCoin(5);
		USDimpl.resetJar();
		assertEquals(0, (int) USDimpl.getJarBalance());
		assertEquals(0, (int) USDimpl.getJarVolume());
	}
	
	@Test
	public void jarVolumeFullTest() {
		USDimpl.depositCoin(5); //volume = 5.7
		USDimpl.depositCoin(5); //volume = 5.7s
		USDimpl.depositCoin(25); //volume = 21
		//now total volume is 32.4
		assertEquals(10, (int) USDimpl.getJarBalance());
		assertNotEquals(35, (int) USDimpl.getJarBalance());
		assertNotEquals(new Double(32.4), new Double(USDimpl.getJarVolume()));
	}
	
	@Test
	public void coinValidateTest() {
		assertEquals(true, USDimpl.coinValidate(5));
		assertEquals(false, USDimpl.coinValidate(9));
	}
	
}
