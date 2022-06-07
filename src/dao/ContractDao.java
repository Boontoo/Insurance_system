package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.contract.Contract;

public class ContractDao extends Dao {
	public ContractDao() {
		super.connect();
	}
	
	public boolean create(Contract contract) {
		// 쿼리 만들기
		String payStatus = "X"; // boolean 값 처리 방법
		String renewConsult = "X";
		if(contract.isPayStatus()) payStatus = "O";
		if(contract.isRenewConsult()) renewConsult = "O";
		String query = "insert into contract (id, customerId, insuranceId, expirationDate, totalPayAmount, payAmount, payStatus, renewConsult) values (" +
						"'" + contract.getId() + "', " +
						"'" + contract.getCustomerID() + "', " +
						"'" + contract.getInsuranceID() + "', " +
						"'" + contract.getExpirationDate() + "', " +
						"'" + contract.getTotalPayAmount() + "', " +
						"'" + contract.getPayAmount() + "', " +
						"'" + payStatus + "', " +
						"'" + renewConsult + "');";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.create(query);
	}
	
	public boolean update(Contract contract) { // 만약에 자주 일어난다면...
		// 쿼리 만들기
		String payStatus = "X"; // boolean 값 처리 방법
		String renewConsult = "X";
		if(contract.isPayStatus()) payStatus = "O";
		if(contract.isRenewConsult()) renewConsult = "O";
		String query = "update contract set " + 
						"customerId='" + contract.getCustomerID() + "', " +
						"insuranceId='" + contract.getInsuranceID() + "', " +
						"expirationDate='" + contract.getExpirationDate() + "', " +
						"totalPayAmount='" + contract.getTotalPayAmount() + "', " +
						"payAmount='" + contract.getPayAmount() + "', " +
						"payStatus='" + payStatus + "', " +
						"renewConsult='" + renewConsult + "' " +
						"where id='" + contract.getId() +"';";
		System.out.println(query);
		
		// 쿼리 실행하기
		return super.update(query);
	}
	
	public boolean delete(String id) {
		String query = "delete from contract where id=" + id;
		return super.delete(query);
	}
	
	public ArrayList<Contract> retrieveAll() {
		String query = "select * from contract";
		ResultSet resultSet = super.retrieve(query);
		ArrayList<Contract> contractList = new ArrayList<Contract>();
		try {
			while(resultSet.next()) {
				Contract contract = new Contract();
				contract.setId(resultSet.getString("id"));
				contract.setCustomerID(resultSet.getString("customerId"));
				contract.setInsuranceID(resultSet.getString("insuranceId"));
				contract.setExpirationDate(resultSet.getString("expirationDate"));
				contract.setTotalPayAmount(resultSet.getInt("totalPayAmount"));
				contract.setPayAmount(resultSet.getInt("payAmount"));
				String payStatus = resultSet.getString("payStatus");
				if(payStatus == "X") contract.setPayStatus(true);
				else if(payStatus == "O") contract.setPayStatus(true);
				contract.setId(resultSet.getString("renewConsult"));
				contractList.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contractList;
	}
}
