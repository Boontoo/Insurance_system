package view;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Model.accident.Accident;
import Model.application.Application;
import Model.backgroundInfo.BackgroundInfo;
import Model.contract.Contract;
import Model.customer.Customer;
import Model.insurance.Insurance;
import Model.userInfo.UserInfo;
import controller.Controller;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 오후 9:00:56
 */
public class View {

	private Controller controller = new Controller();

	public static ArrayList<Accident> accidentUserList = new ArrayList<Accident>();

	public View() {

	}

	public void finalize() throws Throwable {

	}

	private void manageCustomerInformation(Scanner scanner) {
		// 인배
		boolean bOnLoop = true;
		while (bOnLoop) {
			boolean isContinue = false;
			String choice = "";
			while(!isContinue) {
				System.out.println("고객정보관리하기 메뉴입니다.");
				System.out.println("1.고객정보조회");
				System.out.println("2.메인페이지로 돌아가기");
				choice = scanner.nextLine();
				if(controller.checkNumFormat(choice)) isContinue = true;
				else System.out.println("숫자를 입력해 주세요");
			}
			isContinue = false;
			switch (Integer.parseInt(choice)) {
				case 1:
					String type = "";
					while(!isContinue) {
						System.out.println("조회할 고객 정보의 검색 조건을 선택하세요.");
						System.out.println("1.이름");
						System.out.println("2.나이");
						System.out.println("3.성별");
						System.out.println("4.생년월일");
						type = scanner.nextLine();
						if(controller.checkNumFormat(type)) {
							if(type == "1" || type == "2" || type == "3" || type == "4")
								isContinue = true;
							else {
								System.out.println("잘못입력했습니다.");
								System.out.println("다시 입력해주세요");
							}
						}
						else System.out.println("숫자를 입력해 주세요");
					}
					isContinue = false;
					System.out.println("조회할 고객 정보를 입력하세요.");
					String key = scanner.nextLine();
					// System.out.println(this.controller.enquireCustomerInformation(type, key));
					// 변경 후
					ArrayList<Customer> customerList = this.controller.enquireCustomerInformation(Integer.parseInt(type), key);
					int index = 1;
					for (Customer customer : customerList) {
						System.out.println(index + "." + customer.getCustomerName() + customer.getAge() + customer.isGender()
						+ customer.getBirthDate());
						index++;
					}
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					// if null 필요
					while(!isContinue) {
						System.out.print("세부정보를 확인할 고객의 번호를 입력하세요. : ");
						// int index = scanner.nextInt();
						// 변경 후
						choice = scanner.nextLine();
						if(controller.checkNumFormat(choice)) isContinue = true;
						else System.out.println("숫자를 입력해 주세요");
					}
					isContinue = false;
					// System.out.println(this.controller.enquireCustomerDetailInformation(index));
					//////////////////////////////////////////////////////////////////////
					// 변경 후
					// Customer customer = this.controller.enquireCustomerDetailInformation(index);
					Customer customer = controller.getCustomer(Integer.parseInt(choice));
					System.out.print("이름: " + customer.getCustomerName() + ", ");
					System.out.print("나이: " + customer.getAge() + ", ");
					System.out.print("성별: " + customer.isGender() + ", ");
					System.out.print("주민등록번호: " + customer.getSsn() + ", ");
					System.out.print("직업: " + ", ");
					System.out.print("전화번호: " + customer.getPhoneNum() + ", ");
					System.out.print("가입보험: (");
					index = 1;
					for (String subscribedInsurance : customer.getSubscribedInsurance()) {
						System.out.print(subscribedInsurance);
						if (index != customer.getSubscribedInsurance().size())
							System.out.print(", ");
					}
					System.out.print("), ");
					System.out.println("특이사항: " + customer.getUniqueness());
					//////////////////////////////////////////////////////////////
	
					this.modifyOrDeleteCustomerInformation(scanner, bOnLoop, index);
					break;
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
		// boolean bOnLoop = true;
		while (true) {
			boolean isContinue = false;
			String choice = "";
			while(!isContinue) {
				System.out.println("1.고객 정보를 수정한다.");
				System.out.println("2.고객 정보를 삭제한다.");
				System.out.println("3.고객 정보 재조회");
				choice = scanner.nextLine();
				if(controller.checkNumFormat(choice)) isContinue = false;
				else System.out.println("숫자를 입력해 주세요");
			}
			isContinue = true;
			switch (Integer.parseInt(choice)) {
				case 1:
					System.out.println("고객 정보를 수정한다.");
					boolean bModify = true;
					while (bModify) {
						String type = "";
						while(!isContinue) {
							System.out.println("어떤 정보를 수정하시겠습니까?");
							System.out.println("1.이름");
							System.out.println("2.나이");
							System.out.println("3.직업");
							System.out.println("4.전화번호");
							System.out.println("5.뒤로가기");
							type = scanner.nextLine();
							if(controller.checkNumFormat(type)) isContinue = true;
							else System.out.println("숫자를 입력해 주세요");
						}
						isContinue = false;
						// System.out.println();
						if (Integer.parseInt(type) == 5) break;
						System.out.println("새로운 정보를 입력해주세요.");
						String newInformation = scanner.nextLine();
						if (newInformation != null) {
							//////////////////////////
							// System.out.println(controller.checkCustomerInformation(index, choice,
							// newInformation));
							// 변경 후
							// Customer customer = controller.checkCustomerInformation(index, choice,
							// newInformation);
							Customer customer = controller.getCustomer(index);
							System.out.print("이름: " + customer.getCustomerName() + ", ");
							System.out.print("나이: " + customer.getAge() + ", ");
							System.out.print("직업: " + ", ");
							System.out.print("전화번호: " + customer.getPhoneNum());
							System.out.print(" -> ");
							boolean keepGoing = true;
							switch (Integer.parseInt(type)) {
								case 1:
									System.out.print("이름: " + newInformation + ", ");
									System.out.print("나이: " + customer.getAge() + ", ");
									System.out.print("직업: " + ", ");
									System.out.println("전화번호: " + customer.getPhoneNum());
									break;
								case 2:
									System.out.print("이름: " + customer.getCustomerName() + ", ");
									System.out.print("나이: " + newInformation + ", ");
									System.out.print("직업: " + newInformation + ", ");
									System.out.println("전화번호: " + customer.getPhoneNum());
									break;
								case 3:
									System.out.print("이름: " + customer.getCustomerName() + ", ");
									System.out.print("나이: " + customer.getAge() + ", ");
									System.out.print("직업: " + ", ");
									System.out.println("전화번호: " + customer.getPhoneNum());
									break;
								case 4:
									System.out.print("이름: " + customer.getCustomerName() + ", ");
									System.out.print("나이: " + customer.getAge() + ", ");
									System.out.print("직업: " + ", ");
									System.out.println("전화번호: " + newInformation);
									break;
								// case 5:
								// bModify = false;
								// keepGoing = false;
								// break;
								default:
									System.out.println("잘못 선택하셨습니다. 다시 선택해주세요.");
									keepGoing = false;
									break;
							}

							if (keepGoing) {
								////////////////////////////////////////////////////////////
								while(!isContinue) {
									System.out.println("1.저장");
									System.out.println("2.재작성");
									choice = scanner.nextLine();
									if(controller.checkNumFormat(choice)) isContinue = true;
									else System.out.println("숫자를 입력해 주세요");
								}
								isContinue = false;
								// 변경 후
								switch (Integer.parseInt(choice)) {
									case 1:
										if (controller.modifyCustomerInformation(index, Integer.parseInt(type), newInformation)) {
											System.out.println("저장되었습니다!");
											customer = controller.getCustomer(index);
											System.out.print("이름: " + customer.getCustomerName() + ", ");
											System.out.print("나이: " + customer.getAge() + ", ");
											System.out.print("성별: " + customer.isGender() + ", ");
											System.out.print("주민등록번호: " + customer.getSsn() + ", ");
											System.out.print("직업: " + ", ");
											System.out.print("전화번호: " + customer.getPhoneNum() + ", ");
											System.out.print("가입보험: (");
											index = 1;
											for (String subscribedInsurance : customer.getSubscribedInsurance()) {
												System.out.print(subscribedInsurance);
												if (index != customer.getSubscribedInsurance().size())
													System.out.print(", ");
											}
											System.out.print("), ");
											System.out.println("특이사항: " + customer.getUniqueness());
											return;
										} else {
											System.out.println("저장에 실패하였습니다.");
											break;
										}
									case 2:
										// bModify = false;
										break;
								}
							}
							//////////////////////////////////////////////////////////////

							// switch(choose)
							// if(choice == 1) {
							// System.out.println(controller.modifyCustomerInformation(index, type,
							// newInformation));
							// System.out.println(this.controller.enquireCustomerDetailInformation(index));
							// return;
							// // bOnLoop = false;
							// }
							// else if(choice == 2) {
							// break;
							// }
						} else {
							System.out.println("수정 정보를 다시 입력해주세요.");
						}
					}
					break;
				case 2:
					// System.out.println(this.controller.enquireCustomerDetailInformation(index));
					// 변경 후
					boolean bDelete = true;
					while (bDelete) {
						System.out.println("고객 정보를 삭제한다.");
						Customer customer = controller.getCustomer(index);
						System.out.print("이름: " + customer.getCustomerName() + ", ");
						System.out.print("나이: " + customer.getAge() + ", ");
						System.out.print("성별: " + customer.isGender() + ", ");
						System.out.print("주민등록번호: " + customer.getSsn() + ", ");
						System.out.print("직업: " + ", ");
						System.out.print("전화번호: " + customer.getPhoneNum() + ", ");
						System.out.print("가입보험: (");
						index = 1;
						for (String subscribedInsurance : customer.getSubscribedInsurance()) {
							System.out.print(subscribedInsurance);
							if (index != customer.getSubscribedInsurance().size())
								System.out.print(", ");
						}
						System.out.print("), ");
						System.out.println("특이사항: " + customer.getUniqueness());
						///////////////////////////////////////////////////////////////
						while(!isContinue) {
							System.out.println("해당 고객을 삭제하겠습니까?");
							System.out.println("1.삭제");
							System.out.println("2.뒤로가기");
							choice = scanner.nextLine();
							if(controller.checkNumFormat(choice)) isContinue = true;
							else System.out.println("숫자를 입력해 주세요");
						}
						isContinue = true;
						// 변경 후
						switch (Integer.parseInt(choice)) {
							case 1:
								System.out.println("삭제 고객ID를 입력하세요.");
								String id = scanner.nextLine();
								if (this.controller.deleteCustomerInformation(index, id)) {
									System.out.println("고객ID가 확인되었습니다.");
									System.out.println("고객 정보가 삭제 완료되었습니다.");
									return;
								} else {
									System.out.println("고객ID와 일치하지 않습니다. 다시 입력해주세요.");
									break;
								}
							case 2:
								bDelete = false;
								break;
							default:
								break;
						}
						/////////////////////////////////////////////////////////////////
						// if(choice == 1) {
						// System.out.println("삭제 고객ID를 입력하세요.");
						// String id = scanner.next();
						// System.out.println(controller.deleteCustomerInformation(index, id));
						// }
						// else if(choice == 2) {
						// break;
						// }
						// //수정필요
						// bOnLoop = false;
						// break;
					}
					break;
				case 3:
					return;
				// bOnLoop = false;
				// break;
			}
		}
	}

	private void startContractMaintenanceActivities(Scanner scanner) {
		// 계약 유지 관리 - 기존 만기일보다 이전 날짜 입력시 입력 적용되는 에러 발생 - 이거 해결할 것
		System.out.print("계약 유지 관리를 진행하겠습니까? (1.진행, 그이외.뒤로가기) : ");
		if (!scanner.nextLine().equals("1"))
			return;
		try {
			String selectedId = "";
			ArrayList<Contract> expOneMonthList;
			while (true) {
				String result = "";
				String renewConsultStr = "";
				expOneMonthList = controller.enquireExpOneMonthList(LocalDate.now().toString());
				for (Contract contract : expOneMonthList) {
					renewConsultStr = contract.isRenewConsult() ? "예" : "아니오";
					result += contract.getId() + "   " +
							controller.getCustByCont(contract).getCustomerName() + "   " +
							contract.getExpirationDate() + "   " +
							renewConsultStr + "\n";
				}
				System.out.println("[만료 한달 남은 계약 리스트]\n" + result);
				System.out.print("아이디를 선택해 주세요(0.뒤로 가기) : ");
				selectedId = scanner.nextLine();
				if (selectedId.equals("0"))
					return;
				Contract selContract = controller.getContById(selectedId);
				if (selContract == null) {
					System.out.println("입력 아이디가 리스트에 없습니다");
					continue;
				}
				if (selContract.isRenewConsult()) {
					System.out.println("상담 완료한 고객입니다.");
					continue;
				}
				String isRenewConsultStr = selContract.isRenewConsult() ? "예" : "아니오";
				System.out.println("[해당 계약의 세부 정보]");
				System.out.println("고객 이름 : " + controller.getCustByCont(selContract).getCustomerName() + "\n" +
						"전화번호 : " + controller.getCustByCont(selContract).getPhoneNum() + "\n" +
						"가입 보험 : " + controller.getInsByCont(selContract).getInsuranceName() + "\n" +
						"만료일 : " + selContract.getExpirationDate() + "\n" +
						"갱신상담 여부 : " + isRenewConsultStr);
				System.out.print("\n고객에게 전화를 겁니다.");
				for (int i = 0; i < 3; i++) {
					System.out.print(".");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("\n고객의 응답 여부(1.예  그 이외.아니오(돌아가기)) : ");
				if (!scanner.nextLine().equals("1"))
					continue;
				System.out.print("보험을 갱신하겠습니까?(1.yes  그 이외.no) : ");
				if (scanner.nextLine().equals("1")) {
					String expDate = "";
					boolean isContinue = false;
					while (!isContinue) {
						expDate = checkDate(scanner);
						if (controller.checkInputDateBefore(expDate, selectedId))
							isContinue = true;
						else
							System.out.println("이후 날짜를 입력해 주세요");
					}
					isContinue = false;
					controller.renewExpirationDateById(expDate, selectedId);
					System.out.println("만기일이 연장되었습니다(만기일 : " + expDate + ")");
					return;
				} else
					controller.changeRenewConsult(selectedId);
			}
		} catch (ParseException e) {
			System.out.println("날짜 비교에 실패했습니다.");
		}
	}

	private void payInsuranceFee(Scanner scanner, UserInfo submitUser) {
		// 민재 - 월 보험료 납입하기
		// 파라미터 추가(22.06.03)
		while (true) {
			// ArrayList<Contract> contList = controller.enquireContractList();
			ArrayList<Contract> contList = controller.enquireContractListBySubUser(submitUser);
			boolean isContinue = false;
			String selected = null;
			while (!isContinue) {
				String result = "";
				String payStatus;
				for (int i = 0; i < contList.size(); i++) {
					payStatus = contList.get(i).isPayStatus() ? "예" : "아니오";
					result += i + 1 + ". " +
							controller.getCustByCont(contList.get(i)).getCustomerName() + "    " +
							controller.getInsByCont(contList.get(i)).getInsuranceName() + "    " +
							contList.get(i).getPayAmount() + "    " +
							payStatus + "\n";
				}
				System.out.println("[보험 상품 납입 정보]");
				System.out.println(result);
				System.out.print("납부할 보험상품 선택번호를 입력하세요(0.뒤로 가기) : ");
				selected = scanner.nextLine();
				if (selected.equals("0"))
					return;
				if (controller.checkNumFormat(selected) &&
						Integer.parseInt(selected) > 0 &&
						Integer.parseInt(selected) <= contList.size())
					isContinue = true;
				else
					System.out.println("번호를 다시 입력해 주세요");
			}
			isContinue = false;
			Contract selectedContract = contList.get(Integer.parseInt(selected) - 1);
			String inputPay = null;
			while (!isContinue) {
				System.out.print("납입 금액 입력 : ");
				inputPay = scanner.nextLine();
				if (inputPay.length() == 0 || !controller.checkNumFormat(inputPay)) {
					System.out.println("금액을 입력해 주세요");
					continue;
				}
				if (Integer.parseInt(inputPay) >= selectedContract.getPayAmount())
					isContinue = true;
				else
					System.out.println("납입 금액 이상 입력해 주세요");
			}
			isContinue = false;
			String custName = controller.getCustByCont(selectedContract).getCustomerName();
			String insName = controller.getInsByCont(selectedContract).getInsuranceName();
			if (!selectedContract.isPayStatus()) {
				controller.saveAmountOfInsuranceFee(selectedContract, Integer.parseInt(inputPay));
				System.out.println("\n" + "[영업 활동 부서에 보낼 납입 정보]\n" +
						"보험 가입자 이름 : " + custName + "\n" +
						"보험 상품 이름 : " + insName + "\n" +
						"납입 금액 : " + inputPay);
				System.out.println("\n<월 보험료 납입이 완료되었습니다>");
				System.out.println("가입 보험 상품 이름 : " + insName +
						"\n납입 금액 : " + selectedContract.getPayAmount() +
						"\n총 납입 금액 : " + selectedContract.getTotalPayAmount());
			} else
				System.out.println("이미 월 납입을 완료하셨습니다");
			String inputBinCase = null;
			while (!isContinue) {
				System.out.println("\n<다른 보험 상품을 납부하시겠습니까?>");
				System.out.print("(1. 예, 2. 아니오) : ");
				inputBinCase = scanner.nextLine();
				if (!controller.checkNumFormat(inputBinCase) ||
						!(Integer.parseInt(inputBinCase) == 1 ||
								Integer.parseInt(inputBinCase) == 2))
					System.out.println("1 혹은 2를 입력해 주세요");
				else
					isContinue = true;
			}
			if (inputBinCase.equals("2")) {
				System.out.println("===========================");
				return;
			}
		}
	}

	private void applyForMembership(Scanner scanner) {
		// 민재 - 가입 신청 받기
		boolean ageCheck;
		System.out.print("가입신청을 진행하시겠습니까? (1.진행, 그 이외.뒤로가기) : ");
		if (!scanner.next().equals("1"))
			return;
		scanner.nextLine();
		while (true) {
			boolean isNameIn = false;
			String name = null;
			String insuranceName = null;
			while (!isNameIn) {
				System.out.print("고객 이름 : ");
				name = scanner.nextLine();
				if (controller.checkInCustList(name))
					isNameIn = true;
				else
					System.out.println("입력된 정보가 고객으로 등록되어있지 않습니다. 다시 입력하세요");
			}
			isNameIn = false;
			while (!isNameIn) {
				System.out.print("가입 희망 보험 : ");
				insuranceName = scanner.nextLine();
				if (controller.checkInInsList(insuranceName))
					isNameIn = true;
				else
					System.out.println("입력된 정보가 보험으로 등록되어있지 않습니다. 다시 입력하세요");
			}
			System.out.print("전화번호 : ");
			String phoneNum = scanner.nextLine();
			String age = null;
			ageCheck = false;
			while (!ageCheck) {
				System.out.print("나이 : ");
				age = scanner.nextLine();
				if (controller.checkNumFormat(age))
					ageCheck = true;
				// 나이나 숫자 입력 시 24를 2 4 이렇게 입력하면 에러 생기던데 시간 나면 해결해 보자
				else
					System.out.println("나이를 다시 입력해 주세요");
			}
			System.out.print("성별(1.남자, 그 이외.여자) : ");
			boolean gender = scanner.nextLine().equals("1");
			System.out.print("직업 : ");
			String jop = scanner.nextLine();
			System.out.print("주민번호 : ");
			String SSN = scanner.nextLine();
			boolean result = this.controller.applyForMembership(insuranceName, phoneNum, age, gender, name, jop, SSN);
			if (!result) {
				System.out.println("올바른 형식에 맞게 입력하세요");
				continue;
			} else {
				System.out.println("가입 신청이 정상적으로 진행됩니다");
				break;
			}
		}
		System.out.println("==================================");
	}

	private void startUW(Scanner scanner) {
		// 민재 - 인수심사 진행하기
		while (true) {
			String selList = "";
			for (Application afMembership : controller.enquireApplicationList())
				selList += afMembership.toString() + "\n";
			System.out.println(selList);
			System.out.print("선택번호를 입력해 주세요(0 : 뒤로가기) : ");
			String choice = scanner.nextLine();
			if (choice.equals("0")) return;
			boolean checkInID = controller.checkInID(choice + "");
			if (!checkInID) {
				System.out.println("선택번호 내 번호를 다시 입력해 주세요");
				continue;
			}
			System.out.println("입력 번호 : " + choice);
			if (controller.checkAlreadyJudged(choice + "")) {
				System.out.println("이미 인수심사가 완료된 신청정보입니다. 다른 번호를 입력해 주세요");
				continue;
			}
			boolean automaticExaminationResult = startAutomaticJudge(scanner, choice + "");
			System.out.print("진단심사 결과(1.합격, 그이외.불합격) : ");
			boolean diagnosticExaminationResult = scanner.nextLine().equals("1");
			System.out.print("이미지심사 결과(1.합격, 그이외.불합격) : ");
			boolean imageExaminationResult = scanner.nextLine().equals("1");
			System.out.print("특인심사 결과(1.합격, 그이외.불합격) : ");
			boolean specialExaminationResult = scanner.nextLine().equals("1");
			System.out.print("일반심사 결과(1.합격, 그이외.불합격) : ");
			boolean generalExaminationResult = scanner.nextLine().equals("1");
			boolean uwResult = controller.enquireUWResult(choice + "", automaticExaminationResult,
					diagnosticExaminationResult,
					imageExaminationResult, specialExaminationResult, generalExaminationResult);
			if (uwResult) {
				System.out.println("인수심사에 합격하였습니다");
				break;
			}
			String result = "인수심사에 불합격하였습니다\n사유 : ";
			if (!automaticExaminationResult) System.out.println(result + "자동심사");
			else if (!diagnosticExaminationResult) System.out.println(result + "진단심사");
			else if (!imageExaminationResult) System.out.println(result + "이미지심사");
			else if (!specialExaminationResult) System.out.println(result + "특인심사");
			else System.out.println(result + "일반심사");
			System.out.println(
					"타보험사에 보낼 가입 희망 보험 정보\n" + controller.enquireApplication(choice + "").toString());
			break;
		}
		System.out.println("==================================");
	}

	private boolean startAutomaticJudge(Scanner scanner, String id) throws InputMismatchException {
		// 새로 만든 함수(자동심사)
		while (true) {
			System.out.print("본인 소유의 건물(1.예, 그이외.아니오) : ");
			boolean isOwnedBuilding = scanner.nextLine().equals("1");
			System.out.print("리모델링 여부(1.예, 그이외.아니오) : ");
			boolean isRemodeling = scanner.nextLine().equals("1");
			boolean checkPointInteger = false;
			String buildingAgeScore = null;
			String fireEquipmentConditionScore = null;
			String buildingLocationScore = null;
			String buildingConditionScore = null;

			while (!checkPointInteger) {
				System.out.print("건물 연식(점수 입력 - 0점~20점) : ");
				buildingAgeScore = scanner.nextLine();
				System.out.print("화재 설비 상태(점수 입력 - 0점~20점) : ");
				fireEquipmentConditionScore = scanner.nextLine();
				System.out.print("건물 위치(점수 입력 - 0점~20점) : ");
				buildingLocationScore = scanner.nextLine();
				System.out.print("건물 가격(점수 입력 - 0점~20점) : ");
				buildingConditionScore = scanner.nextLine();
				if (controller.checkNumFormat(buildingAgeScore) &&
						controller.checkNumFormat(fireEquipmentConditionScore) &&
						controller.checkNumFormat(buildingLocationScore) &&
						controller.checkNumFormat(buildingConditionScore))
					checkPointInteger = true;
				else System.out.println("점수는 숫자로 입력해 주세요");
			}
			// 파라미터 길이 줄일 것
			if (!controller.checkPointInput(Integer.parseInt(buildingAgeScore),
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
		while (true) {
			try {
				ArrayList<Application> passedCustomerList = controller.enquirePassedCustomerInUW();
				for (int i = 0; i < passedCustomerList.size(); i++) {
					System.out.println(i + 1 + ". " +
							passedCustomerList.get(i).getCustomerName() + "  " +
							passedCustomerList.get(i).getPhoneNum() + "  " +
							passedCustomerList.get(i).getInsuranceName());
				}
				System.out.print("신청할 고객 정보를 선택하세요(0 : 뒤로가기) : ");
				String choice = scanner.nextLine();
				if (choice.equals("0")) return;
				if (!controller.checkNumFormat(choice)) {
					System.out.println("번호를 입력해 주세요");
					continue;
				}
				if (!(Integer.parseInt(choice) > 0 && Integer.parseInt(choice) <= passedCustomerList.size())) {
					System.out.println("번호에 해당하는 고객이 없습니다");
					continue;
				}
				Application passedCustomer = passedCustomerList.get(Integer.parseInt(choice) - 1);
				System.out.println("\n[선택 고객 세부 정보]");
				String genderStr = passedCustomer.isGender() ? "남자" : "여자";
				System.out.println("이름 : " + passedCustomer.getCustomerName() +
						"\n주민번호 : " + passedCustomer.getSSN() +
						"\n전화번호 : " + passedCustomer.getPhoneNum() +
						"\n성별 : " + genderStr +
						"\n가입 요청 보험명 : " + passedCustomer.getInsuranceName());
				System.out.print("\n가입 신청 하시겠습니까?(1. 예, 그이외. 뒤로가기) : ");
				String checkInput = scanner.nextLine();
				if (!checkInput.equals("1"))
					continue;
				if (controller.makeInsuranceContract(passedCustomer, checkDate(scanner))) {
					System.out.println("가입 신청이 완료되었습니다(신규 가입 정보)");
					System.out.println("id 고객ID 만기일 가입보험ID 지불금액 납입여부");
					System.out.println(controller.enquireNewContractInformation().toString());
				} else {
					System.out.println("가입 고객을 찾지 못하였습니다 다시 입력해 주세요");
					continue;
				}
				System.out.println("============================");
				break;
			} catch (ParseException e) {
				System.out.println("날짜 비교에 실패했습니다.");
			}
		}
	}

	private String checkDate(Scanner scanner) throws ParseException {
		// 새로 만든 함수
		while (true) {
			System.out.print("지정할 만기일(YYYY-MM-DD) : ");
			String date = scanner.next();
			if (!controller.checkInputDateFormat(date)) {
				System.out.println("날짜 입력 형식이 올바르지 않습니다.");
				continue;
			}
			if (controller.checkInputDateBeforeToday(date, LocalDate.now().toString())) {
				System.out.println("오늘 날짜 이후로 입력해 주세요");
				continue;
			}
			scanner.nextLine();
			return date;
		}
	}

	private void reinsurance(Scanner scanner) {
		// 민재 - 재보험 처리하기
		String name;
		String sSN;
		System.out.print("무엇을 하시겠습니까?\n1. 산출 2. 정산 3. 재보험 등록 (그 이외. 뒤로가기) : ");
		String selectCase = scanner.nextLine();
		if (!(selectCase.equals("1") ||
				selectCase.equals("2") ||
				selectCase.equals("3"))) {
			System.out.println("=========================");
			return;
		}
		while (true) {
			try {
				System.out.print("이름 : ");
				name = scanner.nextLine();
				System.out.print("주민번호 : ");
				sSN = scanner.nextLine();
				if (!controller.checkCitizenNumFormat(sSN)) {
					System.out.println("주민번호를 다시 입력해 주세요");
					continue;
				}
				if (!controller.checkValidCustomer(name, sSN)) {
					System.out.println("입력 정보에 맞는 고객 혹은 가입한 보험이 없습니다.");
					return;
				}
				String result = "";
				ArrayList<Insurance> submitInsList = controller.enquireCustInsurances(name, sSN);
				switch (Integer.parseInt(selectCase)) {
					case 1:
						System.out.println("[산출 재보험료 정보]");
						System.out.println("이름 : " + name);
						System.out.println("주민번호 : " + sSN);
						for (Insurance insurance : submitInsList)
							result += "기입된 보험명 : " + insurance.getInsuranceName() + ", "
									+ "재보험료 : " + insurance.getReInsuranceFee();
						System.out.println("<가입 보험명, 재보험료 목록>");
						System.out.println(result);
						System.out.println("=========================");
						break;
					case 2:
						while (true) {
							int index = 0;
							result = name + " 고객의 보험 가입 정보\n";
							for (Insurance insurance : submitInsList)
								result += ++index + ". " + insurance.getInsuranceName() + "\n";
							System.out.println(result);
							System.out.print("선택 번호 : ");
							String selectInsNum = scanner.nextLine();
							if (!controller.checkNumFormat(selectInsNum)) {
								System.out.println("선택 번호를 다시 입력해 주세요");
								continue;
							}
							if (!(Integer.parseInt(selectInsNum) > 0
									&& Integer.parseInt(selectInsNum) <= submitInsList.size())) {
								System.out.println("선택 번호 해당 정보가 없습니다. 다시 입력해 주세요");
								continue;
							}
							String payInsName = submitInsList.get(Integer.parseInt(selectInsNum) - 1)
									.getInsuranceName();
							System.out.println("-------------------------\n" +
									"고객 명 : " + name +
									"\n주민번호 : " + sSN +
									"\n정산된 보험명 : " + payInsName);
							String payFee = null;
							boolean isContinue = false;
							while (!isContinue) {
								System.out.print("정산 요금 입력 : ");
								payFee = scanner.nextLine();
								if (controller.checkNumFormat(payFee))
									isContinue = true;
								else
									System.out.println("지불 금액을 다시 입력해 주세요");
							}
							isContinue = false;
							System.out.print("정산하겠습니까?(1. 예, 그이외. 아니오) : ");
							if (!scanner.next().equals("1")) {
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
						while (true) {
							int index = 0;
							result = name + " 고객의 보험 가입 정보\n";
							for (Insurance insurance : submitInsList)
								result += ++index + ". " + insurance.getInsuranceName() + "\n";
							System.out.println(result);
							System.out.print("선택 번호 : ");
							String selectInsNum = scanner.nextLine();
							if (!controller.checkNumFormat(selectInsNum)) {
								System.out.println("선택 번호를 다시 입력해 주세요");
								continue;
							}
							if (!(Integer.parseInt(selectInsNum) > 0
									&& Integer.parseInt(selectInsNum) <= submitInsList.size())) {
								System.out.println("선택 번호 해당 정보가 없습니다. 다시 입력해 주세요");
								continue;
							}
							Insurance selectedIns = submitInsList.get(Integer.parseInt(selectInsNum) - 1);
							Customer selectCust = controller.getCustBySsn(sSN);
							Contract selectCont = controller.getContByCustInsId(selectedIns.getId(),
									selectCust.getId());
							String isRenewStr = selectedIns.isRenew() ? "예" : "아니오";
							System.out.println("-------------------------\n" +
									"고객명 : " + name +
									"\n주민번호 : " + sSN +
									"\n보험명 : " + selectedIns.getInsuranceName() +
									"\n만기일 : " + selectCont.getExpirationDate() +
									"\n재등록 보험 요금 : " + selectedIns.getReInsuranceFee() +
									"\n갱신 여부 : " + isRenewStr);
							System.out.print("재보험 등록하겠습니까?\n(1. 등록, 그 이외. 뒤로가기) : ");
							if (!scanner.next().equals("1")) {
								System.out.println("=========================");
								return;
							}
							System.out.println("\n[재보험 등록 정보]\n" +
									"고객명 : " + name +
									"\n주민번호 : " + sSN +
									"\n보험명 : " + selectedIns.getInsuranceName() +
									"\n재등록 보험 요금 : " + selectedIns.getReInsuranceFee() + "\n"
									+ "<재보험 등록이 완료되었습니다>");
							System.out.println("=========================");
							break;
						}
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("정수를 입력해 주세요");
				continue;
			}
		}
	}

	// private String showInputCustInsurances(Scanner scanner, String name, String
	// sSN) {
	// // 새로 만든 함수
	// // 삭제(22.06.01)
	// return null;
	// }

	// private void manageCompensationManagement(Scanner scanner) {
	// // 보상 운용 관리
	// }

	private void payInsuranceMoney(Scanner scanner) {
		// 보험금 지급
		boolean isContinue = false;
		String name = "";
		String sSN = "";
		String accidentId = "";
		System.out.print("보험금 지급 진행하겠습니까?(1.진행, 그이외.뒤로가기) : ");
		if (!scanner.nextLine().equals("1")) return;
		ArrayList<Accident> accList = controller.enquireAccidentList();
		String result = "";
		String payedMoneyStr = "";
		for (Accident accidentReception : accList) {
			payedMoneyStr = accidentReception.isPayed() ? "예" : "아니오";
			Customer customer = controller.getCustByCont(controller.getContByAccident(accidentReception));
			result += customer.getCustomerName() + "      " + customer.getSsn() + "     " +
					accidentReception.getAccidentID() + "           " + payedMoneyStr + "\n";
		}
		if (accList.size() == 0) {
			System.out.println("처리할 정보가 없습니다");
			System.out.println("=========================");
			return;
		}
		while (!isContinue) {
			System.out.println("[처리할 사고 선택]\n고객 이름    주민번호            사건번호    보험금 지급 여부");
			System.out.println(result);
			System.out.print("고객 이름 : ");
			name = scanner.nextLine();
			System.out.print("주민 번호 : ");
			sSN = scanner.nextLine();
			System.out.print("사건 번호 : ");
			accidentId = scanner.nextLine();
			if (controller.checkInAccidentList(name, sSN, accidentId)) isContinue = true;
			else System.out.println("입력 형식이 맞지 않습니다(고객이름, 주민번호, 사건번호)");
		}
		isContinue = false;
		// 사고 접수자 상품명, 납입 기간, 납입 주기 출력 -> 사고 접수자의 이름, 나이, 직업, 사고 위치, 사고 유형, 상품명으로 시나리오
		// 바꿀 것

		result = "";
		Accident accidentReception = controller.enquireDetailAccidentInfo(accidentId);
		Contract contract = controller.getContByAccident(accidentReception);
		Customer customer = controller.getCustByCont(contract);
		result += "이름 : " + customer.getCustomerName() + "\n" +
				"나이 : " + customer.getAge() + "\n" +
				"사고 위치 : " + accidentReception.getLocation() + "\n" +
				"사고 유형 : " + accidentReception.getAccidentType() + "\n" +
				"상품명 : " + controller.getInsByCont(contract).getInsuranceName();
		System.out.println("\n[사고 접수자 사고 및 가입 정보]");
		System.out.println(result);
		System.out.print("보험금을 지급하겠습니까?(1.지급  그이외.취소) : ");
		if (!scanner.nextLine().equals("1")) {
			System.out.println("\n보험금 지급을 취소합니다.");
			System.out.println("=========================");
			return;
		}
		if (controller.enquireDetailAccidentInfo(accidentId).isPayed()) {
			System.out.println("\n<이미 보험금 지급이 완료된 고객입니다>\n=========================");
			return;
		}
		controller.payInsuranceMoney(accidentId);
		System.out.println("\n[보험금 지급이 완료되었습니다]");
		System.out.println("약물 치료비 : 12000원\n"
				+ "입원비 : 21000원\n"
				+ "수술비 : 17000원\n"
				+ "재산보상비 : 15000원");
		System.out.println("보상 기획부서에 위 내역을 지원합니다");
		System.out.println("=========================");
	}

	private void reportAccident(Scanner scanner) {
		// EA 시나리오 사고를 접수하다? -> 사고 처리 하기
		// 민우(재)
		// 이거 시나리오 다시 써야 함
		boolean isContinue = false;
		String name = "";
		while (!isContinue) {
			System.out.print("보험 가입자 이름 : ");
			name = scanner.nextLine();
			if (controller.checkInCustList(name)) isContinue = true;
			else System.out.println("입력 고객이 고객 리스트에 없습니다");
		}
		isContinue = false;
		String phoneNum = "";
		while (!isContinue) {
			System.out.print("전화번호 : ");
			phoneNum = scanner.nextLine();
			if (controller.checkPhoneNumFormat(phoneNum)) isContinue = true;
			else System.out.println("입력 형식에 맞게 입력해 주세요");
		}
		isContinue = false;
		String accidentLocation = "";
		while (!isContinue) {
			System.out.print("사고위치 : ");
			accidentLocation = scanner.nextLine();
			if (accidentLocation.length() != 0) isContinue = true;
			else System.out.println("내용을 입력해 주세요");
		}
		isContinue = false;
		String accidentType = "";
		while (!isContinue) {
			System.out.print("사고유형 : ");
			accidentType = scanner.nextLine();
			if (accidentType.length() != 0) isContinue = true;
			else System.out.println("내용을 입력해 주세요");
		}
		isContinue = false;
		if (!controller.checkCustContracted(name, phoneNum)) {
			System.out.println("해당 정보를 조회할 수 없습니다");
			System.out.println("=======================");
			return;
		}
		ArrayList<Contract> contractList = controller.enquireCustomerContracted(name);
		String result = "";
		for (Contract contract : contractList)
			result += contract.getId() + ".  " +
					controller.getInsByCont(contract).getInsuranceName() + "   " +
					contract.getExpirationDate() + "\n";

		System.out.println("[" + name + " 고객님이 가입한 가입 정보]");
		System.out.println("ID     보험 이름      만기일");
		System.out.println(result);
		String selectedID = null;
		while (!isContinue) {
			System.out.print("어떤 보험을 적용하겠습니까?(ID입력) : ");
			selectedID = scanner.nextLine();
			if (controller.checkIdInContract(selectedID, name)) isContinue = true;
			else System.out.println("입력 아이디가 존재하지 않습니다. 다시 입력하세요");
		}
		isContinue = false;
		controller.saveAccident(selectedID, accidentLocation, accidentType);
		Accident recentRecept = controller.enquireAccidentList()
				.get(controller.enquireAccidentList().size() - 1);
		System.out.println("\n[사고 접수 정보]");
		System.out.println("적용 보험 이름 : "
				+ controller.getInsByCont(controller.getContByAccident(recentRecept)).getInsuranceName() + "\n" +
				"잔여 무료 렉카 서비스 횟수 : " + recentRecept.getTowTruckCallNum());
		System.out.print("\n직원콜여부(1.yes 그이외.no) : ");
		String employeeCallStatus = scanner.nextLine();
		if (employeeCallStatus.equals("1")) {
			System.out.println("\n[관할 직원에 보낼 사고 정보]\n이름      전화번호         사고위치      사고유형");
			System.out.println(name + "    " + phoneNum + "    " + accidentLocation + "       " + accidentType);
		}
		System.out.print("렉카콜여부(1.yes 그이외.no) : ");
		String towTruckCallStatus = scanner.nextLine();
		if (!towTruckCallStatus.equals("1"))
			return;
		System.out.println("\n[관할 렉카 협력업체에 보낼 사고 정보]\n이름    사고위치    사고유형");
		System.out.println(name + "    " + accidentLocation + "      " + accidentType);
		System.out.println("=======================");
	}

	private void manageExpirationContract(Scanner scanner) {
		// 만기계약 관리
		boolean isContinue = false;
		System.out.print("만기 계약 관리를 진행하겠습니까?\n(1.진행   그이외.뒤로가기) : ");
		if (!scanner.nextLine().equals("1")) return;
		String choice = "";
		ArrayList<Contract> contractList;
		while (!isContinue) {
			contractList = controller.enquireExpirationContractList();
			String result = "";
			int idx = 0;
			for (Contract contract : contractList)
				result += ++idx + "         " +
						controller.getCustByCont(contract).getCustomerName() + "   " +
						controller.getInsByCont(contract).getInsuranceName() + "    " +
						contract.getExpirationDate() + "\n";
			System.out.println("[만기 계약 정보 관리]");
			System.out.println("선택번호    이름     가입 보험          만기일");
			if (contractList.size() == 0) return;
			System.out.println(result);
			System.out.print("관리할 정보를 선택하세요(0.뒤로가기) : ");
			choice = scanner.nextLine();
			if (choice.equals("0")) return;
			if (controller.checkInContractList(choice)) isContinue = true;
			else System.out.println("알맞는 번호를 선택해 주세요");
		}
		isContinue = false;
		String inputCase = "";
		while (!isContinue) {
			System.out.print("1.계약 연장\n그이외.계약 해지\n입력 : ");
			inputCase = scanner.nextLine();
			if (!inputCase.equals("1")) {
				System.out.println("해당 고객은 만기일 이후 계약이 해지됩니다.");
				System.out.println("=========================");
				return;
			}
			if (inputCase.length() != 0)
				isContinue = true;
			else System.out.println("진행 동작을 입력해 주세요");
		}
		isContinue = false;
		String newExpirationDate = "";
		while (!isContinue) {
			System.out.print("만기일 입력 : ");
			newExpirationDate = scanner.nextLine();
			if (!controller.checkInputDateFormat(newExpirationDate)) {
				System.out.println("날짜 형식에 맞춰 다시 입력해 주세요(YYYY-MM-DD)");
				continue;
			}
			if (!controller.compareBeforeDate(newExpirationDate, choice)) {
				System.out.println("기존 만기일 이후 날짜를 입력해 주세요");
				continue;
			}
			isContinue = true;
		}
		controller.renewExpirationDate(newExpirationDate, choice);
		System.out.println("만기일이 연장되었습니다(만기일 : " + newExpirationDate + ")");
		System.out.println("=========================");
	}

	private void managePaymentInformation(Scanner scanner) {
		// 납입 정보 관리
		// 민재
		while (true) {
			String selectInput = null;
			boolean isContinue = false;
			while (!isContinue) {
				System.out.print("\n<무엇을 하시겠습니까?>"
						+ "\n1.보험료 납입 현황을 출력한다"
						+ "\n2.월 보험료 납입 현황을 초기화 한다"
						+ "\n0.뒤로가기"
						+ "\n입력 : ");
				selectInput = scanner.nextLine();
				if (controller.checkNumFormat(selectInput) &&
						controller.checkInMenu(selectInput))
					isContinue = true;
				else
					System.out.println("<선택 메뉴 내 번호를 입력해 주세요>");

			}
			isContinue = false;
			if (selectInput.equals("0"))
				return;
			switch (Integer.parseInt(selectInput)) {
				case 1:
					ArrayList<Contract> contractList = controller.enquireContractList();
					String isPay = "";
					String result = "";
					for (Contract contract : contractList) {
						isPay = contract.isPayStatus() ? "예" : "아니오";
						result += controller.getCustByCont(contract).getCustomerName() + "    " +
								controller.getCustByCont(contract).getPhoneNum() + "    " +
								controller.getInsByCont(contract).getInsuranceName() + "    " +
								contract.getPayAmount() + "    " + isPay + "\n";
					}

					System.out.println("[보험 가입자의 보험 상품 가입 현황]");
					System.out.println("<이름    전화번호            가입 보험       납입 금액  납입 여부>");
					System.out.println(result + "\n=========================");
					return;
				case 2:
					while (!isContinue) {
						System.out.print("\n월 보험료 미납입 고객이 " + controller.countInsuranceFeeNotPaid() +
								"명 있습니다.\n계속 진행하겠습니까?" +
								"\n(1.진행 2.취소) : ");
						selectInput = scanner.nextLine();
						if (controller.checkNumFormat(selectInput) &&
								(selectInput.equals("1") || selectInput.equals("2")))
							isContinue = true;
						else
							System.out.println("선택 메뉴 내 번호를 입력해 주세요");
					}
					if (selectInput.equals("2"))
						break;
					else {
						controller.initializeInsuranceFeePaymentStatus();
						System.out.println("\n납입 여부 초기화가 완료되었습니다\n=========================");
						return;
					}
			}
		}
	}

	private void designInsuranceProductMenu(Scanner scanner) {
		while (true) {
			// 없애야 할 것 ////////////////
			controller.setData(); //////
			/////////////////////////////
			System.out.println("1.보험 상품 설계");
			System.out.println("2.보험 상품 관리");
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					boolean bStartDesign = true;
					while (bStartDesign) {
						System.out.println("1.새로 설계하기");
						System.out.println("2.이어서 설계하기");
						choice = scanner.nextInt();
						switch (choice) {
							case 1:
								this.controller.designNewInsuranceProduct();
								this.designInsuranceProduct(scanner);
								bStartDesign = false;
								break;
							case 2:
								System.out.println("설계중인 보험이름을 입력하세요.");
								int point = this.controller.checkInsuranceUnderDesign(scanner.next());
								switch (point) {
									case 0:
										System.out.println("해당 이름의 설계중인 보험 상품이 없습니다.");
										System.out.println("보험 상품 설계하기 메뉴로 돌아갑니다.");
										bStartDesign = false;
										break;
									case 1:
										System.out.println("진행중인 작업이 있습니다.");
										this.designInsuranceProduct(scanner);
										bStartDesign = false;
										break;
									case 2:
										System.out.println("해당 이름은 설계가 완료된 상품입니다.");
										System.out.println("보험 상품 설계하기 메뉴로 돌아갑니다.");
										bStartDesign = false;
										break;
								}
								break;
							// if(point == 0)
							// break;
							// this.continueToDesign(point);
							default:
								System.out.println("잘못 선택했습니다. 다시 선택해주세요.");
								break;
						}
					}
					break;
				case 2:
					// 보험 상품 관리
					// 시스템
					// System.out.println(controller.enquireInsuranceList());
					// 변경 후
					ArrayList<Insurance> insuranceList = this.controller.enquireInsuranceList();
					int i = 1;
					for (Insurance insurance : insuranceList) {
						System.out.println(i + "." + insurance.getInsuranceName());
						i++;
					}
					///////////////////////////////////////////////////////////////////////////
					int insuranceChoice = scanner.nextInt();
					// 변경 후
					Insurance insurance = controller.enquireInsuranceProductDetails(insuranceChoice - 1);
					////////////////////////////////////////////////////////////////////////////
					// ArrayList<String> productDetails =
					// controller.enquireInsuranceProductDetails(insuranceChoice-1);
					boolean bInsuranceDetailsPart = true;
					while (bInsuranceDetailsPart) {
						// 변경 후
						System.out.println("판매실적");
						System.out.println(insurance.getSalesPerformance() + "\n");
						System.out.println("속성");
						System.out.println(insurance.getAttribute() + "\n");
						System.out.println("손익");
						System.out.println(insurance.getProfitAndLoss() + "");
						//
						//
						// 여기부터!!!!
						//
						//
						///////////////////////////////////////////////////////////////////////////
						// for(String content : productDetails) {
						// System.out.println(content);
						// }
						System.out.println("보험을 유지하시겠습니까?");
						System.out.println("1.유지");
						System.out.println("2.중지");
						choice = scanner.nextInt();
						switch (choice) {
							case 1:
								System.out.println("보험을 유지합니다.");
								bInsuranceDetailsPart = false;
								break;
							case 2:
								if (this.controller.stopInsurance(insuranceChoice - 1))
									System.out.println("보험을 중지합니다.");
								else
									System.out.println("보험 중지에 실패하였습니다.");
								bInsuranceDetailsPart = false;
								break;
							default:
								System.out.println("잘못 선택했습니다. 다시 선택해주세요.");
								break;
						}
					}
					// System.out.println(controller);
					// A1. 해당 보험 상품 관련 정보(판매 실적 및 속성, 손익)을 출력한다

					// 판매 실적 및 속성, 손익을 보고 해당 보험의 문제점을 파악한다
					return;
				default:
					System.out.println("잘못 선택했습니다. 다시 선택해주세요.");
					break;
			}
		}
	}

	// private void continueToDesign(int point) {
	// switch(point) {
	//
	// }
	// }

	private void designInsuranceProduct(Scanner scanner) {
		// while(true) {
		// System.out.println("1.보험 상품 설계");
		// System.out.println("2.보험 상품 관리");
		// int choice = scanner.nextInt();
		// switch(choice) {
		// case 1:
		// boolean bStartDesign = true;
		// while(bStartDesign) {
		// System.out.println("1.새로 설계하기");
		// System.out.println("2.이어서 설계하기");
		// choice = scanner.nextInt();
		// switch(choice) {
		// case 1:
		// case 2:
		// default:
		// }
		// }
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// this.controller.checkInsuranceUnderDesign();
		// 보험 상품 설계
		// 시스템
		// 보험상품개발정보(고객니즈분석 설문조사 결과, 최근 보험가입 빈도, 경쟁사의 동향 정보)및 저장버튼을 출력한다
		// System.out.println(controller.enquireInsuranceProductDevelopmentInformation());
		// 보험상품기획서 작성
		// ArrayList<String> planningForm =
		// controller.enquireInsuranceProductPlanningForm();
		// ArrayList<String> planningContents = new ArrayList<String>();
		// for(String planningContent : planningForm) {
		// System.out.println(planningContent);
		// planningContents.add(scanner.next());
		// }

		
		boolean bPlanningContents = this.controller.checkPlanningContents();
		if (bPlanningContents) {
			int type = 1;
			this.insuranceDesignForm(scanner, type); // 0이 새로운 설계, 1이 이어서 설계
			return;
		}

		boolean bSavePlanningPart = true;
		while (bSavePlanningPart) {
			// 보험상품개발정보(고객니즈분석 설문조사 결과, 최근 보험가입 빈도, 경쟁사의 동향 정보)및 저장버튼을 출력한다
//			System.out.println(controller.enquireInsuranceProductDevelopmentInformation());
			// 변경 후
			BackgroundInfo information = this.controller.enquireBackgroundInformation();
			System.out.println("고객니즈분석 설문조사 결과");
			System.out.println(information.getSurveyResults());
			System.out.println("최근 보험가입 빈도");
			System.out.println(information.getApplyFrequency());
			System.out.println("경쟁사의 동향 정보");
			System.out.println(information.getTrend());
			////////////////////////////////////////////////////////////////////////////////////
			// 보험상품기획서 작성
			ArrayList<String> planningForm = controller.enquireInsuranceProductPlanningForm();
			ArrayList<String> planningContents = new ArrayList<String>();
			for (String planningContent : planningForm) {
				System.out.println(planningContent);
				planningContents.add(scanner.next());
			}
			System.out.println("저장하시겠습니까?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			System.out.println("3.뒤로가기");
			int choice = scanner.nextInt();
			switch (choice) {
				case 3:
					bSavePlanningPart = false;
					break;
				case 1:
					if (this.controller.savePlannedContents(planningContents)) {
						System.out.println("저장완료");
						// 보험 상품 설계 입력 양식
						this.insuranceDesignForm(scanner, 0); // 0이 새로운 설계, 1이 이어서 설계
						bSavePlanningPart = false;
						break;
					} else {
						System.out.println("모든 항목을 입력해주세요.");
						break;
					}
				case 2:
					System.out.println("재작성");
					break;
				default:
					System.out.println("잘못 선택했습니다. 다시 선택해주세요.");
					break;
			}
		}
	}

	private void insuranceDesignForm(Scanner scanner, int type) {
		// 새로 만든 함수
		boolean bDesignContents = this.controller.checkDesignContents();
		if (bDesignContents) {
			// System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
			this.requestAuthorization(scanner, type);
			return;
		}
		while (true) {
			ArrayList<String> designForm = controller.enqireInsuranceProductDesignForm();
			ArrayList<String> designContents = new ArrayList<String>();
			for (String content : designForm) {
				System.out.println(content);
				designContents.add(scanner.next());
			}
			System.out.println("저장하시겠습니까?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			System.out.println("3.뒤로가기");
			int choice = scanner.nextInt();
			switch (choice) {
				case 3:
					return;
				case 1:
					boolean isSaved = controller.saveInsuranceDesignContent(designContents);
					if (isSaved) {
						System.out.println("저장완료");
						// 인가품의받기
						this.requestAuthorization(scanner, type);
						return;
					} else {
						System.out.println("모든 항목을 입력해주세요.");
						break;
					}
				case 2:
					System.out.println("재작성");
					break;
				default:
					System.out.println("잘못 선택했습니다. 다시 선택해주세요.");
					break;
			}
		}
	}

	private void requestAuthorization(Scanner scanner, int type) {
		boolean bRequestAuthorizationOfCompany = true;
		boolean bRequestAuthorizationOfFSS = false;

		int point = this.controller.checkAuthorization();
		switch (point) {
			case 0:
				break;
			case 1:
				this.confirmProduct(scanner);
				bRequestAuthorizationOfCompany = false;
				bRequestAuthorizationOfFSS = true;
				break;
			case 2:
				bRequestAuthorizationOfCompany = false;
				bRequestAuthorizationOfFSS = true;
				type = 1;
				break;
			case 3:
				return;
		}
		// if(bDesignContents) {
		// this.requestAuthorization(scanner);
		// return;
		// }
		// boolean bRequestAuthorizationOfCompany = false;
		// boolean bRequestAuthorizationOfFSS = false;
		// 회사 인가품의
		while (bRequestAuthorizationOfCompany) {
			System.out.println("보험상품을 인가품의하겠습니까?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			System.out.println("3.뒤로가기");
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					System.out.println("상품 인가품의 완료");
					// 상품 확정 후 상품을 등록시킨다.
					this.controller.requestAuthorizationOfCompany(true);
					// 상품 확정 질문 필요?
					if (this.confirmProduct(scanner)) {
						bRequestAuthorizationOfCompany = false;
						bRequestAuthorizationOfFSS = true;
						break;
					} else {
						return;
					}
				case 2:
					this.controller.requestAuthorizationOfCompany(false);
					return;
				default:
					System.out.println("잘못 선택했습니다. 다시 선택해주세요.");
					break;
			}
		}

		// 금융감독원 인가품의
		while (bRequestAuthorizationOfFSS) {
			System.out.println("금융감독원 상품인가 품의하겠습니까?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			System.out.println("3.뒤로가기");
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					System.out.println("상품 인가품의 완료");
					this.controller.requestAuthorizationOfFSS(true);
					this.writeProductSalesSupportDetailsContents(scanner, type);
				case 3:
					return;
				case 2:
					this.controller.requestAuthorizationOfFSS(false);
					// bRequestAuthorizationOfFSS = false;
					return;
				default:
					System.out.println("잘못 선택했습니다. 다시 선택해주세요.");
					break;
			}
		}

	}

	private boolean confirmProduct(Scanner scanner) {
		while (true) {
			System.out.println("상품을 확정시키겠습니까?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					System.out.println("상품이 확정되었습니다.");
					// 상품 확정 코드
					this.controller.makeDecisionInsuranceProduct(true);
					return true;
				case 2:
					return false;
				default:
					System.out.println("잘못 선택했습니다. 다시 선택해주세요.");
					break;
			}
		}
	}

	private void writeProductSalesSupportDetailsContents(Scanner scanner, int type) {
		ArrayList<String> productSalesSupportDetails = this.controller.enquireProductSalesSupportDetails();
		ArrayList<String> productSalesSupportDetailsContents = new ArrayList<String>();
		for (String content : productSalesSupportDetails) {
			System.out.println(content);
			productSalesSupportDetailsContents.add(scanner.next());
		}
		// 보험 설계가 완료되었습니다.
		// if(controller.saveProductSalesSupportDetails(productSalesSupportDetailsContents)
		// && type == 0) {
		// controller.addInsurance();
		// }
		if (this.controller.saveProductSalesSupportDetails(productSalesSupportDetailsContents)) {
			if (this.controller.addInsurance(type)) {
				System.out.println("보험 설계가 완료되었습니다.");
			}
		}
	}

	private void mainForEmployee(Scanner scanner, UserInfo submitUser) {
		// 새로 만든 함수 - 직원 전용 메뉴 표시(22.06.03)

		// Scanner scanner = new Scanner(System.in);
		boolean bOnLoop = true;
		while (bOnLoop) {
			String choice = "";
			boolean isContinue = false;
			while (!isContinue) {
				System.out.println("[분산투자화재 보험 시스템입니다. 접속 직원 이름 : " + submitUser.getUserName() + "]");
				System.out.println("0.로그아웃");
				System.out.println("1.고객정보 관리하기"); // -
				System.out.println("2.계약유지활동 진행하기");
				System.out.println("3.가입신청 받기"); // 0
				System.out.println("4.인수심사 진행하기"); // 0
				System.out.println("5.보험 가입하기"); // 0
				System.out.println("6.재보험 처리하기"); // 0
				System.out.println("7.보험금 지급하기"); // 0
				System.out.println("8.사고 접수하기"); // 0
				System.out.println("9.만기계약 관리하기"); // 0
				System.out.println("10.납입정보 관리하기"); // 0
				System.out.println("11.보험 상품 설계하기"); // -
				System.out.print("입력 번호 : ");
				choice = scanner.nextLine();
				if (controller.checkNumFormat(choice)) isContinue = true;
				else System.out.println("숫자를 입력해 주세요\n");
			}
			isContinue = false;
			switch (Integer.parseInt(choice)) {
				case 0:
					System.out.println("시스템을 종료합니다.");
					bOnLoop = false;
					break;
				case 1:
					// 인배
					// 20220521 수정필요
					manageCustomerInformation(scanner);
					break;
				case 2:
					// 민재 20220530완성
					startContractMaintenanceActivities(scanner);
					break;
				case 3:
					// 민재 20220525완성
					applyForMembership(scanner);
					break;
				case 4:
					// 민재 20220525완성
					startUW(scanner);
					break;
				case 5:
					// 민재 20220525완성
					joinInsurance(scanner);
					break;
				case 6:
					// 민재 20220525완성
					reinsurance(scanner);
					break;
				case 7:
					// 민재 20220528완성
					payInsuranceMoney(scanner);
					break;
				case 8:
					// 민우 사고 접수를 하다
					// 20220521 수정필요
					// 민재 20220526완성(시나리오 수정)
					reportAccident(scanner);
					break;
				case 9:
					// 민재 20220528완성
					manageExpirationContract(scanner);
					break;
				case 10:
					// 민재 20220526완성
					managePaymentInformation(scanner);
					break;
				case 11:
					// 인배 20220521
					designInsuranceProductMenu(scanner);
					break;
				default:
					System.out.println("입력정보가 잘못되었습니다. 다시 메뉴를 선택해주세요.\n");
					break;
			}
		}
		System.out.println();
	}

	private void mainForCustomer(Scanner scanner, UserInfo submitUser) {
		// 새로 만든 함수 - 고객 전용 메뉴 표시(22.06.03)
		// scanner.nextLine();
		boolean bOnLoop = true;
		while (bOnLoop) {
			String choice = "";
			boolean isContinue = false;
			while (!isContinue) {
				System.out.println("[분산투자화재 보험 시스템입니다. 접속 고객 이름 : " + submitUser.getUserName() + "]");
				System.out.println("0.로그아웃");
				System.out.println("1.월보험료 납입하기"); // 0
				System.out.print("입력 번호 : ");
				choice = scanner.nextLine();
				if (controller.checkNumFormat(choice))
					isContinue = true;
				else
					System.out.println("숫자를 입력해 주세요\n");
			}
			isContinue = false;
			switch (Integer.parseInt(choice)) {
				case 0:
					bOnLoop = false;
					break;
				case 1:
					// 민재 20220526완성
					payInsuranceFee(scanner, submitUser);
					break;
				default:
					System.out.println("입력정보가 잘못되었습니다. 다시 메뉴를 선택해주세요.\n");
					break;
			}
		}
		System.out.println();
	}

	private UserInfo login(Scanner scanner) {
		// 새로 만든 함수 - 로그인 기능 구현(22.06.03)
		boolean isContinue = false;
		String userId = "";
		String userPw = "";
		UserInfo submitUser = null;
		while (!isContinue) {
			System.out.print("아이디 : ");
			userId = scanner.nextLine();
			System.out.print("비밀번호 : ");
			userPw = scanner.nextLine();
			submitUser = controller.getSubmitUser(userId, userPw);
			if (submitUser != null)
				System.out.print("해당 고객 및 직원을 찾았습니다. 계속 진행하겠습니까?(1.예 그이외.아니오) : ");
			else System.out.print("해당 고객 및 직원을 찾지 못했습니다. 계속 진행하겠습니까?(1.예 그이외.아니오) : ");
			if (!scanner.nextLine().equals("1")) return null;
			if (submitUser != null) isContinue = true;
			else System.out.println("아이디 및 비밀번호를 다시 입력해 주세요");
		}
		String userTypeStr = submitUser.isUserType() ? "직원" : "고객";
		System.out.println("\n<접속 고객 정보>\n" +
				"이름 : " + submitUser.getUserName() + "\n" +
				"아이디 : " + submitUser.getUserId() + "\n" +
				"접속 구분 : " + userTypeStr + "\n");
		return submitUser;
	}

	public static void main(String[] args) {
		View main = new View();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("1. 로그인 \n그이외.뒤로 가기\n입력 : ");
			if (!scanner.nextLine().equals("1")) break;
			UserInfo submitUser = main.login(scanner);
			if (submitUser == null) continue;
			if (submitUser.isUserType())
				main.mainForEmployee(scanner, submitUser);
			else main.mainForCustomer(scanner, submitUser);
			// 로그인 사용자가 고객일 때 보험 상품 납입 정보들 중에 로그인한 고객에게 보일 수 있게 해야 함
			// 얘를 하려면 고객 속성에 아이디 비번도 있어야 댐 - 이래야지 로그인 정보랑 고객 정보의 아이디 비번 비교가 ㄱㄴ함
			// 월 보험료 납입하기 - 납입 정보가 로그인한 고객의 가입 보험으로만 보여져야 함
		}
		scanner.close();
	}

	// public static void main(String[] args) {
	// Main main = new Main();
	//
	// Scanner scanner = new Scanner(System.in);
	// boolean bOnLoop = true;
	// while(bOnLoop) {
	//
	// System.out.println("분산투자화재 보험 시스템입니다.");
	// System.out.println("0.시스템 종료하기");
	// System.out.println("1.고객정보 관리하기"); // -
	// System.out.println("2.계약유지활동 진행하기");
	// System.out.println("3.월보험료 납입하기"); // 0
	// System.out.println("4.가입신청 받기"); // 0
	// System.out.println("5.인수심사 진행하기"); // 0
	// System.out.println("6.보험 가입하기"); // 0
	// System.out.println("7.재보험 처리하기"); // 0
	// System.out.println("8.보험금 지급하기"); // 0
	// System.out.println("9.사고 접수하기"); // 0
	// System.out.println("10.만기계약 관리하기"); // 0
	// System.out.println("11.납입정보 관리하기"); // 0
	// System.out.println("12.보험 상품 설계하기"); // -
	//
	// int choice = scanner.nextInt();
	// switch(choice) {
	// case 0:
	// bOnLoop = false;
	// break;
	// case 1:
	// // 인배
	// // 20220521 수정필요
	// main.manageCustomerInformation(scanner);
	// break;
	// case 2:
	// // 민재 20220530완성
	// main.startContractMaintenanceActivities(scanner);
	// break;
	// case 3:
	// // 민재 20220526완성
	// main.payInsuranceFee(scanner);
	// break;
	// case 4:
	// // 민재 20220525완성
	// main.applyForMembership(scanner);
	// break;
	// case 5:
	// // 민재 20220525완성
	// main.startUW(scanner);
	// break;
	// case 6:
	// // 민재 20220525완성
	// main.joinInsurance(scanner);
	// break;
	// case 7:
	// // 민재 20220525완성
	// main.reinsurance(scanner);
	// break;
	// case 8:
	// // 민재 20220528완성
	// main.payInsuranceMoney(scanner);
	// break;
	// case 9:
	// // 민우 사고 접수를 하다
	// // 20220521 수정필요
	// // 민재 20220526완성(시나리오 수정)
	// main.reportAccident(scanner);
	// break;
	// case 10:
	// // 민재 20220528완성
	// main.manageExpirationContract(scanner);
	// break;
	// case 11:
	// // 민재 20220526완성
	// main.managePaymentInformation(scanner);
	// break;
	// case 12:
	// // 인배 20220521
	// main.designInsuranceProductMenu(scanner);
	// break;
	// case 13:
	// break;
	// default :
	// System.out.println("입력정보가 잘못되었습니다. 다시 메뉴를 선택해주세요.");
	// break;
	// }
	// }
	// scanner.close();
	// }
}