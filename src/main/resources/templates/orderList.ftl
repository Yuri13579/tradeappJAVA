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
    <ul class="nav navbar-nav">
        <li class="active"><a href="<@spring.url '/index'/>">Home</a></li>
        <li><a href="/order/add" class="btn btn-primary">Добавить</a></li>
        <li><a href="<@spring.url '/order/summ'/>" class="list-group-item active">Сума всех заказов</a></li>
       </ul>



<h3>Список продаж</h3>
<div>
    <div class="table table-sm" style="width: 50%;">
        <table class="table table-dark" border="2">
            <thead>
            <tr>
                <th>Дата</th>
                <th>Товар</th>
                <th>Покупотель</th>
                <th>к-во</th>
                <th>цена</th>
                <th>сума</th>
                <th>Прибиль</th>
                <th>наценка</th>
            </tr>
            </thead>
            <#list orders as order>
            <tbody>
            <tr>
                <td width="150">${order.date}</td>
                <td width="250">${order.good.name}</td>
                <td width="200">${order.customer.name}</td>
                <td>${order.count}</td>
                <td>${order.priseSale}</td>
                <td>${order.margin?string.percent}</td>
                <td>${order.profit}</td>
                <td>${order.summ}</td>
                <td><a href="/order/delete/${order.id}">Delete</a> </td>
            </tr>
            </tbody>
            </#list>
        </table>
    </div>

</div>

<a href="/order/add" class="btn btn-primary">Add new order</a>


</body>
</html>