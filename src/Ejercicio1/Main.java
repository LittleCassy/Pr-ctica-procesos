package Ejercicio1;

import java.io.File;
import java.util.Scanner;

public class Main {

	static String originLanguage="en";
	static String destinationLanguage = "es";
	static String textToTranslate="Test";
	static long timeToSleep=(long)5000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultValues();
	}
	
	public static void Init() {
		try {
			
			String home = System.getProperty("java.home");
			String bin = home + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			
			ProcessBuilder pb;
			
			pb = new ProcessBuilder(bin, "-cp", classpath, "Ejercicio1.translator", originLanguage, destinationLanguage, textToTranslate);
			Process myProc = pb.start();
			Thread.sleep(timeToSleep);
			myProc.destroy();
			AskRepeat();
			//System.out.println(""+myProc.isAlive());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void AskCancellationTime() {
		System.out.println("////////////////////////////////////////////////////////////////");
		System.out.println("////");
		System.out.println("//// Please, how long would you like the browser tab to show?");
		System.out.println("////");
		System.out.println("//// Please, input the number in seconds");
		System.out.println("////");
		System.out.println("////////////////////////////////////////////////////////////////");
		Scanner sc = new Scanner(System.in);
		int aux=10;
		try {
			aux = sc.nextInt();
			timeToSleep=(long)(aux*1000);
		}catch(Exception e) {
			System.out.println("//// Please, use a number here.");
			AskCancellationTime();
		}
	}
	
	public static void AskOriginLanguage() {
		System.out.println("////////////////////////////////////////////////////////////////");
		System.out.println("////");
		System.out.println("//// Please, enter the origin language forthe translation");
		System.out.println("////");
		System.out.println("//// The language format is:");
		System.out.println("////");
		System.out.println("//// ES for Spanish and EN for English.");
		System.out.println("////");
		System.out.println("////////////////////////////////////////////////////////////////");
		Scanner sc = new Scanner(System.in);
		String aux = sc.next().toLowerCase();
		
		if(aux.equals("es")) {
			originLanguage=aux;
			destinationLanguage="en";
		}else if(aux.equals("en")) {
			originLanguage=aux;
			destinationLanguage="es";
		}else {
			System.out.println("//// I don't understand you. Using default ES -> EN");
			AskOriginLanguage();
		}
	}
	
	public static void AskText() {
		System.out.println("////////////////////////////////////////////////////////////////");
		System.out.println("////");
		System.out.println("//// Please, enter the text to be translated");
		System.out.println("////");
		System.out.println("////////////////////////////////////////////////////////////////");
		Scanner sc = new Scanner(System.in);
		String aux = sc.nextLine();
		textToTranslate=aux;
	}
	
	public static void AskRepeat() {
		System.out.println("////////////////////////////////////////////////////////////////");
		System.out.println("////");
		System.out.println("//// Would you like to go again?");
		System.out.println("////");
		System.out.println("////////////////////////////////////////////////////////////////");
		Scanner sc = new Scanner(System.in);
		String aux = sc.next().toUpperCase();
		switch (aux) {
		case "Y":
			DefaultValues();
			break;
		case "N":
			System.exit(1);
			break;
		default:
			System.out.println("//// I don't understand you. Please use Y for Yes and N for No");
		}
		
	}
	
	public static void DefaultValues() {
		System.out.println("////////////////////////////////////////////////////////////////");
		System.out.println("////");
		System.out.println("//// Would you like to use default values?");
		System.out.println("////");
		System.out.println("////////////////////////////////////////////////////////////////");
		Scanner sc = new Scanner(System.in);
		String aux = sc.next().toUpperCase();
		switch (aux) {
		case "Y":
			Init();
			break;
		case "N":
			AskCancellationTime();
			AskOriginLanguage();
			AskText();
			Init();
			break;
		default:
			System.out.println("//// I don't understand you. Please use Y for Yes and N for No");
		}
		
	}
}
