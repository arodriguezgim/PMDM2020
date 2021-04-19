package org.iesch.alberto.a10_articulossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityPanel extends AppCompatActivity {
    //1 - creamos los objetos EditText
    private EditText et_Codigo, et_Descripcion, et_Precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        //2-Relacion entre la parte logica y grafica
        et_Codigo = (EditText)findViewById(R.id.txtCodigo);
        et_Descripcion = (EditText)findViewById(R.id.txtNombre);
        et_Precio = (EditText)findViewById(R.id.txtPrecio);
    }

    // 3 - METODO para dar de ALTA los productos
    public void Registrar(View view){
        //4- Creamos un Objeto de tipoAdminSQLiteOpenHelper y le asignamos un nombe...
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        //5- Abrimos la BBDD enmodo lectura/escritura
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        //6- Comenzamos a trabajar con los datos que el usuario de la App introduzca
        String codigo = et_Codigo.getText().toString();
        String descripcion = et_Descripcion.getText().toString();
        String precio = et_Precio.getText().toString();

        if ( !codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty() ) {
            //Si los tres campos estan llenos añado el registro
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);
            //Inserto el valor en la tabla
            BaseDeDatos.insert("articulos", null, registro);
            BaseDeDatos.close();

            et_Codigo.setText("");
            et_Descripcion.setText("");
            et_Precio.setText("");

            Toast.makeText(this, "Se ha añadido correctamente", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_LONG).show();
        }
    }

    // 4 - METODO para BUSCAR un registro
    public void Buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_Codigo.getText().toString();

        if( !codigo.isEmpty() ){
            Cursor fila = BaseDeDatos.rawQuery
                    ("SELECT descripcion, precio FROM articulos WHERE codigo=" + codigo,null);
            //Revisamos si nuestra consulta contiene o no valores
            if ( fila.moveToFirst() ) {
                et_Descripcion.setText(fila.getString(0));
                et_Precio.setText(fila.getString(1));
                BaseDeDatos.close();
            } else {
                Toast.makeText(this, "El producto NO existe", Toast.LENGTH_LONG).show();
                BaseDeDatos.close();
            }

        } else {
            Toast.makeText(this, "Debes rellenar el campo CODIGO", Toast.LENGTH_LONG).show();
        }

    }

    // 5 - METODO PARA ELIMINAR VALORES
    public void Eliminar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String codigo = et_Codigo.getText().toString();
        if( !codigo.isEmpty() ){
            //Metodo que devuelve el numero de articulos borrados.
            int cantidad = BaseDeDatos.delete("articulos","codigo=" + codigo,null);
            BaseDeDatos.close();
            //Limpiamos los campos
            et_Codigo.setText("");
            et_Descripcion.setText("");
            et_Precio.setText("");

            if ( cantidad == 1 ){
                Toast.makeText(this, "Articulo eliminado CORRECTAMENTE", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "El articulo no existe,", Toast.LENGTH_LONG).show();
            }
        } else{
            Toast.makeText(this, "Debes rellenar el campo CODIGO", Toast.LENGTH_LONG).show();
        }

    }

    // 6 - METODO PARA MODIFICAR VALORES
    public void Modificar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_Codigo.getText().toString();
        String descripcion = et_Descripcion.getText().toString();
        String precio = et_Precio.getText().toString();

        //Validamos los campos
        if( !codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty() ) {

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);
            //Ahora lo guardamos en nuestra BBDD
            int cantidad = BaseDeDatos.update("articulos", registro, "codigo=" + codigo, null);
            BaseDeDatos.close();

            if( cantidad == 1){
                Toast.makeText(this, "El articulo se ha MODIFICADO correctamente", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "El articulo NO EXISTE", Toast.LENGTH_LONG).show();
            }


        } else {
            Toast.makeText(this, "Debes rellenar TODOS los campos", Toast.LENGTH_LONG).show();
        }

    }
}
















