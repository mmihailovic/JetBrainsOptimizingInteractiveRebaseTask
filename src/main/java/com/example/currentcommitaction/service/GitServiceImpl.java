package com.example.currentcommitaction.service;

import com.example.currentcommitaction.process.ProcessFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GitServiceImpl implements GitService {
    private final ProcessFactory processFactory;

    public GitServiceImpl(ProcessFactory processFactory) {
        this.processFactory = processFactory;
    }

    @Override
    public void changeCurrentCommitMessage(String repoPath, String newMessage) {
        try {
            processFactory.executeProcess(repoPath, "git", "commit", "--amend", "-m", newMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCurrentCommitMessage(String repoPath) {
        try {
            Process process = processFactory.executeProcess(repoPath, "git", "log", "-1", "--format=format:%B");

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            return output.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
