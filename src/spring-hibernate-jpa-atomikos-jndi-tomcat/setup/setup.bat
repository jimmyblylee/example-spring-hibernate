@echo off

title Setup Local Development Env

:: current folder path
set currentdir=%~sdp0

:: logger
set msg=call %currentdir:~0,-7%\dev\msg.bat
set info=%msg% info
set warn=%msg% warn
set error=%msg% error

:: Project root path
set BASE_HOME=%currentdir:~0,-7%
echo %BASE_HOME%
set ARIA=%BASE_HOME%\setup\win\get\aria2c.exe -c -x 16 -j 10 -s 10
set ZIP=%BASE_HOME%\setup\win\7z\7z.exe

set PACKAGE=workspace-tomcat-package.zip

set PACKAGE_URL=https://raw.githubusercontent.com/jimmyblylee/workspace/master/dist/%PACKAGE%

set TEMP=%BASE_HOME%\setup\temp

rmdir /S /Q %TEMP% >NUL 2>NUL
mkdir %TEMP%
pushd %TEMP%
    %ARIA% -o %PACKAGE% "%PACKAGE_URL%"
    echo %TEMP%\%PACKAGE%
    %ZIP% x -o. %TEMP%\%PACKAGE%
    
    rmdir /S /Q %BASE_HOME%\workspace >NUL 2>NUL
    mkdir %BASE_HOME%\workspace
    xcopy /Y /e /h %BASE_HOME%\setup\common %TEMP%\workspace\common >NUL 2>NUL
    xcopy /Y /e /h %BASE_HOME%\setup\conf %TEMP%\workspace\conf >NUL 2>NUL
    xcopy /Y /e /h %BASE_HOME%\setup\win %TEMP%\workspace\win >NUL 2>NUL
    xcopy /Y /e /h %TEMP%\workspace %BASE_HOME%\workspace >NUL 2>NUL
popd

rmdir /S /Q %TEMP% >NUL 2>NUL

call %BASE_HOME%\workspace\win\setupWorkspace.bat