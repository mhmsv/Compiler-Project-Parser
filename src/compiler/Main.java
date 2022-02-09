package compiler;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

//java.util.Arrays.asList(theArray).indexOf(o)
//
public class Main {

    public static void main(String[] args) throws Exception {
Boolean output= run(new File("/Users/mohammad/IdeaProjects/lastversionphase2/src/test/phase2test/samples/t205-define.in"));
//        System.out.println("ino gereftim"+'\n'+output);


        }


    public static Boolean run(File inputFile) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        StringBuilder stringBuilder = new StringBuilder();
        String linee;
        while ((linee = reader.readLine()) != null) {
            stringBuilder.append(linee);
            stringBuilder.append('\n');
//            System.out.println("line ha ke khabde sgid:"  + linee);
        }
        String content= stringBuilder.toString();
        //System.out.println("natije nahaei ===" +'\n'+content);
        //System.out.println(content);
        String contentf = content;
        StringBuilder filtred = new StringBuilder();
        String[] words = content.split("\n");
        String find="",replace="",line="";
        for (int i = 0; i < words.length; i++) {
            //System.out.println("strrrr"+words[i].toString());
            if(words[i].toString().toLowerCase().contains("define"))
            {
                line=words[i].toString();
                int firstws = line.indexOf(' ', 0);
                int secws = line.indexOf(" ", firstws+1);
                find=line.substring(firstws+1,secws);
                replace=line.substring(secws+1,line.length());

                content=content.replaceAll(find.toString(),replace.toString());

                words = content.split("\n");
                words[i]="";
            }
            filtred.append(words[i]);
            filtred.append('\n');
        }
        //System.out.println(filtred.toString());

        StringBuilder str = new StringBuilder();

        try {
            String item;
            File file = new File("test1.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write( filtred.toString());
            fileWriter.flush();
            fileWriter.close();

            lexic scanner = new lexic(new FileReader(file.getPath()));
            parser parser = new parser(scanner);
            try{
                parser.parse();
                System.out.println("kar kaar");
                return true;
            } catch (Exception e) {
                System.out.println("syntaks err KN");
            return false;
            }

            //*************
//            while (!scanner.yyatEOF() ) {
//                item = scanner.yylex();
//
//                if (item!=(null)) {
//                    System.out.println(item);
//                    str.append(item);
//                    str.append('\n');
//                }
//                else break;
//
//            }
            //*********

        } catch (IOException e) {
            return false;
        }
//        System.out.println("khorooojie in binamos"+'\n'+str.toString());

    }


}

//public class Main {
//

//        return str.toString();
//}