
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="update" method="post">
  empno<input name="empNo" value="${emp.empNo}" readonly/> <br>
  eName<input name="eName" value="${emp.eName}" /> <br>
  job<input name="job" value="${emp.job}" /> <br>
  mgr<input name="mgr" value="${emp.mgr}" /> <br>
  hireDate<input name="hireDate" value="${emp.hireDate}" type="date" /> <br>
  sal<input name="sal" value="${emp.sal}" /> <br>
  comm<input name="comm" value="${emp.comm}" /> <br>
  <input type="submit" value="Update" />
</form>
</body>
</html>
