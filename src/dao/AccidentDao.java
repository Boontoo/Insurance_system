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
						"'" + accident.getID() + "', " +
						"'" + accident.getTowTruckCallNum() + "', " +
						"'" + accident.getLocation() + "', " +
						"'" + accident.getAccidentType() + "', " +
						"'" + payed + "', " +
						"'" + accident.getContractID() + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.create(query);
	}
	
	public boolean update(Accident accident) {
		String payed = "X"; // boolean 값 처리 방법
		if(accident.isPayed()) payed = "O";
		String query = "update accident set " + 
						"towTruckCallNum='" + accident.getTowTruckCallNum() + "', " +
						"location='" + accident.getLocation() + "', " +
						"accidentType='" + accident.getAccidentType() + "', " +
						"payed='" + payed + "', " +
						"contractID='" + accident.getContractID() + "' " +
						"where id='" + accident.getID() +"';";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.update(query);
	}
	
	public boolean delete(String id) {
		String query = "delete from accident where id=" + id;
		return super.delete(query);
	}
}
