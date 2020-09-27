
import java.net.*;
import java.util.*;
import java.io.*;

public class Class {	
	public static void main(String[] args) {
		Socket soc = null;
		int port = 2013;
		try {
			soc = new Socket("192.168.1.2",port);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(input);
		
		try {
			InputStreamReader inn = new InputStreamReader(soc.getInputStream());
			BufferedReader in = new BufferedReader(inn);
			
			BufferedOutputStream outt = new BufferedOutputStream(soc.getOutputStream());
			PrintStream out = new PrintStream(outt);
			
			System.out.println("Nom livre : ");
			out.println(bf.readLine());
			out.flush();
			String str = in.readLine();
			System.out.println(str);
			soc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
