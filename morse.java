import java.util.*;
import java.io.*;
import java.util.Scanner;

public class morse{

public static void main(String[] args) throws IOException {
        
		int i,j;
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int[] lettersCount = new int[26];
		
		for (i=0;i<26;i++)
		{
			lettersCount[i]=0;
		}

        Scanner reader = new Scanner(new FileInputStream("C:\\Users\\binky\\Desktop\\ButterflyEffect.txt"));

        while (reader.hasNextLine()) 
		{
			char[] line = reader.nextLine().toLowerCase().toCharArray();
			System.out.println(line);
			
			for (i = 0; i<line.length; i++)
			{
				for (j=0; j<26; j++)
				{
					if(alphabet[j] == line[i])
					{
						lettersCount[j]++;
					}
				}
			}
			
        }
		reader.close();

		for (i=0; i<26; i++)
		{
			System.out.println(alphabet[i] + " : " + lettersCount[i]);
		}
		
		
    }
}