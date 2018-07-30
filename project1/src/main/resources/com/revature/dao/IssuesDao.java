package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IssuesDao {
	public List<Issues> getAllIssues(){
		PreparedStatement ps = null;
		Issues myIssues = null;
		List<Issues> issuesList = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ISSUES";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int issueId = rs.getInt("issue_id");
				String email = rs.getString("email");
				String issueTitle = rs.getString("issue_title");
				String issue = rs.getString("issue");
				String issueResponse = rs.getString("issue_response");
				boolean issueStatus = rs.getBoolean("issue_status");
				
				myIssues = new Issues(int issueId, String email, String issueTitle, String issue,
						String issueResponse, boolean issueStatus)
						issuesList.add(myIssues);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return issuesList;
	}
}