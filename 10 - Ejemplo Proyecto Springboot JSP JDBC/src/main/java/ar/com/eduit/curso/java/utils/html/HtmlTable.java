package ar.com.eduit.curso.java.utils.html;

import java.lang.reflect.Field;
import java.util.List;

public class HtmlTable<E> {
    public String getTable(List<E>list){
        if(list==null || list.isEmpty()) return "";
        String table="<table id='tabla' >";
        E e=list.get(0);
        Field[] campos=e.getClass().getDeclaredFields();
        table+="<tr>";
        for(Field c:campos){
            //System.out.println(c);
            table+="<td>"+c.getName()+"</td>";
        }
        table+="</tr>";
        for(E x:list){
            table+="<tr>";
            for(Field c:campos){
                table+="<td>";
                try{
                    String method="get"+c.getName().substring(0, 1).toUpperCase()+c.getName().substring(1);
                    table+=x.getClass().getMethod(method, null).invoke(x, null);
                }catch(Exception ex){}
                table+="</td>";
            }
            table+="</tr>";
        }
        table+="</table>";
        return table;
    }
}
