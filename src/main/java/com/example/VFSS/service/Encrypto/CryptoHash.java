package com.example.VFSS.service.Encrypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoHash {
	
	public static String encryptoHash(String text) {
	  // ハッシュ化
    MessageDigest digest;
	
		try {
			digest = MessageDigest.getInstance("SHA-256");
			digest.update(text.getBytes());
			
			byte [] b = digest.digest();
		
			StringBuilder sb = new StringBuilder();
			for(int i= 0; i < b.length; i++) {
				String tmpHex = Integer.toHexString(b[i]);
				if(tmpHex.length() == 1){
		            // 値が一桁だった場合、先頭に0を追加し、バッファに追加
		            sb.append('0').append(tmpHex);
		        } else {
		            // その他の場合、バッファに追加
		            sb.append(tmpHex);
		        }
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
			return "";
	}
}
