set projectLocation=C:\Users\adhri\Desktop\NewFolder\Perseus
cd %projectLocation%
set classpath=%projectLocation%\lib\*;%projectLocatiom%\bin
java org.testng.TestNG %projectLocation%\testng.xml
pause