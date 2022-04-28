/*
 * Copyright (c) 2022 Tobias Briones. All rights reserved.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 *
 * This file is part of JDesk.
 *
 * This source code is licensed under the BSD-3-Clause License found in the
 * LICENSE file in the root directory of this source tree or at
 * https://opensource.org/licenses/BSD-3-Clause.
 */

package engineer.mathsoftware.jdesk;

import engineer.mathsoftware.jdesk.resources.Resources;
import engineer.mathsoftware.jdesk.resources.StringResources;
import engineer.mathsoftware.jdesk.ui.style.AppStyle;
import engineer.mathsoftware.jdesk.ui.style.DefaultStyle;
import engineer.mathsoftware.jdesk.ui.style.Style;

import javax.swing.*;
import java.awt.*;

public class TestApp extends App implements AppInstance {
    private static final Font FONT;
    private static final StringResources strings;
    private static final DefaultStyle.ColorPair[] appColors;

    static {
        FONT = Resources.loadFont("Roboto-Light");
        strings = StringResources.load();
        appColors = new DefaultStyle.ColorPair[] {
            new DefaultStyle.ColorPair(
                Style.ACCENT,
                Color.decode("#00B8D4")
            )
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TestApp::new);
    }

    private final AppStyle appStyle;

    private TestApp() {
        super(FONT);
        this.appStyle = new DefaultStyle(FONT, appColors);
        addMainWindow(new TestWindow(this));
    }

    @Override
    public StringResources getStringResources() {
        return strings;
    }

    @Override
    public AppStyle getAppStyle() {
        return appStyle;
    }

    @Override
    public String getAppConfigFile() {
        return "config.properties";
    }

    @Override
    protected AppInstance getAppInstance() {
        return this;
    }
}