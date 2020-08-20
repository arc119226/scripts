prunsrv install ArcService ^
	--DisplayName="ArcService" ^
	--Install=%cd%\prunsrv.exe ^
	--JvmMx=1024M ^
	--JvmMs=256M ^
	--JvmMs=1M ^
	--Jvm=auto ^
	--StartMode=jvm ^
	--StopMode=jvm ^
	--Classpath=starter.jar ^
	--StartClass=com.arc.core.Starter ^
	--StartMethod=start ^
	--StopMode=jvm ^
	--StopClass=com.arc.core.Starter ^
	--StopMethod=stop ^
	--StdOutput=out.txt ^
	--StdError=error.txt
pause