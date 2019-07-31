hdfs dfs -rm -r output
HADOOP_CLIENT=/usr/hdp/current/hadoop-client
CONF=/etc/hadoop/conf
HDP_VERSION=3.1.0.0-78
KERB_PRINCIPAL=user1@CENTOS.COM.REALM
KERB_KEYTAB=/home/user1/user1.keytab
java -Dhdp.version=$HDP_VERSION -cp jar/WordCount.jar:$HADOOP_CLIENT/*:$HADOOP_CLIENT/client/*:$CONF MapReduce input output $KERB_PRINCIPAL $KERB_KEYTAB
