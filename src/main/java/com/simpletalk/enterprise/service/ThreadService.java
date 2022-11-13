package com.simpletalk.enterprise.service;

import com.simpletalk.enterprise.dto.ThreadDTO;
import com.simpletalk.enterprise.exceptions.SpringThreadException;
import com.simpletalk.enterprise.mapper.ThreadMapper;
import com.simpletalk.enterprise.model.Thread;
import com.simpletalk.enterprise.repository.ThreadRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class ThreadService {

    private final ThreadRepository threadRepository;
    private final ThreadMapper threadMapper;

    @Transactional
    public ThreadDTO save(ThreadDTO threadDTO) {
        Thread save = threadRepository.save(threadMapper.mapDtoToThread(threadDTO));
        threadDTO.setId(save.getId());
        return threadDTO;
    }

    @Transactional(readOnly = true)
    public List<ThreadDTO> getAll() {
        return threadRepository.findAll()
                .stream()
                .map(threadMapper::mapThreadToDto)
                .collect(toList());
    }

    public ThreadDTO getThread(Long id) {
        Thread thread = threadRepository.findById(id)
                .orElseThrow(() -> new SpringThreadException("No subreddit found with ID - " + id));
        return threadMapper.mapThreadToDto(thread);
    }
}
