package com.example.currentcommitaction.service;

public interface GitService {

    /**
     * This method changes commit message of the current commit
     * @param repoPath path of the repository
     * @param newMessage new message
     */
    void changeCurrentCommitMessage(String repoPath, String newMessage);

    /**
     * This method returns commit message of the current commit
     * @param repoPath path of the repository
     * @return {@link String} object representing the message of the current commit
     */
    String getCurrentCommitMessage(String repoPath);
}
