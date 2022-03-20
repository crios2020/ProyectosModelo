package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.files.FileText;
import ar.com.eduit.curso.java.files.I_File;
import java.util.List;

public class TestFiles {
    public static void main(String[] args) {
        String file="texto.txt";
        I_File fText=new FileText(file);
        fText.setText("Curso de Java.\n");
        fText.appendText("Hoy es Martes.\n");
        fText.appendLine("Verano.");
        fText.appendLine("Verano.");
        fText.appendLine("Otoño.");
        fText.appendLine("Invierno.");
        fText.appendLine("Invierno.");
        fText.appendLine("Primavera.");
        fText.addLines(List.of("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"));
        fText.addLines(List.of("Lunes", "Enero", "Febrero", "Jueves", "Marzo", "Sábado", "Domingo"));
        
        //System.out.println(fText.getText());
        //fText.print();
        
        fText.remove("Enero");
        fText.remove("Invierno.");
        
        fText.getAll().forEach(System.out::println);
        //fText.getSortedLines().forEach(System.out::println);
        //fText.getReversedSortedLines().forEach(System.out::println);
        //fText.getLikeFilter("mi").forEach(System.out::println);
        //fText.getLinkedHashSet().forEach(System.out::println);
        //fText.getTreeSet().forEach(System.out::println);
        
    }
}
