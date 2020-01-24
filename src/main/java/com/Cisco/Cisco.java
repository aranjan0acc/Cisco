package com.Cisco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Abhishek Ranjan
 * Reads the input file line by line
 * Were each line is a path to another file
 * Open each file and store the words in an array
 * Displays the words and how many times each word is repeated in the file
 * Repeat the same for each fine path listed in main file
 *          
 */

public class Cisco {

public static void main(String[] args) throws IOException
{
//Read the main file which hold the relative paths of the files that contain the text
List<String> line;
line = Files.readAllLines(Paths.get("C://Workspace//Cisco//src//main//resources//mainfiles.txt"));
//read each line of the main file
for(int a = 0;a<line.size();a++)
{
String path = line.get(a);
System.out.println("----------------------------------------------------");
System.out.println("----File " +path +"   Words and respective count----");
System.out.println("----------------------------------------------------");

//passing the text file path
String filetext = null;
try {
filetext = readFile(path);
} catch (IOException e) {
e.printStackTrace();

}
//splitting the text from the file into words
String split[] = filetext.split("\\W+");
//storing the non-repetitive words and their counts
Map<String, Integer> word = new HashMap<String, Integer> ();
for (String t:split)

{
if (word.containsKey(t))
{

word.put(t, word.get(t)+1);

} else {

word.put(t, 1);

}

}

//to display the words and their counts from the stored element
Set <String> keys = word.keySet();
for(String key :keys)
{
System.out.print("\""+key+"\" occurence count: ");
System.out.println(word.get(key));
}
}
}
//function to read the text file and concatenate all the lines into a single string
private static String readFile(String fileName) throws IOException {
BufferedReader br = new BufferedReader(new FileReader(fileName));
try {
StringBuilder sb = new StringBuilder();
String line = br.readLine();
while (line != null) {
sb.append(line);
// sb.append("/n");
line = br.readLine();
}
return sb.toString();
} finally {
br.close();
}
}

}
