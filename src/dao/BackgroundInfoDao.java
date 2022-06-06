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
	
	public void updateByName(BackgroundInfo backgroundInfo) { // 만약에 자주 일어난다면...
		
	}
	
	public void delete(BackgroundInfo backgroundInfo) {
		
	}
}
