package modules;

public enum DataType {
    _INT,
    _DOUBLE,
    _STRING,
    _NULL;

    @Override
    public String toString() {
        if(this==_INT){
            return "INT";
        }else if(this==_DOUBLE){
            return "DOUBLE";
        }else if(this==_STRING){
            return "STRING";
        }else{
            return "NULL";
        }
    }
}
