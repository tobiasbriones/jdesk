// Copyright (c) 2018-2021 Tobias Briones. All rights reserved.
// SPDX-License-Identifier: BSD-3-Clause
// This file is part of https://github.com/tobiasbriones/jdesk

package engineer.mathsoftware.jdesk.ui.style;

import java.awt.*;

/**
 * Default app style. It can be customized to the app style.
 *
 * @author Tobias Briones
 * @see Style
 * @see AppStyle
 */
public final class DefaultStyle extends Style {
    /**
     * Pair of colors to pass to {@link DefaultStyle} constructor and apply to
     * those app style.
     */
    public static final class ColorPair {
        private final int id;
        private final Color color;

        /**
         * Constructs a pair of colors.
         *
         * @param id    color id
         * @param color color
         */
        public ColorPair(int id, Color color) {
            this.id = id;
            this.color = color;
        }
    }

    /**
     * Creates default style.
     *
     * @param font font
     */
    public DefaultStyle(Font font) {
        super(font, createColors(null));
        if (font == null) {
            throw new NullPointerException("Font can't be null");
        }
    }

    /**
     * Creates custom style by passing the colors to be set.
     *
     * @param font   font
     * @param colors set of app colors
     */
    public DefaultStyle(Font font, ColorPair... colors) {
        super(font, createColors(colors));
        if (font == null) {
            throw new NullPointerException("Font can't be null");
        }
    }

    private static Color[] createColors(ColorPair[] colors) {
        final Color[] array = {
            Color.WHITE,
            Color.WHITE,
            Color.WHITE,
            Color.decode("#D0D0D0"),
            Color.decode("#CACACA"),
            Color.decode("#90CAF9"),
            Color.decode("#DADADA"),
            Color.decode("#212121"),
            Color.decode("#DDDDDD"),
            Color.decode("#212121"),
            Color.decode("#757575"),
            Color.decode("#E64A19")
        };
        if (colors != null) {
            for (ColorPair pair : colors) {
                array[pair.id] = pair.color;
            }
        }
        return array;
    }
}
