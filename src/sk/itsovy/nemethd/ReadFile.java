package sk.itsovy.nemethd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {

    public void printJoke(){
        try{
            File myFile = new File("joke.txt");
            Scanner myReader = new Scanner(myFile);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void writeJoke(){
        try{
            FileWriter myFile = new FileWriter("joke.txt");
            Scanner myReader = new Scanner((Readable) myFile);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printFileInfo(){
        File myFile = new File("joke.txt");
        if(myFile.exists()){
            System.out.println("File name: "+myFile.getName());
            System.out.println("Absolute path: "+myFile.getAbsolutePath());
            System.out.println("Size: "+myFile.length()+"b");
            System.out.println("Readable: "+myFile.canRead());
            System.out.println("Writable: "+myFile.canWrite());
            System.out.println("Last modified: "+myFile.lastModified());
        } else{
            System.out.println("File not found");
        }
    }

    public void copyTextFile(String sourceFile){
        try {
            File myFile = new File(sourceFile);
            Scanner myReader = new Scanner(myFile);
            FileWriter myFileCopy = new FileWriter("input_copy.txt");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myFileCopy.write(data.toUpperCase()+"\n");
            }
            myFileCopy.close();
        }  catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int dictation(){
        int count = 0;
        try {
            File myFile = new File("dictation.txt");
            Scanner myReader = new Scanner(myFile);
            FileWriter myFileCopy = new FileWriter("dictation_edit.txt");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                StringBuilder builder = new StringBuilder();
                char replaceChar = '_';
                for(char currentChar : data.toCharArray()){
                    if((currentChar == 'i') || (currentChar == 'í') || (currentChar == 'y') || (currentChar == 'ý')
                            || (currentChar == 'I') || (currentChar == 'Í') || (currentChar == 'Y') || (currentChar == 'Ý')){
                        builder.append(replaceChar);
                        count++;
                    }
                }
                String replacedData = builder.toString();
                myFileCopy.write(replacedData);
            }
            myFileCopy.close();
        }  catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
