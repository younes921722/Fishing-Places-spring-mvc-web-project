package com.ensah.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.LieuPeche;
import com.ensah.core.dao.ILieuPecheDao;

@Service
@Transactional
public class LieuPecheServiceImp implements ILieuPecheService{
	
	@Autowired
	private ILieuPecheDao lieuPecheDao ;

	@Override
	public void addLieuPeche(LieuPeche lieu) {
		lieuPecheDao.create(lieu);
		
	}

	@Override
	public void updateLieuPeche(LieuPeche lieu) {
		lieuPecheDao.update(lieu);		
	}

	@Override
	public void deleteLieuPeche(Long id) {
		lieuPecheDao.delete(id);		
	}

	@Override
	public List<LieuPeche> getAllLieuPeche() {
		// TODO Auto-generated method stub
		return lieuPecheDao.getAll();
	}

	@Override
	public LieuPeche getLieuPecheById(Long id) {
		// TODO Auto-generated method stub
		return lieuPecheDao.findById(id);
	}

	@Override
	public List<LieuPeche> searchLieuPeche(String location) {
		// TODO Auto-generated method stub
		return lieuPecheDao.getLieuPecheByLocation(location);
	}

}
