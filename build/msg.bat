@echo off
@rem ***************************************************************************
@rem This script is using the findstr command to make message colourful, the message should not contain char of "\/:*?"<>|"
@rem First, write two backwards char(ASCII 8) into a file named with the given message(That's why we should not putting "\/:*?"<>|" in the message).
@rem Then, we run findstr command to show it.
@rem Finally, we delete the new file named by given message
@rem Examples: 
@rem  1. one line message command: msg error "[ERROR] hello world"
@rem  2. two colour message by one line command: msg error "[ERROR]-" & msg warn "Hello world!"
@rem ***************************************************************************
set THE_MESSAGE_NEED_TO_SET_COLOR=%~2
if not "%THE_MESSAGE_NEED_TO_SET_COLOR:\=%" == "%THE_MESSAGE_NEED_TO_SET_COLOR%" (echo %~2 & goto :eof)
if not "%THE_MESSAGE_NEED_TO_SET_COLOR:/=%" == "%THE_MESSAGE_NEED_TO_SET_COLOR%" (echo %~2 & goto :eof)
if not "%THE_MESSAGE_NEED_TO_SET_COLOR::=%" == "%THE_MESSAGE_NEED_TO_SET_COLOR%" (echo %~2 & goto :eof)
::if not "%THE_MESSAGE_NEED_TO_SET_COLOR:^*=%" == "%THE_MESSAGE_NEED_TO_SET_COLOR%" (echo %~2 & goto :eof)
if not "%THE_MESSAGE_NEED_TO_SET_COLOR:?=%" == "%THE_MESSAGE_NEED_TO_SET_COLOR%" (echo %~2 & goto :eof)
if not "%THE_MESSAGE_NEED_TO_SET_COLOR:<=%" == "%THE_MESSAGE_NEED_TO_SET_COLOR%" (echo %~2 & goto :eof)
if not "%THE_MESSAGE_NEED_TO_SET_COLOR:>=%" == "%THE_MESSAGE_NEED_TO_SET_COLOR%" (echo %~2 & goto :eof)
if not "%THE_MESSAGE_NEED_TO_SET_COLOR::=%" == "%THE_MESSAGE_NEED_TO_SET_COLOR%" (echo %~2 & goto :eof)

if "%~1" == "error" call :ColorText 0C "%~2"
if "%~1" == "warn" call :ColorText 0E "%~2"
if "%~1" == "info" call :ColorText 0B "%~2"

goto :eof

:ColorText
<nul set /p ".=  " > "%~2"
findstr /v /a:%1 /R "^$" "%~2" nul
del "%~2" > nul 2>&1
goto :eof
:end