package de.tzimon.cloudsystem.managers;

import java.util.HashSet;
import java.util.Set;

public class ThreadManager {

    private Set<Thread> threads;

    public ThreadManager() {
        threads = new HashSet<>();
    }

    public void registerThread(Thread thread) {
        threads.add(thread);
    }

    public void joinAny() {
        for (Thread thread : threads) {
            try {
                thread.join();
                break;
            } catch (InterruptedException ignored) {
            }
        }
    }

}
