package com.example.currentcommitaction.action;

import com.example.currentcommitaction.dialog.RenameCurrentCommitDialog;
import com.example.currentcommitaction.process.DefaultProcessFactory;
import com.example.currentcommitaction.service.GitService;
import com.example.currentcommitaction.service.GitServiceImpl;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class RenameCurrentCommitAction extends AnAction {
    private final GitService gitService;

    public RenameCurrentCommitAction() {
        this.gitService = new GitServiceImpl(new DefaultProcessFactory());
    }

    public RenameCurrentCommitAction(GitService gitService) {
        this.gitService = gitService;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        String projectPath = e.getProject().getBasePath();
        String currentCommitMessage = gitService.getCurrentCommitMessage(projectPath);

        if(currentCommitMessage == null || currentCommitMessage.isEmpty()) {
            Messages.showErrorDialog("There are no commits!", "Error");
            return;
        }

        RenameCurrentCommitDialog renameCurrentCommitDialog =
                new RenameCurrentCommitDialog(currentCommitMessage, projectPath, gitService);

        renameCurrentCommitDialog.show();
    }
}
