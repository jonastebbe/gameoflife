package de.gameoflife.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import de.gameoflife.controller.BoardController;

public class BoardView {

	private BoardController boardController;
	private Shell shell;
	private static Display display = new Display();
	private int gridCount;
	private Table table;
	private Button btnNextRound;
	
	public BoardView() {
		new BoardView(5);
	}

	public BoardView(int boardSize) {
		gridCount = boardSize;
		shell = new Shell();
		shell.setText("Game of Life");
		init(shell);
	}

	private void init(Shell s) {
		shell.setLayout(new GridLayout());
		initTable();
		btnNextRound = new Button(shell, SWT.NONE);
		btnNextRound.setText("Next Round");
		btnNextRound.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		btnNextRound.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				boardController.nextRound();
			}
		});
		start();
	}

	private void initTable() {
		table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(false);
		table.setHeaderVisible(false);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 400;
		table.setLayoutData(data);
		
	}

	private void start() {
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	
	public void setBoardController(BoardController myBoardController) {
		this.boardController = myBoardController;
	}

}
