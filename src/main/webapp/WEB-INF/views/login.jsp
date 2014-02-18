<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:layout>
	<div class="col-md-4 col-md-offset-4">
		<form method="post" action="j_spring_security_check">
	        <c:if test="${param.error}">
	            <div class="cold-md-4 col-offset-4 alert alert-danger"><p>Invalid login</p></div>
	        </c:if>
		    <div class="form-group">
		        <label for="login-username">Username</label>
		        <input class="form-control" id="login-username" type="text" name="j_username" placeholder="Username" />
		    </div>
		    <div class="form-group">
		        <label for="login-password">Password</label>
		        <input class="form-control" id="login-password" type="password" name="j_password" placeholder="Password" />
		    </div>
		    <div class="checkbox">
		       <label>
		           <input type="checkbox" id="password-toggle" value="Show Password" /> Show Password
		       </label>
		    </div>
		    <button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
</t:layout>
