package realm.fungatech.com.realmDb

import android.app.Application
import com.facebook.stetho.Stetho
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by kevinjanvier on 17/02/2018.
 */
class MyApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        // The default Realm file is "default.realm" in Context.getFilesDir();
        // we'll change it to "myrealm.realm"

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build())

        Realm.init(this)
        val reamconfig:RealmConfiguration = RealmConfiguration.Builder()
                .name("myrealm")
                .schemaVersion(1)
                .build()
        Realm.setDefaultConfiguration(reamconfig)


    }
}