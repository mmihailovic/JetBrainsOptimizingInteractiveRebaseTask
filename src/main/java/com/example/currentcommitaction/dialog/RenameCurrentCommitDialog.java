package com.example.currentcommitaction.dialog;

import com.example.currentcommitaction.service.GitService;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.ui.components.JBTextArea;
import com.intellij.ui.components.labels.BoldLabel;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class RenameCurrentCommitDialog extends DialogWrapper {
    private final String currentCommitMessage;
    private final String projectPath;
    private final GitService gitService;
    private JBTextArea newCommitMessageTextArea;

    public RenameCurrentCommitDialog(String currentCommitMessage, String projectPath, GitService gitService) {
        super(true);
        this.currentCommitMessage = currentCommitMessage;
        this.projectPath = projectPath;
        this.gitService = gitService;

        setTitle("Rename current commit");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        JPanel jPanel = new JPanel();

        GridLayout gridLayout = new GridLayout(2, 2);
        gridLayout.setHgap(30);
        gridLayout.setVgap(10);
        jPanel.setLayout(gridLayout);

        String commitMessageInMoreLines = "<html>"
                + currentCommitMessage.replace("\n", "<br>")
                + "</html>";

        BoldLabel currentCommitMessageLabel = new BoldLabel("Current commit message:");
        JLabel currentCommitMessageText = new JLabel(commitMessageInMoreLines);
        BoldLabel newCommitMessageLabel = new BoldLabel("New commit message:");
        newCommitMessageTextArea = new JBTextArea();
        newCommitMessageTextArea.setPreferredSize(new Dimension(100, 20));

        jPanel.add(currentCommitMessageLabel);
        jPanel.add(currentCommitMessageText);
        jPanel.add(newCommitMessageLabel);
        jPanel.add(newCommitMessageTextArea);

        return jPanel;
    }

    @Override
    protected void doOKAction() {
        super.doOKAction();

        gitService.changeCurrentCommitMessage(projectPath, newCommitMessageTextArea.getText());
    }

    @Override
    protected @Nullable ValidationInfo doValidate() {
        if(newCommitMessageTextArea.getText().trim().isEmpty()) {
            return new ValidationInfo("New commit message cannot be empty", newCommitMessageTextArea);
        }

        return null;
    }
}
