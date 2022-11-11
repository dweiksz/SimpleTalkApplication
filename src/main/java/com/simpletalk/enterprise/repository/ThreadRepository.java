package com.simpletalk.enterprise.repository;

import com.simpletalk.enterprise.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, Long> {
    Optional<Thread> findByName(String threadName);
}
