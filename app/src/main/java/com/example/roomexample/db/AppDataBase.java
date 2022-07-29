package com.example.roomexample.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract UserDAO userDAO();

    private static AppDataBase INSTANCE;

    public static AppDataBase getINSTANCE(Context context) {
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "DB")
                    .allowMainThreadQueries().build();
        }
        return INSTANCE;
    }


}
