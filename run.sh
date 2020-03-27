hdfs dfs -rm -r -f output
hdfs dfs -mkdir -p input
hdfs dfs -copyFromLocal input/input.txt input
yarn jar target/SampleMapReduce-1.0-SNAPSHOT.jar MapReduce input output 
