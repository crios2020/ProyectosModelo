package ar.com.eduit.curso.java.files;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public interface I_File {
    default void print(){ System.out.println(getText()); }
    String getText();
    void setText(String text);
    void appendText(String text);
    default void clear(){ setText(""); }
    default void appendLine(String line){
        appendText(line+"\n");
    }
    default void addLines(Collection<String>lines){
        //for(String s: lines) appendLine(s);
        lines.forEach(this::appendLine);
    }
    List<String>getAll();
    default List<String>getLikeFilter(String filter){
        if(filter==null) return new ArrayList();
        return getAll()
                .stream()
                .filter(l->l.toLowerCase().contains(filter.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<String>getSortedLines(){
        return getAll()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
    default List<String>getReversedSortedLines(){
        return getAll()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
    default LinkedHashSet<String>getLinkedHashSet(){
        LinkedHashSet<String>set=new LinkedHashSet();
        set.addAll(getAll());
        return set;
    }
    default TreeSet<String>getTreeSet(){
        TreeSet<String>set=new TreeSet();
        set.addAll(getAll());
        return set;
    }
    default void remove(String line){
        List<String>list=getAll();
        list.remove(line);
        clear();
        addLines(list);
    }
    default void remove(List<String>lines){
        lines.forEach(this::remove);
    }
}
