package com.aseiler.servicout.servicoutbackend.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.aseiler.servicout.servicoutbackend.DAO.ISizeDAO;
import com.aseiler.servicout.servicoutbackend.Models.Size;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class SizeController {
    @Autowired
    ISizeDAO sizeDAO;

    @SuppressWarnings("null")
    @GetMapping("/sizes")
    public ResponseEntity<List<Size>> getAllSizes() {
        try {
			List<Size> sizes = new ArrayList<Size>();

            sizeDAO.findAll().forEach(sizes::add);
			
			if (sizes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(sizes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @GetMapping("/sizes/{id}")
    public ResponseEntity<Size> getSizeById(@PathVariable("id") long id) {
        Optional<Size> sizeData = sizeDAO.findById(id);

		if (sizeData.isPresent()) {
			return new ResponseEntity<>(sizeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }
    
}
