package dipendra.np.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SQLiteActivity extends AppCompatActivity {
    EditText etName, etPassword, etUpdateOld, etUpdateNew, etDelete;
    MySqlDbHelper mySqlDbHelper;
    Button btnAddUser, btnDelUser, btnUpdateUser, btnViewData;

    public static void start(Context context) {
        Intent intent = new Intent(context, SQLiteActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        etName = findViewById(R.id.et_name);
        etPassword = findViewById(R.id.et_password);
        etUpdateOld = findViewById(R.id.et_current_user);
        etUpdateNew = findViewById(R.id.et_new_user);
        etDelete = findViewById(R.id.et_del_user);
        mySqlDbHelper = new MySqlDbHelper(this);
        btnAddUser = findViewById(R.id.btn_add_user);
        btnUpdateUser = findViewById(R.id.btn_update);
        btnDelUser = findViewById(R.id.btn_del);
        btnViewData = findViewById(R.id.btn_view_data);
addData();
viewaAll();
deleteData();


    }

    public void deleteData() {
        btnDelUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deletedRows=mySqlDbHelper.
                        deleteData(etDelete.getText().
                                toString());
                if(deletedRows>0){
                    Toast.makeText(SQLiteActivity.this, "Data deleted.", Toast.LENGTH_SHORT).show();
                    etDelete.setText("");
                }
                else
                {

                    Toast.makeText(SQLiteActivity.this, "Data could not be deleted.", Toast.LENGTH_SHORT).show();
                    etDelete.setText("");
                }
            }
        });

    }

    public void addData() {
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted=mySqlDbHelper.insertData(etName.getText().toString(),etPassword.getText().toString());
                if(isInserted==true){
                    Toast.makeText(SQLiteActivity.this, "Data inserted.", Toast.LENGTH_SHORT).show();
                    etName.setText("");
                    etPassword.setText("");
                }else {
                    Toast.makeText(SQLiteActivity.this, "Data could not be inserted.", Toast.LENGTH_SHORT).show();
                    etName.setText("");
                    etPassword.setText("");
                }
            }
        });

    }
   public void viewaAll(){
        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor=mySqlDbHelper.getAllData();
                if(cursor.getCount()==0){
                    showMessage("Error","Nothing Found.");
                    return;
                }
                StringBuffer stringBuffer=new StringBuffer();
                while (cursor.moveToNext()){
                    stringBuffer.append("Name:"+cursor.getString(1)+"\n");
                    stringBuffer.append("Password:"+cursor.getString(2)+"\n");
                }
                showMessage("Data:",stringBuffer.toString());
            }

        });
   }
    private void showMessage(String title, String message) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
