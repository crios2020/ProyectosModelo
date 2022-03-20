package ar.com.eduit.curso.java.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileText implements I_File{

    private File file;

    public FileText(File file) {
        this.file = file;
    }
    
    public FileText(String file){
        this.file = new File(file);
    }

    @Override
    public String getText() {
        String text="";
        int car;
        try (FileReader in=new FileReader(file)){
            while((car=in.read())!=-1){
                text+=(char)car;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return text;
    }

    @Override
    public void setText(String text) {
        try (FileWriter out=new FileWriter(file)){
            out.write(text);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void appendText(String text) {
        try (FileWriter out=new FileWriter(file,true)){
            out.write(text);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<String> getAll() {
        List<String>list=new ArrayList();
        //String line;
        try (BufferedReader in=new BufferedReader(new FileReader(file))) {
            //while((line=in.readLine())!=null){
            //    list.add(line);
            //}
            
            list=in.lines().collect(Collectors.toList());
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}
