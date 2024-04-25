package com.ensah.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.LieuPeche;

@Repository
public class LieuPecheDaoImpl extends DaoImpl<LieuPeche,Long> implements ILieuPecheDao{
	
	public List<LieuPeche> getLieuPecheByLocation(String location){
		return getEntityByColValue("localisation",location);
	}
}
