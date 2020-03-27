hdfs dfs -rm -r -f output
HADOOP_CLIENT=/usr/hdp/current/hadoop-client
CONF=/etc/hadoop/conf
HDP_VERSION=3.1.0.0-78
KERB_PRINCIPAL=bench@CENTOS.COM.REALM
KERB_KEYTAB=$HOME/bin/security/bench.keytab
#java -Dhdp.version=$HDP_VERSION -cp target/SampleMapReduce-1.0-SNAPSHOT.jar:$HADOOP_CLIENT/*:$HADOOP_CLIENT/client/*:$CONF MapReduce input output $KERB_PRINCIPAL $KERB_KEYTAB
yarn jar target/SampleMapReduce-1.0-SNAPSHOT.jar MapReduce input output $KERB_PRINCIPAL $KERB_KEYTAB
