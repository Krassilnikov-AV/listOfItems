<!DOCTYPE html>
<html>
<head>
	<title>ItemsRUS</title>
</head>
<body>
<h1>ItemsRUS</h1><hr>
<h3>Подробная информация о пользователе ${user.name}</h3>
<b>Номер телефона: </b> ${user.numberPhone}<br>
<b>Email: </b> ${user.email}<br>
<h4>Товары пользователя ${user.name}</h4>
<#list items as item>
	<div>
		<p><b>${item.title}</b> ${item.price} руб. | <a href="/item/${item.id}">Подробнее...</a></p>
	</div>
<#else>
	<h3>Товаров нет</h3>
</#list>
<#if errorMessage??>
	<h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>