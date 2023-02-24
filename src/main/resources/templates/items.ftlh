<#import "blocks/template.ftlh" as t>
<@t.template user>
	<h1 style="text-align: center">Поиск товаров</h1><hr>
	<form method="get" action="/">
		<div class="form-row">
			<div class="form-group col-md-2">
				<label for="searchCity">Город</label>
				<select id="searchCity" class="form-control">
					<option value="">Город не выбран</option>
					<option value="Москва">Москва</option>
					<option value="Красноярск">Красноярск</option>
					<option value="Казань">Казань</option>
				</select>
			</div>
			<div class="form-group col-md-10">
				<label for="searchWord">Поиск по объявлениям</label>
				<input type="text" name="searchWord" <#if searchWord??>value="${searchWord}"</#if> class="form-control"
					   id="searchWord">
			</div>
			<button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
		</div>
	</form>
	<hr>
	<div class="card-columns">
		<#list items as item>
			<a href="/item/${item.id}" class="item-link">
				<div class="card text-white bg-dark my-3 item">

					<img src="/images/${item.previewImageId}"
						 class="card-img-top">
					<div class="card-body">
						<h5 class="card-title">${item.title}</h5>
						<p class="card-text">${item.price} ₽</p>
					</div>
					<div class="card-footer">
						${item.city}
					</div>
				</div>
			</a>
		<#else>
			<h1 style="text-align: center">Не найдено</h1>
		</#list>
	</div>
</@t.template>