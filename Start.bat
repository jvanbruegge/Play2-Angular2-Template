IF NOT EXIST %~dp0installed (
	npm i -g typescript
	gem install sass
	npm i
	echo. 2>installed
)

activator ui