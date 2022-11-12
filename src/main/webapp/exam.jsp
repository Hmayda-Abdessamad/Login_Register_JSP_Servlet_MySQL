<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 08/11/2022
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="vueCredit.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>


<!-- Sidebar -->
<div class="w3-sidebar w3-light-grey w3-bar-block" style="width:25%">
    <h3 class="w3-bar-item">Menu</h3>
    <select name="cars" id="cars">
        <option selected> Students</option>
        <option > <a href="#" class="w3-bar-item w3-button">Add Student</a></option>
        <option > <a href="#" class="w3-bar-item w3-button">remove student</a></option>
    </select>
<br><br>
    <select name="cars" id="cars">
             <option selected> University</option>
            <option > <a href="#" class="w3-bar-item w3-button">Operation</a></option>
    </select>



</div>

<!-- Page Content -->
<div style="margin-left:25%">

        <h1>You are the visitor Number :</h1>

    <div class="w3-container">
        <header>
            <nav>
                <a href="#top">Main Menu</a>
                <a href="#middle">Show All students</a>
                <a href="#bottom">Smart Search</a>
            </nav>
        </header>
        <main>
            <article>
                <section><h2 id="top">Main Menu</h2>
                    <form>
                        <div class="form-group">
                            <label for="exampleInputEmail1">First Name</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Last name</label>
                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Age</label>
                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Gender</label>
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Open this select menu</option>
                                <option value="1">Man</option>
                                <option value="2">Women</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Date</label>
                            <input type="date" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">University</label>
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Open this select menu</option>
                                <option value="1">UCD</option>
                                <option value="2">UHD</option>
                            </select>
                        </div>

                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </section>
                <section><h2 id="middle">List</h2>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">First</th>
                            <th scope="col">Last</th>
                            <th scope="col">Handle</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>@twitter</td>
                        </tr>
                        </tbody>
                    </table>
                </section>
                <section><h2 id="bottom">Search</h2>
                    <form>
                        <input type="se"style="float:left">
                        <button class="float-right btn btn-outline-success" type="submit">Search</button>
                    </form>
                </section>
            </article>
        </main>

    </div>

</div>
</body>
</html>
