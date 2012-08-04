package sample.quiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	static final Integer version = 1;
	static final CursorFactory factory = null;
	
	public DBHelper(Context context) {
		super(context, null, factory, version);
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
		Log.v("DB","�J�n");

		db.execSQL("create table �G�w("+
				" question text not null,"+
				" choices1 text not null,"+
				" choices2 text not null,"+
				" choices3 text not null,"+
				" choices4 text not null,"+
				" ans text not null"+
				");"
			);
		

		
		//db.execSQL("insert into �G�w(question,ans1,ans2,ans3,ans4) values ('�����́H','�z�㐻��', '�z�㐻��','�z�㐻��','�z�㐻��');");
		
		
//		db.execSQL("create table genre1("+
//				" question text not null"+");"
//			);
//		
//		db.execSQL("insert into genre1(question) values ('���NO��');");
		Log.v("DB","����");
		
		//�N�C�Y�o�^
		db.execSQL("insert into �G�w(question,choices1,choices2,choices3,choices4,ans) values ('�����́H','�z�㐻��', '�z�㐻��','�z�㐻��','�z�㐻��','�z�㐻��');");
		
		//����insert~������̂��ʓ|�Ȃ̂ň�����Ԃ����\�b�h�����
		
		//execsql(�W������,���,������4�n��)�@���͂��܂������h�N�T�C
		db.execSQL(execsql("�G�w","���{�ň�Ԗʐς��������s���{���́H","���쌧","���ꌧ","�Q�n��","�T�C�^�}�[!","���쌧"));
		db.execSQL(execsql("�G�w","X���𔭌������l���́H","�X�P���g��","�L�����[","�����g�Q��","�_�C�i�}�C�g","�����g�Q��"));
		db.execSQL(execsql("�G�w","�b�q�����ꂪ����s���{���́H","���{","���s�{","������","���Ɍ�","���Ɍ�"));
		db.execSQL(execsql("�G�w","�A���t�@�x�b�g�̗R���ƂȂ������̂̓A���t�@�Ɖ��H","�r�[�^","�x�[�^","�x�b�h","�r�[�Y","�x�[�^"));
		db.execSQL(execsql("�G�w","I Love You���u�����Y��ł��ˁv�Ɩ󂵂��l���́H","����@�g","��{���n","�H�열�V��","�Ėڟ���","�Ėڟ���"));
		db.execSQL(execsql("�G�w","�����ٖ̈��������d�͂����݂ɑ��鍂�M�Ȃ鏗���R�m�ƌ����΁H","�G�A���X","���C�g�j���O","�Z���X","�W�F�N�g","���C�g�j���O"));
		
		
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}
	
	//execSQL�H�̈�����Ԃ����\�b�h
	public String execsql(String g,String q,String a1,String a2,String a3,String a4,String a5){
		
		String re;
		//�G�w+question+ans1~4���K�v
		//db.execSQL("insert into �G�w(question,ans1,ans2,ans3,ans4) values ('�����́H','�z�㐻��', '�z�㐻��','�z�㐻��','�z�㐻��');");
		
		
		
		return "insert into "+g+"(question,choices1,choices2,choices3,choices4,ans) values ('"+q+"','"+a1+"', '"+a2+"','"+a3+"','"+a4+"','"+a5+"');";
		
	}
	

}
