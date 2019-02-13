package com.weekly.utils;

import java.util.Random;

public class RandomUID {
	private static Random random = new Random();
	public static String getRandomNumber(int digCount) {
	    StringBuilder sb = new StringBuilder(digCount);
	    for(int i=0; i < digCount; i++)
	        sb.append((char)('0' + random.nextInt(10)));
	    return sb.toString();
	}
}
