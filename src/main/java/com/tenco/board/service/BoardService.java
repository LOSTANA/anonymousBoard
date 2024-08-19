package com.tenco.board.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tenco.board.dto.ReWriteDTO;
import com.tenco.board.dto.WriterDTO;
import com.tenco.board.handler.exception.DataDeliveryException;
import com.tenco.board.handler.exception.RedirectException;
import com.tenco.board.repository.interfaces.ListRepository;
import com.tenco.board.repository.model.Boarder;
import com.tenco.board.repository.model.Writer;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class BoardService {

	private final ListRepository listRepository;

	public BoardService(ListRepository listRepository, HttpSession session) {
		this.listRepository = listRepository;

	}

	@Transactional
	public void createContents(WriterDTO dto, String name) {
		int result = 0;

		try {

			result = listRepository.insert(dto.toWriter(name));
		} catch (DataAccessException e) {
			throw new DataDeliveryException("잘못된 요청입니다", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			throw new RedirectException("알 수 없는 오류 입니다", HttpStatus.SERVICE_UNAVAILABLE);
		}

		if (result == 0) {
			throw new DataDeliveryException("정상 처리 되지 않았습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public List<Boarder> readAll() {
		List<Boarder> listEntity = null;
		try {
			listEntity = listRepository.findAll();

		} catch (DataAccessException e) {
			throw new DataDeliveryException("잘못된 처리 입니다", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			throw new RedirectException("알수 없는 오류", HttpStatus.SERVICE_UNAVAILABLE);
		}
		return listEntity;
	}

	public Boarder findBySome(Integer id, String name) {
		Boarder listEntity = listRepository.findById(id);
		listEntity.checkUser(name);

		if (listEntity == null) {
			throw new DataDeliveryException("존재하지 않는 게시글 입니다", HttpStatus.BAD_REQUEST);
		}
		listEntity.checkUser(name);
		return listEntity;

	}

	@Transactional
	public void reWriteContents(ReWriteDTO dto,String name) {

		int result = 0;	
		try {
			dto.setUsername(name);
			result = listRepository.updateById(dto.toWriter());
		} catch (DataAccessException e) {
			throw new DataDeliveryException("잘못된 요청입니다", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			throw new RedirectException("알 수 없는 오류 입니다", HttpStatus.SERVICE_UNAVAILABLE);
		}

		if (result == 0) {
			throw new DataDeliveryException("정상 처리 되지 않았습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
	}
}
