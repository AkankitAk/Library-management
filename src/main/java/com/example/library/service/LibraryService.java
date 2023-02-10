package com.example.library.service;

import com.example.library.model.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LibraryService {
    static Map<String,Library> libraryMap=new HashMap<>();

    public Library addLibrary(Library library) {
        return libraryMap.put(library.getLibrarySNo(),library);
    }

    public List<Library> getByLNo(String librarySNo) {
        List<Library> currentLibrary=new ArrayList<>();
        if(libraryMap.containsKey(librarySNo)) currentLibrary.add(libraryMap.get(librarySNo));
        return currentLibrary;
    }

    public Map<String, Library> getAllLibrary() {
        return libraryMap;
    }

    public String updateLibrary(Library library, String librarySNo) {
        if(libraryMap.containsKey(librarySNo)){
            libraryMap.put(librarySNo,library);
            return "Successfully update  "+library.getName();
        }
        else {
            return "Library No not Found" + librarySNo;
        }
    }

    public String deleteLibrary(String librarySNo) {

        if(libraryMap.containsKey(librarySNo)) {
            libraryMap.remove(librarySNo);
            return "User deleted with user Id" + librarySNo;
        }
        else {
            return "User not found";
        }
    }
}