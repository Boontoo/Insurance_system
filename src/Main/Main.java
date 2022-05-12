package Main;
import java.util.Scanner;

import Control.Control;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 오후 9:00:56
 */
public class Main {

	private Control control = new Control();

	public Main(){

	}

	public void finalize() throws Throwable {

	}

	private void manageCustomerInformation(Scanner scanner) {
		// 인배
	// ex
//		this.control.enquireCustomerInformation();
	}
	
	private void startContractMaintenanceActivities(Scanner scanner) {

	}
	
	private void payInsuranceFee(Scanner scanner) {

	}

	private void applyForMembership(Scanner scanner) {
		// 민재
	}
	
	private void startUW(Scanner scanner) {
		// 민재
	}
	
	private void joinInsurance(Scanner scanner) {
		// 민재
	}
	
	private void reinsurance(Scanner scanner) {
		// 민재
	}
	
	private void manageCompensationManagement(Scanner scanner) {

	}
	
	private void payInsuranceMoney(Scanner scanner) {

	}
	
	private void reportAccident(Scanner scanner) {
		// 민우
	}
	
	private void manageExpirationContract(Scanner scanner) {

	}
	
	private void managePaymentInformation(Scanner scanner) {

	}
	
	private void designInsuranceProduct(Scanner scanner) {
		this.requestAuthorization(scanner);
	}
	
	private void requestAuthorization(Scanner scanner) {

	}

	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("분산투자화재 보험 시스템입니다.");
			System.out.println("0.시스템 종료하기");
			System.out.println("1.고객정보 관리하기");
			System.out.println("2.계약유지활동 진행하기");
			System.out.println("3.월보험료 납입하기");
			System.out.println("4.가입신청 받기");
			System.out.println("5.인수심사 진행하기");
			System.out.println("6.보험 가입하기");
			System.out.println("7.재보험 처리하기");
			System.out.println("8.보상운용 관리하기");
			System.out.println("9.보험금 지급하기");
			System.out.println("10.사고 접수하기");
			System.out.println("11.만기계약 관리하기");
			System.out.println("12.납입정보 관리하기");
			System.out.println("13.보험 상품 설계하기");

			int choice = scanner.nextInt();
			
			if(choice == 0)
				break;
			switch(choice) {
				case 1:
					// 인배
					main.manageCustomerInformation(scanner);
					break;
				case 2:
					main.startContractMaintenanceActivities(scanner);
					break;
				case 3:
					main.payInsuranceFee(scanner);
					break;
				case 4:
					// 민재
					main.applyForMembership(scanner);
					break;
				case 5:
					// 민재
					main.startUW(scanner);
					break;
				case 6:
					// 민재
					main.joinInsurance(scanner);
					break;
				case 7:
					// 민재
					main.reinsurance(scanner);
					break;
				case 8:
					main.manageCompensationManagement(scanner);
					break;
				case 9:
					main.payInsuranceMoney(scanner);
					break;
				case 10:
					// 민우 사고접수 시나리오 보고 code 작성해오기.
					main.reportAccident(scanner);
					break;
				case 11:
					main.manageExpirationContract(scanner);
					break;
				case 12:
					main.managePaymentInformation(scanner);
					break;
				case 13:
					main.designInsuranceProduct(scanner);
					break;
				default :
					System.out.println("입력정보가 잘못되었습니다. 다시 메뉴를 선택해주세요.");
					break;
			}
		}
		scanner.close();
	}

	

}