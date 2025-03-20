This project is my solution for the task for project **Optimizing interactive rebase in JetBrains IDEs**.

### Description
This is IntelliJ IDEA plugin that adds a **"Rename current commit"** action to the Git section by extending the **Git4Idea** plugin.
Action is added to the **Git.MainMenu** action group. With this action, the commit message of the current commit can be modified.

### Visual presentation
![rename_current_commit_action](https://github.com/user-attachments/assets/c45f32c3-430b-44df-8b86-87d45610cf8b)

When the **"Rename current commit"** button is clicked and there are no commits, an error popup will display.
![nocommits](https://github.com/user-attachments/assets/c146c5b0-5828-4dd0-8531-59281ac2bd37)

If there is at least one commit, a dialog will open displaying the current commit message and an input field for entering a
new commit message.
![dialog](https://github.com/user-attachments/assets/55e6b50e-0192-4de6-93c1-5b3775d34476)

There is also validation to ensure that the input field for new commit message cannot be empty or contain only blank characters.
![commit message empty](https://github.com/user-attachments/assets/eb4edb7f-c11b-4424-a34a-d80e4e2b33ed)


