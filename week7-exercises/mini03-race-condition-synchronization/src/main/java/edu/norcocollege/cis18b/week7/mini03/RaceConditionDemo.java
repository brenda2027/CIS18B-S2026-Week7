package edu.norcocollege.cis18b.week7.mini03;

public class RaceConditionDemo {

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 8;
        int incrementsPerThread = 25_000;
        int expected = threadCount * incrementsPerThread;

        int unsafe = RaceConditionHarness.runUnsafeTrial(threadCount, incrementsPerThread);
        int safe = RaceConditionHarness.runSynchronizedTrial(threadCount, incrementsPerThread);
        int atomic = RaceConditionHarness.runAtomicTrial(threadCount, incrementsPerThread);

        System.out.println("Expected count: " + expected);
        System.out.println("Unsafe count: " + unsafe);
        System.out.println("Synchronized count: " + safe);
        System.out.println("Atomic count: " + atomic);
    }
}
/*
* Written response:
*
* With the expression values++ it is not the safest when multiple threads are to use the same counter.
* There are multiple steps taking place such as reading current value, adds one, and writes new values 
* back. With an overlap there can be an update lost
*
* With unsafe count is should not be tested against one number due to the thread scheduling changing 
* each tme when the program runs
*/