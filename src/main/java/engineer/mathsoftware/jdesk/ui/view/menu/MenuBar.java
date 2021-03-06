// Copyright (c) 2018-2021 Tobias Briones. All rights reserved.
// SPDX-License-Identifier: BSD-3-Clause
// This file is part of https://github.com/tobiasbriones/jdesk

package engineer.mathsoftware.jdesk.ui.view.menu;

import engineer.mathsoftware.jdesk.WindowContext;

import javax.swing.*;
import java.awt.*;

/**
 * View which contains the {@link Menu} elements to build a usual window menu.
 *
 * @author Tobias Briones
 */
public class MenuBar extends JMenuBar {
    private static final long serialVersionUID = -4252109343379286594L;
    private Menu menuShowing;

    /**
     * Constructor for MenuBar.
     *
     * @param context window context
     */
    public MenuBar(WindowContext context) {
        super();
        this.menuShowing = null;

        setBackground(context.getAppStyle().getTopBackgroundColor());
    }

    Menu getMenuShowing() {
        return menuShowing;
    }

    void setMenuShowing(Menu value) {
        this.menuShowing = value;
    }

    /**
     * Sets the bottom border color for the menu bar.
     *
     * @param borderColor border color
     */
    public void setBorderColor(Color borderColor) {
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, borderColor));
    }

    /**
     * Adds a menu to the menu bar.
     *
     * @param menu menu
     */
    public void addMenu(Menu menu) {
        menu.setMenuBar(this);
        add(menu);
    }
}
