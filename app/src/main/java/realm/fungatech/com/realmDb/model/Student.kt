package realm.fungatech.com.realmDb.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by kevinjanvier on 19/02/2018.
 */
@RealmClass
open class Student : RealmObject() {
    @PrimaryKey
    open lateinit var primId: String
    open lateinit var name: String
    open lateinit var descrption: String
    open lateinit var image: String
    open var age: Int = 0
}