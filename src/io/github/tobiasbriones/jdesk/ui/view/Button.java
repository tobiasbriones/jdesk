/*
 * Copyright (c) 2018-2021 Tobias Briones. All rights reserved.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 *
 * This file is part of JDesk.
 *
 * This source code is licensed under the BSD-3-Clause License found in the
 * LICENSE file in the root directory of this source tree or at
 * https://opensource.org/licenses/BSD-3-Clause.
 */

package io.github.tobiasbriones.jdesk.ui.view;

import io.github.tobiasbriones.jdesk.WindowContext;
import io.github.tobiasbriones.jdesk.ui.style.AppStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Button view.
 */
@SuppressWarnings("unused")
public class Button extends JButton implements TextIdClickView {
    private static final long serialVersionUID = -8346675620406508178L;
    private final int textId;
    private Color backgroundColor;
    private Color hoverColor;
    private Color pressedColor;
    private Color focusedColor;
    private Color disabledColor;
    private boolean isFocused;

    /**
     * Default constructor for a button.
     *
     * @param context window context
     */
    @SuppressWarnings("WeakerAccess")
    public Button(WindowContext context) {
        super();
        this.textId = -1;
        init(context.getAppStyle());

        config(context.getAppStyle());
    }

    /**
     * Constructor for a button.
     *
     * @param context window context
     * @param text    button text
     */
    @SuppressWarnings("WeakerAccess")
    public Button(WindowContext context, String text) {
        super(text);
        this.textId = -1;
        init(context.getAppStyle());

        config(context.getAppStyle());
    }

    /**
     * Constructor for a button. It automatically adds a {@link ClickListener} with the passed text resource id provided
     * that context is instance of {@link ClickListener}, otherwise it won't add the listener.
     *
     * @param context window context
     * @param textRes button text resource
     */
    public Button(WindowContext context, int textRes) {
        super(context.getStringResources().get(textRes));
        this.textId = (context instanceof ClickListener) ? textRes : -1;
        init(context.getAppStyle());

        if (context instanceof ClickListener) {
            addActionListener(new TextIdViewActionListener((ClickListener) context));
        }
        config(context.getAppStyle());
    }

    /**
     * Constructor for a button.
     *
     * @param context window context
     * @param icon    button icon
     */
    @SuppressWarnings("WeakerAccess")
    public Button(WindowContext context, Icon icon) {
        super(icon);
        this.textId = -1;
        init(context.getAppStyle());

        config(context.getAppStyle());
    }

    /**
     * Constructor for a button.
     *
     * @param context window context
     * @param text    button text
     * @param icon    button icon
     */
    @SuppressWarnings("WeakerAccess")
    public Button(WindowContext context, String text, Icon icon) {
        super(text, icon);
        this.textId = -1;
        init(context.getAppStyle());

        config(context.getAppStyle());
    }

    /**
     * Constructor for a button. It automatically adds a {@link ClickListener} with the passed text resource id provided
     * that context is instance of {@link ClickListener}, otherwise it won't add the listener.
     *
     * @param context window context
     * @param textRes button text resource
     * @param icon    button icon
     */
    @SuppressWarnings("WeakerAccess")
    public Button(WindowContext context, int textRes, Icon icon) {
        super(context.getStringResources().get(textRes), icon);
        this.textId = (context instanceof ClickListener) ? textRes : -1;
        init(context.getAppStyle());

        if (context instanceof ClickListener) {
            addActionListener(new TextIdViewActionListener((ClickListener) context));
        }
        config(context.getAppStyle());
    }

    @SuppressWarnings("WeakerAccess")
    public final Color getBackgroundColor() {
        return backgroundColor;
    }

    @SuppressWarnings("WeakerAccess")
    public final void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @SuppressWarnings("WeakerAccess")
    public final Color getHoverColor() {
        return hoverColor;
    }

    @SuppressWarnings("WeakerAccess")
    public final void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
    }

    @SuppressWarnings("WeakerAccess")
    public final Color getPressedColor() {
        return pressedColor;
    }

    @SuppressWarnings("WeakerAccess")
    public final void setPressedColor(Color pressedColor) {
        this.pressedColor = pressedColor;
    }

    @SuppressWarnings("WeakerAccess")
    public final Color getFocusedColor() {
        return focusedColor;
    }

    @SuppressWarnings("WeakerAccess")
    public final Color getDisabledColor() {
        return disabledColor;
    }

    @SuppressWarnings("WeakerAccess")
    public final void setDisabledColor(Color disabledColor) {
        this.disabledColor = disabledColor;
    }

    @SuppressWarnings("WeakerAccess")
    public final boolean isFocused() {
        return isFocused;
    }

    /**
     * Sets the button text as is passed, it doesn't apply capitalization to the text.
     *
     * @param text button text
     */
    protected void setNormalText(String text) {
        super.setText(text);
    }

    @Override
    public void setText(String text) {
        super.setText(text.toUpperCase());
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        if (pressedColor != null && getModel().isPressed()) {
            g.setColor(pressedColor);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        else if (hoverColor != null && getModel().isRollover()) {
            g.setColor(hoverColor);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        else if (focusedColor != null && isFocused) {
            g.setColor(focusedColor);
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
        else if (disabledColor != null && !isEnabled()) {
            g.setColor(disabledColor);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(g);
    }

    @Override
    public int getTextId() {
        return textId;
    }

    @SuppressWarnings("WeakerAccess")
    public final void setBold() {
        setFont(getFont().deriveFont(Font.BOLD));
    }

    private void init(AppStyle appStyle) {
        this.backgroundColor = appStyle.getButtonBackgroundColor();
        this.hoverColor = appStyle.getItemHoverColor();
        this.pressedColor = appStyle.getItemPressedColor();
        this.focusedColor = appStyle.getItemFocusedColor();
        this.disabledColor = appStyle.getDisabledColor();
    }

    private void config(AppStyle appStyle) {
        setFont(appStyle.getFont());
        setContentAreaFilled(false);
        setFocusPainted(false);
        addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                isFocused = true;
            }

            @Override
            public void focusLost(FocusEvent e) {
                isFocused = false;
            }
        });
    }
}
