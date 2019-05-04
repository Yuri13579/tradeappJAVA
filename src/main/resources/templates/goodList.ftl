<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>

<body>
<a href="<@spring.url '/index'/>">Home</a>
    <h3>Good list</h3>
    <br>
    <div>
     <div class="table table-sm" style="width: 50%;">
        <table class="table table-dark">
            <thead>
            <tr>
                <th>Name</th>
                <th>Prise</th>
                <th>Delivery</th>
                <th>Description</th>
                <th>Delete</th>
            </tr>
            </thead>
            <#list goods as good>
            <tbody>
                <tr>
                    <td>${good.name}</td>
                    <td>${good.price}</td>
                    <td>${good.delivery}</td>
                    <td>${good.description}</td>
                    <td><a href="/good/saleGood/${good.id}">saleGood</a></td>
                    <td><a href="/good/delete/${good.id}">Delete</a> </td>
                    <td><a href="/good/edit/${good.id}">Edit</a></td>
                </tr>
            </tbody>
            </#list>
        </table>
     </div>

    </div>

    <a href="/good/add" class="btn btn-primary">Add new good</a>


</body>
</html>