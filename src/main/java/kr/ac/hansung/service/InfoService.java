package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.InfoDAO;
import kr.ac.hansung.model.InfoModel;

@Service
public class InfoService {

	@Autowired
	private InfoDAO infoDAO;
	
	
	public List<InfoModel> myGetSemesterGrade(){
		return infoDAO.getSemesterGrade();
	}
	
	public List<InfoModel> myGetcompleteGrade(){
		return infoDAO.getcompleteGrade();
	}
	
	public List<InfoModel> myGetshowDetails(int year, int semester){
		return infoDAO.getshowDetails(year, semester);
	}

	public void insert(InfoModel infoModel) {
		infoDAO.insert(infoModel);
		
	}
	
	public List<InfoModel> myGet2018register(){
		return infoDAO.get2019register();
	}
}
