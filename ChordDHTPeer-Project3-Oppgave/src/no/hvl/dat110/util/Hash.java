package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import no.hvl.dat110.middleware.Message;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) {		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		// we use MD5 with 128 bits digest
		// compute the hash of the input 'entity'
		// convert the hash into hex format
		// convert the hex into BigInteger
		// return the BigInteger
		//TASK IS DONE!!!
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(entity.getBytes());
			byte[] digest = md.digest();
			String hexformat = toHex(digest);
			hashint = new BigInteger(hexformat, 16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashint;
	}
	
	public static BigInteger addressSize() {

		// Compute the address size of MD5

		int digestLength = 0;
		try {
			 digestLength = MessageDigest.getInstance("MD5").getDigestLength(); // gets the digest length

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		// compute the address size = 2 ^ number of bi
		BigInteger StorInteger = new BigInteger("2");
		int BigBits = digestLength * 8; // compute the number of bits = digest length * 8

		// return the address size
		return StorInteger.pow(BigBits);
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		// find the digest length
		try {
			digestlen = MessageDigest.getInstance("MD5").getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
