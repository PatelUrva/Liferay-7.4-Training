<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="init.jsp" %>

<link href="<%= request.getContextPath() %>/css/main.css" rel="stylesheet">

<liferay-ui:error key="error" message="Authenticated Failed ! Due to invalid email domain" />

<!-- Section: Design Block -->
	<section class="background-radial-gradient overflow-hidden">
	
	  <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
	    <div class="row gx-lg-5 align-items-center mb-5">
	      <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
	        <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
	          Liferay CE 7.4 <br />
	          <span style="color: hsl(218, 81%, 75%)">Custom Login Portlet</span>
	        </h1>
	        <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
	          Authenticating to Liferay DXP .
	          It has only one view, which is used for logging in or showing the user who is already logged in.
	          The portlet handles all processing of this form using a single Action Command
	        </p>
	      </div>
	
	      <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
	        <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
	        <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>
	
	        <div class="card bg-glass">
	          <div class="card-body px-4 py-5 px-md-5">
	          
		<c:choose>
    		<c:when test="<%= themeDisplay.isSignedIn() %>">

		        <%
		        String signedInAs = HtmlUtil.escape(user.getFullName());
		
		        if (themeDisplay.isShowMyAccountIcon() && (themeDisplay.getURLMyAccount() != null)) {
		            String myAccountURL = String.valueOf(themeDisplay.getURLMyAccount());
		
		            signedInAs = "<a class=\"signed-in\" href=\"" + HtmlUtil.escape(myAccountURL) + "\">" + signedInAs + "</a>";
		        }
		        %>
		
		        <liferay-ui:message arguments="<%= signedInAs %>" key="you-are-signed-in-as-x" translateArguments="<%= false %>" />
		    </c:when>
    		<c:otherwise>
    
				<portlet:actionURL name="/custom/login" var="loginURL">
				     <portlet:param name="mvcRenderCommandName" value="/custom/login" />
				 </portlet:actionURL>
				 
				<%
					String redirect = ParamUtil.getString(request, "redirect");
				%>
	 
	
	            <form action="${loginURL}" method="post" name="loginForm">
	              
	                <input name="saveLastPath" type="hidden" value="<%= false %>" />
	            	<input name="redirect" type="hidden" value="${redirect}" />
	            
	              <!-- Email input -->
	              <div class="form-outline mb-4">
	                <input type="email" id="form3Example3" name="email" class="form-control" />
	                <label class="form-label" for="form3Example3">Email address</label>
	              </div>
	
	              <!-- Password input -->
	              <div class="form-outline mb-4">
	                <input type="password" name="password" id="form3Example4" class="form-control" />
	                <label class="form-label" for="form3Example4">Password</label>
	              </div>
	
	              <!-- Checkbox -->
	              <div class="form-check d-flex justify-content-center mb-4">
	                <input class="form-check-input me-2" name="rememberMe" type="checkbox" value="" id="form2Example33" checked />
	                <label class="form-check-label" for="form2Example33">
	                  Remember Me
	                </label>
	              </div>
	
	              <!-- Submit button -->
	              <button type="submit" name="btnLogin" class="btn btn-primary btn-block mb-4">
	                Sign in
	              </button>
	             
	            </form>
	          </c:otherwise>
			</c:choose>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

	<!-- Section: Design Block -->