package edu.norcocollege.cis18b.week7.mini04;

import java.util.List;

public class LivenessDiagnosisLab {

    public static void main(String[] args) {
        for (LivenessScenario scenario : scenarios()) {
            System.out.println(scenario.name() + " -> " + scenario.issue());
        }
    }

    static List<LivenessScenario> scenarios() {
        return List.of(
            new LivenessScenario(
                "lock-order-conflict",
                LivenessIssue.DEADLOCK,
                "Two threads acquire the same pair of locks in opposite order.",
                "Use consistent lock ordering."
            ),
            new LivenessScenario(
                "always-last-in-line",
                LivenessIssue.STARVATION,
                "A low-priority worker keeps losing access to a shared resource.",
                "Reduce unfair scheduling and bound how long one actor can monopolize the resource."
            ),
            new LivenessScenario(
                "over-polite-retry-loop",
                LivenessIssue.LIVELOCK,
                "Both workers keep backing off and retrying without making progress.",
                "Add backoff rules that eventually allow one side to proceed."
            )
        );
    }
}

/* Locker-order-conflict:
This is having to be a deadlock due to the two threads holding one lock while it waits for the other lock. Due to neither thread being able to release what is needed, both get stuck. A way to fix is to make every thread acquire locks in the same order each time.

Always-last-in-line: Starvation
Since this starvation due to one worker possibly continue to miss its chance to use the shared resource. The program continues to progress but the worker does not that is having issues. A way to fix this is by using queue in which everyone get theres turn in a specific order.

Over-polite-retry-loop: Livelokc
This is livelock since workers are active but their repeated backing prevents useful progress. To fix this the usage of randomized backoff.

Extension challenge: deadlock
To fix this is by giving a fixed order and always ensuring the first lock before the second. 
*/