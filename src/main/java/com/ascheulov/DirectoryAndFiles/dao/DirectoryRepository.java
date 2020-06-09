package com.ascheulov.DirectoryAndFiles.dao;

import com.ascheulov.DirectoryAndFiles.entity.Directory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectoryRepository extends JpaRepository<Directory, Long> {
}
