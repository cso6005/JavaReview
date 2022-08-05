/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  EndView.java
 * DESC  : 재능 기부 정보 출력 클래스
 * 
 * @author  
 * @version 1.0
*/

package probono.view;

import java.util.ArrayList;

import probono.model.dto.TalentDonationProject;

public class EndView {
	
	//진행중인 특정 프로젝트 출력 
	public static void projectView(TalentDonationProject project){
		if(project != null) {
			System.out.println(project);		
		}else {
			System.out.println("해당 프로젝트는 존재하지 않습니다.");
		}
	}
	
	//진행중인 모든 프로젝트 출력
	public static void projectListView(ArrayList <TalentDonationProject> allProbonoProject){
		int projectSize = allProbonoProject.size();
		int index = 1;
		
		for(TalentDonationProject p : allProbonoProject) {
			if (index <= projectSize) {
				System.out.println("[진행 중인 project : " + (index++) + "] " + p);

		}

			
			
			
			}
		}
	}

