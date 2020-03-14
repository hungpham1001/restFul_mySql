package com.example.demo.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Note;
import com.example.demo.Service.NoteServiceInterface;

@RestController
@RequestMapping(path = "/note", produces = MediaType.APPLICATION_JSON_VALUE)
public class NoteController {
	@Autowired
	NoteServiceInterface noteService;
	@GetMapping()
	public ResponseEntity<List<Note>> findAllNote(){
		List<Note> notes = noteService.findAll();
		if(notes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(notes,HttpStatus.OK);
	}
	@GetMapping(path = "{id}")
	public ResponseEntity<Note> findById(@PathVariable("id") int id){
		Optional<Note> note = noteService.findById(id);
		if(note.isPresent()) {
			return new ResponseEntity<Note>(note.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Note>(HttpStatus.NO_CONTENT);
	}
	@PostMapping()
	public ResponseEntity<Note> save(@RequestBody Note note) {
		noteService.save(note);	
		return new ResponseEntity<Note>(HttpStatus.CREATED);
	}
	@PutMapping(path = "{id}")
	public ResponseEntity<Note> update(@PathVariable("id") Integer id ,@RequestBody Note note){
		Optional<Note> oldNote = noteService.findById(id);
		if(!oldNote.isPresent()) {
			return new ResponseEntity<Note>(HttpStatus.NO_CONTENT);
		}
		Date date = new Date();
		Note newNote = oldNote.get();
		newNote.setNote_date(date);
		newNote.setNote_content(note.getNote_content());
		noteService.save(newNote);
		return new ResponseEntity<Note>(HttpStatus.CREATED);
	}
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Note> delete(@PathVariable("id") Integer id){
		Optional<Note> note = noteService.findById(id);
		if(!note.isPresent()) {
			return new ResponseEntity<Note>(HttpStatus.NOT_FOUND);
		}
		noteService.delete(note.get());
		return new ResponseEntity<Note>(HttpStatus.OK);
	}
}
