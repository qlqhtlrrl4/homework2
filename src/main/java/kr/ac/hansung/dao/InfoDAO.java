package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.InfoModel;

@Repository
public class InfoDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<InfoModel> getSemesterGrade() {

		String sqlStatement = "select year, semester, sum(grade) from subjected group by year, semester";

		return jdbcTemplate.query(sqlStatement, new RowMapper<InfoModel>() {

			@Override
			public InfoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				InfoModel infoModel = new InfoModel();

				infoModel.setYear(rs.getInt("year"));
				infoModel.setSemester(rs.getInt("semester"));
				infoModel.setGrade(rs.getInt("sum(grade)"));

				return infoModel;
			}

		});

	}

	public List<InfoModel> getcompleteGrade() {

		String sqlStatement = "select division, sum(grade) from subjected group by division";

		return jdbcTemplate.query(sqlStatement, new RowMapper<InfoModel>() {

			@Override
			public InfoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				InfoModel infoModel = new InfoModel();

				infoModel.setDivision(rs.getString("division"));
				infoModel.setGrade(rs.getInt("sum(grade)"));

				return infoModel;
			}

		});

	}

	public List<InfoModel> getshowDetails(int year, int semester) {

		String sqlStatement = "select year, semester, subjectCode, subjectName, division, grade from subjected where year=? and semester=?";

		return jdbcTemplate.query(sqlStatement, new Object[] {year, semester}, new RowMapper<InfoModel>(){

			@Override
			public InfoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				InfoModel infoModel = new InfoModel();
				
				infoModel.setYear(rs.getInt("year"));
				infoModel.setSemester(rs.getInt("semester"));
				infoModel.setSubjectCode(rs.getString("subjectCode"));
				infoModel.setSubjectName(rs.getString("subjectName"));
				infoModel.setDivision(rs.getString("division"));
				infoModel.setGrade(rs.getInt("grade"));

				return infoModel;
			}
		});

	}

	public boolean insert(InfoModel infoModel) {
		String subjectCode = infoModel.getSubjectCode();
		String subjectName = infoModel.getSubjectName();
		String division = infoModel.getDivision();
		int grade = infoModel.getGrade();

		String sqlStatement = "insert into subjected (year, semester, subjectCode, subjectName, division, grade) values (2019, 1, ?, ?, ?, ?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { subjectCode, subjectName, division, grade }) == 1);
		
	}	
	
	public List<InfoModel> get2019register() {
		String sqlStatement = "select year, semester, subjectCode, subjectName, division, grade from subjected where year=2019";

		return jdbcTemplate.query(sqlStatement, new RowMapper<InfoModel>() {

			@Override
			public InfoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				InfoModel infoModel = new InfoModel();

				infoModel.setYear(rs.getInt("year"));
				infoModel.setSemester(rs.getInt("semester"));
				infoModel.setSubjectCode(rs.getString("subjectCode"));
				infoModel.setSubjectName(rs.getString("subjectName"));
				infoModel.setDivision(rs.getString("division"));
				infoModel.setGrade(rs.getInt("grade"));

				return infoModel;
			}

		});
	}
}
