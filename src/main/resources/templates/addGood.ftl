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

<div>
    <fieldset>
        <legend>Добавить товар</legend>
        <form name="good" action="" method="POST">
            Название:<@spring.formInput "goodForm.name" "" "text"/>
            <br>
            цена продажная:<@spring.formInput "goodForm.price" "" "number"/>
            <br>
            цена закуп:<@spring.formInput "goodForm.purchasePrise" "" "number"/>
            <br>
            описание:<@spring.formInput "goodForm.description" "" "text"/>
            <br>

            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>