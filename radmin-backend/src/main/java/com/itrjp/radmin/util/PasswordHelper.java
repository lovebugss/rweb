package com.itrjp.radmin.util;


import com.itrjp.radmin.bean.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;



/*
 *
 * @Author renjp
 * @Date 2018/11/19 17:22
 * @Version 1.0
 **/
public class PasswordHelper {
	//private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private static String algorithmName = "md5";
	private static int hashIterations = 2;

	public static void encryptPassword(User user) {
		//String salt=randomNumberGenerator.nextBytes().toHex();
		String newPassword = new SimpleHash(algorithmName, user.getPassword(),  ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
		//String newPassword = new SimpleHash(algorithmName, user.getPassword()).toHex();
		user.setPassword(newPassword);

	}
	public static void main(String[] args) {
		PasswordHelper passwordHelper = new PasswordHelper();
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		user.setSalt("123456");
		passwordHelper.encryptPassword(user);
		System.out.println(user);
	}
}
