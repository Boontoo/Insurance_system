package Main;
import java.util.Scanner;

import Control.Control;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:56
 */
public class Main {

	private Control control = new Control();

	public Main(){

	}

	public void finalize() throws Throwable {

	}

	private void manageCustomerInformation(Scanner scanner) {
		// �ι�
	// ex
//		this.control.enquireCustomerInformation();
	}
	
	private void startContractMaintenanceActivities(Scanner scanner) {

	}
	
	private void payInsuranceFee(Scanner scanner) {

	}

	private void applyForMembership(Scanner scanner) {
		// ���� - ���� ��û �ޱ�
		System.out.println("���Խ�û�� �����Ͻðڽ��ϱ�? (1.����, �� �̿�.�ڷΰ���)");
		if(scanner.nextInt() != 1) return; 
		System.out.print("�� �̸� : ");
		String name = scanner.next();
		System.out.print("���� ��� ���� : ");
		String wishInsurance = scanner.next();
		System.out.print("��ȭ��ȣ : ");
		String phoneNum = scanner.next();
		System.out.print("���� : ");
		int age = scanner.nextInt();
		System.out.print("����(1.����, �� �̿�.����) : ");
		boolean gender = (scanner.nextInt() == 1);
		System.out.print("���� : ");
		String jop = scanner.next();
		System.out.print("�ֹι�ȣ : ");
		String citizenNum = scanner.next();
		this.control.applyForMembership(name, wishInsurance, phoneNum, age, gender, jop, citizenNum);
		System.out.println("==================================");
	}
	
	private void startUW(Scanner scanner) {
		// ���� - �μ��ɻ� �����ϱ�
	}
	
	private void joinInsurance(Scanner scanner) {
		// ���� - ���� �����ϱ�
	}
	
	private void reinsurance(Scanner scanner) {
		// ���� - �纸�� ó���ϱ�
	}
	
	private void manageCompensationManagement(Scanner scanner) {

	}
	
	private void payInsuranceMoney(Scanner scanner) {

	}
	
	private void reportAccident(Scanner scanner) {
		// �ο�
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
			System.out.println("�л�����ȭ�� ���� �ý����Դϴ�.");
			System.out.println("0.�ý��� �����ϱ�");
			System.out.println("1.������ �����ϱ�");
			System.out.println("2.�������Ȱ�� �����ϱ�");
			System.out.println("3.������� �����ϱ�");
			System.out.println("4.���Խ�û �ޱ�");
			System.out.println("5.�μ��ɻ� �����ϱ�");
			System.out.println("6.���� �����ϱ�");
			System.out.println("7.�纸�� ó���ϱ�");
			System.out.println("8.������ �����ϱ�");
			System.out.println("9.����� �����ϱ�");
			System.out.println("10.��� �����ϱ�");
			System.out.println("11.������ �����ϱ�");
			System.out.println("12.�������� �����ϱ�");
			System.out.println("13.���� ��ǰ �����ϱ�");

			int choice = scanner.nextInt();
			
			if(choice == 0)
				break;
			switch(choice) {
				case 1:
					// �ι�
					main.manageCustomerInformation(scanner);
					break;
				case 2:
					main.startContractMaintenanceActivities(scanner);
					break;
				case 3:
					main.payInsuranceFee(scanner);
					break;
				case 4:
					// ����
					main.applyForMembership(scanner);
					break;
				case 5:
					// ����
					main.startUW(scanner);
					break;
				case 6:
					// ����
					main.joinInsurance(scanner);
					break;
				case 7:
					// ����
					main.reinsurance(scanner);
					break;
				case 8:
					main.manageCompensationManagement(scanner);
					break;
				case 9:
					main.payInsuranceMoney(scanner);
					break;
				case 10:
					// �ο�
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
					System.out.println("�Է������� �߸��Ǿ����ϴ�. �ٽ� �޴��� �������ּ���.");
					break;
			}
		}
		scanner.close();
	}

	

}