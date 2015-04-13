package gherkinchklist;

import gherkinchklist.model.Checklist;
import gherkinchklist.model.FeatureScenario;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * A render for a simple ms-excel based checklist
 * 
 * @author leonardoluiz
 *
 */
public class ExcelCheckListRenderer {

	private String filePath;
	private Workbook workbook;
	private Sheet sheet;
	private Map<Integer, Row> rows;
	private Map<Integer,Map<Integer,Cell>> cells;

	public ExcelCheckListRenderer() {
		this.workbook = new HSSFWorkbook();
		this.rows = new HashMap<Integer, Row>();
		this.cells = new HashMap<Integer,Map<Integer,Cell>>();
	}

	public ExcelCheckListRenderer(String filePath) {
		this();
		this.filePath = filePath;
	}

	public void render(Checklist model) {
		sheet = workbook.createSheet(model.getFeature());
		sheet.setColumnWidth(0, 16*256);
		sheet.setColumnWidth(1, 80*256);
		// Header
		cellWrite(0, 0, String.format(Messages.get("model.feature")));
		cellWrite(0, 1, String.format(model.getFeature()));
		cellWrite(1, 0, Messages.get("model.description"));
		cellWrite(1, 1, model.getDescription());
		cellWrite(2, 0, Messages.get("model.scenario"));
		cellWrite(2, 1, Messages.get("model.status"));
		// Items
		int i = 3;
		for (FeatureScenario scenario : model.getScenarios()) {
			cellWrite(i, 0, scenario.getName());
			sheet.addMergedRegion(new CellRangeAddress(i, i, 0, 1));
			i++;
		}
		saveWorkbook();
	}

	private Cell cellWrite(int line, int column, String text) {
		Cell cell = getCell(line, column);
		cell.setCellValue(text);
		return cell;
	}

	private Cell getCell(int line, int column) {
		Cell cell = null;
		Map<Integer,Cell> cellMap = cells.get(line);
		if (cellMap == null) {
			cellMap = new HashMap<Integer, Cell>();
		}
		if (cellMap.get(column) == null) {
			Row row = getRow(line);
			cell = row.createCell(column);
			cellMap.put(column, cell);
		}
		return cell;
	}

	private Row getRow(int line) {
		Row row = rows.get(line);
		if (row == null) {
			row = sheet.createRow(line);
			rows.put(line, row);
		}
		return row;
	}

	private void saveWorkbook() {
		try (FileOutputStream out = new FileOutputStream(filePath)) {
			workbook.write(out);
		} catch (FileNotFoundException e) {
			Main.fatal(Messages.get("app.fileoutnotfound"));			
		} catch (IOException e) {
			Main.fatal(Messages.get("error.save"));
		}
	}
}
