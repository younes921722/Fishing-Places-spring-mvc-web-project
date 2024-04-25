<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fishing Place Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        /* Custom styles */
        
        .navbar {
            background-color: #008000;
            color:#008000;
        }
        .navbar-brand,
        .navbar-nav .nav-link {
            color: #008000;
        }
        .container {
            padding: 20px;
            background-color: #ffffff;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            border-radius: 4px;
            border: 1px solid #28a745;
        }
        button[type="submit"],
        button[type="reset"] {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            background-color: #28a745;
            color: #fff;
            cursor: pointer;
        }
        button[type="submit"]:hover,
        button[type="reset"]:hover {
            background-color: #1c7430;
        }
        .table-container {
            max-height: 200px;
            overflow-y: auto;
        }
        table {
            color: #28a745;
        }
    </style>
</head>
<body>

    <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="home">Fishing Place</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/allfichingPlaces">All Fishing Places</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" aria-disabled="true">Disabled</a>
        </li>
      </ul>
      <form method="POST" action="${pageContext.request.contextPath}/serachFishingplace" class="d-flex" role="search">
        <input name="keyword" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

	<c:if test="${showForm}">
    <div class="container">
        <h2 class="text-center">Fishing Place Form</h2>
        <f:form action="${pageContext.request.contextPath}/${action}" method="POST" modelAttribute="locationModel">
            <div class="form-group">
            </div>
            <div class="form-group">
                <label>Location:</label>
                <f:input path="localisation" type="text" name="location" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Depth:</label>
                <f:input path="profondeur" type="text" id="depth" name="depth" class="form-control"/>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-success">Submit</button>
                <button type="reset" class="btn btn-success">Reset</button>
            </div>
        </f:form>
    </div>
	</c:if>
    <div class="container">
    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">Localisation</th>
                <th scope="col">Profondeur</th>
            </tr>
        </thead>
    </table>
        <div class="container">
    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">Localisation</th>
                <th scope="col">Profondeur</th>
                <th scope="col">Actions</th> <!-- Added column for actions -->
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${locationList}" var="p">
                <tr>
                    <td><c:out value="${p.localisation}" /></td>
                    <td><c:out value="${p.profondeur}" /></td>
                    <td>
                        <div class="btn-group" role="group" aria-label="Basic example">
                            <!-- Delete button -->
                            <a href="deleteLocation/${p.id}" class="btn btn-danger">Delete</a>
                            <!-- Update button -->
                            <a href="updateLocation/${p.id}" class="btn btn-success">Update</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

    </div>
    
    <!-- Bootstrap JS -->
   <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <!-- Custom JS -->
    <script>
        // Reset form after submission
        document.getElementById('locationForm').addEventListener('submit', function() {
            this.reset();
        });
    </script>
</body>
</html>
                
                    