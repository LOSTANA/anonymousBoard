package com.tenco.board.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tenco.board.repository.model.Boarder;
import com.tenco.board.repository.model.Writer;

@Mapper
public interface ListRepository {
	public int insert(Writer writer);
	public int updateById(Boarder boarder);
	public int deleteById(Integer id, String name);
	
	public List<Boarder> findAll();
	
	
	public Boarder findById(Integer id);
	
}
