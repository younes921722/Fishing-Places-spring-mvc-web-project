package com.ensah.core.dao;

import java.util.List;

import com.ensah.core.bo.LieuPeche;


public interface ILieuPecheDao extends IDao<LieuPeche,Long>{
	
	List<LieuPeche> getLieuPecheByLocation(String location);
}
