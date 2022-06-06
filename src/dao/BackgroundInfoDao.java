package dao;

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
}
