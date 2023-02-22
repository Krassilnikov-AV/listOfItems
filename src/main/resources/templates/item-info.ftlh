<#--ко 2-му уроку-->
<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
<#--<title>ItemsRUS</title>-->
<#--</head>-->
<#--<body>-->
<#--<h1>ItemsRUS</h1><hr>-->
<#--<h4>Подробная информация о товаре</h4>-->
<#--<b>Название товара: </b>${item.title}<br>-->
<#--<b>Описание товара: </b>${item.description}<br>-->
<#--<b>Цена: </b>${item.price}<br>-->
<#--<b>Город: </b>${item.city}<br>-->
<#--<b>Автор: </b>${item.author}<br>-->
<#--<hr>-->
<#--<form action="/item/delete/${item.id}" method="post">-->
<#--<input type="submit" value="Удалить товар"/>-->
<#--</form>-->
<#--</body>-->
<#--</html>-->

<#--к 3-му уроку-->
<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
<#--<title>ItemsRUS</title>-->
<#--</head>-->
<#--<body>-->
<#--<h1>ItemsRUS</h1>-->
<#--<hr>-->
<#--<h4>Подробная информация о товаре</h4>-->

<#--<b>Название товара: </b>${item.title}<br>-->
<#--<b>Описание товара: </b>${item.description}<br>-->
<#--<b>Цена: </b>${item.price}<br>-->
<#--<b>Город: </b>${item.city}<br>-->
<#--<b>Автор: </b>${item.author}<br>-->

<#--<hr>-->
<#--<form action="/item/delete/${item.id}" method="post">-->
<#--<input type="submit" value="Удалить товар"/>-->
<#--</form>-->
<#--</body>-->
<#--</html>-->


<#--к 4-му уроку добавление картинок-->

<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
<#--<title>ItemsRUS</title>-->
<#--</head>-->
<#--<body>-->
<#--<h1>ItemsRUS</h1>-->
<#--<hr>-->
<#--<h4>Подробная информация о товаре</h4>-->
<#--<#list images as img>-->
	<#--<img src="/images/${img.id}" height="60px"/><br><br>-->
<#--</#list>-->

<#--<b>Название товара: </b>${item.title}<br>-->
<#--<b>Описание товара: </b>${item.description}<br>-->
<#--<b>Цена: </b>${item.price}<br>-->
<#--<b>Город: </b>${item.city}<br>-->
<#--<b>Автор: </b>${item.author}<br>-->
<#--<hr>-->
<#--<form action="/item/delete/${item.id}" method="post">-->
	<#--<input type="submit" value="Удалить товар"/>-->
<#--</form>-->
<#--</body>-->
<#--</html>-->

<#--к 5-му уроку добавление регистрации и авторизации-->
<!DOCTYPE html>
<html>
<head>
	<title>ItemsRUS</title>
</head>
<body>
<h1>ItemsRUS</h1><hr>
<h4>Подробная информация о товаре</h4>
<#list images as img>
	<img src="/images/${img.id}" height="60px"/><br><br>
</#list>
<b>Название товара: </b>${item.title}<br>
<b>Описание товара: </b>${item.description}<br>
<b>Цена: </b>${item.price}<br>
<b>Город: </b>${item.city}<br>
<b>Автор: </b>${item.author}<br>
<hr>
<form action="/item/delete/${item.id}" method="post">
	<input type="hidden" name="_csrf" value="${_csrf.token}">
	<input type="submit" value="Удалить товар"/>
</form>
</body>
</html>
