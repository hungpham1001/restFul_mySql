package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Note;
import com.example.demo.Repository.NoteRepository;

@Service
public class NoteServiceIpml implements NoteServiceInterface{
	@Autowired
	NoteRepository noteRepository;
	
	@Override
	public List<Note> findAll() {
		return (List<Note>) noteRepository.findAll();
	}

	@Override
	public Optional<Note> findById(Integer id) {
		return noteRepository.findById(id);
	}

	@Override
	public void save(Note note) {
		noteRepository.save(note);
	}

	@Override
	public void delete(Note note) {
		noteRepository.delete(note);
	}
	
}
