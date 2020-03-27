
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.hadoop.util.GenericOptionsParser;

public class MapReduce {

	private static void P(String s) {
		System.out.println(s);
	}

	private static void printHelp() {
		P("jar MapReduce /input/ /output/ (optional) /principal/ /keytab/");
		P("Example:");
		P("jar MapReduce input output user1@CENTOS.COM.REALM /home/sbartkowski/workspace/resttimeline/testyarnclient/etc/user1.keytab");
		System.exit(4);
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		{
			Configuration c = new Configuration();

			String[] files = new GenericOptionsParser(c, args).getRemainingArgs();
			if (files.length != 2 && files.length != 4)
				printHelp();
			Path input = new Path(files[0]);
			Path output = new Path(files[1]);
			if (files.length > 2) {
				c.set("hadoop.security.authentication", "Kerberos");
				UserGroupInformation.setConfiguration(c);
				UserGroupInformation.loginUserFromKeytab(files[2], files[3]);
			}

			Job j = new Job(c, "MyWordCount");

			j.setJarByClass(MapReduce.class);
			j.setMapperClass(MapJob.class);
			j.setReducerClass(ReduceJob.class);

			j.setMapOutputKeyClass(Text.class);
			j.setMapOutputValueClass(IntWritable.class);

			j.setOutputKeyClass(Text.class);
			j.setOutputValueClass(IntWritable.class);

			FileInputFormat.addInputPath(j, input);
			FileOutputFormat.setOutputPath(j, output);
			System.exit(j.waitForCompletion(true) ? 0 : 1);
		}
	}

}
