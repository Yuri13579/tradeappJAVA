<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title2</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<a href="<@spring.url '/index'/>">Home</a>


<div>
    <fieldset>
        <legend>Добавить клиента</legend>
        <div  class="table table-sm">
            <form name="customer" action="" method="POST">
                Название:<@spring.formInput "customerForm.name" "" "text"/>
                <br>
                Адрес:<@spring.formInput "customerForm.addres" "" "text"/>
                <br>
                Телефон:<@spring.formInput "customerForm.phone" "" "number"/>
                <br>
                Имя:<@spring.formInput "customerForm.contactPerson" "" "text"/>
                <br>

                <input type="submit" value="Create"/>
            </form>
        </div>
    </fieldset>
</div>

</body>
</html>