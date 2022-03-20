<%-- 
    Document   : Cursos.jsp
    Created on : 26 ago. 2021, 17:06:31
    Author     : carlos
--%>

<%@page import="ar.com.eduit.curso.java.utils.html.HtmlTable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ar.com.eduit.curso.java.connectors.Connector"%>
<%@page import="ar.com.eduit.curso.java.repositories.jdbc.CursoRepository"%>
<%@page import="ar.com.eduit.curso.java.repositories.interfaces.I_CursoRepository"%>
<%@page import="ar.com.eduit.curso.java.entities.Curso"%>
<%@page import="ar.com.eduit.curso.java.enums.Turno"%>
<%@page import="ar.com.eduit.curso.java.enums.Dia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% I_CursoRepository cr=new CursoRepository(Connector.getConnection()); %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cursos</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
    </head>
    <body>
        <ul>
            <li><a href="http://localhost:8080/index.jsp"   >Inicio </a></li>
            <li><a href="http://localhost:8080/Cursos.jsp"  >Cursos </a></li>
            <li><a href="http://localhost:8080/Alumnos.jsp" >Alumnos</a></li>
            <li>v0.99</li>
        </ul>
        <h1>Mantenimiento de Cursos!</h1>
        
        <form>
            <table>
                <tr><td>Titulo:     </td><td><input type="text" name="titulo"   required    minlength="3" maxlength="20" style="width: 200px;"/></td></tr>
                <tr><td>Profesor:   </td><td><input type="text" name="profesor" required    minlength="3" maxlength="20" style="width: 200px;"/></td></tr>
                <tr>
                    <td>Dia:        </td>
                    <td>
                        <select name="dia" style="width: 208px;">
                            <!--
                            <option value="LUNES"       >Lunes      </option>
                            <option value="MARTES"      >Martes     </option>
                            <option value="MIERCOLES"   >Miércoles  </option>
                            <option value="JUEVES"      >Jueves     </option>
                            <option value="VIERNES"     >Viernes    </option>
                            -->                         
                            <%
                                for(Dia d:Dia.values()){
                                    out.print("<option value='"+d+"'>"+d.toString().toLowerCase()+"</option>");
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Turno: </td>
                    <td>
                        <select name="turno" style="width: 208px;">
                            <%
                                for(Turno t:Turno.values()){
                                    out.print("<option value='"+t+"'>"+t.toString().toLowerCase()+"</option>");
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="reset"     value="Limpiar" /></td>
                    <td><input type="submit"    value="Guardar"   /></td>
                </tr>
            </table>
        </form>
        
        <% 
            try {
                String titulo=request.getParameter("titulo");
                String profesor=request.getParameter("profesor");
                Dia dia=Dia.valueOf(request.getParameter("dia"));
                Turno turno=Turno.valueOf(request.getParameter("turno"));
                Curso curso=new Curso(titulo, profesor, dia, turno);
                cr.save(curso);
                if(curso.getId()!=0){
                    out.println("<div id='info'><h3>Se guardo el curso id="+curso.getId()+" </h3></div>");
                }else{
                    out.println("<div id='error'><h3>No se pudo guardar el curso!</h3></div>");
                }
            } catch (Exception e) {
                System.out.println(e);
                out.println("<div id='error'><h3>Problemas con los parametros!</h3></div>");
            }
            
        %>
       
        <div id='cursos'>
            
            <form>
                Buscar Titulo:
                <input type="text" name="buscarTitulo"/>
                <input type="submit" value="Buscar" />
            </form>
            
            <% 
                String buscarTitulo=request.getParameter("buscarTitulo");
                List<Curso>list=new ArrayList();
                if(buscarTitulo==null || buscarTitulo.isEmpty())
                    list=cr.getAll();
                else
                    list=cr.getLikeTitulo(buscarTitulo);
                
                out.println(new HtmlTable<Curso>().getTable(list));
            %>
        </div>
                        
    </body>
</html>
