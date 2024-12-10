class Adapter implements ITarget {
    private final Original original;

    public Adapter(Original original) {
        this.original = original;
    }

    @Override
    public void ClientDouble(double value) {
        original.OriginalDouble(value);
    }

    @Override
    public void ClientInt(int value) {
        original.OriginalInt(value * 2);
    }

    @Override
    public void ClientChar(char value) {
        for(int i = 0; i < 5; i++){
            original.OriginalChar(value);
        }
    }
}