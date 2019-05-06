<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<a href="<@spring.url '/index'/>">Home</a>

<h3>Customer list</h3>
<br>
<div>
    <div class="table table-sm" >
    <table class="text-info" border="2">
        <thead>
            <th>Название</th>
            <th>Адрес</th>
            <th>телефон</th>
            <th>Имя</th>

        <thead>
            <#list customers as customer>
            <tbody>
                <tr>
                    <td width="250">${customer.name}</td>
                    <td>${customer.addres}</td>
                    <td>${customer.phone}</td>
                    <td>${customer.contactPerson}</td>
                    <td><a href="/customer/delete/${customer.id}">удалить</a> </td>
                    <td><a href="/customer/edit/${customer.id}">редакт</a></td> -->
                    <td><a href="/customer/saleCustomer/${customer.id}">продажы по клиенту</a></td>
                </tr>
            </tbody>
            </#list>
    </table>
    </div>
</div>

<a href="/customer/add">Add new customer</a>


</body>
</html>