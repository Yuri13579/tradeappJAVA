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

<h1>Welcome</h1>

<br>
<div>

    <ul class="list-rectangle">

    <li><a href="<@spring.url '/good/list'/>" class="list-group-item" >Good List</a> </li>
    <li><a href="<@spring.url '/customer/list'/>" class="list-group-item active">customer List</a> </li>
    <li><a href="<@spring.url '/order/list'/>" class="list-group-item">order List</a> </li>
    <li><a href="<@spring.url '/order/summ'/>" class="list-group-item active">Сума всех заказов</a> </li>
</ul>
    <img src="https://www.advokatkopanchuk.com/wp-content/uploads/2017/02/588.jpg" class="rounded" alt="Cinque Terre" width="150" height="150" >

</div>






<br>



</body>
</html>