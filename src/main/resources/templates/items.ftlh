<!DOCTYPE html>
<html>
<head>
	<title>ItemsRUS</title>
</head>
<body>
<h1>ItemsRUS</h1>
<hr>
<h4>Товары со всей России</h4>
<form action="/" method="get">
	Поиск по названию объявления: <input type="text" name="title" value="0"><br>
	<input type="submit" value="Поиск"/>
</form>
<#list items as item>
	<div>
		<p><b>${item.title}</b> ${item.price} руб. | <a href="/item/${item.id}">Подробнее...</a></p>
	</div>
<#else>
	<h3>Товаров нет</h3>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/item/create" method="post">
	Название объявления: <input type="text" name="title"/><br><br>
	Описание объявления: <input type="text" name="description"/><br><br>
	Цена: <input type="number" name="price"/><br><br>
	Город: <input type="text" name="city"/><br><br>
	Имя: <input type="text" name="author"/><br><br>
	<input type="submit" value="Добавить товар"/>
</form>
</body>
</html>