package SequencersPack;

public class TodoItemIdSequencer {
    private static int currentId;

    public  static int nextId(){
setCurrentId(++currentId);
        return currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int number) {
        currentId =number;
    }
}


