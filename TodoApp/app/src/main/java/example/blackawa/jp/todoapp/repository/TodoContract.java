package example.blackawa.jp.todoapp.repository;

import android.provider.BaseColumns;

public class TodoContract {
    private TodoContract() {}

    public static final class TodoEntity implements BaseColumns {
        public static final String TABLE_NAME = "todo";

        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_OWNER = "owner";
        public static final String COLUMN_DEAD_LINE = "dead_line";
    }
}
