package com.ascheulov.DirectoryAndFiles.service;

import com.ascheulov.DirectoryAndFiles.dao.FilesRepository;
import com.ascheulov.DirectoryAndFiles.entity.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
public class FilesService {

    private final FilesRepository filesRepository;

    @Autowired
    public FilesService(FilesRepository filesRepository) {
        this.filesRepository = filesRepository;
    }

    public List<Files> findAllFiles(){
        return filesRepository.findAll();
    }

    public void saveFiles(String path){

        File dir = new File(path);
        File[] arrFiles = dir.listFiles();
        List<File> listOfFiles = Arrays.asList(arrFiles);


        for (File file : listOfFiles){
            Files files = new Files();
            files.setName(file.getName());
            if (file.isDirectory() == true){
                files.setSize("<DIR>");
            } else {
                long size = (file.length()/1024);
                files.setSize(String.valueOf(size) + " Кб");
            }
            files.setPath(path);
            filesRepository.save(files);
        }
    }

    public List<Files> findByPath(String path){
        return filesRepository.findByPath(path);
    }
}
