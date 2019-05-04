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
<h3>Order list</h3>
<br>
<a href="/order/add" class="btn btn-primary">Add new order</a>
<div>
    <div class="table table-sm" style="width: 50%;">
        <table class="table table-dark">
            <thead>
            <tr>
                <th>Amount</th>
                <th>Date</th>
                <th>Good</th>
                <th>Customer</th>
                <th>Count</th>
                <th>Summ</th>
                <th>Delete</th>
            </tr>
            </thead>
            <#list orders as order>
            <tbody>
            <tr>
                <td>${order.amount}</td>
                <td>${order.date}</td>
                <td>${order.good.name}</td>
                <td>${order.customer.name}</td>
                <td>${order.count}</td>
                <td>${order.summ}</td>
                <td><a href="/good/delete/${order.id}">Delete</a> </td>
                <td><a href="/good/edit/${order.id}">Edit</a></td>

            </tr>
            </tbody>
            </#list>
        </table>
    </div>

</div>

<a href="/order/add" class="btn btn-primary">Add new order</a>


</body>
</html>