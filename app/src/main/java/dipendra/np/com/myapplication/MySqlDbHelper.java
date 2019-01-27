package dipendra.np.com.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//My SQL DB Helper
public class MySqlDbHelper extends SQLiteOpenHelper {
    public final Context context;
    public static final String DATABASE_NAME = "myDatabase";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "myTable"; // Table Name
    public static final String UID = "_id"; // Column I (Primary Key)
    public static final String NAME = "Name"; //Column II
    public static final String MY_PASSWORD = "Password";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255) ," +
            MY_PASSWORD + " VARCHAR(225));";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;



    public MySqlDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
    }


    public boolean insertData(String name, String password){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NAME,name);
        cv.put(MY_PASSWORD,password);
        long result=sqLiteDatabase.insert(TABLE_NAME,null,cv);
        if(result==-1){
            return false;
        }

       else return true;
    }
    public Cursor getData(String name, String password){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String sql="SELECT * FROM "+TABLE_NAME+" WHERE NAME='"+name+"'" +"and MY_PASSWORD='"+password+"'";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        return  cursor;
    }

    public int deleteData(String name){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,"NAME=?",new String[]{name});
    }

    public Cursor getAllData() {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return cursor;

    }
}