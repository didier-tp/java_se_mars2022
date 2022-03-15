cd /d "%~dp0"
REM cd ..
REM mvn package
REM cd /scripts
copy ..\mod_main\target\mod_main.jar .\my_modules
copy ..\mod_gui\target\mod_gui.jar .\my_modules
copy ..\mod_compute\target\mod_compute.jar .\my_modules

pause