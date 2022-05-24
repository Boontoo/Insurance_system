package Main;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

import AccidentReception.AccidentReception;
import Control.Control;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 오후 9:00:56
 */
public class Main {

	private Control control = new Control();

	public static ArrayList<AccidentReception> accidentUserList = new ArrayList<AccidentReception>(); 

	public Main(){

	}

	public void finalize() throws Throwable {

	}

	private void manageCustomerInformation(Scanner scanner) {
		// 인배
		boolean bOnLoop = true;
		while(bOnLoop) {
			System.out.println("고객정보관리하기 메뉴입니다.");
			System.out.println("1.고객정보조회");
			System.out.println("2.메인페이지로 돌아가기");
			int choice = scanner.nextInt();

			switch(choice) {
				case 1:
					System.out.println("조회할 고객 정보의 검색 조건을 선택하세요.");
					System.out.println("1.이름");
					System.out.println("2.나이");
					System.out.println("3.성별");
					System.out.println("4.생년월일");
					int type = scanner.nextInt();
					System.out.println("조회할 고객 정보를 입력하세요.");
					String key = scanner.next();
					System.out.println(this.control.enquireCustomerInformation(type, key));
					//if null 필요
					System.out.println("세부정보를 확인할 고객의 번호를 입력하세요.");
					int index = scanner.nextInt();
					System.out.println(this.control.enquireCustomerDetailInformation(index));
	
					this.modifyOrDeleteCustomerInformation(scanner, bOnLoop, index);
					break;
					//		   			bOnLoop = false;
				case 2:
					bOnLoop = false;
					break;
				default:
					System.out.println("잘못 선택하셨습니다. 다시 선택해주세요.");
					break;
			}
		}
	}

	private void modifyOrDeleteCustomerInformation(Scanner scanner, boolean bOnLoop, int index) {
		//		boolean bOnLoop = true;
		while(true) {
			System.out.println("1.고객 정보를 수정한다.");
			System.out.println("2.고객 정보를 삭제한다.");
			System.out.println("3.고객 정보 재조회");
			int choice = scanner.nextInt();
			switch(choice) {
				case 1:
					System.out.println("고객 정보를 수정한다.");
					while(true) {
						System.out.println("어떤 정보를 수정하시겠습니까?");
						System.out.println("1.이름");
						System.out.println("2.나이");
						System.out.println("3.직업");
						System.out.println("4.전화번호");
						//	   				System.out.println();
						int type = scanner.nextInt();
						System.out.println("새로운 정보를 입력해주세요.");
						String newInformation = scanner.next();
						if(newInformation != null) {
							//////////////////////////
							System.out.println(control.checkCustomerInformation(index, choice, newInformation));
							System.out.println("1.저장");
							System.out.println("2.재작성");
							choice = scanner.nextInt();
							//							switch(choose)
							if(choice == 1) {
								System.out.println(control.modifyCustomerInformation(index, type, newInformation));
								System.out.println(this.control.enquireCustomerDetailInformation(index));
								return;
								//								bOnLoop = false;
							}
							else if(choice == 2) {
								break;
							}
						} else {
							System.out.println("수정 정보를 다시 입력해주세요.");
						}
					}
					break;
				case 2:
					System.out.println(this.control.enquireCustomerDetailInformation(index));
					System.out.println("해당 고객을 삭제하겠습니까?");
					System.out.println("1.삭제");
					System.out.println("2.뒤로가기");
					choice = scanner.nextInt();
					if(choice == 1) {
						System.out.println("삭제 고객ID를 입력하세요.");
						String id = scanner.next();
						System.out.println(control.deleteCustomerInformation(index, id));
					}
					else if(choice == 2) {
						break;
					}
					//수정필요
					bOnLoop = false;
					break;
				case 3:
					return;
					//					bOnLoop = false;
					//					break;
			}
		}
	}

	private void startContractMaintenanceActivities(Scanner scanner) {
		// 계약 유지 관리
	}

	private void payInsuranceFee(Scanner scanner) {
		// 월 보험료 납입
	}

	private void applyForMembership(Scanner scanner) {
		// 민재 - 가입 신청 받기
		boolean ageCheck;
		System.out.print("가입신청을 진행하시겠습니까? (1.진행, 그 이외.뒤로가기) : ");
		if(!scanner.next().equals("1")) return; 
		while(true) {
			ageCheck = false;
			System.out.print("고객 이름 : ");
			String name = scanner.next();
			scanner.nextLine();
			System.out.print("가입 희망 보험 : ");
			String insurance = scanner.next();
			scanner.nextLine();
			System.out.print("전화번호 : ");
			String phoneNum = scanner.next();
			scanner.nextLine();
			String age = null;
			while(!ageCheck) {
				System.out.print("나이 : ");
				age = scanner.next();
				scanner.nextLine();
				if(control.checkNumFormat(age)) ageCheck = true;
				else System.out.println("나이를 다시 입력해 주세요");
			}
			System.out.print("성별(1.남자, 그 이외.여자) : ");
			boolean gender = scanner.next().equals("1");
			scanner.nextLine();
			System.out.print("직업 : ");
			String jop = scanner.next();
			scanner.nextLine();
			System.out.print("주민번호 : ");
			String SSN = scanner.next();
			scanner.nextLine();
			boolean result = this.control.applyForMembership(insurance, phoneNum, age, gender, name, jop, SSN);
			if(!result) {
				System.out.println("올바른 형식에 맞게 입력하세요");
				continue;
			}else {
				System.out.println("가입 신청이 정상적으로 진행됩니다");
				break;
			}
		}
		System.out.println("==================================");
	}

	private void startUW(Scanner scanner) {
		// 민재 - 인수심사 진행하기
		while(true) {
			System.out.println(control.enquireInformationAboutApplicationForMembership());
			System.out.print("선택번호를 입력해 주세요(0 : 뒤로가기) : ");
			String choice = scanner.next();
			if(choice.equals("0")) return;
			boolean checkInID = control.checkInID(choice + "");
			if(!checkInID) {
				System.out.println("선택번호 내 번호를 다시 입력해 주세요");
				continue;
			}
			System.out.println("입력 번호 : " + choice);
			if(control.checkAlreadyJudged(choice + "")) {
				System.out.println("이미 인수심사가 완료된 신청정보입니다. 다른 번호를 입력해 주세요");
				continue;
			}
			boolean automaticExaminationResult = startAutomaticJudge(scanner, choice + "");
			System.out.print("진단심사 결과(1.합격, 그이외.불합격) : ");
			boolean diagnosticExaminationResult = scanner.next().equals("1");
			System.out.print("이미지심사 결과(1.합격, 그이외.불합격) : ");
			boolean imageExaminationResult = scanner.next().equals("1");
			System.out.print("특인심사 결과(1.합격, 그이외.불합격) : ");
			boolean specialExaminationResult = scanner.next().equals("1");
			System.out.print("일반심사 결과(1.합격, 그이외.불합격) : ");
			boolean generalExaminationResult = scanner.next().equals("1");
			String uwResult = control.enquireUWResult(choice + "", automaticExaminationResult, diagnosticExaminationResult, 
					imageExaminationResult, specialExaminationResult, generalExaminationResult);
			System.out.println(uwResult);
			if(!uwResult.equals("인수심사에 합격하였습니다"))
				System.out.println("타보험사에 보낼 가입 희망 보험 정보\n" + control.enquireApplicationForMembership(choice + "")); // 이거 다시 확인
			break;
		}
		System.out.println("==================================");
	}

	private boolean startAutomaticJudge(Scanner scanner, String id) throws InputMismatchException {
		// 새로 만든 함수(자동심사)
		while(true) {
			System.out.print("본인 소유의 건물(1.예, 그이외.아니오) : ");
			boolean isOwnedBuilding = scanner.next().equals("1");
			System.out.print("리모델링 여부(1.예, 그이외.아니오) : ");
			boolean isRemodeling = scanner.next().equals("1");
			boolean checkPointInteger = false;
			String buildingAgeScore = null;
			String fireEquipmentConditionScore = null;
			String buildingLocationScore = null;
			String buildingConditionScore = null;
			
			while(!checkPointInteger) {
				System.out.print("건물 연식(점수 입력 - 0점~20점) : ");
				buildingAgeScore = scanner.next();
				System.out.print("화재 설비 상태(점수 입력 - 0점~20점) : ");
				fireEquipmentConditionScore = scanner.next();
				System.out.print("건물 위치(점수 입력 - 0점~20점) : ");
				buildingLocationScore = scanner.next();
				System.out.print("건물 가격(점수 입력 - 0점~20점) : ");
				buildingConditionScore = scanner.next();
				if(control.checkNumFormat(buildingAgeScore) && 
						control.checkNumFormat(fireEquipmentConditionScore) && 
						control.checkNumFormat(buildingLocationScore) && 
						control.checkNumFormat(buildingConditionScore)) checkPointInteger = true;
				else System.out.println("점수는 숫자로 입력해 주세요");
			}
			//파라미터 길이 줄일 것
			if(!control.checkPointInput(Integer.parseInt(buildingAgeScore), 
										Integer.parseInt(fireEquipmentConditionScore), 
										Integer.parseInt(buildingLocationScore), 
										Integer.parseInt(buildingConditionScore))) {
				System.out.println("범위에 맞는 점수를 다시 적어주세요");
				continue;
			}
			return control.automaticJudge(id, 
										isOwnedBuilding, 
										isRemodeling, 
										Integer.parseInt(buildingAgeScore), 
										Integer.parseInt(fireEquipmentConditionScore), 
										Integer.parseInt(buildingLocationScore), 
										Integer.parseInt(buildingConditionScore));
		}

	}

	private void joinInsurance(Scanner scanner) {
		// 민재 - 보험 가입하기
		while(true) {
			System.out.println(control.enquirePassedCustomerInUW());
			System.out.print("신청할 고객 정보를 선택하세요(0 : 뒤로가기) : ");
			String choice = scanner.next();
			scanner.nextLine();
			if(choice.equals("0")) return;
			if(!control.checkNumFormat(choice)) {
				System.out.println("번호를 입력해 주세요");
				continue;
			}
			if(!control.checkInIDUW(Integer.parseInt(choice))) {
				System.out.println("번호에 해당하는 고객이 없습니다");
				continue;
			}
			System.out.println("[선택 고객 세부 정보]");
			System.out.println(control.enquireCustDetailInfoFromEnquirePassedList(Integer.parseInt(choice)));
			System.out.print("가입 신청 하시겠습니까?(1. 예, 그이외. 뒤로가기) : ");
			String checkInput = scanner.next();
			if(!checkInput.equals("1")) continue;
			if(control.makeInsuranceContract(Integer.parseInt(choice), checkDate(scanner))) {
				System.out.println("가입 신청이 완료되었습니다(신규 가입 정보)");
				System.out.println("id 고객ID 만기일 가입보험ID 지불금액 납입여부");
				System.out.println(control.enquireNewContractInformation());
			}
			else {
				System.out.println("가입 고객을 찾지 못하였습니다 다시 입력해 주세요");
				continue;
			}
			System.out.println("============================");
			break;
		}
	}

	private String checkDate(Scanner scanner) {
		// 새로 만든 함수
		while(true) {
			System.out.print("지정할 만기일(YYYY-MM-DD) : ");
			String date = scanner.next();
			if(!control.checkInputDateFormat(date)) {
				System.out.println("날짜 입력 형식이 올바르지 않습니다.");
				continue;
			}
			return date;
		}
	}

	private void reinsurance(Scanner scanner) {
		// 민재 - 재보험 처리하기
		String name;
		String sSN;
		System.out.print("무엇을 하시겠습니까?\n1. 산출 2. 정산 3. 재보험 등록 (그 이외. 뒤로가기) : ");
		String selectCase = scanner.next();
		if(!(selectCase.equals("1") || 
				selectCase.equals("2") || 
				selectCase.equals("3"))) {
			System.out.println("=========================");
			return;
		}
		while(true) {
			try {
				System.out.print("이름 : ");
				name = scanner.next();
				System.out.print("주민번호 : ");
				sSN = scanner.next();
				if(!control.checkCitizenNumFormat(sSN)) {
					System.out.println("주민번호를 다시 입력해 주세요");
					continue;
				}
				if(!control.checkValidCustomer(name, sSN)) {
					System.out.println("입력 정보에 맞는 고객 혹은 가입한 보험이 없습니다.");
					return;
				}
				switch(Integer.parseInt(selectCase)) {
				case 1:
					control.enquireCustInsurances(name, sSN);
					System.out.println("\n[산출 재보험료 정보]");
					System.out.println("이름 : " + name);
					System.out.println("주민번호 : " + sSN);
					System.out.println("<가입 보험명, 재보험료 목록>");
					System.out.println(control.enquireReinsInfo());
					System.out.println("\n=========================");
					break;
				case 2:
					while(true) {
						String selectInsNum = showInputCustInsurances(scanner, name, sSN);
						if(!control.checkValidReInsName(selectInsNum)) {
							System.out.println("선택 번호 해당 정보가 없습니다. 다시 입력해 주세요");
							continue;
						}
						String payInsName = control.enquireSpecificPayInfo(name, sSN, selectInsNum);
						System.out.println("-------------------------\n"+
								"고객 명 : " + name + 
								"\n주민번호 : " + sSN + 
								"\n정산된 보험명 : " + payInsName);
						String payFee = null;
						boolean validInput = false;
						while(!validInput) {
							System.out.print("정산 요금 입력 : ");
							payFee = scanner.next();
							if(control.checkNumFormat(payFee)) validInput = true;
							else System.out.println("지불 금액을 다시 입력해 주세요");
						}
						System.out.print("정산하겠습니까?(1. 예, 그이외. 아니오) : ");
						if(!scanner.next().equals("1")) {
							System.out.println("=========================");
							return;
						}
						System.out.println("\n[정산 결과]\n" + 
								"고객명 : " + name + 
								"\n주민번호 : " + sSN + 
								"\n정산 보험명 : " + payInsName + 
								"\n정산 요금 : " + payFee);
						System.out.println("=========================");
						break;
					}
					break;
				case 3:
					while(true) {
						String selectInsNum = showInputCustInsurances(scanner, name, sSN);
						if(!control.checkValidReInsName(selectInsNum)) {
							System.out.println("선택 번호 해당 정보가 없습니다. 다시 입력해 주세요");
							continue;
						}
						System.out.println("-------------------------\n"+
								control.enquireSpecificReinsInfo(name, sSN, selectInsNum));
						System.out.print("재보험 등록하겠습니까?\n(1. 등록, 그 이외. 뒤로가기) : ");
						if(!scanner.next().equals("1")) {
							System.out.println("=========================");
							return;
						}
						System.out.println("\n[재보험 등록 정보]\n" + 
								control.reinsCommit(name, sSN) + "\n");
						System.out.println("=========================");
						break;
					}
				}
				break;
			}catch(InputMismatchException e) {
				System.out.println("정수를 입력해 주세요");
				continue;
			}
		}
	}

	private String showInputCustInsurances(Scanner scanner, String name, String sSN) {
		// 새로 만든 함수
		System.out.println(control.enquireCustInsurances(name, sSN));
		System.out.print("선택 번호 : ");
		return scanner.next();
	}

	private void manageCompensationManagement(Scanner scanner) {
		// 보상 운용 관리
	}

	private void payInsuranceMoney(Scanner scanner) {
		// 보험금 지급
	}

	private void reportAccident(Scanner scanner) {
		// EA 시나리오 사고를 접수하다? -> 사고 처리 하기 
		// 민우
		
		MainFrame frame = new MainFrame();
		
		System.out.println("----------------------------");
		System.out.println("사고 처리를 시작합니다.");
		while(true) {
			System.out.println("보험 가입자 이름을 입력해주세요.");
			String name = scanner.next();
			System.out.println("전화번호를 입력해주세요.");
			String phoneNum = scanner.next();
			System.out.println("사고위치를 입력해주세요.");
			String accidentLocation = scanner.next();
			System.out.println("사고유형을 입력해주세요.");
			String accidentType = scanner.next();
			System.out.println(control.enquireAccidentInformation(name, phoneNum));
			System.out.println("직원콜여부");
			System.out.println("1.yes");
			System.out.println("2.no");
			int employeeCallStatus = scanner.nextInt();
			System.out.println("렉카콜여부");
			System.out.println("1.yes");
			System.out.println("2.no");
			int towTruckCallStatus = scanner.nextInt();
			//확인메세지
			System.out.println("직원콜을 호출하시겠습니까?");
			System.out.println("1.yes");
			System.out.println("2.no");
			int choice = scanner.nextInt();
			//관할 직원에 보험자 가입 이름, 전화번호, 사고위치, 사고유형을 자동 메시지로 보낸다.
			//확인메세지
			System.out.println("렉카콜을 호출하시겠습니까?");
			System.out.println("1.yes");
			System.out.println("2.no");
//			int choice = scanner.nextInt(); 민우형이 처리하기로
			//관할 렉카 협력업체에 보험가입자 이름, 사고위치, 사고유형을 자동 메시지로 보낸다.
			
			int remainingNumberOfTowTruckCalls = 0;
			boolean towTruckCallPresent = false;
//			control.saveAccident(new AccidentReception(accidentID, customerID, customerName, employeeCallStatus, remainingNumberOfTowTruckCalls, towTruckCallPresent));
			System.out.println();
		}
	}

	private void manageExpirationContract(Scanner scanner) {
		// 만기계약 관리
	}

	private void managePaymentInformation(Scanner scanner) {
		// 납입 정보 관리
	}

	private void designInsuranceProduct(Scanner scanner) {
		// 보험 상품 설계
		this.requestAuthorization(scanner);
	}

	private void requestAuthorization(Scanner scanner) {
		// 새로 만든 함수
	}

	public static void main(String[] args) {
		Main main = new Main();
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.initialize();
		
		Scanner scanner = new Scanner(System.in);
		boolean bOnLoop = true;
		while(bOnLoop) {
//	         try { 정수가 아니라 다른 값 입력시 예외 처리 구현 - 다들 같이 있을 때 논의해볼 것
//          
//       }catch(InputMismatchException e) {
//          System.out.println("정수를 입력해 주세요");
//          continue;
//       }

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
			switch(choice) {
				case 0:
					bOnLoop = false;
					break;
				case 1:
					// 인배
					// 20220521 수정필요
					main.manageCustomerInformation(scanner);
					break;
				case 2:
					main.startContractMaintenanceActivities(scanner);
					break;
				case 3:
					main.payInsuranceFee(scanner);
					break;
				case 4:
					// 민재 20220525완성
					main.applyForMembership(scanner);
					break;
				case 5:
					// 민재 20220525완성
					main.startUW(scanner);
					break;
				case 6:
					// 민재 20220525완성
					main.joinInsurance(scanner);
					break;
				case 7:
					// 민재 20220525완성
					main.reinsurance(scanner);
					break;
				case 8:
					main.manageCompensationManagement(scanner);
					break;
				case 9:
					main.payInsuranceMoney(scanner);
					break;
				case 10:
					// 민우 사고 접수를 하다
					// 일단 이 내용은 사고처리를 적어 놓은 것 
					// 20220521 수정필요
					main.reportAccident(scanner);
					break;
				case 11:
					main.manageExpirationContract(scanner);
					break;
				case 12:
					main.managePaymentInformation(scanner);
					break;
				case 13:
					// 인배 20220521
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