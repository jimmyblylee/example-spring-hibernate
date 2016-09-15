@echo off
set BASEDIR=%~sdp0
call %BASEDIR%\setEnv.bat

echo removing the old
rmdir /S /Q %TOMCAT_HOME%\webapps\test >NUL 2>NUL
del /F /Q %TOMCAT_HOME%\webapps\test.war >NUL
echo deploying the new
copy /Y %PROJECT_HOME%\target\test.war %TOMCAT_HOME%\webapps\test.war
echo done
timeout /t 1 >NUL 