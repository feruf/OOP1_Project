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

    public static DataType getDataType(String type) {
        for (DataType dataType : DataType.values()) {
            if (dataType.type.equalsIgnoreCase(type)) {
                return dataType;
            }
        }
        throw new RuntimeException("ne e nameren takuv tip");
    }

    public static DataType parse(String value) {
        return value.equalsIgnoreCase("null") ? _NULL : (value.startsWith("\"") && value.endsWith("\"")) ? _STRING : value.contains(".") ? _DOUBLE : _INT;
    }
}
