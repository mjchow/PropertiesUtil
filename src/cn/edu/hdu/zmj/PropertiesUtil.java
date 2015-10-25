package cn.edu.hdu.zmj;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static Properties getResources(String filename) {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
	
	public static void main(String[] args) throws IOException {
		Properties prop = getResources("email.properties");
		String account = prop.getProperty("mail.account");
		System.out.println(account);
	}
}
