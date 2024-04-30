package com.aseiler.servicout.servicoutbackend.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aseiler.servicout.servicoutbackend.Models.Size;

public interface ISizeDAO extends JpaRepository<Size, Long> {
	@SuppressWarnings("null")
	List<Size> findAll();
	List<Size> findById(Integer id);
}
