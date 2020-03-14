package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Note;

@Service
public interface NoteServiceInterface {
	List<Note> findAll();
	Optional<Note> findById(Integer id);
	void save(Note note);
	void delete(Note note);
}
