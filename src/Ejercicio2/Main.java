package Ejercicio2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<String> myParameters;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Init();
	}

	private static void Init() {
		System.out.println("////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("////");
		System.out.println("//// This program works by using one or two parameters. Here's the guide:");
		System.out.println("////");
		System.out.println("//// 1 parameter -> We'll check if that exists as a username in the PC");
		System.out.println("////");
		System.out.println("//// 2 parameters -> We'll compare both routes (Making sure they are files)");
		System.out.println("////                 and compare them.");
		System.out.println("////");
		System.out.println("////////////////////////////////////////////////////////////////////////////////////");
		myParameters = myParams();
		Launch();
	}

	private static void Launch() {
		try {
			String home = System.getProperty("java.home");
			String bin = home + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			
			ProcessBuilder pb;
			
			if(myParameters.size()==1) {
				pb = new ProcessBuilder(bin, "-cp", classpath, "Ejercicio2.Utility", myParameters.get(0));
			}else {
				pb = new ProcessBuilder(bin, "-cp", classpath, "Ejercicio2.Utility", myParameters.get(0), myParameters.get(1));
			}
			
			pb.inheritIO();
			Process myProc = pb.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Oh-Oh " + e);
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> myParams(){
		ArrayList<String> aux = new ArrayList<>();
		try {
			System.out.println("////////////////////////////////////////////////////////////////////////////////////");
			System.out.println("////");
			System.out.println("//// Enter the first parameter (Username or first of two files)");
			System.out.println("////");
			System.out.println("////////////////////////////////////////////////////////////////////////////////////");
			Scanner sc = new Scanner(System.in);
			String auxStr = sc.nextLine();
			aux.add(auxStr);
		}catch (Exception e) {
			System.err.println("Oh oh: "+e);
		}
		
		boolean redLight = true;
		boolean second=false;
		while (redLight) {
			System.out.println("////////////////////////////////////////////////////////////////////////////////////");
			System.out.println("////");
			System.out.println("//// Would you like to input a second parameter?");
			System.out.println("////            Y- Yes         N- No");
			System.out.println("////");
			System.out.println("////////////////////////////////////////////////////////////////////////////////////");
			Scanner sc = new Scanner(System.in);
			String auxStr = sc.next().toUpperCase();
			switch (auxStr){
			case "Y": {
				second=true;
				redLight=false;
				break;
			}
			case "N":
				second=false;
				redLight=false;
				break;
			default:
				System.out.println("////////////////////////////////////////////////////////////////////////////////////");
				System.out.println("////");
				System.out.println("//// Oh-Oh. I didn't understand you. Use Y for Yes or N for No");
				System.out.println("////");
				System.out.println("////////////////////////////////////////////////////////////////////////////////////");
			}
		}
		if(second) {
			try {
				System.out.println("////////////////////////////////////////////////////////////////////////////////////");
				System.out.println("////");
				System.out.println("//// Enter the second parameter (The second of two files)");
				System.out.println("////");
				System.out.println("////////////////////////////////////////////////////////////////////////////////////");
				Scanner sc = new Scanner(System.in);
				String auxStr = sc.nextLine();
				aux.add(auxStr);
			}catch (Exception e) {
				System.err.println("Oh oh: "+e);
			}
		}
		
		return aux;
	}
	
}