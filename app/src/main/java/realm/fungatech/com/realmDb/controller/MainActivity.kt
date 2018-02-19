package realm.fungatech.com.realmDb.controller

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import io.realm.Realm

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import realm.fungatech.com.realmDb.adapter.StudentAdapter
import realm.fungatech.com.realmDb.model.*
import android.widget.EditText
import realm.fungatech.com.realmDb.*


class MainActivity : AppCompatActivity() {
    lateinit var realm:Realm
    lateinit var stringArray:ArrayList<Student>
    lateinit var mdapter : StudentAdapter
    lateinit var realmHelper:RealmHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        realm = Realm.getDefaultInstance()
        realmHelper = RealmHelper(realm)

        recyclerview.layoutManager = LinearLayoutManager(this)


        //retrive realm
        val helper = RealmHelper(realm)
        stringArray =helper.retrieve()

        //bindata
        mdapter= StudentAdapter(this, stringArray)
        recyclerview.adapter = mdapter

        fab.setOnClickListener {

            displayInputDialog()
        }


    }

    private fun displayInputDialog() {
        val d = Dialog(this)
        d.setTitle("Save To Realm")
        d.setContentView(R.layout.input_dialog)

        val nameEditTxt :EditText= d.findViewById(R.id.student_name)
        val meditText2 :EditText= d.findViewById(R.id.student_desc)
        val desc :EditText= d.findViewById(R.id.editText3)


        val saveBtn = d.findViewById(R.id.button) as Button

        saveBtn.setOnClickListener {
            val space = Student()
            space.name = nameEditTxt.text.toString()
            space.age = meditText2.text.toString().toInt()
            space.descrption = desc.text.toString()


            //save

            realmHelper.save(space)


            //refresh
            stringArray = realmHelper.retrieve()
            mdapter = StudentAdapter(this, stringArray)
            recyclerview.adapter = mdapter
            mdapter.notifyDataSetChanged()
            d.dismiss()
        }
        d.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        d.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

}
