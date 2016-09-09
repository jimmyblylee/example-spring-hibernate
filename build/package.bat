@echo off
title Packaging verification-code-generator
call msg info "[INFO] Packaging verification-code-generator" & echo.

set BASEDIR=%~dp0

pushd %BASEDIR%\..\src
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