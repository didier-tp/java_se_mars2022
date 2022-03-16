package tp.j14;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import jdk.jfr.Configuration;
import jdk.jfr.consumer.EventStream;
import jdk.jfr.consumer.RecordingStream;//depuis java14
//https://openjdk.java.net/jeps/349

public class LiveMonitoring {

	public static void main(String[] args) {
		/*
		try (var rs = new RecordingStream()) {
		       rs.enable("jdk.CPULoad").withPeriod(Duration.ofMillis(5000));
		       rs.onEvent("jdk.CPULoad", event -> {
		         System.out.println(event.getFloat("machineTotal"));
		       });
		       rs.start();
		    }
         */
		/*
		 try (var rs = new RecordingStream()) {
			 rs.enable("jdk.GarbageCollection").withPeriod(Duration.ofMillis(30000));
			 rs.enable("jdk.CPULoad").withPeriod(Duration.ofMillis(30000));
			 rs.enable("jdk.JVMInformation").withPeriod(Duration.ofMillis(60000));
		     rs.onEvent("jdk.GarbageCollection", System.out::println);
		     rs.onEvent("jdk.CPULoad", System.out::println);
		     rs.onEvent("jdk.JVMInformation", System.out::println);
		     rs.start();
		 }
		 */
		
		try {
			Configuration config = Configuration.getConfiguration("default");
			//The base JFR configuration files (XML) can be found in JDK_HOME/lib/jfr.
			System.out.println(config.getDescription());
			System.out.println("settings:");
			config.getSettings().forEach((key, value) -> System.out.println(key+": "+value));

			// open a stream and start local recording
			try (EventStream es = new RecordingStream(config)) {

			    // register event handlers
			    es.onEvent("jdk.GarbageCollection", System.out::println);
			    es.onEvent("jdk.CPULoad", System.out::println);
			    es.onEvent("jdk.JVMInformation", System.out::println);

			    // start and block
			    es.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
