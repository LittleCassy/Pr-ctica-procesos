package Ejercicio1;

import java.awt.Desktop;
import java.net.URI;

public class translator {
	
	public static void main(String[] args) {
		try {
			Translate(args[0],args[1],args[2]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Translate(String originLanguage, String destinationLanguage, String sentence) throws Exception {
		
		String textSentence = sentence.replace(" ", "%20");
		URI myUrl = new URI("http://translate.google.es/?sl="+ originLanguage + "&tl="+ destinationLanguage+"&text="+textSentence);
		Desktop.getDesktop().browse(myUrl);
		
	}
}
