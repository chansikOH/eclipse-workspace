package kr.co.hta.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.hta.hr.vo.Job;
import kr.co.hta.util.ConnectionUtils;

public class JobDao {

	public ArrayList<Job> selectAllJobs() throws Exception {
		ArrayList<Job> jobs = new ArrayList<Job>();
		
		String sql = "select job_id, job_title, min_salary, max_salary "
				+ "from jobs "
				+ "order by 1 ";
		
		Connection con = ConnectionUtils.hrConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Job job = new Job();
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			job.setMinSalary(rs.getInt("min_salary"));
			job.setMaxSalary(rs.getInt("max_salary"));
			
			jobs.add(job);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return jobs;
	}
	
}
