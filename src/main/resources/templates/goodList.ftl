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
    <h3>Список товаров</h3>
    <br>
    <div>

     <div class="table table-sm" style="width: 50%;">
        <table  class="table table-dark" border="2" >
            <thead>
            <tr >
                <th>Название</th>
                <th>Цена продажная</th>
                <th>Цена закупочная</th>
                <th>Описание</th>

            </tr>
            </thead>
            <#list goods as good>
            <tbody>
                <tr>
                    <td width="250">${good.name}</td>
                    <td>${good.price}</td>
                    <td>${good.purchasePrise}</td>
                    <td width="500"; style = font-size:6pt>${good.description}</td>
                    <td style = font-size:6pt><a href="/good/saleGood/${good.id}">Продажы по товару</a></td>
                    <td style = font-size:6pt><a href="/good/delete/${good.id}">Удалить</a> </td>
                    <td style = font-size:6pt><a href="/good/edit/${good.id}">Редактировать</a></td>
                </tr>
            </tbody>
            </#list>
        </table>
     </div>

    </div>

    <a href="/good/add" class="btn btn-primary">Add new good</a>


</body>
</html>