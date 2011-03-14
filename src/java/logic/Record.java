package logic;

public class Record extends DatabaseWork {

    private String tableName = "";
    public String _SQLstring = "";
    private String rowsString = "";
    private String valuesString = "";

    public void setTable(String tableName) {
        this.tableName = tableName;
    }

    public void setValue(String row, String value) {
        this.rowsString += row + ", ";
        this.valuesString += "'" + value + "'" + ", ";

    }
    //queryString = "INSERT INTO leftmenu (parentid, text) values ('" + parentId + "','" + text + "')";
    public void addRecord() {
        this._SQLstring += "INSERT INTO " + this.tableName + " (" + subString(this.rowsString) + ") values (" + subString(this.valuesString) + ")";
        this.exec();
    }

    public void delRecord() {
        this._SQLstring += "DELETE FROM " + this.tableName + " WHERE " + subString(this.rowsString) + "=" + subString(this.valuesString) + " LIMIT 1";
        this.exec();
    }

    public void updateValue(String SQLstring) {
        this._SQLstring = SQLstring;
        this.exec();
    }

    private void exec() {
        try {
            this.connect();
            this.executeUpdate(this._SQLstring);
            this.disconnect();
        } catch (Exception e) {
            System.out.println("SQL execute Public");
        }
    }

    private String subString(String in) { //Индусы отдыхают.....
        int len = in.length();
        in = in.subSequence(0, len - 2).toString();
        return in;
    }
}
