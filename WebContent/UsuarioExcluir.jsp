<%@ include file="verificaSessao.jsp" %>

<%@ page import="projeto.USUARIODAO" import="projeto.USUARIOMODEL" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
 <% String msg = null;
 if(request.getParameter("IDusuario")==null)
 {	 msg = "Registro n�o encontrado"; }else
 {	 USUARIOMODEL usuario = new USUARIOMODEL();
	 USUARIODAO dao = new USUARIODAO();
	 usuario.setIDusuario(request.getParameter("IDusuario"));
 	 boolean ret = dao.apaga(usuario);
 	 if(ret==true){
 		msg = "Registro Excluido com sucesso!";
 		// Define parametros para a sess�o
        request.setAttribute("msg", msg);
 	 }else{
 		msg = "N�o foi possivel excluir registro.";
 		// Define parametros para a sess�o
        request.setAttribute("msg", msg);
 	 }
 }	   %>
 <jsp:forward page="UsuarioListar.jsp"/>
