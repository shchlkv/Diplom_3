# Диплом (3 часть)

Тестирование UI учебного сервиса [Stellar Burgers](https://stellarburgers.nomoreparties.site/) в браузерах Google Chrome и Яндекс.Браузере

## Технологии:
Java
JUnit
Maven
Silenium

## Запуск

Клонировать репозиторий

git clone https://github.com/shchlkv/Diplom_3

Запуск тестов

`mvn clean test`

Просмотра отчета в Allure

`mvn allure:serve`

## Для проверки Яндекс.Браузера: 
- YandexWebDriver на [Github](https://github.com/yandex/YandexDriver/releases)
- положи yandexdriver.exe в локальный каталог на ПК   
- укажи путь к yandexdriver.exe : System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
ИЛИ
- положи yandexdriver.exe в каталог проекта \src\main\resources
- укажи путь к yandexdriver.exe: System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");


