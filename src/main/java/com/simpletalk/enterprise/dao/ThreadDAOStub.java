package com.simpletalk.enterprise.dao;
import com.simpletalk.enterprise.dto.Thread;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * <p>
 *     public class that implements methods from the IThreadDAO interface
 * </p>
 */
@Repository
public class ThreadDAOStub implements IThreadDAO {
    Map<Integer, Thread> allThreads = new HashMap<>();

    /**
     * @param thread
     * @return
     */
    @Override
    public Thread save(Thread thread) throws Exception{
        Integer threadID = (thread.getThreadID());
        allThreads.put(threadID, thread);
        return thread;
    }

    /**
     * @return
     */
    @Override
    public List<Thread> fetchAll() {
        List<Thread> returnThreads = new ArrayList<>(allThreads.values());
        return returnThreads;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Thread fetch(int id) {
        return allThreads.get(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Thread delete(int id) {
        return allThreads.remove(id);
    }
}


