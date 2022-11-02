package com.simpletalk.enterprise.dao;

import com.simpletalk.enterprise.dto.Thread;

import java.util.List;

public interface IThreadDAO {
    Thread save(Thread thread) throws Exception;

    List<Thread> fetchAll();

    Thread fetch(int id) ;

    Thread delete(int id) throws Exception;
}