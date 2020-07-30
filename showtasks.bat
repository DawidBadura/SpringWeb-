call runcrud.bat
if "%ERRORLEVEL%" == "0" goto getTasks
echo.
echo runcrud.bat has errors - breaking work
goto fail

:getTasks
set url="http://localhost:8080/crud/v1/task/getTasks"
start firefox.exe %url%
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.