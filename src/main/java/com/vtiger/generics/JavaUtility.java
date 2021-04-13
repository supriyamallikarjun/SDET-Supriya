package com.vtiger.generics;

import java.util.Random;

public class JavaUtility {

	public int randomNumber() {
		Random r = new Random();
		int rnumber = r.nextInt(1000);
		return rnumber;
	}
}
