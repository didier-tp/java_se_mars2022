REM se placer dans le répertoire courant:
cd /d %~dp0

REM MariaDB est une version complétement open source de MySQL (plus facile à installer)

set MYSQL_HOME=C:\Program Files\MariaDB 10.6


REM option -p pour demander à saisir le mot de passe (ex: root)
"%MYSQL_HOME%/bin/mysql" -u root -p < init_db.sql

pause