// Copyright (c) 2018-2021 Tobias Briones. All rights reserved.
// SPDX-License-Identifier: BSD-3-Clause
// This file is part of https://github.com/tobiasbriones/jdesk

package engineer.mathsoftware.jdesk.ui.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.util.Vector;

public class Table extends JTable {
    private static final long serialVersionUID = -6215396228667151097L;

    /**
     * Constructs a default {@code JTable} that is initialized with a default
     * data model, a default column model, and a default selection model.
     *
     * @see #createDefaultDataModel
     * @see #createDefaultColumnModel
     * @see #createDefaultSelectionModel
     */
    public Table() {}

    /**
     * Constructs a {@code JTable} that is initialized with {@code dm} as the
     * data model, a default column model, and a default selection model.
     *
     * @param dm the data model for the table
     *
     * @see #createDefaultColumnModel
     * @see #createDefaultSelectionModel
     */
    public Table(TableModel dm) {
        super(dm);
    }

    /**
     * Constructs a {@code JTable} that is initialized with {@code dm} as the
     * data model, {@code cm} as the column model, and a default selection
     * model.
     *
     * @param dm the data model for the table
     * @param cm the column model for the table
     *
     * @see #createDefaultSelectionModel
     */
    public Table(TableModel dm, TableColumnModel cm) {
        super(dm, cm);
    }

    /**
     * Constructs a {@code JTable} that is initialized with {@code dm} as the
     * data model, {@code cm} as the column model, and {@code sm} as the
     * selection model. If any of the parameters are {@code null} this method
     * will initialize the table with the corresponding default model. The
     * {@code autoCreateColumnsFromModel} flag is set to false if {@code cm} is
     * non-null, otherwise it is set to true and the column model is populated
     * with suitable {@code TableColumns} for the columns in {@code dm}.
     *
     * @param dm the data model for the table
     * @param cm the column model for the table
     * @param sm the row selection model for the table
     *
     * @see #createDefaultDataModel
     * @see #createDefaultColumnModel
     * @see #createDefaultSelectionModel
     */
    public Table(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
        super(dm, cm, sm);
    }

    /**
     * Constructs a {@code JTable} with {@code numRows} and {@code numColumns}
     * of empty cells using {@code DefaultTableModel}.  The columns will have
     * names of the form "A", "B", "C", etc.
     *
     * @param numRows    the number of rows the table holds
     * @param numColumns the number of columns the table holds
     *
     * @see DefaultTableModel
     */
    public Table(int numRows, int numColumns) {
        super(numRows, numColumns);
    }

    /**
     * Constructs a {@code JTable} to display the values in the {@code Vector}
     * of {@code Vectors}, {@code rowData}, with column names, {@code
     * columnNames}.  The {@code Vectors} contained in {@code rowData} should
     * contain the values for that row. In other words, the value of the cell at
     * row 1, column 5 can be obtained with the following code:
     *
     * <pre>((Vector)rowData.elementAt(1)).elementAt(5);</pre>
     *
     * @param rowData     the data for the new table
     * @param columnNames names of each column
     */
    public Table(Vector<? extends Vector> rowData, Vector<?> columnNames) {
        super(rowData, columnNames);
    }

    /**
     * Constructs a {@code JTable} to display the values in the two-dimensional
     * array, {@code rowData}, with column names, {@code columnNames}. {@code
     * rowData} is an array of rows, so the value of the cell at row 1, column 5
     * can be obtained with the following code:
     *
     * <pre> rowData[1][5]; </pre>
     * <p>
     * All rows must be of the same length as {@code columnNames}.
     *
     * @param rowData     the data for the new table
     * @param columnNames names of each column
     */
    public Table(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
    }
}
