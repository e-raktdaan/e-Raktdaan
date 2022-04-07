<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.eratkdaan.Stock" %>
   



<!doctype html>
<html lang="en">
  <head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Bootstrap CSS v5.0.2 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"  integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <style>

        #mbutton:hover{
          background-color:#4b92dc;
        }
    
          button{
          background-color: #CA0B00;
         }
            body{
                background-color: gainsboro;
                font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
            }
    
            /* Main Footer */
    footer .main-footer{  padding: 20px 0;  background: #252525;}
    footer ul{  padding-left: 0;  list-style: none;}
    
    /* Copy Right Footer */
    .footer-copyright { background: #222; padding: 5px 0;}
    .footer-copyright .logo {    display: inherit;}
    .footer-copyright nav {    float: right;    margin-top: 5px;}
    .footer-copyright nav ul {  list-style: none; margin: 0;  padding: 0;}
    .footer-copyright nav ul li { border-left: 1px solid #505050; display: inline-block;  line-height: 12px;  margin: 0;  padding: 0 8px;}
    .footer-copyright nav ul li a{  color: #969696;}
    .footer-copyright nav ul li:first-child { border: medium none;  padding-left: 0;}
    .footer-copyright p { color: #969696; margin: 2px 0 0;}
    
    /* Footer Top */
    .footer-top{  background: #252525;  padding-bottom: 30px; margin-bottom: 30px;  border-bottom: 3px solid #222;}
    
    /* Footer transparent */
    footer.transparent .footer-top, footer.transparent .main-footer{  background: transparent;}
    footer.transparent .footer-copyright{ background: none repeat scroll 0 0 rgba(0, 0, 0, 0.3) ;}
    
    /* Footer light */
    footer.light .footer-top{ background: #f9f9f9;}
    footer.light .main-footer{  background: #f9f9f9;}
    footer.light .footer-copyright{ background: none repeat scroll 0 0 rgba(255, 255, 255, 0.3) ;}
    
    /* Footer 4 */
    .footer- .logo {    display: inline-block;}
    
    /*==================== 
      Widgets 
    ====================== */
    .widget{  padding: 20px;  margin-bottom: 40px;}
    .widget.widget-last{  margin-bottom: 0px;}
    .widget.no-box{ padding: 0; background-color: transparent;  margin-bottom: 40px;
      box-shadow: none; -webkit-box-shadow: none; -moz-box-shadow: none; -ms-box-shadow: none; -o-box-shadow: none;}
    .widget.subscribe p{  margin-bottom: 18px;}
    .widget li a{ color: #CA0B00;}
    .widget li a:hover{ color: #4b92dc;}
    .widget-title {margin-bottom: 20px;}
    .widget-title span {background: #839FAD none repeat scroll 0 0;display: block; height: 1px;margin-top: 25px;position: relative;width: 20%;}
    .widget-title span::after {background: inherit;content: "";height: inherit;    position: absolute;top: -4px;width: 50%;}
    .widget-title.text-center span,.widget-title.text-center span::after {margin-left: auto;margin-right:auto;left: 0;right: 0;}
    .widget .badge{ float: right; background: #7f7f7f;}
    
    .typo-light h1, 
    .typo-light h2, 
    .typo-light h3, 
    .typo-light h4, 
    .typo-light h5, 
    .typo-light h6,
    .typo-light p,
    .typo-light div,
    .typo-light span,
    .typo-light small{  color: #fff;}
    
    ul.social-footer2 { margin: 0;padding: 0; width: auto;}
    ul.social-footer2 li {display: inline-block;padding: 0;}
    ul.social-footer2 li a:hover {background-color:#CA0B00;}
    ul.social-footer2 li a {display: block; height:30px;width: 30px;text-align: center;}
    .btn{background-color: #CA0B00; color:#fff;}
    .btn:hover, .btn:focus, .btn.active {background: #4b92dc;color: #fff;
    -webkit-box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
    -moz-box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
    -ms-box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
    -o-box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
    box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
    -webkit-transition: all 250ms ease-in-out 0s;
    -moz-transition: all 250ms ease-in-out 0s;
    -ms-transition: all 250ms ease-in-out 0s;
    -o-transition: all 250ms ease-in-out 0s;
    transition: all 250ms ease-in-out 0s;
    
    }
      
      
        </style>

  </head>
  <body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark py-1">
        <div class="container-fluid">
          <a class="navbar-brand" href="one.html">
            <img src="logo.png" alt="Avatar Logo" style="width:40px;" class="rounded-pill"> </a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="one.html"><i class="fa fa-home"></i> Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="one.html#about"><i class="fa fa-book"></i> About Us</a>
              </li>
             
              <li class="nav-item">
                <a class="nav-link " href="#"><i class="fa fa-bell-o"></i> Notification</a>
              </li>
              <li class="nav-item">
                <a class="nav-link " href="#footer"><i class="fa fa-address-book-o"></i> Contact Us</a>
              </li>

              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fa fa-key"></i>
                   Login
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="#">Needy?</a></li>
                  <li><a class="dropdown-item" href="#">Donor?</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="#">Admin</a></li>
                </ul>
              </li>
            </ul>
            <form action="find" class="d-flex" method="post">
              <input class="form-control me-2" type="text" name="city" placeholder="City Name... " aria-label="Search" style="font-style:italic">
              <button class="btn btn-danger" type="submit">find?</button>
            </form>
          </div>
        </div>
      </nav>
      

      

      <div class="container">
          <div class="row mt-4">
              <div class="col-12">
                  find Blood Near By You !
              </div>
          </div>
           <form action="findbg" method="post">

          <div class="row mt-4">
            <div class="col-5 text-center">
                <input type="text" class="form-control" placeholder= "Enter Your City Name" required >
            </div>
            <div class="col-5 ">
                <input type="text" class="form-control " placeholder= "Blood Group" required >
            </div>
            <div class="col-2 text-center">
           
               <button type="submit" class="btn btn-primary">Submit</button>
            
                
            </div>
           
        </div>
         </form>
        
         <%
@SuppressWarnings("unchecked") 
ArrayList<Stock> list=(ArrayList<Stock>) request.getAttribute("elist");
         if(list.isEmpty()) {
            %>
            <br>
            
            <br>
            <h4>Sorry, Not available in city Right Now</h4> 
   			
  <%       } 
         else {
%>



        <div class="row">
            <div class="col-12">

              <table class="table table-responsive mt-4 table-hover table-sm">
                  <thead class="thead-inverse|thead-default">
                      <tr class="table-danger">
                          <th scope="col">Blood Group</th>
                          <th scope="col">Best Before</th>
                          <th scope="col">City</th>
                          <th scope="col">Phone</th>
                          <th scope="col">Quantity</th>
                        
                      </tr>
                      </thead>

                      <tbody>
        	
         <%
          for(Stock s :list)
          {

         %>
                	
                          <tr class="table-success">
                              <td ><%out.print(s.getB_Group()); %></td>
                              <td><%out.print(s.getExpiry()); %></td>
                              <td><%out.print(s.getCity()); %></td>
                              <td><%out.print(s.getPhone()); %></td>
                              <td ><%out.print(s.getQuantity()); %> units</td>
                             
                          </tr>

   <%}}%>                   </tbody>
              </table>

            </div>




      </div>
      </div>

      <br>
      <br>
      <br>
      <br>







    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
  </body>
  </html>