package realm.fungatech.com.realmDb.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import realm.fungatech.com.realmDb.R
import realm.fungatech.com.realmDb.model.Student

/**
 * Created by kevinjanvier on 19/02/2018.
 */
class StudentAdapter(val context: Context, val stringarray: ArrayList<Student>) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent!!.context).inflate(R.layout.item_name, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return stringarray.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bindView(context,stringarray[position])
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var name = itemView!!.findViewById<TextView>(R.id.student_name)
        var time = itemView!!.findViewById<TextView>(R.id.time)
        var uuid = itemView!!.findViewById<TextView>(R.id.uuid)
        var radomImag = itemView!!.findViewById<ImageView>(R.id.imageView)

        fun bindView(context: Context,nameview: Student) {
            name.text = nameview.name
            time.text = nameview.age.toString()
            uuid.text = nameview.descrption

            val resourceId = context.resources.getIdentifier("ic_user_profile", "drawable", context.packageName)
            radomImag.setImageResource(resourceId)
            println("nameView ${nameview.name}")

        }
    }
}