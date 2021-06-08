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

package io.github.tobiasbriones.jdesk.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class IOFiles {
    /**
     * Writes a text file with UTF-8 charset.
     *
     * @param text text to put into the text file
     * @param file file to save the content
     *
     * @throws FileNotFoundException if the specified file does not exist
     * @throws IOException           if an I/O error occurs
     * @see IOFile
     */
    public static void writeTextFile(String text, IOFile file) throws FileNotFoundException, IOException {
        writeTextFile(text, file, StandardCharsets.UTF_8);
    }

    /**
     * Writes a text file.
     *
     * @param text    text to put into the text file
     * @param file    file to save the content
     * @param charset charset to save the content
     *
     * @throws FileNotFoundException if the file does not exist
     * @throws IOException           if an I/O error occurs
     * @see IOFile
     */
    public static void writeTextFile(
        String text,
        IOFile file,
        Charset charset
    ) throws FileNotFoundException, IOException {
        try (
            BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file), charset)
            )
        ) {
            bw.write(text);
        }
    }

    /**
     * Returns the string containing the file's content with UTF-8 charset.
     *
     * @param file file to load
     *
     * @return the file loaded into a String
     *
     * @throws FileNotFoundException if the file does not exist
     * @throws IOException           if an I/O error occurs
     * @see StandardCharsets
     * @see IOFiles#loadTextFile(IOFile, Charset)
     */
    public static String loadTextFile(IOFile file) throws FileNotFoundException, IOException {
        return loadTextFile(file, StandardCharsets.UTF_8);
    }

    /**
     * Returns the string containing the file's content with the specified charset.
     *
     * @param file    file to load
     * @param charset charset to specify when loading the stream
     *
     * @return the file loaded into a String
     *
     * @throws FileNotFoundException if the file does not exist
     * @throws IOException           if an I/O error occurs
     * @see StandardCharsets
     */
    public static String loadTextFile(IOFile file, Charset charset) throws FileNotFoundException, IOException {
        final StringBuilder builder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream(file), charset))
        ) {
            String line = br.readLine();

             while(line != null) {
                 builder.append(line);
                 line = br.readLine();
             }
        }
        return builder.toString();
    }

    private IOFiles() {}
}