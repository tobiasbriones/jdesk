// Copyright (c) 2018-2021 Tobias Briones. All rights reserved.
// SPDX-License-Identifier: BSD-3-Clause
// This file is part of https://github.com/tobiasbriones/jdesk

package engineer.mathsoftware.jdesk.ui.view.menu;

import engineer.mathsoftware.jdesk.WindowContext;
import engineer.mathsoftware.jdesk.resources.StringResourceId;
import engineer.mathsoftware.jdesk.ui.style.AppStyle;
import engineer.mathsoftware.jdesk.ui.view.Button;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * Menu item view to put on a {@link Menu} or {@link PopupMenu}.
 *
 * @author Tobias Briones
 */
public class MenuItem extends Button {
    private static final long serialVersionUID = 7869101163125586456L;
    private static final Border PADDING = new EmptyBorder(5, 20, 5, 10);
    private final StringResourceId textId;

    /**
     * Constructor for MenuItem with text and icon.
     *
     * @param context window context
     * @param text    menu item text
     * @param icon    menu item icon
     */
    public MenuItem(WindowContext context, String text, Icon icon) {
        super(context, icon);
        this.textId = null;

        config(context.getAppStyle(), text);
    }

    /**
     * Constructor for MenuItem with text.
     *
     * @param context window context
     * @param text    menu item text
     */
    public MenuItem(WindowContext context, String text) {
        super(context);
        this.textId = null;

        config(context.getAppStyle(), text);
    }

    /**
     * Constructor for MenuItem with text and icon.
     *
     * @param context window context
     * @param textRes menu item text resource
     * @param icon    menu item icon
     */
    public MenuItem(WindowContext context, StringResourceId textRes, Icon icon) {
        super(context, icon);
        this.textId = textRes;

        config(
            context.getAppStyle(),
            context.getStringResources().get(textRes)
        );
    }

    /**
     * Constructor for MenuItem with text and icon.
     *
     * @param context window context
     * @param textRes menu item text resource
     */
    public MenuItem(WindowContext context, StringResourceId textRes) {
        super(context);
        this.textId = textRes;

        config(
            context.getAppStyle(),
            context.getStringResources().get(textRes)
        );
    }

    // Click listener is handled by Menu
    @Override
    public StringResourceId getTextId() {
        return textId;
    }

    private void config(AppStyle appStyle, String text) {
        setFocusable(false);
        setBackgroundColor(appStyle.getWindowBackgroundColor());
        setBorder(PADDING);
        setHorizontalAlignment(SwingConstants.LEFT);
        setNormalText(text);
    }
}
