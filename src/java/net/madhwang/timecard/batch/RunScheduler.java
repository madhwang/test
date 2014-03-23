package net.madhwang.timecard.batch;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunScheduler {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job timeStatsJob;

	public void run() {

		try {
			JobParameters param = new JobParametersBuilder().addString("date", new Date().toString()).toJobParameters();
			JobExecution execution = jobLauncher.run(timeStatsJob, param);
			System.out.println("Exit Status :" + execution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
