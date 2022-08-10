/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  TalentDonationProjectService.java
 * DESC  :  재능 기부 프로젝트를 저장, 수정, 삭제, 검색하는 서비스 로직
 * 
 * @author  
 * @version 1.0
*/

package probono.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import probono.model.dto.Beneficiary;
import probono.model.dto.Donator;
import probono.model.dto.TalentDonationProject;

public class TalentDonationProjectService {

	private static TalentDonationProjectService instance = new TalentDonationProjectService();

	/** 진행중인 Project를 저장하는 배열 */	

	//private TalentDonationProject[] donationProjectList = new TalentDonationProject[10];
	private ArrayList <TalentDonationProject> donationProjectList = new ArrayList();
	
	
	// log 기록
	static Logger logger = Logger.getLogger("PROJECT 접근 발생");

	

	/** 진행중인 Project 총 개수 */
	private int index;

	private TalentDonationProjectService() {}

	public static TalentDonationProjectService getInstance() {
		return instance;
	}
	

	/**
	 * 모든 Project 검색
	 * 
	 * @return 모든 Project
	 */
	public ArrayList<TalentDonationProject> getDonationProjectsList() {
		return donationProjectList;
	}

	
	// TO DO --
	/** 
	 * Project 이름으로 검색 - 객체된 Project 반환하기
	 * 
	 * @param projectName 프로젝트 이름
	 * @return TalentDonationProject 검색된 프로젝트 
	 */
	public TalentDonationProject getDonationProject(String projectName) {
		TalentDonationProject project = null;
		for(TalentDonationProject p : donationProjectList) {
			if (p.getTalentDonationProjectName()== projectName) {
				project = p;
				break;
			}
		
		}
		return project;
			
	}
	

	// TO DO --
	/**
	 * 새로운 Project 추가 
	 * 
	 * @param project 저장하고자 하는 새로운 프로젝트
	 */
	public void donationProjectInsert(TalentDonationProject project) {
		donationProjectList.add(project);
		logger.info("프로젝트가 업로드되었습니다.");
		
		}
	

	
	/** 
	 * Project의 기부자 수정 - 프로젝트 명으로 검색해서 해당 프로젝트의 기부자 수정
	 * 
	 * @param projectName 프로젝트 이름
	 * @param people 기부자 
	 */
	public void donationProjectUpdate(String projectName, Donator people) {
		//TalentDonationProject project = null;
		
		for (TalentDonationProject p : donationProjectList) {
			if (p != null && p.getTalentDonationProjectName().equals(projectName)) {		
				p.setProjectDonator(people);
				break;
			}
			
		}
		logger.info("프로젝트 정보가 변경되었습니다.");
	}
	
	
	//TO DO
	/**
	 * Project의 수혜자 수정 - 프로젝트 명으로 검색해서 해당 프로젝트의 수혜자 수정
	 * 
	 * @param projectName 프로젝트 이름
	 * @param people 수혜자 
	 */
	public void beneficiaryProjectUpdate(String projectName, Beneficiary people) {
		for (TalentDonationProject p : donationProjectList) {
			if (p != null && p.getTalentDonationProjectName().equals(projectName)) {
				int i = p.hashCode();
				p.setProjectBeneficiary(people);
				break;
			}
		}
		logger.info("프로젝트 정보가 변경 되었습니다.");
		
		
		
		
	}
	
	
	//TO DO
	/**
	 * Project 삭제 - 프로젝트 명으로 해당 프로젝트 삭제
	 * 
	 * @param projectName 삭제하고자 하는 프로젝트 이름
	 */
	public void donationProjectDelete(String projectName) {
		for (TalentDonationProject p : donationProjectList) {
			if (p != null && p.getTalentDonationProjectName().equals(projectName)) {		
				TalentDonationProject project = p;
				donationProjectList.remove(project);
				break;		
				}
			
		}
		logger.info("프로젝트가 삭제되었습니다.");
	}
	
		
	
	/**
	 * 진행중인 Project 총 개수 반환
	 * @return 개수
	 */
	public int projectListSize() {
		
		index = donationProjectList.size();
		return index;
	}
}
