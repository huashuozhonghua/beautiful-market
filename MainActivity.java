package tarena.day0119sqlite;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// �򿪻��ߴ������ݿ�
		String name = "tarena.db"; // ���ݿ���ļ���
		int mode = MODE_PRIVATE; // ����ģʽ
		CursorFactory factory = null; // �α깤��
		SQLiteDatabase db = openOrCreateDatabase(name, mode, factory);

		// createTable(db);
		// ��������
		 insertData(db);
		// deleteData(db);
		updateData(db);

	}



	private void updateData(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "update from stu_score set id = 7,username = 'ZhangWenxiang' where id = 1";
		db.execSQL(sql);
		
	}



	private void deleteData(SQLiteDatabase db) {

		String sql = "delete from stu_score where id = 5";
		db.execSQL(sql);

	}

	public void insertData(SQLiteDatabase db) {
		String sql = "insert into stu_score" + "(username,subject,score)"
				+ "values" + "('GuanWen','Java',54)";
		db.execSQL(sql);
	}

	// // ������������ݱ�
	public void createTable(SQLiteDatabase db) {
		String sql = "create table stu_score("
				+ "id integer primary key autoincrement,"
				+ "username varchar(16) not null,"
				+ "subject varchar(16) not null," + "score integer);";

		db.execSQL(sql);
	}

}
