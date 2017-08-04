package com.noel.readinglist.repository;

import com.noel.readinglist.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, String> {
}
