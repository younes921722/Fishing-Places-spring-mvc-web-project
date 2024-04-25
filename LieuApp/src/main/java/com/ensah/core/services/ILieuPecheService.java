package com.ensah.core.services;

import com.ensah.core.bo.LieuPeche;
import java.util.List;


public interface ILieuPecheService {

	public void addLieuPeche(LieuPeche lieu);
	
	public void updateLieuPeche(LieuPeche lieu);
	
	public void deleteLieuPeche(Long id);
	
	public List<LieuPeche> getAllLieuPeche();
	
	public LieuPeche getLieuPecheById(Long id);
	
	public List<LieuPeche> searchLieuPeche(String location);

	
}
