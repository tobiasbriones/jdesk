// Copyright (c) 2018-2021 Tobias Briones. All rights reserved.
// SPDX-License-Identifier: BSD-3-Clause
// This file is part of https://github.com/tobiasbriones/jdesk

package engineer.mathsoftware.jdesk.ui.view.loading;

import engineer.mathsoftware.jdesk.WindowContext;
import engineer.mathsoftware.jdesk.ui.view.Panel;
import engineer.mathsoftware.jdesk.work.LoadingView;

import javax.swing.*;
import java.awt.*;

/**
 * Loading view with little squares running from left to right.
 *
 * @author Tobias Briones
 */
public final class SquaresLoadingView extends Panel implements LoadingView {
    private static final long serialVersionUID = -3024496598749776705L;
    private static final Dimension SIZE = new Dimension(36, 4);
    private static final int DELAY_MS = 150;
    private final Color backgroundColor;
    private final Timer timer;
    private Color color;
    private int n;

    /**
     * Default constructor for SquaresLoadingView.
     *
     * @param context window context
     */
    public SquaresLoadingView(WindowContext context) {
        super(context);
        this.backgroundColor = context.getAppStyle().getWindowBackgroundColor();
        this.timer = new Timer(DELAY_MS, e -> repaint());
        this.color = context.getAppStyle().getAccentColor();
        this.n = -1;

        setPreferredSize(SIZE);
    }

    /**
     * Sets the view squares color.
     *
     * @param color view color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean isRunning() {
        return timer.isRunning();
    }

    @Override
    public void start() {
        if (timer.isRunning()) {
            return;
        }
        n = -1;

        repaint();
        timer.start();
    }

    @Override
    public void end() {
        if (!timer.isRunning()) {
            return;
        }
        n = -1;

        timer.stop();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        final int x = n * getHeight() + 4 * (n + 1);

        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        if (n == -1) {
            g.setColor(backgroundColor);
            g.fillRect(0, 0, getWidth(), getHeight());
            n++;
            return;
        }
        if (n == 3) {
            n = -2;
        }
        g.setColor(color);
        g.fillRect(x, 0, getHeight(), getHeight());
        n++;
    }
}
