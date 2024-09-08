# Решение
### Задание 1

  Используя команду cat в терминале операционной системы Linux, создать
   два файла Домашние животные (заполнив файл собаками, кошками,
   хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
   ослы), а затем объединить их. Просмотреть содержимое созданного файла.
   Переименовать файл, дав ему новое имя (Друзья человека).
  
_mkdir animals_

_cd animals_

_cat > pets_

_вводим в терминале: собака кошка хомяк , жмём Ctrl+D_

_cat > packAnimals_

_вводим в терминале: лошадь верблюд осел , жмём Ctrl+D_

_cat pets packAnimals > allAnimals_

_cat allAnimals_

_mv allAnimals humanFriends_

<img alt="скриншот" src="./img/2024-07-06_00-22-21.png"/>


### Задание 2

Создать директорию, переместить файл туда.

_mkdir animals2_

_mv humanFriends /home/volott/animals/animals2/_

### Задание 3

Подключить дополнительный репозиторий MySQL. Установить любой пакет
   из этого репозитория.

_Скачиваем пакет настройки репозитория по ссылке ниже:_

https://dev.mysql.com/downloads/file/?id=531268

_cd Загрузки_

_sudo dpkg -i mysql-apt-config_0.8.32-1_all.deb_

<img alt="скриншот" src="./img/Установка MySQL.png"/>

_sudo apt update_

<img alt="скриншот" src="./img/Обновление MySQL.png"/>

_sudo apt install mysql-server_

_systemctl status mysql_

<img alt="скриншот" src="./img/Статус MySQL-server.png"/>










