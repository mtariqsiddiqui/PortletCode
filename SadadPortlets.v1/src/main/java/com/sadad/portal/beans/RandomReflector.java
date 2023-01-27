/**
 * 
 */
package com.sadad.portal.beans;

import java.util.Random;

/**
 * @author Tariq Siddiqui
 * 
 */
public class RandomReflector
{

	public int reflectRamdomlyInteger()
	{
		return new Random().nextInt(999999999);
	}

	public byte[] reflectRamdomlyBytes()
	{
		byte[] b = new byte[20];
		new Random().nextBytes(b);
		return b;
	}

	public short reflectRandomlyShort()
	{
		return (short) new Random().nextInt(Short.MAX_VALUE + 1);
	}

	public long reflectRandomlyLong()
	{
		return new Random().nextLong();
	}

	public float reflectRandomlyFloat()
	{
		return new Random().nextFloat();
	}

	public char reflectRandomlyCharacter()
	{
		String charRange = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		return charRange.charAt(new Random().nextInt(charRange.length()));
	}

	public double reflectRandomlyDouble()
	{
		return new Random().nextDouble();
	}

	public boolean reflectRandomlyBoolean()
	{
		return new Random().nextBoolean();
	}
	
	public String reflectRandomlyString()
	{
		int leftLimit = 65; // letter 'a'
		int rightLimit = 90; // letter 'z'
		int targetStringLength = 12;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++)
		{
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		return buffer.toString();
	}
}
