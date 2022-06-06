package dao;

import Model.accident.Accident;

public class AccidentDao extends Dao {
	public AccidentDao() {
		super.connect();
	}
	
	public boolean create(Accident accident) {
		// 쿼리 만들기
		String payed = "X"; // boolean 값 처리 방법
		if(accident.isPayed()) payed = "O";
		String query = "insert into accident (id, towTruckCallNum, location, accidentType, payed, contractID) values (" +
						"'" + accident.getId() + "', " +
						"'" + accident.getTowTruckCallNum() + "', " +
						"'" + accident.getLocation() + "', " +
						"'" + accident.getAccidentType() + "', " +
						"'" + payed + "', " +
						"'" + accident.getContractID() + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.create(query);
	}
	
	public void updateByName(Accident accident) { // 만약에 자주 일어난다면...
		
	}
	
	public void delete(Accident accident) {
		
	}
}
