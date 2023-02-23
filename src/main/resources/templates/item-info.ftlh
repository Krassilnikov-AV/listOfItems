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
<b>Автор: </b><a href="/user/${item.user.id}">${item.user.name}</a><br>
</body>
</html>