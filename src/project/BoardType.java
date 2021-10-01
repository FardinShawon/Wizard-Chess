package project;

public enum BoardType {
    BOARD_TYPE_1('1'),
    BOARD_TYPE_2('2'),
    BOARD_TYPE_3('3'),
    BOARD_TYPE_4('4'),
    BOARD_TYPE_5('5'),
    BOARD_TYPE_DEFAULT('6');

    private final Character type;

    BoardType(Character type) {
        this.type = type;
    }

    public Character getType() {
        return type;
    }
}
