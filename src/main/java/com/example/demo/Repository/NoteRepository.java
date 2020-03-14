package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {	
}
