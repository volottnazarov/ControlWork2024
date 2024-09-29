abstract public class AnimalsType {
    private String typeName;

    public AnimalsType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "AnimalsType{" +
                "typeName= " + typeName + '\'' +
                '}';
    }
}
