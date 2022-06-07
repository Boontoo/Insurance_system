package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.backgroundInfo.BackgroundInfo;

public class BackgroundInfoDao extends Dao {
	public BackgroundInfoDao() {
		super.connect();
	}
	
	public boolean create(BackgroundInfo backgroundInfo) {
		// 쿼리 만들기
		String query = "insert into backgroundinfo (id, surveyResults, applyFrequency, trend) values (" +
						"'" + backgroundInfo.getId() + "', " +
						"'" + backgroundInfo.getSurveyResults() + "', " +
						"'" + backgroundInfo.getApplyFrequency() + "', " +
						"'" + backgroundInfo.getTrend() + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.create(query);
	}
	
	public boolean update(BackgroundInfo backgroundInfo) {
		// 쿼리 만들기
		String query = "update backgroundinfo set " + 
						"surveyResults='" + backgroundInfo.getSurveyResults() + "', " +
						"applyFrequency='" + backgroundInfo.getApplyFrequency() + "', " +
						"trend='" + backgroundInfo.getTrend() + "' " +
						"where id='" + backgroundInfo.getId() +"';";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.update(query);
	}
	
	public boolean delete(String id) {
		String query = "delete from backgroundinfo where id=" + id;
		return super.delete(query);
	}
	
	public ArrayList<BackgroundInfo> retrieveAll() {
		String query = "select * from backgroundinfo";
		ResultSet resultSet = super.retrieve(query);
		ArrayList<BackgroundInfo> backgroundInfoList = new ArrayList<BackgroundInfo>();
		try {
			while(resultSet.next()) {
				BackgroundInfo backgroundInfo = new BackgroundInfo();
				backgroundInfo.setId(resultSet.getString("id"));
				backgroundInfo.setSurveyResults(resultSet.getString("surveyResults"));
				backgroundInfo.setApplyFrequency(resultSet.getString("applyFrequency"));
				backgroundInfo.setTrend(resultSet.getString("trend"));
				backgroundInfoList.add(backgroundInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return backgroundInfoList;
	}
}
