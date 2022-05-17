package Main;
import java.util.InputMismatchException;
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
		// 민재 - 가입 신청 받기
		System.out.println("가입신청을 진행하시겠습니까? (1.진행, 그 이외.뒤로가기)");
		if(scanner.nextInt() != 1) return; 
		while(true) {
			try {
				System.out.print("고객 이름 : ");
				String name = scanner.next();
				System.out.print("가입 희망 보험 : ");
				String insurance = scanner.next();
				System.out.print("전화번호 : ");
				String phoneNum = scanner.next();
				System.out.print("나이 : ");
				int age = scanner.nextInt();
				System.out.print("성별(1.남자, 그 이외.여자) : ");
				boolean gender = (scanner.nextInt() == 1);
				System.out.print("직업 : ");
				String jop = scanner.next();
				System.out.print("주민번호 : ");
				String SSN = scanner.next();
				boolean result = this.control.applyForMembership(insurance, phoneNum, age, gender, name, jop, SSN);
				if(!result) {
					System.out.println("올바른 형식에 맞게 입력하세요");
					continue;
				}else {
					System.out.println("가입 신청이 정상적으로 진행됩니다");
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("올바른 값을 입력해 주세요");
				// 위 상황 발생시 고객이름 입력이 스킵됨 - 이거 해결해야 함
				continue;
			}
		}
		System.out.println("==================================");
	}
	
	
	
	private void startUW(Scanner scanner) {
		// 민재 - 인수심사 진행하기
		while(true) {
			try {
				System.out.println(control.enquireInformationAboutApplicationForMembership());
				System.out.print("선택번호를 입력해 주세요(0 : 뒤로가기) : ");
				int choice = scanner.nextInt();
				if(choice == 0) return;
				boolean checkInID = control.checkInID(choice + "");
				if(!checkInID) {
					System.out.println("선택번호 내 번호를 다시 입력해 주세요");
					continue;
				}
				System.out.println("입력 번호 : " + choice);
				boolean automaticExaminationResult = startAutomaticJudge(scanner, choice + "");
				System.out.print("진단심사 결과(1.합격, 그이외.불합격) : ");
				boolean diagnosticExaminationResult = (scanner.nextInt()==1);
				System.out.print("이미지심사 결과(1.합격, 그이외.불합격) : ");
				boolean imageExaminationResult = (scanner.nextInt()==1);
				System.out.print("특인심사 결과(1.합격, 그이외.불합격) : ");
				boolean specialExaminationResult = (scanner.nextInt()==1);
				System.out.print("일반심사 결과(1.합격, 그이외.불합격) : ");
				boolean generalExaminationResult = (scanner.nextInt()==1);
				String uwResult = control.enquireUWResult(choice + "", automaticExaminationResult, diagnosticExaminationResult, 
						imageExaminationResult, specialExaminationResult, generalExaminationResult);
				System.out.println(uwResult);
				break;
			}catch(InputMismatchException e) {
				System.out.println("올바른 값을 입력해 주세요");
				// 무한루프 발생 - 이거 해결해야 함
				continue;
			}
		}
	}

	private boolean startAutomaticJudge(Scanner scanner, String id) throws InputMismatchException{
		// 새로 만든 함수
		while(true) {
			System.out.print("본인 소유의 건물(1.예, 그이외.아니오) : ");
			boolean isOwnedBuilding = (scanner.nextInt()==1);
			System.out.print("리모델링 여부(1.예, 그이외.아니오) : ");
			boolean isRemodeling = (scanner.nextInt()==1);
			System.out.print("건물 연식(점수 입력) : ");
			int buildingAgeScore = scanner.nextInt();
			System.out.print("화재 설비 상태(점수 입력) : ");
			int fireEquipmentConditionScore = scanner.nextInt();
			System.out.print("건물 위치(점수 입력) : ");
			int buildingLocationScore = scanner.nextInt();
			System.out.print("건물 가격(점수 입력) : ");
			int buildingConditionScore = scanner.nextInt();
			//파라미터 길이 줄일 것
			if(!control.checkPointInput(buildingAgeScore, fireEquipmentConditionScore, 
					buildingLocationScore, buildingConditionScore)) {
				System.out.println("범위에 맞는 가격을 다시 적어주세요");
				continue;
			}
			return control.automaticJudge(id, isOwnedBuilding, isRemodeling, buildingAgeScore, 
					fireEquipmentConditionScore, buildingLocationScore, buildingConditionScore);
		}
		
	}
	
	private void joinInsurance(Scanner scanner) {
		// 민재 - 보험 가입하기
	}
	
	private void reinsurance(Scanner scanner) {
		// 민재 - 재보험 처리하기(할 수 있으면)
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
//			try { 정수가 아니라 다른 값 입력시 예외 처리 구현 - 다들 같이 있을 때 논의해볼 것
//				
//			}catch(InputMismatchException e) {
//				System.out.println("정수를 입력해 주세요");
//				continue;
//			}
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
					// 민우
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