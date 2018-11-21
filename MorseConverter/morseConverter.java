import java.util.*;
import java.io.*;
import java.util.Scanner;

public class morseConverter{

public static void main(String []args)  
	{
		
		Scanner in = new Scanner(System.in);
		while(true){
		System.out.println("1 - Morse Code to Text");
		System.out.println("2 - Text to Morse Code");
		System.out.println("\n0 - Exit");
		System.out.println("Select: ");
		int selection = in.nextInt();
		if (selection > 2){
			System.out.println("INVALID ENTRY");
			morseConverter.main(null);
		}
		if (selection == 0){System.exit(0);}
			
		System.out.println("File to Convert: ");
		String morseFile = in.next();
		System.out.println("Set File Name: ");
		String customFileName = in.next();
		if (selection == 1){
			try{
			convertToDoc(morseFile, customFileName);
			}catch(IOException e){e.printStackTrace();}
		}
		if (selection == 2){
			try{
			convertToMorse(morseFile, customFileName);
			}catch(IOException e){e.printStackTrace();}
		}
		
		}
	}
	
	public static void convertToDoc(String file, String customFileName)throws IOException{	
		File newFile = new File(customFileName);
					if (!newFile.exists())
					{
						newFile.createNewFile();
					}
		PrintWriter pw = new PrintWriter(newFile);
        Scanner morseDoc = new Scanner(new FileInputStream(file));

		System.out.println("Converting "+file+" to Morse Code...");
        while (morseDoc.hasNextLine()) 
		{
			String line = morseDoc.nextLine();
			String [] word = line.split("/");
			
			for (int i=0;i<word.length;i++){
				String [] letter = word[i].split(" ");
				for (int j=0;j<letter.length;j++){
					Scanner morseCode = new Scanner(new FileInputStream("morsecode.txt"));
					while(morseCode.hasNextLine())
					{
						String lineCode = morseCode.nextLine();
						String [] codes = lineCode.split("/");
						if (codes[1].equals(letter[j]))
						{
							pw.append(codes[0]);
							break;
						}
						
					}
					morseCode.close();
				}
				pw.append(" ");
			}
			pw.println();
		}
		System.out.println("Completed");
		System.out.println("The file can be found here: "+ newFile.getAbsolutePath()+"\n\n");
		
		morseDoc.close();
		pw.close();
	}
	
	public static void convertToMorse(String file, String customFileName)throws IOException{	
		File newFile = new File(customFileName);
					if (!newFile.exists())
					{
						newFile.createNewFile();
					}
		PrintWriter pw = new PrintWriter(newFile);
        Scanner textDoc = new Scanner(new FileInputStream(file));

		System.out.println("Converting "+file+" to Text...");
		
        while (textDoc.hasNextLine()) 
		{
			String line = textDoc.nextLine().toLowerCase();
			String [] word = line.split(" ");
			
			for (int i=0;i<word.length;i++){
				String hold="#";
				String [] letter = word[i].split("");
				for (int j=0;j<letter.length;j++){
					Scanner morseCode = new Scanner(new FileInputStream("morsecode.txt"));
					while(morseCode.hasNextLine())
					{
						String lineCode = morseCode.nextLine();
						String [] codes = lineCode.split("/");
						if (!codes[0].equals(letter[j]))
						{
							hold=" ";
						}
						else{
							hold=codes[1];
							break;
						}
						
					}
					pw.append(hold);
					pw.append(" ");
					morseCode.close();
				}
				pw.append("/");
			}
			pw.println();
		}
		System.out.println("Completed");
		System.out.println("The file can be found here: "+ newFile.getAbsolutePath()+"\n\n");
		
		textDoc.close();
		pw.close();
	}
}