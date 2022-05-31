package test.pkg;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass {

	public static final boolean isLinux = File.separatorChar == '/';
	public static void main(String[] args) throws Exception {
		System.out.println("MainClass run");
		
		/*Process p;
		if(isLinux) {
			p = Runtime.getRuntime().exec("ll");
		}
		else {
			p = Runtime.getRuntime().exec("notepad");
		}*/
		
		
		ProcessBuilder builder = new ProcessBuilder();
		if(isLinux) {
			//builder.command("sh", "-c", "ls -ltrh");
			//builder.command("sh", "-c", "cat /root/filepath/app_server_checks_270522_1600.txt");
			//builder.command("sh", "-c", "cat /root/filepath/app_server_checks_270522_1600.txt");
		
			//cat /root/db_checks_files/db_server_checks_300522_1000.txt
			builder.command("sh", "-c", "cat /root/filepath/db_server_checks_300522_1600.txt");
			//builder.command("sh", "-c", "cat /root/app_checks_files/app_server_checks_300522_1500.txt");
			//builder.command("sh", "-c", "cat /root/filepath/app_server_checks_300522_1700.txt");
			//cat /root/app_checks_files/app_server_checks_300522_1500.txt
			//cat /root/filepath/web_server_checks_300522_1500.txt
		}
		else {
			builder.command("cmd.exe", "/c", "dir d:\\mdms");
		}
		Process p = builder.start();
		InputStream in = p.getInputStream();
		
		StringBuilder sb = new StringBuilder();
		int n;
		char[]chars=new char[1024];
		InputStreamReader rdr = new InputStreamReader(in);
		while((n = rdr.read(chars)) != -1) {
			sb.append(chars, 0, n);
		}
		System.out.println(sb);
		//SendMDMSEMail snd=new SendMDMSEMail();
		SendMDMSEMail.MailDetail(sb);
		
		Thread.sleep(1000);
	}

}
