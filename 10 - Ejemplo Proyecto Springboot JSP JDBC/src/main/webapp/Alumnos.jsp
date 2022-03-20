<%-- 
    Document   : Alumnos
    Created on : 31 ago. 2021, 15:52:39
    Author     : carlos
--%>

<%@page import="ar.com.eduit.curso.java.utils.html.HtmlTable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ar.com.eduit.curso.java.entities.Alumno"%>
<%@page import="ar.com.eduit.curso.java.entities.Curso"%>
<%@page import="ar.com.eduit.curso.java.repositories.jdbc.AlumnoRepository"%>
<%@page import="ar.com.eduit.curso.java.repositories.interfaces.I_AlumnoRepository"%>
<%@page import="ar.com.eduit.curso.java.repositories.jdbc.CursoRepository"%>
<%@page import="ar.com.eduit.curso.java.connectors.Connector"%>
<%@page import="ar.com.eduit.curso.java.repositories.interfaces.I_CursoRepository"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% I_CursoRepository cr=new CursoRepository(Connector.getConnection()); %>
<% I_AlumnoRepository ar=new AlumnoRepository(Connector.getConnection()); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumnos</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
    </head>
    <body>
        <ul>
            <li><a href="http://localhost:8080/index.jsp"   >Inicio </a></li>
            <li><a href="http://localhost:8080/Cursos.jsp"  >Cursos </a></li>
            <li><a href="http://localhost:8080/Alumnos.jsp" >Alumnos</a></li>
            <li>v0.99</li>
        </ul>
        <h1>Mantenimiento de Alumnos</h1>
        
        <form>
            <table>
                <tr><td>Nombre:     </td><td><input type="text"     name="nombre"   required    minlength="3" maxlength="20"    style="width: 200px;"/></td></tr>
                <tr><td>Apellido:   </td><td><input type="text"     name="apellido" required    minlength="3" maxlength="20"    style="width: 200px;"/></td></tr>
                <tr><td>Edad:       </td><td><input type="number"   name="edad"     required    value="18" min="18" max="120"   style="width: 200px;"/></td></tr>
                <tr>
                    <td>Curso:      </td>
                    <td>
                        <select name="idCurso" style="width: 208px;">
                            <%
                                for(Curso c:cr.getAll()){
                                    out.println("<option value='"+c.getId()+"'>"
                                            +c.getId()+" "+c.getTitulo()+" "+c.getProfesor()+" "+c.getDia()+" "+c.getTurno()
                                            +"</option>");
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
                String nombre=request.getParameter("nombre");
                String apellido=request.getParameter("apellido");
                int edad=Integer.parseInt(request.getParameter("edad"));
                int idCurso=Integer.parseInt(request.getParameter("idCurso"));
                Alumno alumno=new Alumno(nombre, apellido, edad, idCurso);
                ar.save(alumno);
                if(alumno.getId()!=0){
                    out.println("<div id='info'><h3>Se guardo el alumno id="+alumno.getId()+" </h3></div>");
                }else{
                    out.println("<div id='error'><h3>No se pudo guardar el alumno!</h3></div>");
                }
            } catch (Exception e) {
                System.out.println(e);
                out.println("<div id='error'><h3>Problemas con los parametros!</h3></div>");
            }
            
        %>
        
        <div id='alumnos'>
            
            <form>
                Buscar Apellido:
                <input type="text" name="buscarApellido"/>
                <input type="submit" value="Buscar" />
            </form>
            
            <% 
                String buscarApellido=request.getParameter("buscarApellido");
                List<Alumno>list=new ArrayList();
                if(buscarApellido==null || buscarApellido.isEmpty())
                    list=ar.getAll();
                else
                    list=ar.getLikeApellido(buscarApellido);
                
                out.println(new HtmlTable<Alumno>().getTable(list));

            %>
        </div>
    </body>
</html>
