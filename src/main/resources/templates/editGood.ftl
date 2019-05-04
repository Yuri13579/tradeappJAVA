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
<br>
<a href="<@spring.url '/good/list'/>">Good List</a>
<div>
    <fieldset>
        <legend>Add good</legend>
        <form name="good" action="" method="POST">
            name:<@spring.formInput "goodForm.name" "" "text"/>
            <br>
            price:<@spring.formInput "goodForm.price" "" "number"/>
            <br>
            delivery:<@spring.formInput "goodForm.delivery" "" "text"/>
            <br>
            description:<@spring.formInput "goodForm.description" "" "text"/>
            <br>
            <input type="submit" value="Edit"/>
        </form>
    </fieldset>
</div>

</body>
</html>
