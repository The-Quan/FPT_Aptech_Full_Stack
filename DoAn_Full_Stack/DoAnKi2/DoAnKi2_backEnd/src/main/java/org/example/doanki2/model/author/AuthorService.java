package org.example.doanki2.model.author;



import org.example.doanki2.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public ResponseEntity<List<Author>> getAllAuthor(){
        List<Author> authorList = authorRepository.findAll();
        return ResponseEntity.ok(authorList);
    }
    public ResponseEntity<Author> getByIdAuthor(int id){
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (!authorOptional.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        return ResponseEntity.ok(authorOptional.get());
    }
    public ResponseEntity<Author> addAuthor(Author author){
        Author authorSave = authorRepository.save(author);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(authorSave.getAuthor_id()).toUri();

        return ResponseEntity.created(location).body(authorSave);
    }
    public ResponseEntity<Author> updateAuthor(int id, Author author){
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (!authorOptional.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        author.setAuthor_id(authorOptional.get().getAuthor_id());
        authorRepository.save(author);
        return ResponseEntity.ok().body(author);
    }
    public ResponseEntity<Author> deleteAuthor(int id){
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (!authorOptional.isPresent()){
            throw new IllegalArgumentException("id not found");
        }
        authorRepository.deleteById(authorOptional.get().getAuthor_id());
        return ResponseEntity.noContent().build();
    }

}
