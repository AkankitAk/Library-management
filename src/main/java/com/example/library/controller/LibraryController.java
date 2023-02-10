package com.example.library.controller;

import com.example.library.model.Library;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;


@RestController
public class LibraryController {
    @Autowired
    LibraryService libraryService;
    @PostMapping("/addLibrary")
    public String saveLibrary(@RequestBody Library library){
        libraryService.addLibrary(library);
        return library.getName()+" Library added successfully";
    }

    @GetMapping("/getLibraryByLNo/{LibrarySNo}")
    public String getLibrarByLNo(@PathVariable String LibrarySNo){
        return libraryService.getByLNo(LibrarySNo).toString();
    }

    @GetMapping("/getAllLibrary")
    public Map<String,Library> getAllLibrary(){
        return libraryService.getAllLibrary();
    }

    @PutMapping("/updateLibrary/{librarySNo}")
    public String updateLibrary(@RequestBody Library library, @PathVariable String librarySNo){
        return libraryService.updateLibrary(library,librarySNo);
    }

    @DeleteMapping("/deleteLibrary/{librarySNo}")
    public String deleteUserById(@PathVariable String librarySNo) {
        return libraryService.deleteLibrary(librarySNo);

    }
}
