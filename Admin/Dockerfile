FROM swr.cn-north-4.myhuaweicloud.com/ddn-k8s/docker.io/library/eclipse-temurin:21-jre

ENV TZ=Asia/Shanghai
ENV PARAMS="--spring.profiles.active=prod"

ENV JAVA_OPS="-XX:MaxRAMPercentage=70.0 \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=/tmp \
-XX:+ExitOnOutOfMemoryError \
-Xlog:gc*,gc+heap=info"

ADD build/libs/*.jar /admin.jar

ENTRYPOINT ["sh","-c","java -server \
-Dfile.encoding=UTF-8 \
-Duser.timezone=$TZ \
-Djava.security.egd=file:/dev/./urandom \
$JAVA_OPS \
-jar /admin.jar $PARAMS"]
