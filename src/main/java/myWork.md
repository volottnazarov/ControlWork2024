# Решение
### Задание 1

  Используя команду cat в терминале операционной системы Linux, создать
   два файла Домашние животные (заполнив файл собаками, кошками,
   хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
   ослы), а затем объединить их. Просмотреть содержимое созданного файла.
   Переименовать файл, дав ему новое имя (Друзья человека).

<span style="color:blue">mkdir animals</span>

<span style="color:blue">cd animals</span>

<span style="color:blue">cat > pets</span>

_вводим в терминале: собака кошка хомяк , жмём Ctrl+D_

<span style="color:blue">cat > packAnimals</span>

_вводим в терминале: лошадь верблюд осел , жмём Ctrl+D_

<span style="color:blue">cat pets packAnimals > allAnimals</span>

<span style="color:blue">cat allAnimals</span>

<span style="color:blue">mv allAnimals humanFriends</span>

<img alt="скриншот" src="./img/2024-07-06_00-22-21.png"/>


### Задание 2

Создать директорию, переместить файл туда.

<span style="color:blue">mkdir animals2</span>

<span style="color:blue">mv humanFriends /home/volott/animals/animals2/</span>

### Задание 3

Подключить дополнительный репозиторий MySQL. Установить любой пакет
   из этого репозитория.

_Скачиваем пакет настройки репозитория по ссылке ниже:_

https://dev.mysql.com/downloads/file/?id=531268

<span style="color:blue">cd Загрузки</span>

<span style="color:blue">sudo dpkg -i mysql-apt-config_0.8.32-1_all.deb</span>

<img alt="скриншот" src="./img/Установка MySQL.png"/>

<span style="color:blue">sudo apt update</span>

<img alt="скриншот" src="./img/Обновление MySQL.png"/>

<span style="color:blue">sudo apt install mysql-server</span>

<span style="color:blue">systemctl status mysql</span>

<img alt="скриншот" src="./img/Статус MySQL-server.png"/>

### Задание 4

Установить и удалить deb-пакет с помощью dpkg.

_Находим необходимый нам пакет или драйвер в интернете, например на сайте
launchpad.net и скачиваем его_

<span style="color:blue">cd Загрузки</span>

_копируем имя скаченного пакета_

<span style="color:blue">sudo dpkg -i</span> _вставляем имя_

_устанавливается пакет_

<span style="color:blue">sudo apt -f install</span> _если пакет установился с ошибками_

<img alt="скриншот" src="./img/Установка deb пакета.png"/>

_для удаления пакета, находим его в списке установленных_

<span style="color:blue">sudo dpkg -l | grep</span>  _слово из имени установленного пакета,
что бы отсеить не нужные_

_копируем имя установленного пакета из списка установленных_

<span style="color:blue">sudo dpkg -r имя пакета</span>

<img alt="скриншот" src="./img/Удаление deb пакета.png">

<span style="color:blue">sudo dpkg --purge имя пакета</span> , _удалим также конфигурационные файлы_

### Задание 7

В подключенном MySQL репозитории создать базу данных “Друзья
   человека”

<span style="color:blue">CREATE DATABASE IF NOT EXISTS</span> HumanFriends;

<span style="color:blue">USE</span> HumanFriends;

### Задание 8

Создать таблицы с иерархией из диаграммы в БД

[<u>переход к диаграмме</u>](img/diagram%20(2).png)


### Задания:

9. Заполнить низкоуровневые таблицы именами(животных), командами
   которые они выполняют и датами рождения
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
    питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
    11.Создать новую таблицу “молодые животные” в которую попадут все
    животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
    до месяца подсчитать возраст животных в новой таблице
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
    прошлую принадлежность к старым таблицам.

### можно просмотреть по ссылке:

[<u>Ссылка на SQL файл</u>](HumanFriends.sql)

















