REM se placer dans le r�pertoire courant:
cd /d %~dp0

REM MariaDB est une version compl�tement open source de MySQL (plus facile � installer)

set MYSQL_HOME=C:\Program Files\MariaDB 10.6


REM option -p pour demander � saisir le mot de passe (ex: root)
"%MYSQL_HOME%/bin/mysql" -u root -p < init_db.sql

pause