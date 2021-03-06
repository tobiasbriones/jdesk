// Copyright (c) 2018-2021 Tobias Briones. All rights reserved.
// SPDX-License-Identifier: BSD-3-Clause
// This file is part of https://github.com/tobiasbriones/jdesk

package engineer.mathsoftware.jdesk.ui.view;

import engineer.mathsoftware.jdesk.WindowContext;
import engineer.mathsoftware.jdesk.ui.style.AppStyle;

import javax.swing.*;

/**
 * Radio button view.
 *
 * @author Tobias Briones
 */
public class RadioButton extends JRadioButton {
    private static final long serialVersionUID = -1814692214609746784L;

    /**
     * Default constructor for RadioButton.
     *
     * @param context window context
     */
    public RadioButton(WindowContext context) {
        super();
        config(context.getAppStyle());
    }

    public RadioButton(WindowContext context, Action a) {
        super(a);
        config(context.getAppStyle());
    }

    public RadioButton(WindowContext context, Icon icon, boolean selected) {
        super(icon, selected);
        config(context.getAppStyle());
    }

    public RadioButton(WindowContext context, Icon icon) {
        super(icon);
        config(context.getAppStyle());
    }

    public RadioButton(WindowContext context, String text) {
        super(text);
        config(context.getAppStyle());
    }

    public RadioButton(WindowContext context, String text, boolean selected) {
        super(text, selected);
        config(context.getAppStyle());
    }

    public RadioButton(
        WindowContext context,
        String text,
        Icon icon,
        boolean selected
    ) {
        super(text, icon, selected);
        config(context.getAppStyle());
    }

    public RadioButton(WindowContext context, String text, Icon icon) {
        super(text, icon);
        config(context.getAppStyle());
    }

    private void config(AppStyle appStyle) {
        setFont(appStyle.getFont());
        setBackground(appStyle.getWindowBackgroundColor());
        setFocusable(false);
    }
}
