<%@ page import="DBHandler.DBQueries" %>
<jsp:include page="select/table_displayer.jsp" >
    <jsp:param name="title" value="Suppliers" />
    <jsp:param name="sql" value="<%=DBQueries.supplier%>" />
</jsp:include>