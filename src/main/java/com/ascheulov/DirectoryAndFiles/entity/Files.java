package com.ascheulov.DirectoryAndFiles.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String size;

    private String path;

}
