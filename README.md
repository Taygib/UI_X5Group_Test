#   Автотест страницы X5Group 

[![Typing SVG](https://readme-typing-svg.herokuapp.com?color=%2336BCF7&lines=Автотест+страницы+X5Group)](https://www.x5.ru/ru/)

<h2>  :hammer_and_wrench: Cтек </h2>
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

## :page_with_curl: Проверки
- *Проверка разделов:*
- - *Планирование*
- - *Покупки*
- - *Доставка*
- - *Сервисы*
- - *Партнерам*
- - *Инвесторам*
- *Проверка поиска*
- *Проверка наличие подменю в меню главной страницы:*
- - *Компания*
- - *Партнерам*
- - *Инвесторам*
- - *Пресс-центр*
- *Проверка кликабельности чекбоксов в разделе Обратная связь:*
- - *Я сотрудник*
- - *Я бывший сотрудник*
- - *Я не сотрудник*
- *Проверка контактной информации:*
- - *Номер телефона*
- - *Адрес*
- *Проверка страниц социальных сетей:*
- - *Телеграм*
- - *VK*
- - *Dzen*
- - *TenChat*

 
##  <img width="5%" title="Jenkins" src="materials/pictures/Jenkins.png"> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/Students/job/testX5Group/)  :gear:  
<p align="center">
<img width="70%" title="Jenkins Build" src="materials/screens/Jenkins Start.png?raw=true">
 </p>

## :rocket: Запуск тестов

__*Локально, из терминала:*__
```
gradle clean test
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
### Фаил test.properties
для запуска теста локально нужно создать фаил в папке resources (src/test/resources) и необходимо указать следующее параметры 
```
selenoid_UserName = UserName
selenoid_Password = Password
selenoid_Url = Url
```
## :bar_chart: Пример отчета о прохождении тестов в Allure и Telegram


|        <img width="5%" title="Allure Report" src="materials/pictures/Allure Report.png" > Allure <img src="materials/screens/test%20%E2%84%961%20MainPage.png?raw=true">        | <img width="5%" title="Allure Report" src="materials/pictures/Allure Report.png" > Allure<img src="materials/screens/test%20%E2%84%961%20MainPage1.png?raw=true"> |
|:-------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------:|

<p align="center">
<img width="3%" title="Telegram" src="materials/pictures/Telegram.png">Telegram
</p>
<p align="center">
<img width="45%"  src="materials/screens/test%20%E2%84%961%20MainPage2%20Telegram.png?raw=true">                                                                            
 </p>

### <img width="5%" title="Selenoid" src="materials/pictures/Selenoid.png"> Видео теста на Selenoid


https://user-images.githubusercontent.com/105595414/225107084-5e28cb85-46b2-4166-a95b-b73f16108ce7.mp4 





