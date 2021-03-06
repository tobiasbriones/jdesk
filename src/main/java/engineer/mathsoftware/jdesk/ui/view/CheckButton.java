// Copyright (c) 2018-2021 Tobias Briones. All rights reserved.
// SPDX-License-Identifier: BSD-3-Clause
// This file is part of https://github.com/tobiasbriones/jdesk

package engineer.mathsoftware.jdesk.ui.view;

import engineer.mathsoftware.jdesk.WindowContext;
import engineer.mathsoftware.jdesk.resources.StringResourceId;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Check button view.
 *
 * @author Tobias Briones
 */
public class CheckButton extends engineer.mathsoftware.jdesk.ui.view.Panel implements TextIdClickView {
    private static final long serialVersionUID = -1977865084712151136L;
    private static final Insets PADDING = new Insets(4, 8, 4, 8);
    private final StringResourceId textId;
    private final TextLabel label;
    private final CheckBoxSquare checkBox;

    /**
     * Constructor for CheckButton.
     *
     * @param context window context
     * @param text    check button text
     * @param checked mark as checked
     */
    public CheckButton(WindowContext context, String text, boolean checked) {
        super(context);
        this.textId = null;
        this.label = new TextLabel(context);
        this.checkBox = new CheckBoxSquare(context);

        config(text);
    }

    /**
     * Constructor for CheckButton. It automatically adds a {@link
     * ClickListener} to this check button if context is instance of {@link
     * ClickListener}.
     *
     * @param context window context
     * @param textRes check button text resource
     * @param checked mark as checked
     */
    public CheckButton(WindowContext context, StringResourceId textRes, boolean checked) {
        super(context);
        this.textId = textRes;
        this.label = new TextLabel(context);
        this.checkBox = new CheckBoxSquare(context);

        config(context.getStringResources().get(textRes));
        if (context instanceof ClickListener) {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    ((ClickListener) context).onClick(CheckButton.this, textId);
                }
            });
        }
    }

    /**
     * Constructor for CheckButton.
     *
     * @param context window context
     * @param text    check button text
     */
    public CheckButton(WindowContext context, String text) {
        this(context, text, false);
    }

    /**
     * Constructor for CheckButton. It automatically adds a {@link
     * ClickListener} to this check button if context is instance of {@link
     * ClickListener}.
     *
     * @param context window context
     * @param textRes check button text resource
     */
    public CheckButton(WindowContext context, StringResourceId textRes) {
        this(context, textRes, false);
    }

    /**
     * Returns {@code true} if and only if this check button is checked.
     *
     * @return {@code true} if and only if this check button is checked
     */
    public boolean isChecked() {
        return checkBox.isChecked;
    }

    /**
     * Sets whether this check button is checked.
     *
     * @param isChecked mark as checked
     */
    public void setChecked(boolean isChecked) {
        checkBox.setChecked(isChecked);
    }

    /**
     * Sets the text for this check button.
     *
     * @param text check button text
     */
    public void setText(String text) {
        label.setText(text);
    }

    @Override
    public StringResourceId getTextId() {
        return textId;
    }

    private void config(String text) {
        setLayout(new FlowLayout(FlowLayout.LEADING, 8, 0));
        setText(text);
        setPadding(PADDING);
        add(checkBox);
        add(label);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                checkBox.setChecked(!checkBox.isChecked);
                super.mouseClicked(e);
            }
        });
    }

    private static final class CheckBoxSquare extends Panel {
        private static final Dimension SIZE = new Dimension(12, 12);
        private static final long serialVersionUID = -7554783009089690566L;
        private final Color backgroundColor;
        private final Color color;
        private boolean isChecked;

        private CheckBoxSquare(WindowContext context) {
            super(context);
            this.backgroundColor = context.getAppStyle()
                                          .getWindowBackgroundColor();
            this.color = context.getAppStyle().getAccentColor();

            setPreferredSize(SIZE);
        }

        private void setChecked(boolean checked) {
            this.isChecked = checked;

            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(backgroundColor);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(color);
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

            if (isChecked) {
                g.fillRect(3, 3, getWidth() - 6, getHeight() - 6);
            }
        }
    }
}
