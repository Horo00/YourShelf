package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public static String getHash(String password) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		byte[] digest = md.digest(password.getBytes());
		StringBuilder builder = new StringBuilder();

		for(int i = 0;i < digest.length;i++) {
			String tmp = Integer.toHexString(digest[i] & 0xff);
			if(tmp.length() == 1) {
				builder.append('0');
			}
			builder.append(tmp);
		}
		return builder.toString();
	}
}
