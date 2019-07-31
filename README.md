# SampleMapReduce

Classic "wordcount" M/R Eclipse project to test connectivity.

# Eclipse project
Import project from GitHib. To execute, add Hadoop direcory *conf* to Java Class Path.

# Standalone, submit using yarn command
https://github.com/stanislawbartkowski/SampleMapReduce/blob/master/run.sh
> ./run.sh<br>

# Submit without yarn
https://github.com/stanislawbartkowski/SampleMapReduce/blob/master/runkerb.sh
>./runkerb.sh<br>

If Kerberos is not enabled or Kerberos ticket is obtained using *kinit* command, comment out KERB variables.

# Submit without yarn and Kerberos self-authenticate.
Obtain proper *keytab* file and modify KERB variables.
https://github.com/stanislawbartkowski/SampleMapReduce/blob/master/runkerb.sh
>./runkerb.sh
