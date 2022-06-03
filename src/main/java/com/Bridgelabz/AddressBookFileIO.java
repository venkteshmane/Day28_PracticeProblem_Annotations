package com.Bridgelabz;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBookFileIO {
    public  void writeData(Map<String,AddressBook> addressBook){

        System.out.println("inside file");
        File file=new File("C:\\Users\\user\\Desktop\\LFP_Batch\\Day28-Practice-program_Annotation\\src\\main\\java\\com\\Bridgelabz\\Contacts.txt");
        BufferedWriter bf=null;

        try {

            bf=new BufferedWriter(new FileWriter(file));

            for (Map.Entry<String,AddressBook> entry:  addressBook.entrySet()) {
                System.out.println(entry.getKey()+":"+entry.getValue());

                bf.write(entry.getKey() + ":" + entry.getValue());


                bf.newLine();
            }
            bf.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String,String> readData(){
        Map<String,String> mapFileContents=new HashMap<>();
        BufferedReader br=null;
        try {

            File file=new File( "C:\\Users\\user\\Desktop\\LFP_Batch\\Day28-Practice-program_Annotation\\src\\main\\java\\com\\Bridgelabz\\Contacts.txt");


            br=new BufferedReader(new FileReader(file));

            String line=null;
            String line2="";

            //read file line by line
            while ((line= br.readLine())!=null){

                //split the line by:
                String[] parts=line.split(":");
                String[] part2=line2.split(",");

                String bookName = parts[0].trim();
                String fname = parts[1].trim();
                mapFileContents.put(bookName, fname);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
        }
        return mapFileContents;
    }

}
