import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;



class MyModel extends AbstractTableModel {

	private String[] columns;
	private Object[][] rows;
	
	// public MyModel() {}
		// TODO Auto-generated constructor stub
	
	public MyModel()
	{}
	
	public MyModel(Object[][] data, String[] columnsNames)
	{
		this.columns=columnsNames;
		this.rows= data;
		
	}

	/*public Class getColumnClass(int col) {
		// TODO Auto-generated method stub
		if(col == 7) {return Icon.class;
		}
		else
		{return getValueAt(0, col).getClass();
		}
	}
	*/
	
	
	@Override
	public int getRowCount() {
		return this.rows.length;
	}

	@Override
	public int getColumnCount() {
		return this.columns.length;
				
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.rows[rowIndex][columnIndex];
	}
	
	public String getColumnName(int col)
	{
		return this.columns[col];
	}

}
