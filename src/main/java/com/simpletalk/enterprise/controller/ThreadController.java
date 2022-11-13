package com.simpletalk.enterprise.controller;

import com.simpletalk.enterprise.dto.ThreadDTO;
import com.simpletalk.enterprise.service.ThreadService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thread")
@AllArgsConstructor
@Slf4j
public class ThreadController {

    private final ThreadService threadService;

    @PostMapping
    public ResponseEntity<ThreadDTO> createThread(@RequestBody ThreadDTO threadDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(threadService.save(threadDTO));
    }

    @GetMapping
    public ResponseEntity<List<ThreadDTO>> getAllThreads() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(threadService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThreadDTO> getThread(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(threadService.getThread(id));
    }
}
