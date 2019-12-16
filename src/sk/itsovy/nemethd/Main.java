package sk.itsovy.nemethd;

public class Main {
    public static void main(String[] args) {

        /*ReadFile firstJoke = new ReadFile();
        firstJoke.printJoke();
        System.out.println();
        firstJoke.printFileInfo();*/

        /*ReadFile textFile = new ReadFile();
        textFile.copyTextFile("input.txt");*/

        ReadFile dict = new ReadFile();
        System.out.println(dict.dictation());
    }
}
