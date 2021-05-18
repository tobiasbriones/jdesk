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

package io.github.tobiasbriones.jdesk.ui;

import io.github.tobiasbriones.jdesk.io.FileFormat;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Filters all files with the specified format or extension.
 *
 * @see FileFilter
 */
@SuppressWarnings("unused")
public final class FileFormatFilter extends FileFilter {
    private final String extension;

    /**
     * Constructs a filter with the specified file format.
     *
     * @param format file format to filter
     */
    public FileFormatFilter(FileFormat format) {
        this.extension = format.toString();
    }

    /**
     * Constructs a filter with the specified file extension.
     *
     * @param extension extension to filter
     */
    public FileFormatFilter(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File file) {
        return io.github.tobiasbriones.jdesk.io.File.getExtension(file.getName()).equals(extension);
    }

    @Override
    public String getDescription() {
        return "Files " + "(" + io.github.tobiasbriones.jdesk.io.File.EXTENSION_SEPARATOR + extension.toUpperCase() + ")";
    }
}
