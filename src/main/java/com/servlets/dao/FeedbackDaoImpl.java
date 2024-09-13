package com.servlets.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.servlets.dto.Feedback;

public class FeedbackDaoImpl implements FeedbackDao {
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public void save(Feedback feedback) {
		String q = "insert into feedback values(?,?,?)";
		jdbcTemplate.update(q, feedback.getEmailId(), feedback.getPhoneNo(), feedback.getFeedback());
	}

}
