package com.testtask.buttonplugin;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.impl.ActionButton;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ToolWindFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(Project project, ToolWindow toolWindow) {
        ToolWindFactory toolWindFactory = new ToolWindFactory();
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(toolWindFactory.getContent(), "", false);
        toolWindow.getContentManager().addContent(content);

        // Register the action

        ActionManager actionManager = ActionManager.getInstance();


        ButtonAction buttonAction = new ButtonAction();
        actionManager.registerAction("buttonAction", buttonAction);

        // Create a button and link it to the action
        AnAction buttonAnAction = actionManager.getAction("buttonAction");
        ActionButton button = new ActionButton(buttonAnAction, new Presentation(), null, ActionToolbar.NAVBAR_MINIMUM_BUTTON_SIZE);
        DefaultActionGroup actionGroup = new DefaultActionGroup((List<? extends AnAction>) button);
        final JComponent component = (JComponent) button.getComponent(0);
        component.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        toolWindow.setTitleActions((List<? extends AnAction>) actionGroup);
    }

    private JComponent getContent() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Window"));
        return panel;
    }
}

