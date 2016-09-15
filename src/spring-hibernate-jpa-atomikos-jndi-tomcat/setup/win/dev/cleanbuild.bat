@echo off
title Doing clean build to all the Project
set BASEDIR=%~sdp0
call %BASEDIR%\setEnv.bat >NUL

pushd %PROJECT_HOME%
    call mvn clean package
popd

call beep.bat
timeout /t 1 >NUL 
call beep.bat
timeout /t 1 >NUL 
call beep.bat
timeout /t 1 >NUL 
call beep.bat
timeout /t 1 >NUL 
call beep.bat
timeout /t 1 >NUL 

timeout /t 10 >NUL 