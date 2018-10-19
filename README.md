# Мониторинг датчиков умного дома

## [Наше техническое задание](https://docs.google.com/document/d/1jECODOGwiMZTNoaF317uyLEgo2tcucP1GZAu7PmXeyc/edit?ts=5ba61bf8#)

## Описание продукта

Приложение, которое предназначено для сбора данных с датчиков, установленных в доме, удаленного управления состояниями датчиков и задания сценарий реагирования в зависимости от условий, определенных пользователем. 

## Что представляет собой продукт

Веб-страница в браузере, которая отображает текущее состояние датчиков, позволяет управлять ими.

## Стек технологий


 Java 8, Spring (Boot, MVC, Security), Gradle, Lombok, Docker, Mosquito, Web Socket, MQTT

## Оценка трудоёмкости прооекта

 Задачи | Роли | Количество человек | Время | Всего  
 --- | --- | --- | --- | ---
 `Этап анализа и сбора требований` | | | |
 Встречи с заказчиком для проведения интервью | вся команда | 4 | 3 раза по 1 часу | 12
 `Проектирование рещения` | | | |
 Написание ТЗ | вся команда | 4 | 7 часов | 28
 Написание архитектуры решения | вся команда | 4 | 2,5 часа | 10
 Обучение специалистов предметной области | вся команда | 4 | 40 часов |160 
 Установка сред разработки | программисты | 2 | 5 часов | 10
 Встречи с заказчиком | teamlead, программист | 6 раз по 1 часу | 12
 `Разаработка` | | | |
 Еженедельные встречи разработчиков | вся команда | 4 | 10 встреч по 3 часа | 120
 Программирование | вся команда | 4 | 100 часов | 400
 Проведение демонстрации | teamlead, программист | 2 | 5 раз по 2 часа | 20
 Доработка и исправление неисправностей(20% от разработки) | вся команда | 4 | | 80
 **Итого** | | | | 852
 `Дополнительно` | | | |
 Время на риски | | | 10% от разработки | 40
 Время на изменения | | | 10% от разработки | 40
 **Всего** | | | | **Приблизительно 932 часа**

  
 Базы данных.
 - Для пользователей
   - MySQL.
 - Для хранения состояния датчиков (в кэше)
   - Redis
 - Для хранения временных рядов
   - Cassandra 


## Архитектурная диаграмма

![Screenshot](https://github.com/YauheniReyantovich/SmartHouse/blob/master/src/main/resources/img/diagramm.png)


#### Build the project

In order to build the project install the node.js.

Then run:

```
npm install -g bower
```
```
npm install -g gulp-cli
```

In order to build the project itself run:

```
bower install
```
```
npm install
```
```
gulp build
```
```
./gradlew build
```

#### Run the project:

```
./gradlew build
```
```
./gradlew bootRun
```

Access http://localhost:8080

Or you can simply run:

```
java -jar ./build/libs/sample-0.0.1-SNAPSHOT.jar
```

By default the application uses embedded in-memory database H2. So you don't need to setup anything else for it.
In order to use PostgreSQL create a database sampledb.
It's assumed that it has postgres/postgres credentials. Otherwise, correct the configuration in application.yml.

Then run the application as described above but with _-Dspring.profiles.active=production_ option. It will create automatically all necessary tables and data.
 
#### Run the project in dev mode:

Start the backend part. Then run:
 
```
gulp
```

It will run the project in dev mode with active browser sync extension which automatically reload the browser upon any change. 
When you need to do a release after this you can run again:

```
./gradlew build
```

