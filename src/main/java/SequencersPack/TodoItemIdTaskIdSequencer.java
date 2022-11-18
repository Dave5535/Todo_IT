package SequencersPack;

public class TodoItemIdTaskIdSequencer {
    private static int currentId;

    public static int nextId(){
setCurrentId(currentId+++1);
        return currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int number) {
        currentId = number;
    }
}
