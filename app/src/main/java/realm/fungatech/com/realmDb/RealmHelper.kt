package realm.fungatech.com.realmDb

/**
 * Created by kevinjanvier on 19/02/2018.
 */

import io.realm.Realm
import realm.fungatech.com.realmDb.model.Student
import java.util.*

class RealmHelper(internal var realm: Realm) {


    //WRITE
    fun save(spacecraft: Student) {
        realm.executeTransaction { realm ->
            val dddd = realm.createObject(Student::class.java, UUID.randomUUID().toString())
            dddd.name = spacecraft.name
            dddd.age = spacecraft.age

        }

    }

    //READ
    fun retrieve(): ArrayList<Student> {
        val arraylist = ArrayList<Student>(realm.where(Student::class.java).findAll())
        println("Else  ---- $arraylist")
        return arraylist
    }
}
