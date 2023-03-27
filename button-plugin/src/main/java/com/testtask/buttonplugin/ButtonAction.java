package com.testtask.buttonplugin;

import com.intellij.ide.browsers.BrowserLauncher;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class ButtonAction extends AnAction {
    public ButtonAction() {
        super("New Option");
    }
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        int choice = Messages.showDialog("Choose a button", "Button Dialog",
                new String[]{"Java Doc", "Intellij Doc"}, -1, Messages.getQuestionIcon());
        if (choice == 0) {
            openUrlInBrowser("https://docs.oracle.com/en/java/");
        } else if (choice == 1) {
            openUrlInBrowser("https://www.jetbrains.com/help/idea/getting-started.html");
        }
    }

    private void openUrlInBrowser(String url) {
        BrowserLauncher.getInstance().browse(url, null);
    }
}
