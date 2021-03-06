package com.l2jong.shorten.util;

/**
 * A class to convert numbers to Base62. Default charset: 0..9a..zA..Z Alternate
 * character sets can be specified when constructing the object.
 *
 * @author Andreas Holley
 */
public class Base62 {

	private static String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * Encodes a decimal value to a Base62 <code>String</code>.
	 *
	 * @param b10 the decimal value to encode, must be nonnegative.
	 * @return the number encoded as a Base62 <code>String</code>.
	 */
	public static String encodeBase10(long b10) {
		if (b10 < 0) {
			throw new IllegalArgumentException("b10 must be nonnegative");
		}
		String ret = "";
		while (b10 > 0) {
			ret = characters.charAt((int) (b10 % 62)) + ret;
			b10 /= 62;
		}
		return ret;

	}

	/**
	 * Decodes a Base62 <code>String</code> returning a <code>long</code>.
	 *
	 * @param b62 the Base62 <code>String</code> to decode.
	 * @return the decoded number as a <code>long</code>.
	 * @throws IllegalArgumentException if the given <code>String</code> contains characters not
	 *                                  specified in the constructor.
	 */
	public static long decodeBase62(String b62) {
		for (char character : b62.toCharArray()) {
			if (!characters.contains(String.valueOf(character))) {
				throw new IllegalArgumentException("Invalid character(s) in string: " + character);
			}
		}
		long ret = 0;
		b62 = new StringBuffer(b62).reverse().toString();
		long count = 1;
		for (char character : b62.toCharArray()) {
			ret += characters.indexOf(character) * count;
			count *= 62;
		}
		return ret;
	}
}
