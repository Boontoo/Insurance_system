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
		// 민재 - 월 보험료 납입하기
		while(true) {
			boolean isInputValid = false;
			String selected = null;
			while(!isInputValid) {
				System.out.println("[보험 상품 납입 정보]");
				System.out.println(controller.enquireInsuranceFeePaymentStatus());
				System.out.print("납부할 보험상품 선택번호를 입력하세요(0.뒤로 가기) : ");
				selected = scanner.next();
				if(selected.equals("0")) return;
				if(controller.checkNumFormat(selected) && 
						controller.checkInSelectSize(selected)) isInputValid = true;
				else System.out.println("번호를 다시 입력해 주세요");
			}
			scanner.nextLine();
			isInputValid = false;
			String inputPay = null;
			while(!isInputValid) {
				System.out.print("납입 금액 입력 : ");
				inputPay = scanner.nextLine();
				if(inputPay.length() == 0 || !controller.checkNumFormat(inputPay)) {
					System.out.println("금액을 입력해 주세요");
					continue;
				}
				if(controller.checkAmountOfInsuranceFee(Integer.parseInt(inputPay), 
						Integer.parseInt(selected))) isInputValid = true;
				else System.out.println("납입 금액 이상 입력해 주세요");
			}
			isInputValid = false;
//			System.out.println("납입 금액 : " + inputPay);
			if(!controller.checkAlreadyPay(Integer.parseInt(selected))) {
				System.out.println("\n" + controller.saveAmountOfInsuranceFee(Integer.parseInt(selected), Integer.parseInt(inputPay)));
				System.out.println("\n<월 보험료 납입이 완료되었습니다>");
				System.out.println(controller.enquirePaymentResult(Integer.parseInt(selected)));
			}else System.out.println("이미 월 납입을 완료하셨습니다");
			String inputBinCase = null;
			while(!isInputValid) {
				System.out.println("\n<다른 보험 상품을 납부하시겠습니까?>");
				System.out.print("(1. 예, 2. 아니오) : ");
				inputBinCase = scanner.nextLine();
				if(!controller.checkNumFormat(inputBinCase) ||
						!(Integer.parseInt(inputBinCase) == 1 || 
						Integer.parseInt(inputBinCase) == 2)) 
					System.out.println("1 혹은 2를 입력해 주세요");
				else isInputValid = true;
			}
			if(inputBinCase.equals("2")) {
				System.out.println("===========================");
				return;
			}
		}
	}

	private void applyForMembership(Scanner scanner) {
		// 민재 - 가입 신청 받기
		boolean ageCheck;
		System.out.print("가입신청을 진행하시겠습니까? (1.진행, 그 이외.뒤로가기) : ");
		if(!scanner.next().equals("1")) return; 
		scanner.nextLine();
		while(true) {
			boolean isNameIn = false;
			String name = null;
			String insuranceName = null;
			while(!isNameIn) {
				System.out.print("고객 이름 : ");
				name = scanner.nextLine();
				if(controller.checkInCustList(name)) isNameIn = true;
				else System.out.println("입력된 정보가 고객으로 등록되어있지 않습니다. 다시 입력하세요");
			}
			isNameIn = false;
			while(!isNameIn) {
				System.out.print("가입 희망 보험 : ");
				insuranceName = scanner.nextLine(); 
				if(controller.checkInInsList(insuranceName)) isNameIn = true;
				else System.out.println("입력된 정보가 보험으로 등록되어있지 않습니다. 다시 입력하세요");
			}
			System.out.print("전화번호 : ");
			String phoneNum = scanner.nextLine();
			String age = null;
			ageCheck = false;
			while(!ageCheck) {
				System.out.print("나이 : ");
				age = scanner.nextLine();
				if(controller.checkNumFormat(age)) ageCheck = true;
				// 나이나 숫자 입력 시 24를 2 4 이렇게 입력하면 에러 생기던데 시간 나면 해결해 보자
				else System.out.println("나이를 다시 입력해 주세요");
			}
			System.out.print("성별(1.남자, 그 이외.여자) : ");
			boolean gender = scanner.nextLine().equals("1");
			System.out.print("직업 : ");
			String jop = scanner.nextLine();
			System.out.print("주민번호 : ");
			String SSN = scanner.nextLine();
//			System.out.println("[입력 정보]");
//			System.out.println("나이 : " + age);
//			System.out.println("가입 희망 보험 : " + insuranceName);
//			System.out.println("직업 : " + jop);
//			System.out.println("이름 :" + name);
//			System.out.println("전화번호 : " + phoneNum);
//			System.out.println("주민번호 : " + SSN);
//			System.out.println("성별 : " + gender);
//			System.out.println("===========================");
			boolean result = this.controller.applyForMembership(insuranceName, phoneNum, age, gender, name, jop, SSN);
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
			System.out.println(controller.enquireInformationAboutApplicationForMembership());
			System.out.print("선택번호를 입력해 주세요(0 : 뒤로가기) : ");
			String choice = scanner.next();
			if(choice.equals("0")) return;
			boolean checkInID = controller.checkInID(choice + "");
			if(!checkInID) {
				System.out.println("선택번호 내 번호를 다시 입력해 주세요");
				continue;
			}
			System.out.println("입력 번호 : " + choice);
			if(controller.checkAlreadyJudged(choice + "")) {
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
			String uwResult = controller.enquireUWResult(choice + "", automaticExaminationResult, diagnosticExaminationResult, 
					imageExaminationResult, specialExaminationResult, generalExaminationResult);
			System.out.println(uwResult);
			if(!uwResult.equals("인수심사에 합격하였습니다"))
				System.out.println("타보험사에 보낼 가입 희망 보험 정보\n" + controller.enquireApplicationForMembership(choice + "")); // 이거 다시 확인
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
				if(controller.checkNumFormat(buildingAgeScore) && 
						controller.checkNumFormat(fireEquipmentConditionScore) && 
						controller.checkNumFormat(buildingLocationScore) && 
						controller.checkNumFormat(buildingConditionScore)) checkPointInteger = true;
				else System.out.println("점수는 숫자로 입력해 주세요");
			}
			//파라미터 길이 줄일 것
			if(!controller.checkPointInput(Integer.parseInt(buildingAgeScore), 
										Integer.parseInt(fireEquipmentConditionScore), 
										Integer.parseInt(buildingLocationScore), 
										Integer.parseInt(buildingConditionScore))) {
				System.out.println("범위에 맞는 점수를 다시 적어주세요");
				continue;
			}
			return controller.automaticJudge(id, 
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
			if(!controller.checkNumFormat(choice)) {
				System.out.println("번호를 입력해 주세요");
				continue;
			}
			if(!controller.checkInIDUW(Integer.parseInt(choice))) {
				System.out.println("번호에 해당하는 고객이 없습니다");
				continue;
			}
			System.out.println("\n[선택 고객 세부 정보]");
			System.out.println(controller.enquireCustDetailInfoFromEnquirePassedList(Integer.parseInt(choice)));
			System.out.print("\n가입 신청 하시겠습니까?(1. 예, 그이외. 뒤로가기) : ");
			String checkInput = scanner.next();
			if(!checkInput.equals("1")) continue;
			if(controller.makeInsuranceContract(Integer.parseInt(choice), checkDate(scanner))) {
				System.out.println("가입 신청이 완료되었습니다(신규 가입 정보)");
				System.out.println("id 고객ID 만기일 가입보험ID 지불금액 납입여부");
				System.out.println(controller.enquireNewContractInformation());
			}
			else {
				System.out.println("가입 고객을 찾지 못하였습니다 다시 입력해 주세요");
				continue;
			}
			System.out.println("\n============================");
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
		scanner.nextLine();
		while(true) {
			try {
				System.out.print("이름 : ");
				name = scanner.nextLine();
				System.out.print("주민번호 : ");
				sSN = scanner.nextLine();
				if(!controller.checkCitizenNumFormat(sSN)) {
					System.out.println("주민번호를 다시 입력해 주세요");
					continue;
				}
				if(!controller.checkValidCustomer(name, sSN)) {
					System.out.println("입력 정보에 맞는 고객 혹은 가입한 보험이 없습니다.");
					return;
				}
				switch(Integer.parseInt(selectCase)) {
				case 1:
					controller.enquireCustInsurances(name, sSN);
					System.out.println("\n[산출 재보험료 정보]");
					System.out.println("이름 : " + name);
					System.out.println("주민번호 : " + sSN);
					System.out.println("<가입 보험명, 재보험료 목록>");
					System.out.println(controller.enquireReinsInfo());
					System.out.println("\n=========================");
					break;
				case 2:
					while(true) {
						String selectInsNum = showInputCustInsurances(scanner, name, sSN);
						if(!controller.checkValidReInsName(selectInsNum)) {
							System.out.println("선택 번호 해당 정보가 없습니다. 다시 입력해 주세요");
							continue;
						}
						String payInsName = controller.enquireSpecificPayInfo(name, sSN, selectInsNum);
						System.out.println("-------------------------\n"+
								"고객 명 : " + name + 
								"\n주민번호 : " + sSN + 
								"\n정산된 보험명 : " + payInsName);
						String payFee = null;
						boolean validInput = false;
						while(!validInput) {
							System.out.print("정산 요금 입력 : ");
							payFee = scanner.next();
							if(controller.checkNumFormat(payFee)) validInput = true;
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
								"\n정산 요금 : " + payFee + 
								"\n정산이 완료되었습니다");
						System.out.println("=========================");
						break;
					}
					break;
				case 3:
					while(true) {
						String selectInsNum = showInputCustInsurances(scanner, name, sSN);
						if(!controller.checkValidReInsName(selectInsNum)) {
							System.out.println("선택 번호 해당 정보가 없습니다. 다시 입력해 주세요");
							continue;
						}
						System.out.println("-------------------------\n"+
								controller.enquireSpecificReinsInfo(name, sSN, selectInsNum));
						System.out.print("재보험 등록하겠습니까?\n(1. 등록, 그 이외. 뒤로가기) : ");
						if(!scanner.next().equals("1")) {
							System.out.println("=========================");
							return;
						}
						System.out.println("\n[재보험 등록 정보]\n" + 
								controller.reinsCommit(name, sSN) + "\n"
										+ "<재보험 등록이 완료되었습니다>");
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
		System.out.println(controller.enquireCustInsurances(name, sSN));
		System.out.print("선택 번호 : ");
		return scanner.next();
	}

	private void manageCompensationManagement(Scanner scanner) {
		// 보상 운용 관리
	}

	private void payInsuranceMoney(Scanner scanner) {
		// 보험금 지급
		scanner.nextLine();
		boolean isContinue = false;
		String name = "";
		String sSN = "";
		String accidentId = "";
		System.out.print("보험금 지급 진행하겠습니까?(1.진행, 그이외.뒤로가기) : ");
		if(!scanner.nextLine().equals("1")) return;
		String accList = controller.enquireAccidentList();
		if(accList.length() == 0) {
			System.out.println("처리할 정보가 없습니다");
			System.out.println("=========================");
			return;
		}
		while(!isContinue) {
			System.out.println("[처리할 사고 선택]\n고객 이름    주민번호            사건번호    보험금 지급 여부");
			System.out.println(accList);
			System.out.print("고객 이름 : ");
			name = scanner.nextLine();
			System.out.print("주민 번호 : ");
			sSN = scanner.nextLine();
			System.out.print("사건 번호 : ");
			accidentId = scanner.nextLine();
			if(controller.checkInAccidentList(name, sSN, accidentId)) isContinue = true;
			else System.out.println("입력 형식이 맞지 않습니다(고객이름, 주민번호, 사건번호)");
		}
		isContinue = false;
		// 사고 접수자 상품명, 납입 기간, 납입 주기 출력 -> 사고 접수자의 이름, 나이, 직업, 사고 위치, 사고 유형, 상품명으로 시나리오 바꿀 것
		System.out.println("\n[사고 접수자 사고 및 가입 정보]");
		System.out.println(controller.enquireDetailAccidentInfo(accidentId));
		System.out.print("보험금을 지급하겠습니까?(1.지급  그이외.취소) : ");
		if(!scanner.nextLine().equals("1")) {
			System.out.println("\n보험금 지급을 취소합니다.");
			System.out.println("=========================");
			return;
		}
		if(controller.checkMoneyPayed(accidentId)) {
			System.out.println("\n<이미 보험금 지급이 완료된 고객입니다>\n=========================");
			return;
		}
		System.out.println("\n[보험금 지급이 완료되었습니다]");
		System.out.println(controller.payInsuranceMoney(accidentId));
		System.out.println("보상 기획부서에 위 내역을 지원합니다");
		System.out.println("=========================");
		// 보험금 지금 or 취소 버튼 출력
		// 이후 출력 처리
	}

	private void reportAccident(Scanner scanner) {
		// EA 시나리오 사고를 접수하다? -> 사고 처리 하기 
		// 민우(재)
		// 이거 시나리오 다시 써야 함
		scanner.nextLine();
		System.out.println("----------------------------");
		System.out.println("사고 처리를 시작합니다.");
		boolean isContinue = false;
		String name = "";
		while(!isContinue) {
			System.out.print("보험 가입자 이름 : ");
			name = scanner.nextLine();
			if(controller.checkInCustList(name)) isContinue = true;
			else System.out.println("입력 고객이 고객 리스트에 없습니다");
		}
		isContinue = false;
		String phoneNum = "";
		while(!isContinue) {
			System.out.print("전화번호 : ");
			phoneNum = scanner.nextLine();
			if(controller.checkPhoneNumFormat(phoneNum)) isContinue = true;
			else System.out.println("입력 형식에 맞게 입력해 주세요");
		}
		isContinue = false;
		String accidentLocation = "";
		while(!isContinue) {
			System.out.print("사고위치 : ");
			accidentLocation = scanner.nextLine();
			if(accidentLocation.length() != 0) isContinue = true;
			else System.out.println("내용을 입력해 주세요");
		}
		isContinue = false;
		String accidentType = "";
		while(!isContinue) {
			System.out.print("사고유형 : ");
			accidentType = scanner.nextLine();
			if(accidentType.length() != 0) isContinue = true;
			else System.out.println("내용을 입력해 주세요");
		}
		isContinue = false;
		if(!controller.checkCustContracted(name, phoneNum)) {
			System.out.println("해당 정보를 조회할 수 없습니다");
			return;
		}
		System.out.println("[" + name + " 고객님이 가입한 가입 정보]");
		System.out.println("ID     보험 이름      만기일");
		System.out.println(controller.enquireCustomerContracted(name));
		String selectedID = null;
		while(!isContinue) {
			System.out.print("어떤 보험을 적용하겠습니까?(ID입력) : ");
			selectedID = scanner.nextLine();
			if(controller.checkIdInContract(selectedID, name)) isContinue = true;
			else System.out.println("입력 아이디가 존재하지 않습니다. 다시 입력하세요");
		}
		isContinue = false;
		controller.saveAccident(selectedID, accidentLocation, accidentType); // 사고 접수 내역 저장 - 사고 위치, 사고 유형 포함하자
		System.out.println("\n[사고 접수 정보]");
		System.out.println(controller.enquireAccidentInformation());
		
		System.out.print("\n직원콜여부(1.yes 그이외.no) : ");
		String employeeCallStatus = scanner.nextLine();
		if(employeeCallStatus.equals("1")) {
			System.out.println("\n[관할 직원에 보낼 사고 정보]\n이름      전화번호         사고위치      사고유형");
			System.out.println(name + "    " + phoneNum + "    " + accidentLocation + "       " + accidentType);
		}
		System.out.print("렉카콜여부(1.yes 그이외.no) : ");
		String towTruckCallStatus = scanner.nextLine();
		if(!towTruckCallStatus.equals("1")) return;
		System.out.println("\n[관할 렉카 협력업체에 보낼 사고 정보]\n이름    사고위치    사고유형");
		System.out.println(name + "    " + accidentLocation + "      " + accidentType);
		System.out.println("=======================");
	}

	private void manageExpirationContract(Scanner scanner) {
		// 만기계약 관리
		scanner.nextLine();
		boolean isContinue = false;
		System.out.print("만기 계약 관리를 진행하겠습니까?\n(1.진행   그이외.뒤로가기) : ");
		if(!scanner.nextLine().equals("1")) return;
		String choice = "";
		while(!isContinue) {
			String contractList;
			System.out.println("[만기 계약 정보 관리]");
			System.out.println("선택번호    이름    가입 보험    만기일");
			contractList = controller.enquireExpirationContractInformation();
			if(contractList.length() == 0) return;
			System.out.println(contractList);
			System.out.print("관리할 정보를 선택하세요(0.뒤로가기) : ");
			choice = scanner.nextLine();
			if(choice.equals("0")) return;
			if(controller.checkInContractList(choice)) isContinue = true;
			else System.out.println("알맞는 번호를 선택해 주세요");
		}
		isContinue = false;
		String inputCase = "";
		while(!isContinue) {
			System.out.print("1.계약 연장\n그이외.계약 해지\n입력 : ");
			inputCase = scanner.nextLine();
			if(!inputCase.equals("1")) {
				System.out.println("해당 고객은 만기일 이후 계약이 해지됩니다.");
				System.out.println("=========================");
				return;
			}
			if(inputCase.length() != 0) isContinue = true;
			else System.out.println("진행 동작을 입력해 주세요");
		}
		isContinue = false;
		String newExpirationDate = "";	
		while(!isContinue) {
			System.out.print("만기일 입력 : ");
			newExpirationDate = scanner.nextLine();
			if(!controller.checkInputDateFormat(newExpirationDate)) {
				System.out.println("날짜 형식에 맞춰 다시 입력해 주세요(YYYY-MM-DD)");
				continue;
			}
			if(!controller.compareBeforeDate(newExpirationDate, choice)) {
				System.out.println("기존 만기일 이후 날짜를 입력해 주세요");
				continue;
			}
			isContinue = true;
		}
		System.out.println(controller.renewExpirationDate(newExpirationDate, choice));
		System.out.println("=========================");
	}

	private void managePaymentInformation(Scanner scanner) {
		// 납입 정보 관리
		// 민재
		scanner.nextLine();
		while(true) {
			String selectInput = null;
			boolean isContinue = false;
			while(!isContinue) {
				System.out.print("\n<무엇을 하시겠습니까?>"
						+ "\n1.보험료 납입 현황을 출력한다"
						+ "\n2.월 보험료 납입 현황을 초기화 한다"
						+ "\n0.뒤로가기"  
						+ "\n입력 : ");
				selectInput = scanner.nextLine();
				if(controller.checkNumFormat(selectInput) && 
						controller.checkInMenu(selectInput)) isContinue = true;
				else System.out.println("<선택 메뉴 내 번호를 입력해 주세요>");
				
			}
			isContinue = false;
			if(selectInput.equals("0")) return;
			switch(Integer.parseInt(selectInput)) {
			case 1:
				System.out.println("[보험 가입자의 보험 상품 가입 현황]");
				System.out.println("<이름    전화번호            가입 보험       납입 금액  납입 여부>");
				System.out.println(controller.enquireContractedInsList());
				System.out.println("=========================");
				return;
			case 2:
				while(!isContinue) {
					System.out.print("\n월 보험료 미납입 고객이 " + controller.countInsuranceFeeNotPaid() + 
							"명 있습니다.\n계속 진행하겠습니까?" + 
							"\n(1.진행 2.취소) : ");
					selectInput = scanner.nextLine();
					if(controller.checkNumFormat(selectInput) && 
							controller.checkInMenuIni(selectInput)) isContinue = true;
					else System.out.println("선택 메뉴 내 번호를 입력해 주세요");
				}
				if(selectInput.equals("2")) break;
				else {
					System.out.println(controller.initializeInsuranceFeePaymentStatus());
					System.out.println("=========================");
					return;
				}
			}
		}
	}

	private void designInsuranceProduct(Scanner scanner) {
		while(true) {
			System.out.println("1.보험 상품 설계");
			System.out.println("2.보험 상품 관리");
			int choice = scanner.nextInt();
			switch(choice) {
				case 1:
					//보험 상품 설계
					//시스템
//					보험상품개발정보(고객니즈분석 설문조사 결과, 최근 보험가입 빈도, 경쟁사의 동향 정보)및 저장버튼을  출력한다
					System.out.println(controller.enquireInsuranceProductDevelopmentInformation());
					
//					보험상품시장정보를 보고 통계율을 따져서 새로운 보험상품을 기획한다
//					기획한 내용을 바탕으로 기획서를 작성한 후 저장버튼(엔터)을 누른다
//					choice = scanner.nextInt();
					//시스템
//					"저장완료"라는 메시지를 출력한다 
//					System.out.println("저장완료");
//					보험상품 설계 입력 양식(보장·판매대상, 요율, 시산작업내역, 예상손익분석 가격, 기초서류)및 저장버튼을 출력한다
					// 변경 (폼 다 띄우고 답 받기 -> 폼 하나 띄우고 답변 받는 식(질문1, 답변1, 질문2, 답변2...))
					ArrayList<String> designContents = new ArrayList<String>();
					ArrayList<String> designForm = controller.enqireInsuranceProductDesignForm();
					for(String content : designForm) {
						System.out.println(content);
						designContents.add(scanner.next());
					}
					boolean bSave = true;
					while(bSave) {
						System.out.println("저장하시겠습니다?");
						System.out.println("1.Yes");
						System.out.println("2.No");
						choice = scanner.nextInt();
						switch(choice) {
							case 1:
								boolean isSaved = controller.saveInsuranceDesignContent(designContents);
								if(isSaved) {
									System.out.println("저장완료");
									this.requestAuthorization(scanner);
								}
	//							bSave = false;
	//							break;
							case 2:
								bSave = false;
	//							break;
							default:
								break;
						}
					}
//					choice = scanner.nextInt();
					//대답
					
//					designForm = controller.enqireInsuranceProductDesignForm();
//					System.out.println(controller.euqireInsuranceProductDesignForm());
					
//					controller.saveInsuranceDesignContent(designContents);
//					"저장완료"라는 메시지를 출력한다 
					
					
//					보험설계(보장·판매대상 결정, 요율 수집 및 시산작업, 예상손익분석 가격결정, 기초서류 작성, 요율검증의뢰)를 하고 해당 내용을 작성 후, 저장버튼(엔터)을 누른다.
					
					//시스템
//					"저장완료"메시지와 "상품 인가품의 버튼"을 출력한다
//					유스케이스 '보험상품을 인가한다'를 따른다
					return;
				case 2:
					//보험 상품 관리
					//시스템
					System.out.println(controller.enquireInsuranceList());
					choice = scanner.nextInt();
					controller.enquireInsuranceProductDetails(choice);
//					System.out.println(controller);
//					A1. 해당 보험 상품 관련 정보(판매 실적 및 속성, 손익)을 출력한다
					
//					판매 실적 및 속성, 손익을 보고 해당 보험의 문제점을 파악한다
					return;
				default:
					break;
			}
			this.requestAuthorization(scanner);
		}
	}

	private void requestAuthorization(Scanner scanner) {
		while(true) {
			System.out.println("보험상품을 인가품의하겠습니까?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println("상품 인가품의 완료");
				// 상품 확정 후 상품을 등록시킨다.
				controller.requestAuthorizationOfCompany();
				//상품 확정 질문 필요?
				System.out.println("상품을 확정시키겠습니까?");
				System.out.println("1.Yes");
				System.out.println("2.No");
				// 필요하다면 대답 부분 구현해야 함
				System.out.println("상품이 확정되었습니다.");
				// 상품 확정 코드를 어떻게...? 모델 부분도 없네?
				
				boolean bRequestAuthorizationOfFSS = true;
				while(bRequestAuthorizationOfFSS) {
					System.out.println("금융감독원 상품인가 품의하겠습니까?");
					System.out.println("1.Yes");
					System.out.println("2.No");
					choice = scanner.nextInt();
					switch(choice) {
					case 1:
						System.out.println("상품 인가품의 완료");
						controller.requestAuthorizationOfFSS();
						ArrayList<String> productSalesSupportDetails = controller.enquireProductSalesSupportDetails();
						ArrayList<String> productSalesSupportDetailsContents = new ArrayList<String>();
						for(String content : productSalesSupportDetails) {
							System.out.println(content);
							productSalesSupportDetailsContents.add(scanner.next());
						}
//						controller.
						// 공유를 저장으로 해야하는지?
						controller.saveProductSalesSupportDetails(productSalesSupportDetailsContents);
						// 보험 추가 부분 없음
//						controller.addInsurance();
					case 2:
						bRequestAuthorizationOfFSS = false;
					default:
						break;
					}
				}
				controller.requestAuthorizationOfFSS();
			case 2:
				return;
			default:
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		Main main = new Main();
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.initialize();
		
		Scanner scanner = new Scanner(System.in);
		boolean bOnLoop = true;
		while(bOnLoop) {

			System.out.println("분산투자화재 보험 시스템입니다.");
			System.out.println("0.시스템 종료하기");
			System.out.println("1.고객정보 관리하기"); // -
			System.out.println("2.계약유지활동 진행하기");
			System.out.println("3.월보험료 납입하기"); // 0
			System.out.println("4.가입신청 받기"); // 0
			System.out.println("5.인수심사 진행하기"); // 0
			System.out.println("6.보험 가입하기"); // 0
			System.out.println("7.재보험 처리하기"); // 0
			System.out.println("8.보상운용 관리하기");
			System.out.println("9.보험금 지급하기"); // -
			System.out.println("10.사고 접수하기"); // -
			System.out.println("11.만기계약 관리하기"); // 0
			System.out.println("12.납입정보 관리하기"); // 0
			System.out.println("13.보험 상품 설계하기"); // -

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
					// 민재 20220526완성
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
					// 민재 
					main.payInsuranceMoney(scanner);
					break;
				case 10:
					// 민우 사고 접수를 하다
					// 20220521 수정필요
					// 민재 20220526완성(시나리오 수정)
					main.reportAccident(scanner);
					break;
				case 11:
					main.manageExpirationContract(scanner);
					break;
				case 12:
					// 민재 20220526완성
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