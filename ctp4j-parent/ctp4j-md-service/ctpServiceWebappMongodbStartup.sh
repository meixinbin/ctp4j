#!/bin/sh
##Linux执行.sh文件，提示No such file or directory的问题
##:set ff=unix
##保存退出: 
##:wq 


## java env
#export PATH=/usr/local/java/jdk1.7.0_72/bin:$PATH 
#export JAVA_HOME=/usr/local/java/jdk1.7.0_72
#export JRE_HOME=$JAVA_HOME/jre

## service name
APP_NAME=ctp-service-webapp-mongodb

SERVICE_DIR=/opt/javactp/md
SERVICE_NAME=$APP_NAME
JAR_NAME=$SERVICE_NAME\.jar
PID=$SERVICE_NAME\.pid

cd $SERVICE_DIR

case "$1" in

    start)
        nohup java -Xms64m -Xmx128m -jar $JAR_NAME >nohup.out 2>&1 &
        echo $! > $SERVICE_DIR/$PID
        echo "=== start $SERVICE_NAME"
        tail -f nohup.out
        ;;

    stop)
        kill 'cat $SERVICE_DIR/$PID'
        rm -rf $SERVICE_DIR/$PID
        echo "=== stop $SERVICE_NAME"

        sleep 5
        P_ID=`ps -ef | grep -w "$SERVICE_NAME" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME process not exists or stop success"
        else
            echo "=== $SERVICE_NAME process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME process, pid is:$P_ID"
            kill -9 $P_ID
        fi
        ;;

    restart)
        $0 stop
        sleep 2
        $0 start
        echo "=== restart $SERVICE_NAME"
        ;;

    *)
        ## restart
        $0 stop
        sleep 2
        $0 start
        ;;

esac
exit 0
