#   Автотест страницы X5Group 

[![Typing SVG](https://readme-typing-svg.herokuapp.com?color=%2336BCF7&lines=Автотест+страницы+X5Group)](https://www.x5.ru/ru/)

<h2>  Cтек </h2>
<p align="center">
  <a href="https://www.jetbrains.com/idea/"><img width="6%" title="IDEA" src="materials/pictures/IDEA.png"> </a>
  <a href="https://selenide.org/"><img width="6%" title="Selenide" src="materials/pictures/Selenide.png"> </a>
  <a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="materials/pictures/Selenoid.png"> </a>
  <a href="https://gradle.org/"><img width="6%" title="Gradle" src="materials/pictures/Gradle.png"> </a>
  <a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="materials/pictures/Allure Report.png"> </a>
  <a href="https://github.com/"><img width="6%" title="GitHub" src="materials/pictures/GitHub.png"></a> 
  <a href="https://telegram.org"><img width="6%" title="Telegram" src="materials/pictures/Telegram.png"></a>
  <a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="materials/pictures/Jenkins.png"> </a>
  <a href="https://www.java.com/"><img width="6%" title="Java" src="materials/pictures/Java.png"></a>
  <a href="https://junit.org/junit5/"><img width="6%" title="junit5" src="materials/pictures/junit5.png"> </a>
</p>

## Проверки
- *Проверка разделов:*
- - *Планирование*
- - *Покупки*
- - *Доставка*
- - *Сервисы*
- - *Партнерам*
- - *Инвесторам*
- *Проверка поиска*
- *Проверка наличие подменю в меню:*
- - *Компания*
- - *Партнерам*
- - *Инвесторам*
- - *Пресс-центр*
- *Проверка кликабельности чекбоксов:*
- - *Я сотрудник*
- - *Я бывшый сотрудник*
- - *Я не сотрудник*

 
## <img width="5%" title="Jenkins" src="materials/pictures/Jenkins.png"> Сборка в Jenkins    
<p align="center">
<img width="60%" title="Jenkins Build" src="https://github.com/Taygib/X5Group_Test/blob/FiveTests/materials/screens/Jenkins Start.png?raw=true">
 </p>

## Запуск тестов

__*Локально, из терминала:*__
```
gradle clean x5GroupTests
```
__*Удаленно, из Jenkins:*__
```
clean
${TASK}
-Dbrowser=${Browser}
-DbrVersion=${BrVersion}
-DbrSize=${BrSize}
-DbaseUrl=${BaseUrl}
-Dselenoid=${Selenoid}
-DselenoidRemote=${SelenoidRemote}
```
## Отчет о прохождении тестов в Allure и Telegram

<h2> №1 Тест главной страницы </h2>

|        <img width="5%" title="Allure Report" src="materials/pictures/Allure Report.png" > Allure <img src="materials/screens/test%20%E2%84%961%20MainPage.png?raw=true">        | <img width="5%" title="Allure Report" src="materials/pictures/Allure Report.png" > Allure<img src="materials/screens/test%20%E2%84%961%20MainPage1.png?raw=true"> |
|:-------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------:|

<p align="center">
<img width="3%" title="Telegram" src="materials/pictures/Telegram.png">Telegram
</p>
<p align="center">
<img width="40%"  src="materials/screens/test%20%E2%84%961%20MainPage2%20Telegram.png?raw=true">                                                                            
 </p>

### <img width="5%" title="Selenoid" src="materials/pictures/Selenoid.png"> Видео теста на Selenoid


https://user-images.githubusercontent.com/105595414/225107084-5e28cb85-46b2-4166-a95b-b73f16108ce7.mp4


<h2> №2 Тест поиска </h2>

|<img width="5%" title="Allure Report" src="materials/pictures/Allure Report.png" > Allure![test №2 HeaderSearch.png](materials%2Fscreens%2Ftest%20%E2%84%962%20HeaderSearch.png)| <img width="5%" title="Allure Report" src="materials/pictures/Allure Report.png" > Allure![test №2 HeaderSearch1.png](materials%2Fscreens%2Ftest%20%E2%84%962%20HeaderSearch1.png)|
|:---:|:---:|
|<img width="5%" title="Telegram" src="materials/pictures/Telegram.png"> Telegram![test №2 HeaderSearch2 Telegram.png](materials%2Fscreens%2Ftest%20%E2%84%962%20HeaderSearch2%20Telegram.png)||

### <img width="5%" title="Selenoid" src="materials/pictures/Selenoid.png"> Видео теста на Selenoid

https://user-images.githubusercontent.com/105595414/225115497-60e318ce-768a-444b-826a-a6d5e9131ca1.mp4


<h2> №3 Тест содержания меню </h2>

| <img width="5%" title="Allure Report" src="materials/pictures/Allure Report.png" > Allure![test №3 menuContain.png](materials%2Fscreens%2Ftest%20%E2%84%963%20menuContain.png)  | <img width="5%" title="Allure Report" src="materials/pictures/Allure Report.png" > Allure![test №3 menuContain1.png](materials%2Fscreens%2Ftest%20%E2%84%963%20menuContain1.png) |
|:-----------------------------------------------------------------------------------------------------------:|:--------:|
| <img width="5%" title="Telegram" src="materials/pictures/Telegram.png"> Telegram![test №3 menuContain2 Telegram.png](materials%2Fscreens%2Ftest%20%E2%84%963%20menuContain2%20Telegram.png) |    |

### <img width="5%" title="Selenoid" src="materials/pictures/Selenoid.png"> Видео теста на Selenoid

https://user-images.githubusercontent.com/105595414/225117313-c7a4cd03-4778-4437-a4c0-3cb6495ffd8d.mp4

<h2> №4 Тест кликабельности чекбоксов </h2>

|<img width="5%" title="Allure Report" src="materials/pictures/Allure Report.png" > Allure![test №4 FeedBackEmployee.png](materials%2Fscreens%2Ftest%20%E2%84%964%20FeedBackEmployee.png)|<img width="5%" title="Allure Report" src="materials/pictures/Allure Report.png" > Allure![test №4 FeedBackEmployee1.png](materials%2Fscreens%2Ftest%20%E2%84%964%20FeedBackEmployee1.png)|
|:---:|:---:|
|<img width="5%" title="Telegram" src="materials/pictures/Telegram.png"> Telegram![test №4 FeedBackEmployee2 Telegram.png](materials%2Fscreens%2Ftest%20%E2%84%964%20FeedBackEmployee2%20Telegram.png)||

### <img width="5%" title="Selenoid" src="materials/pictures/Selenoid.png"> Видео теста на Selenoid

https://user-images.githubusercontent.com/105595414/225122657-60f841f9-0216-4920-83ca-64c76e8905ca.mp4

<h2> №5 прогон всех тестов </h2>

|      <img width="5%" title="Allure Report" src="materials/pictures/Allure Report.png" > Allure![test №5 AllTests.png](materials%2Fscreens%2Ftest%20%E2%84%965%20AllTests.png)      |      <img width="5%" title="Allure Report" src="materials/pictures/Allure Report.png" >    Allure![test №5 AllTests1-1.png](materials%2Fscreens%2Ftest%20%E2%84%965%20AllTests1-1.png)          |
|:-----------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------:|
|   <img width="5%" title="Telegram" src="materials/pictures/Telegram.png"> Telegram![test №5 AllTests2 Telegram.png](materials%2Fscreens%2Ftest%20%E2%84%965%20AllTests2%20Telegram.png) | |



