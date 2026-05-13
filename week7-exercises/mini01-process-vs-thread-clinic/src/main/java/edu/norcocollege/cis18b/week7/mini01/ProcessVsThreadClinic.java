package edu.norcocollege.cis18b.week7.mini01;

import java.util.List;

public class ProcessVsThreadClinic {

    public static void main(String[] args) {
        for (Scenario scenario : defaultScenarios()) {
            System.out.println(scenario.name() + " -> " + scenario.recommendation());
        }
    }

    static List<Scenario> defaultScenarios() {
        return List.of(
            new Scenario(
                "student-code-runner",
                "Run untrusted student code with stronger fault isolation.",
                Recommendation.PROCESS,
                "Separate address spaces reduce the blast radius of crashes or unsafe code."
            ),
            new Scenario(
                "gradebook-auto-save",
                "Save updates while the UI remains responsive.",
                Recommendation.THREAD,
                "Shared in-process state makes background saves convenient, but shared data must be protected."
            ),
            new Scenario(
                "sort-single-list-once",
                "Sort one in-memory list and print it immediately.",
                Recommendation.NOT_MEANINGFULLY_CONCURRENT,
                "There is only one task, so concurrency adds complexity without benefit."
            )
        );
    }

    record Scenario(String name, String description, Recommendation recommendation, String reasoning) {
    }

    enum Recommendation {
        PROCESS,
        THREAD,
        NOT_MEANINGFULLY_CONCURRENT
    }
}

/* 
* Written responsses:
* 
* 1. student-code-runner
* I would classify this to be PROCESS. As the student-written code is recommended to be kept seperate 
* from the main program due to the possibility of crashing or anything unsafe. As this allow its to be
* a stronger protecting since it has its own form of memory space.
*
* 2.gradebook-auto-save
* I would classify this as THREAD. Since auto-save is part of the same application and is only able to
* work in the background. When there is a saving of memory this allows there to a sharing of the current
* gradebook, a risk that happens is that to say if the user is changing as it saves.
*
* 3. sort-single-list-once
* I would classify this as NOT_MEANINGFULLY_CONCURRENT. Since there is only the sorting of one list and
* finish from there. The add of extras would over complicate this. 
*
* Extension Challenge
* Through a music app there is the usage of background thread which loads the next part of that song as 
* the current one still plays. The sharing of memeory helps the player know which audio data is ready.
* Of course this remains the need to be careful stll.
*/