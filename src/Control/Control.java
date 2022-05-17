package Control;

import java.util.ArrayList;

import AccidentReception.AccidentReception;
import AccidentReception.AccidentReceptionListImpl;
import ApplicationForMembership.ApplicationForMembershipListImpl;
import CompensationManagement.CompensationManagementListImpl;
import Contract.ContractListImpl;
import Customer.Customer;
import Customer.CustomerImpl;
import Insurance.Insurance;
import Insurance.InsuranceImpl;

/**
 * @author dlsqo
 * @version 1.0
 * @created 16-5-2022      2:40:57
 */
public class Control {

   private int customerID;
   private ArrayList<Customer> customerList;
   private ArrayList<Insurance> insuranceList;
   public CustomerImpl m_CustomerImpl;
   public InsuranceImpl m_InsuranceImpl;
   public AccidentReceptionListImpl m_AccidentReceptionListImpl= new AccidentReceptionListImpl();
   public CompensationManagementListImpl m_CompensationManagementListImpl;
   public ContractListImpl m_ContractListImpl;
   public ApplicationForMembershipListImpl m_ApplicationForMembershipListImpl;

   public Control(){
	  

   }

   public void finalize() throws Throwable {

   }

   /**
    * 
    * @param insurance
    * @param phoneNum
    * @param age
    * @param gender
    * @param name
    * @param job
    * @param SSN
    */
   public void applyForMembership(String insurance, String phoneNum, int age, boolean gender, String name, String job, String SSN){

   }

   /**
    * 
    * @param id
    * @param isOwnedBuilding
    * @param isRemodeling
    * @param buildingAgeScore
    * @param fireEquipmentConditionScore
    * @param buildingLocationScore
    * @param buildingConditionScore
    */
   public boolean automaticJudge(String id, boolean isOwnedBuilding, boolean isRemodeling, int buildingAgeScore, int fireEquipmentConditionScore, int buildingLocationScore, int buildingConditionScore){
      return false;
   }

   /**
    * 
    * @param amountOfInsuranceFee
    */
   public boolean checkAmountOfInsuranceFee(int amountOfInsuranceFee){
      return false;
   }

   /**
    * 
    * @param date
    */
   private String checkInputDateFormat(String date){
      return "";
   }

   /**
    * 
    * @param insurance
    * @param phoneNum
    * @param age
    * @param gender
    * @param name
    * @param job
    */
   private boolean checkInputImformation(String insurance, String phoneNum, int age, boolean gender, String name, String job){
      return false;
   }

   public int countInsuranceFeeNotPaid(){
      return 0;
   }

   public String deleteCustomerInformation(){
      return "";
   }

   /**
    * 
    * @param customerName
    */
   public String enquireAccidentInformation(String customerName){
      return "";
   }

   public String enquireAccidentList(){
      return "";
   }

   /**
    * 
    * @param choice
    */
   public String enquireCustomerDetailInformation(int choice){
      return "";
   }

   public String enquireCustomerInformation(){
      return "";
   }

   /**
    * 
    * @param choice
    */
   public String enquireEmergencyCustomerList(int choice){
      return "";
   }

   /**
    * 
    * @param id
    * @param accidentLocation
    * @param accidentType
    */
   public String enquireEmployeeCallStatusImformation(String id, String accidentLocation, String accidentType){
	  AccidentReception accidentReception = m_AccidentReceptionListImpl.get(id);
	  String temp =  accidentReception.getAccidentID()+" "+accidentReception.getCustomerID()
	  +" "+accidentReception.getCustomerName()+" "+accidentReception.isEmployeeCallStatus()
	  +" "+accidentReception.getRemainingNumberOfTowTruckCalls()+" "+accidentReception.isTowTruckCallPresent();
      return temp;
   }
   
   public void saveAccident(AccidentReception AccidentReception) {
	   
   }

   public String enquireExpirationContractInformation(){
      return "";
   }

   public String enquireInformationAboutApplicationForMembership(){
      return "";
   }

   public String enquireInsuranceFeePaymentStatus(){
      return "";
   }

   public String enquireInsuranceList(){
      return "";
   }

   /**
    * 
    * @param choice
    */
   public String enquireInsuranceProductDetails(int choice){
      return "";
   }

   public String enquireInsuranceProductDevelopmentInformation(){
      return "";
   }

   public String enquireNewContractInformation(){
      return "";
   }

   public String enquirePassedCustomerInUW(){
      return "";
   }

   public void enquireProductSalesSupportDetails(){

   }

   /**
    * 
    * @param automaticExaminationResult
    * @param diagnosticExaminationResult
    * @param imageExaminationResult
    * @param specialExaminationResult
    * @param generalExaminationResult
    */
   public String enquireUWResult(boolean automaticExaminationResult, boolean diagnosticExaminationResult, boolean imageExaminationResult, boolean specialExaminationResult, boolean generalExaminationResult){
      return "";
   }

   public String euqireInsuranceProductDesignForm(){
      return "";
   }

   /**
    * 
    * @param extendedExpirationDate
    */
   public String extendContract(String extendedExpirationDate){
      return "";
   }

   public String initializeInsuranceFeePaymentStatus(){
      return "";
   }

   public void makeDecisionInsuranceProduct(){

   }

   /**
    * 
    * @param id
    */
   public boolean makeInsuranceContract(String id){
      return false;
   }

   public String modifyCustomerInformation(){
      return "";
   }

   public String payInsuranceMoney(){
      return "";
   }

   /**
    * 
    * @param newExpirationDate
    * @param id
    */
   public String renewExpirationDate(String newExpirationDate, String id){ return "";}

   public void requestAuthorizationOfCompany(){

   }

   public void requestAuthorizationOfFSS(){

   }

   /**
    * 
    * @param id
    * @param amountOfInsuranceFee
    */
   public String saveAmountOfInsuranceFee(String id, int amountOfInsuranceFee){
      return "";
   }

   /**
    * 
    * @param targetCustomer
    * @param compensationDevelopmentPlan
    * @param InsuranceProductName
    * @param evaluation
    */
   public void saveCompensationManagementInformation(String targetCustomer, String compensationDevelopmentPlan, String InsuranceProductName, String evaluation){

   }

   public void saveInsuranceDesignContent(){

   }

   /**
    * 
    * @param plannedContents
    */
   public String savePlannedContents(String plannedContents){
      return "";
   }

   public void saveProductSalesSupportDetails(){

   }

}