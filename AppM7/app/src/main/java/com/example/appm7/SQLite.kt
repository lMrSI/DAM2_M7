import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.appm7.Usuario

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NOMBRE + " TEXT," +
                COLUMN_APELLIDO + " TEXT," +
                COLUMN_EMAIL + " TEXT," +
                COLUMN_CONTRASEÑA + " TEXT," +
                COLUMN_TELEFONO + " TEXT)")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertarUsuario(usuario: Usuario): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NOMBRE, usuario.nombre)
        contentValues.put(COLUMN_APELLIDO, usuario.apellido)
        contentValues.put(COLUMN_EMAIL, usuario.email)
        contentValues.put(COLUMN_CONTRASEÑA, usuario.contraseña)
        contentValues.put(COLUMN_TELEFONO, usuario.telefono)
        val result = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return result
    }

    fun validarUsuario(email: String, contraseña: String): Boolean {
        val db = this.readableDatabase
        val columns = arrayOf(COLUMN_ID)
        val selection = "$COLUMN_EMAIL = ? AND $COLUMN_CONTRASEÑA = ?"
        val selectionArgs = arrayOf(email, contraseña)
        val cursor: Cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null)
        val count = cursor.count
        cursor.close()
        db.close()
        return count > 0
    }

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Usuarios.db"
        private const val TABLE_NAME = "usuarios"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NOMBRE = "nombre"
        private const val COLUMN_APELLIDO = "apellido"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_CONTRASEÑA = "contraseña"
        private const val COLUMN_TELEFONO = "telefono"
    }
}
