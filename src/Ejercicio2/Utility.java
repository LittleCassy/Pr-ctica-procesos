package Ejercicio2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utility {

	public static void main(String[] args) {
		if(args.length==1) {
			CheckUsername(args[0]);
		}else {
			CompareFiles(args[0], args[1]);
		}
	}

	public static void CheckUsername(String testUser) {
		try {
			Process p = Runtime.getRuntime().exec("net user "+testUser);
			ReadConsole(p);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static void CompareFiles(String f1, String f2) {
		Process p;
		try {
			p = Runtime.getRuntime().exec("fc " + f1 + " " + f2);
			ReadConsole(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ReadConsole(Process p) throws Exception {
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

		String s = null;
		while ((s = stdInput.readLine()) != null) {
		    System.out.println(s);
		}

		while ((s = stdError.readLine()) != null) {
			System.out.println(s);
			throw new Exception(java.time.LocalDateTime.now() + "//// Oh, I'm sorry. Something went horribly wrong./// \n" + s);
		}
	}
}