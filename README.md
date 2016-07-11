
<h1><a aria-hidden="true" href="#CTP4J 基于Java的开源交易平台开发框架" class="anchor" id="user-content-CTP4J 基于Java的开源交易平台开发框架"></a>CTP4J 基于Java的开源交易平台开发框架</h1>

<hr>

<h3><a aria-hidden="true" href="#quick-start" class="anchor" id="user-content-quick-start"></a>Quick Start</h3>
<p></p>
<ol>
<li><p>准备一台Linux 64位系统的电脑</p></li>
<li><p>安装redis：下载最新版本的redis</p></li>
<li><p>安装<a href="https://www.mongodb.org/downloads#production">MongoDB</a></p></li>
<li><p>
下载本项目，把CTP目录拷贝到你的Linux服务器上，

例如:<BR>
/opt/javactp
把install.sh也放到同一个目录下

打开install.sh文件 修改Java代码生成路径及包名，并把jdk路径修改为你的jdk路径，然后运行，会在你的系统中生成两个so文件

libmdctp.so，libtraderctp.so<br>

行情接收服务：
行情数据存储在mongodb数据库中，对应的项目名称为ctp-md-service-webapp-mongodb

修改config_ctp.properties，config_db.properties，config_dubbo.properties，config_redis.properties这几个配置文件
其中：<br>
config_ctp.properties 是配置CTP连接信息的<br>
config_db.properties 是配置mongodb数据库信息的<br>
config_redis.properties 是配置redis数据库信息的
</p></li>
</ol>
<p>
CTP4J 技术交流QQ群
<br/>
群1：575559444
</p>
