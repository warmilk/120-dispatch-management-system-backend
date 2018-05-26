```shell
cd C:\Users\Administrator\Desktop\毕业设计\project\crEmgcy120\crEmgcy120
mvn clean package ### 重新编译
java -jar -Dserver.port=8888 target\crEmgcy120.jar

```

```
"C:\Program Files\MySQL\MySQL Server 5.7\bin\mysql.exe" -u root -p
```
```密码是123456
use cr_emgcy  # 切换到cr_emgcy
show tables;
sql语句自行操作表
```



cmd窗口：
cd C:\Users\Administrator\Desktop\bysj\back-end\crEmgcy120
mvn clean package
java -jar -Dserver.port=8888 target\crEmgcy120.jar


打开phpstudy，开启Apache和mysql服务(ctrl+shift+esc 打开mysql服务)

cmd窗口：
"C:\Program Files\MySQL\MySQL Server 5.7\bin\mysql.exe" -u root -p
use cr_emgcy