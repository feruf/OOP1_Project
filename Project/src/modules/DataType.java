package modules;

public enum DataType {
    _INT("int"),
    _DOUBLE("double"),
    _STRING("string"),
    _NULL("null");

    private String type;

    DataType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
