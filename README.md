## Задание

Создать сервис, который обращается к сервису курсов валют, и отображает gif:<br>
• если курс по отношению к USD за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich<br>
• если ниже - отсюда https://giphy.com/search/broke<br>
Ссылки<br>
• REST API курсов валют - https://docs.openexchangerates.org/<br>
• REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide<br>
Must Have<br>
• Сервис на Spring Boot 2 + Java / Kotlin<br>
• Запросы приходят на HTTP endpoint (должен быть написан в соответствии с rest conventions), туда передается код валюты по отношению с которой сравнивается USD<br>
• Для взаимодействия с внешними сервисами используется Feign<br>
• Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки<br>
• На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock)<br>
• Для сборки должен использоваться Gradle<br>
• Результатом выполнения должен быть репо на GitHub с инструкцией по запуску<br>
Nice to Have<br>
• Сборка и запуск Docker контейнера с этим сервисом<br>

## Api
EndPoint для получения gif: <br>
GET: http://localhost:9000/giphy-app/api/random-gif?currency=COMPARED_CURRENCY<br>
COMPARED_CURRENCY = RUB, EUR, CNY ,INR и т.д.

## Контроллер с фронтом доступен по адресу:
> http://localhost:9000/giphy-app/get-gif
> 

## Запуск

Запуск jar находясь в корне проекта:

> java -jar AlfaGiphy-0.0.1-SNAPSHOT.jar

Docker:<br>
Для создания образа Docker, находясь в корне проекта:  
> docker build -t ivanbelov/alfa-giphy-docker:v1.0 . 
> 
Запуск контейнера с образом:   
> docker run -d -p 9000:9000 ivanbelov/alfa-giphy-docker:v1.0 
> 
Получить образ с DockerHub:  
>docker pull ivanbelov/alfa-giphy-docker:v1.0 

Остановить контейнер:
> docker stop CONTAINER_ID

